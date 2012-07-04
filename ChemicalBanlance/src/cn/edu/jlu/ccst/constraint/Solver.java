package cn.edu.jlu.ccst.constraint;

import cn.edu.jlu.ccst.model.Csp;

public class Solver {

	public static void main(String[] args) {

		// int[][] source=randomMatrix(2, 10,15);
		int[][] source = { { 7, 6, -14, 3, 12, 1, 11, -1, -13, -10 },
				{ 9, -5, -1, -14, 9, 3, 11, -9, -3, 9 }, };
		int[] step = { 2, 4, 8, 10 };
		int[] result = Solver.compute(source, step);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

//	/**
//	 * 
//	 * @param source输入的int初始矩阵
//	 * @param step一个int数组
//	 *            ，是求解范围， 从第一个开始，以step[i]作为X的取值范围，
//	 *            如果step[i]范围内无解，则到step[i+1]范围内继续求解。
//	 * 
//	 * @return 一个int数组，是求得的解，如果返回结果长度为0，则无解。
//	 */
//	public static int[] compute(int[][] source, int step[]) {
//		long head = System.nanoTime();
//		SimplifiedMatrix simplifiedMatrix=new SimplifiedMatrix(source);
//		simplifiedMatrix.init();
//		System.out.println();
//		simplifiedMatrix.printSource();
//		int[] result = new int[0];
//		for (int i = 0; i < step.length; i++) {
//			result = compute(simplifiedMatrix, step[i]);
//			if (result.length > 0) {
//				break;
//			} 
//		}
//		long end = System.nanoTime();
//		System.out.println("totally cost "
//				+ TimeTool.getSecondDoubleResult(head, end) + " seconds");
//
//		return result;
//
//	}
//	
//	private static int[] compute(SimplifiedMatrix matrix,int domSize) {
//		Csp csp = new Csp(matrix,domSize);
//		Mac mac;
//		// if (solveRange > 100 || source[0].length > 5) {
//		// mac = new FC(csp);
//		// } else {
//		mac = new Mac(csp);
//		// }
//		System.out.print("range= 1..." + domSize+" | ");
//		return compute(mac);
//
//	}
	
	/**
	 * 
	 * @param source输入的int初始矩阵
	 * @param step一个int数组
	 *            ，是求解范围， 从第一个开始，以step[i]作为X的取值范围，
	 *            如果step[i]范围内无解，则到step[i+1]范围内继续求解。
	 * 
	 * @return 一个int数组，是求得的解，如果返回结果长度为0，则无解。
	 */
	public static int[] compute(int[][] source, int step[]) {
		long head = System.nanoTime();
		SimplifiedMatrix simplifiedMatrix=new SimplifiedMatrix(source);
		simplifiedMatrix.init();
		System.out.println();
		simplifiedMatrix.printSource();
		int[] result = new int[0];
		Csp csp=new Csp(simplifiedMatrix,step[0]);
		for (int i = 0; i < step.length; i++) {
			if(i>0){
				csp.update(step[i]);
			}
			System.out.print("range= 1..." + step[i]+" | ");
			result = compute(csp);
			if (result.length > 0) {
				break;
			} 
		}
		long end = System.nanoTime();
		System.out.println("totally cost "
				+ TimeTool.getSecondDoubleResult(head, end) + " seconds");

		return result;

	}
	
	private static int[] compute(Csp csp) {
		Mac mac;
		// if (solveRange > 100 || source[0].length > 5) {
		// mac = new FC(csp);
		// } else {
		mac = new Mac(csp);
		// }
		
		return compute(mac);

	}
	
	
	
	private static int[] compute(Mac mac){
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

}
