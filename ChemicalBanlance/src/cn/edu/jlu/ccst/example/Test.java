package cn.edu.jlu.ccst.example;

import java.util.List;

import cn.edu.jlu.ccst.model.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rstr1 = "H2+O2=H2O";
		String rstr2 = "KClO3 = KCl + O2";
		String rstr3 = "Fe+H2O=Fe3O4+H2";
		String rstr4 = " Al2(SO4)3£«Na2CO3 = Al(OH)3£«CO2£«Na2SO4";
		String rstr5 = "C2H2+ KMnO4+ H2SO4= K2SO4+ MnSO4+ HCOOH+ H2O";
		String rstr6 = "K2Cr2O7+ Fe3O4+ H2SO4=K2SO4+ Fe2(SO4)3+ Cr2(SO4)3+ H2O";
		String rstr7="NaBiO3+MnSO4+H2SO4=Na2SO4+Bi2(SO4)3+NaMnO4+H2O";
		String rstr8 = "CO+CO2+H2=CH4+H2O";
		String rstr9="C+CO+H2+O2+S=CO2+H2O+O3+H2S+SO2+H2O2";
		Reaction r = new Reaction(rstr8);
		
        int[][] matrix = r.generatematrix();
        
		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+"\t");
			}
			
		}
		System.out.println();
		
		 List<Reaction> rs = r.banlance();
		 if(rs.size()<1){
			 System.err.println("TEST no Solutions!!!!!!");
		 }else{
			 for(Reaction rr:rs){
				 System.out.println(rr);
			 }
		 }
		
//		int[] step = {10,20,30,40,50,60,70,80,90,100,300,500,1000,5000,10000 };
//		int[] result = Solver.computeBalance(matrix, step);
		

	}
}
