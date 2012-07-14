package cn.edu.jlu.ccst.constraint;

import java.util.ArrayList;

import cn.edu.jlu.ccst.model.Csp;

public class Solver {

	public static void main(String[] args) {

		// int[][] source=randomMatrix(2, 10,15);
		// int[][] source = { { 7, 6, -14, 3, 12, 1, 11, -1, -13, -10 },
		// { 9, -5, -1, -14, 9, 3, 11, -9, -3, 9 }, };
		// int[] step = { 2, 4, 8, 10 };
		// int[] result = Solver.compute(source, step);
		// for (int i = 0; i < result.length; i++) {
		// System.out.print(result[i] + " ");
		// }

		int[][] source = { { 1, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 2, 0, -2, -1, -3, 0, -2,-2 },
				{ 0, 0, 2, 0, 0, 0, -2, 0, -2, 0, -2 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, -1, -1, 0 }, };

		int[][] result = Solver.computeValidSubReactions(source);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}


	/**
	 * 
	 * @param source
	 * @param step
	 * @return
	 */
	public static int[] computeBalance(int[][] source, int step[]) {
		long head = System.nanoTime();
		SimplifiedMatrix simplifiedMatrix = new SimplifiedMatrix(source);
		simplifiedMatrix.init();
		System.out.println();
		simplifiedMatrix.printSource();
		int[] result = new int[0];
		Csp csp = new Csp(simplifiedMatrix, step[0]);
		for (int i = 0; i < step.length; i++) {
			if (i > 0) {
				csp.update(step[i]);
			}
			System.out.print("range= 1..." + step[i] + " | ");
			result = computeBalance(csp);
			if (result.length > 0) {
				break;
			}
		}
		long end = System.nanoTime();
		System.out.println("totally cost "
				+ TimeTool.getSecondDoubleResult(head, end) + " seconds");

		return result;

	}
	
	private static int[] computeBalance(Csp csp) {
		Mac mac;
		mac = new Mac(csp);
		return computeBalance(mac);

	}
	private static int[] computeBalance(Mac mac){
		mac.testMAC();
		if (mac.success) {
			System.out.print(" find solution ");
		} else {
			System.out.print(" no solution ");
		}
		mac.showResult();
		int[] result = new int[0];
		if (mac.csp.solutionExist) {
			result = new int[mac.csp.varNum];
			for (int i = 0; i < mac.csp.varNum; i++) {
				result[i] = mac.csp.variables[i].getSolutionValue();
			}
		}
		return result;
	}
	

	public static int[][] randomMatrix(int n, int m, int range) {
		int[][] result = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = NumberTool.getrandom(range * 2) - range;
			}
		}
		return result;
	}

	public static int[][] computeValidSubReactions(int[][] source) {
		long head = System.nanoTime();
		Csp csp = new Csp(source);
		int[][] result = computeValidSubReactions(csp);
		long end = System.nanoTime();
		System.out.println("totally cost "
				+ TimeTool.getSecondDoubleResult(head, end) + " seconds");

		return result;

	}

	private static int[][] computeValidSubReactions(Csp csp) {
		Mac mac;
		mac = new Mac(csp);
		return computeSubReactions(mac);

	}

	private static int[][] computeSubReactions(Mac mac) {
		ArrayList<int[]> resultList=mac.searchForAll();
		mac.showResult();
		int[][] result = new int[resultList.size()][];
		for(int i=0;i<result.length;i++){
			result[i]=new int[resultList.get(i).length]; 
			for(int j=0;j<result[i].length;j++){
				result[i][j]=mac.csp.variables[j].domain[resultList.get(i)[j]];
			}
		}
		return result;
	}


}
