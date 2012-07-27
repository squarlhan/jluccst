package cn.edu.jlu.ccst.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.edu.jlu.ccst.constraint.Solver;

public class Reaction {
	
	String name;
	List<Molecular> left;
	List<Molecular> right;

	
	
	public Reaction(String name) {
		super();
		this.name = name;
		validate();
	}



	public Reaction() {
		super();
		left = new ArrayList();
		right = new ArrayList();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<Molecular> getLeft() {
		return left;
	}



	public void setLeft(List<Molecular> left) {
		this.left = left;
	}



	public List<Molecular> getRight() {
		return right;
	}



	public void setRight(List<Molecular> right) {
		this.right = right;
	}



	public void validate(){
		left = new ArrayList();
		right = new ArrayList();
		
		
		String[] strs = name.trim().split("=");
		if(strs.length!=2){
			System.err.println("There must be some mistake in reation, please check it!");
			return;
		}
		String leftstr = strs[0].trim();
		String[] leftstrs = leftstr.split("\\+");
		for(String str : leftstrs){
			Molecular m = new Molecular(str.trim());
			left.add(m);
		}
		String rightstr = strs[1].trim();
		String[] rightstrs = rightstr.split("\\+");
		for(String str :rightstrs){
			Molecular m = new Molecular(str.trim());
			right.add(m);
		}
	}

	
	public int[][] generatematrix(){
    	int m_num = left.size()+right.size();
//    	map<String , Integer>
    	Set<String> atom_set= new HashSet();
    	for(Molecular m: left){
        	for(Atom a:m.getAtoms()){
        		atom_set.add(a.getName());
    		}
    	}
    	for(Molecular m: right){
        	for(Atom a:m.getAtoms()){
        		atom_set.add(a.getName());
    		}
    	}
    	int a_num = atom_set.size();
    	int[][] matrix = new int[a_num][m_num];
    	List<String> atom_list= new ArrayList();
    	atom_list.addAll(atom_set);
    	for(int i = 0;i<=atom_list.size()-1;i++){
    		for(int j = 0;j<=m_num-1;j++){
    			if(j<=left.size()-1){
    				matrix[i][j] = left.get(j).find(atom_list.get(i));
    			}else{
    				matrix[i][j] = -1*right.get(j-left.size()).find(atom_list.get(i));
    			}
    			
    		}
    	}
    	return matrix;
    }
    
	public String toString() {
		String result = "";
		
		for(int i=0;i<=left.size()-1;i++){
			Molecular m =left.get(i);
			if(i == left.size()-1){
				result = result+m.getCount()+m.getName();
			}else{
				result = result+m.getCount()+m.getName()+"+";
			}
		}
		
		result = result+"=";
		
		for(int i=0;i<=right.size()-1;i++){
			Molecular m =right.get(i);
			if(i == right.size()-1){
				result = result+m.getCount()+m.getName();
			}else{
				result = result+m.getCount()+m.getName()+"+";
			}
		}
		
		return result;
	}
   //首先利用约束分解方程式，之后利用线性代数来求解
	public List<Reaction> banlance(){
		List<Reaction> results = new ArrayList();
		
		int[][] matrix = generatematrix();
		MatrixSolver ms = new MatrixSolver(matrix);
		int n = ms.getN();
		int rk = ms.getRank();
		if(n-rk<1){
			System.err.println("No Solution!");
		}else if(n-rk ==1){
			int[][] ans = ms.solve();
			boolean flag = true;
			for(int i=0;i<=n-1;i++){
				if(ans[0][i]<=0){
					System.err.println("Rank = 1 BUT No Solution!");
					flag = false;
					break;
				}else{
					if(i<=left.size()-1){
						left.get(i).setCount(ans[0][i]);
					}else{
						right.get(i-left.size()).setCount(ans[0][i]);
					}					
				}				
			}
			if(flag)results.add(this);
		}else{
			Solver.computeValidSubReactions(matrix);
			int ls = left.size();
			for(int a=0;a<=Solver.elements.size()-1;a++){
				Reaction rtemp = new Reaction();
				for(int b=0;b<=n-1;b++){
					if(Solver.elements.get(a)[b]==1){
						Molecular m = new Molecular();
						if(b<=ls-1){
							m.setAtoms(left.get(b).getAtoms()) ;
							m.setName(left.get(b).getName());
							m.setCount(1);
							rtemp.left.add(m);
						}else{
							m.setAtoms(right.get(b-ls).getAtoms()) ;
							m.setName(right.get(b-ls).getName());
							m.setCount(1);
							rtemp.right.add(m);
						}
					}
				}
				for(int c = 0;c<=Solver.solutions.get(a).length-1;c++){
					if(c<=rtemp.getLeft().size()-1){
						rtemp.getLeft().get(c).setCount(Solver.solutions.get(a)[c]);
					}else{
						rtemp.getRight().get(c-rtemp.getLeft().size()).setCount(Solver.solutions.get(a)[c]);
					}			
				}
				results.add(rtemp);
			}
		}
		
		return results;
	}
	//利用约束直接求解
	public void justbanlance(int[] step){
		int[] result = Solver.computeBalance(generatematrix(), step);
		int ls = left.size();
		int n = result.length;
		
		for(int i = 0;i<=n-1;i++){
			if(i<=ls-1){
				left.get(i).setCount(result[i]);
			}else{
				right.get(i-ls).setCount(result[i]);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rstr1 = "H2+O2=H2O";
		String rstr2 = "KClO3 = KCl + O2";
		String rstr3 = "Fe+H2O=Fe3O4+H2";
		String tstr4 = " AI2(SO4)3＋Na2CO3 = AI(OH)3＋CO2＋Na2SO4";
		Reaction r = new Reaction(rstr3);
        for(Molecular m: r.getLeft()){
        	for(Atom a:m.getAtoms()){
    			System.out.print(a.getName()+a.getCount());
    		}
        	System.out.print("+");
        }
        System.out.print("=");
        for(Molecular m: r.getRight()){
        	for(Atom a:m.getAtoms()){
    			System.out.print(a.getName()+a.getCount());
    		}
        	System.out.print("+");
        }
        
        int[][] matrix = r.generatematrix();
		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+"\t");
			}
			
		}
	}

}
