package cn.edu.jlu.ccst.constraint;

import java.util.Random;

public class NumberTool {

	private static Random ran = new Random();
	public static void main(String[] args) {

		System.out.println(computeCNK(20,3));
	}
	
	public static long product(int[] a){
		long result=1;
		for(int i=0;i<a.length;i++){
			result*=a[i];
		}
		return result;
	}
	
	/**
	 * 计算以n为基础，k个元素的组合个数
	 * @param n
	 * @param k
	 * @return
	 */
	public static int computeCNK(int n,int k){
		long result=1;
		for(int i=0;i<k;i++){
			result*=(n-i);
		}
		for(int i=1;i<=k;i++){
			result/=i;
		}
		return (int)result;
	}
	/**
	 * 计算以n的 m次方
	 * @param n
	 * @param k
	 * @return
	 */
	public static long computeSquare(int n,int m){
		long result=1;
		for(int i=0;i<m;i++){
			result*=n;
		}
		return result;
	}
	/**
	 * 生成在range范围内的随机数
	 * 
	 * @param range
	 * @return
	 */
	public static int getrandom(int range) {
		return ran.nextInt(range);
	}

	/**
	 * 生成在begin 和end之间范围内的随机数
	 * 
	 * @param range
	 * @return
	 */
	public static int getrandom(int begin, int end) {
		return ran.nextInt(end - begin) + begin;
	}

	/**
	 * 获取向上取整的除法结果
	 * @param bcs
	 * @param cs
	 * @return
	 */
	public static int divUpInreger(int bcs, int cs) {
		int result = bcs / cs;
		if (bcs % cs > 0)
			result++;
		return result;

	}
}
