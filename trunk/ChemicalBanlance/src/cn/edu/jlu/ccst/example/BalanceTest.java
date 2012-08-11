package cn.edu.jlu.ccst.example;

import cn.edu.jlu.ccst.constraint.TimeTool;
import cn.edu.jlu.ccst.model.Reaction;

public class BalanceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();

	}

	public static void test() {
		String[] expressions={
				 "K2Cr2O7+ Fe3O4+H2SO4=K2SO4+ Fe2(SO4)3+ Cr2(SO4)3+ H2O",
				 "P+ CuSO4+ H2O=H3PO4+ Cu3P+ H2SO4 ",
				 "C2H2+ KMnO4+ H2SO4=K2SO4+ MnSO4+ HCOOH+ H2O",
				 "Cu2O+ HNO3=Cu(NO3)2+ NO+ H2O ",
				 "KMnO4+ HCl= KCl+ MnCl2+ Cl2+ H2O",
				"FeSO4+HNO3=Fe(NO3)3+Fe2(SO4)3+N2O+H2O",
		};
		int[] step = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 300, 500, 1000,
				5000, 10000 };
		for(int i=0;i<expressions.length;i++){
			long head = System.nanoTime();
			Reaction r = new Reaction(expressions[i]);
			r.justbanlance(step);
			long end = System.nanoTime();
			System.out.println("totally cost "
					+ TimeTool.getSecondDoubleResult(head, end) + " seconds");
			System.out.println(r);
			System.out.println();
		}
		

	}

}
