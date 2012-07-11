package cn.edu.jlu.ccst.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Jama.Matrix;

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
    
    public int rank(int[][] matrix){
    	int m = matrix.length;
    	int n = matrix[0].length;
    	double[][] dma = new double[m][n];
    	for(int i= 0;i<=m-1;i++){
    		for(int j= 0;j<=n-1;j++){
    			dma[i][j] = matrix[i][j];
    		}
    	}
    	Matrix ma = new Matrix(dma);
    	return ma.rank();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rstr1 = "H2+O2=H2O";
		String rstr2 = "KClO3 = KCl + O2";
		String rstr3 = "Fe+H2O=Fe3O4+H2";
		String tstr4 = " AI2(SO4)3£«Na2CO3 = AI(OH)3£«CO2£«Na2SO4";
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
