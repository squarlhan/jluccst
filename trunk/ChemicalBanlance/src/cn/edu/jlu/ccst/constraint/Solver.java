package cn.edu.jlu.ccst.constraint;

import cn.edu.jlu.ccst.model.Csp;

public class Solver {

	public static void main(String[] args) {

		// int[][] source=randomMatrix(2, 10,15);
		// int[][] source = {
		// { 1, -1, 2, 0 },
		// { 0, 0, -2, 4 },
		// };
		int[][] source = { { 7, 6, -14, 3, 12, 1, 11, -1, -13, -10 },
				{ 9, -5, -1, -14, 9, 3, 11, -9, -3, 9 }, };

		int[] step = { 2, 4, 8, 10 };
		int[] result = Solver.compute(source, step);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

	
	/**
	 * 
	 * @param source输入的int初始矩阵
	 * @param step一个int数组，是求解范围，
	 * 从第一个开始，以step[i]作为X的取值范围，
	 * 如果step[i]范围内无解，则到step[i+1]范围内继续求解。
	 * 
	 * @return 一个int数组，是求得的解，如果返回结果长度为0，则无解。
	 */
	public static int[] compute(int[][] source, int step[]) {
		checkSource(source);
		System.out.println();
//		printSource(source);
		int[] result = new int[0];
		for (int i = 0; i < step.length; i++) {
			
			result = compute(source, step[i]);
			if (result.length > 0) {
				break;
			}else{
				
			}
		}
		return result;

	}

	private static int[] compute(int[][] source, int solveRange) {
		
		Csp csp = new Csp(source, solveRange);
		Mac mac;
		if (solveRange > 100 || source[0].length > 5) {
			mac = new FC(csp);
		} else {
			mac = new Mac(csp);
		}
		mac.testMAC();
		System.out.print("range="+solveRange);
		if(mac.success){
			System.out.print(" find solution ");
		}else{
			System.out.print(" no solution ");
		}
		mac.showResult();
		int[] result = new int[0];
		if (mac.csp.solutionExist) {
			result = new int[csp.varNum];
			for (int i = 0; i < csp.varNum; i++) {
				result[i] = csp.variables[i].getSolutionValue();
			}
		}
		return result;

	}

	public static void printSource(int[][] source) {
		for (int i = 0; i < source.length; i++) {
			for (int j = 0; j < source[i].length; j++) {
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

	public static int getFirstValidValue(int[] source) {
		for (int i = 0; i < source.length; i++) {
			if (source[i] != 0) {
				return source[i];
			}
		}
		return 0;
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
