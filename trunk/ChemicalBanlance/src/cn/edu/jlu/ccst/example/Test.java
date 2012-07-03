package cn.edu.jlu.ccst.example;

import cn.edu.jlu.ccst.constraint.Solver;
import cn.edu.jlu.ccst.model.Atom;
import cn.edu.jlu.ccst.model.Molecular;
import cn.edu.jlu.ccst.model.Reaction;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rstr1 = "H2+O2=H2O";
		String rstr2 = "KClO3 = KCl + O2";
		String rstr3 = "Fe+H2O=Fe3O4+H2";
		String rstr4 = " AI2(SO4)3£«Na2CO3 = AI(OH)3£«CO2£«Na2SO4";
		String rstr5 = "C2H2+ KMnO4+ H2SO4= K2SO4+ MnSO4+ HCOOH+ H2O";
		String rstr6 = "K2Cr2O7+ Fe3O4+ H2SO4=K2SO4+ Fe2(SO4)3+ Cr2(SO4)3+ H2O";
		Reaction r = new Reaction(rstr6);
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
		int[] step = { 10, 50, 100 };
		int[] result = Solver.compute(matrix, step);
		System.out.println();
		for(int i=0;i<= r.getLeft().size()-1;i++){
			Molecular m =r.getLeft().get(i);
			m.setCount(result[i]);
			if(i == r.getLeft().size()-1){
				System.out.print(m.getCount()+m.getName());
			}else{
			    System.out.print(m.getCount()+m.getName()+"+");
			}
		}
		System.out.print("=");
		for(int i=0;i<= r.getRight().size()-1;i++){
			Molecular m =r.getRight().get(i);
			m.setCount(result[i+r.getLeft().size()]);
			if(i == r.getRight().size()-1){
				System.out.print(m.getCount()+m.getName());
			}else{
			    System.out.print(m.getCount()+m.getName()+"+");
			}
		}
	}

}
