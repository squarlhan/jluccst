package cn.edu.jlu.ccst.constraint;

import java.util.ArrayList;

public class SimplifiedMatrix {
	public int[][] varOrderForGetTuple;
	public int[] varOrderForSearch;
	public int[][] matrix;
	public int varNum;
	public int cstNum;
	
	public SimplifiedMatrix(int[][] source){
		matrix=source;
		varNum = source[0].length;
		cstNum = source.length;
	}
	
	public void init(){
		simplifySource(matrix);
//		checkSource(matrix);
//		System.out.println();
//		varOrderForSearch=computeVarOrder(matrix);//由于变量个数较少，计算一个固定的变量赋值顺序，连接约束元数较小的变量优先
//		varOrderForGetTuple=computeOrderForGetTuple(matrix);
	}
	private static int[][] computeOrderForGetTuple(int[][] source){
		int[][] result=new int[source.length][];
		for(int i=0;i<result.length;i++){
			result[i]=orderVarForGetTuple(source[i]);
		}
		return result;
	}

	private static int[] orderVarForGetTuple(int[] v){
		int arity=0;
		for(int i=0;i<v.length;i++){
			if(v[i]!=0){
				arity++;
			}
		}
		int[] vector=new int[arity];
		int length=v.length;
		int index2=0;
		int index1=0;
		while(index2<arity){
			for(int i=index1;i<length;i++){
				if(v[i]!=0){
					vector[index2++]=v[i];
					index1=i+1;
					break;
				}
			}
		}
		int[] result = new int[arity];
		boolean[] dealed = new boolean[arity];
		for (int i = 0; i < arity; i++) {
			int max = -1;
			int index = 0;
			for (int j = 0; j < arity; j++) {
				if (!dealed[j] && Math.abs(vector[j]) > max) {
					index = j;
					max = Math.abs(vector[j]);
				}
			}
			result[i] = index;
			dealed[index] = true;
		}
		return result;
	}
	
	public static int[] computeVarOrder(int[][] source) {
		int cstNum=source.length;
		int varNum=source[0].length;
		int[] conOrder = orderConstraints(source);
		int[] result = new int[varNum];
		boolean[] selected = new boolean[varNum];
		int index = 0;
		ArrayList<Integer> equaled = new ArrayList<Integer>();
		while (index < varNum ) {
			for (int j = 0; j < varNum; j++) {
				if (!selected[j]) {
					equaled.add(j);
				}
			}
			for (int i = 0; i < cstNum; i++) {
				int[] currentParams = source[conOrder[i]];
				int max = -99999999;
				for(int j=0;j<equaled.size();j++){
					if (Math.abs(currentParams[equaled.get(j)]) > max) {
						max = Math.abs(currentParams[equaled.get(j)]);
					}
				}
				int ind = 0;
				while (ind < equaled.size()) {
					if (Math.abs(currentParams[equaled.get(ind)]) < max) {
						equaled.remove(equaled.get(ind--));
					}
					ind++;
				}
			}
			
			selected[equaled.get(0)] = true;
			result[index++] = equaled.get(0);
			equaled.clear();
		}
		return result;
	}

	private static int[] orderConstraints(int[][] source) {
		int cstNum=source.length;
		int[] aritys=new int[cstNum];
		for(int i=0;i<cstNum;i++){
			for(int j=0;j<source[i].length;j++){
				if(source[i][j]!=0){
					aritys[i]++;
				}
			}
		}
		int[] result = new int[cstNum];
		boolean[] dealed = new boolean[cstNum];
		for (int i = 0; i < cstNum; i++) {
			int max = -1;
			int index = 0;
			for (int j = 0; j < cstNum; j++) {
				if (!dealed[j] && aritys[j] > max) {
					index = j;
					max = aritys[j];
				}
			}
			result[i] = index;
			dealed[index] = true;
		}
		return result;
	}

	public static void printSource(int[][] source) {
		for (int i = 0; i < source.length; i++) {
			for (int j = 0; j < source[i].length; j++) {
				if(source[i][j]>=0){
					System.out.print(" ");
				}
				if(source[i][j]<10){
					System.out.print(" ");
				}
				System.out.print(source[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void checkSource(int[][] source) {
		for (int i = 0; i < source.length; i++) {
			if (getFirstValidValue(source[i]) < 0) {
				for (int j = 0; j < source[i].length; j++) {
					source[i][j] = 0 - source[i][j];
				}
			}
		}
	}

	public static void simplifySource(int[][] source) {
		int[] lengths = new int[source.length];
		int[][] doubleIndexs = new int[source.length][2];
		boolean[] zeros = new boolean[source.length];
		for (int i = 0; i < source.length; i++) {
			int sum = 0;
			for (int j = 0; j < source[i].length; j++) {
				if (source[i][j] != 0) {
					lengths[i]++;
					sum += source[i][j];
					if (doubleIndexs[i][0] == 0) {
						doubleIndexs[i][0] = j;
					} else {
						if (doubleIndexs[i][1] == 0) {
							doubleIndexs[i][1] = j;
						}
					}
				}
			}
			if (sum == 0 && lengths[i] == 2) {
				zeros[i] = true;
				source[i][doubleIndexs[i][0]]/=source[i][doubleIndexs[i][1]];
				source[i][doubleIndexs[i][1]]=1;
			}
		}
		ArrayList<int[]> temp = new ArrayList<int[]>();
		ArrayList<Integer> tempEqualIndexs = new ArrayList<Integer>();
		for (int i = 0; i < source.length; i++) {
			if (zeros[i]) {
				temp.add(doubleIndexs[i]);
			}
		}
		ArrayList<int[]> equalTuples = new ArrayList<int[]>();
		while (temp.size() > 0) {
			int[] locations = temp.remove(0);
			boolean[] inSet = new boolean[source[0].length];
			inSet[locations[0]] = true;
			inSet[locations[1]] = true;
			boolean change = true;
			while (change) {
				change = false;
				int index = 0;
				while (index < temp.size()) {
					locations = temp.get(index);
					if (inSet[locations[0]] || inSet[locations[1]]) {
						inSet[locations[0]] = true;
						inSet[locations[1]] = true;
						temp.remove(index);
						index--;
						change = true;
					}
					index++;
				}
			}
			for (int i = 0; i < inSet.length; i++) {
				if (inSet[i]) {
					tempEqualIndexs.add(i);
				}
			}
			for (int i = 0; i < tempEqualIndexs.size(); i++) {
				for (int j = i + 1; j < tempEqualIndexs.size(); j++) {
					int[] t = new int[2];
					t[0] = tempEqualIndexs.get(i);
					t[1] = tempEqualIndexs.get(j);
					equalTuples.add(t);
				}
			}
			tempEqualIndexs.clear();
		}
		for (int i = 0; i < equalTuples.size(); i++) {
			for (int j = 0; j < source.length; j++) {
				if (lengths[j] > 2) {
					if (source[j][equalTuples.get(i)[0]] != 0
							&& source[j][equalTuples.get(i)[1]] != 0) {
						source[j][equalTuples.get(i)[0]] += source[j][equalTuples
								.get(i)[1]];
						source[j][equalTuples.get(i)[1]] = 0;
					}
				}
			}
		}


	}

	public static int getFirstValidValue(int[] source) {
		for (int i = 0; i < source.length; i++) {
			if (source[i] != 0) {
				return source[i];
			}
		}
		return 0;
	}

	public void printSource() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j]>=0){
					System.out.print(" ");
				}
				if(matrix[i][j]<10){
					System.out.print(" ");
				}
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
