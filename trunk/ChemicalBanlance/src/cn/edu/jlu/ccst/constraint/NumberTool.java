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
	 * ������nΪ������k��Ԫ�ص���ϸ���
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
	 * ������n�� m�η�
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
	 * ������range��Χ�ڵ������
	 * 
	 * @param range
	 * @return
	 */
	public static int getrandom(int range) {
		return ran.nextInt(range);
	}

	/**
	 * ������begin ��end֮�䷶Χ�ڵ������
	 * 
	 * @param range
	 * @return
	 */
	public static int getrandom(int begin, int end) {
		return ran.nextInt(end - begin) + begin;
	}

	/**
	 * ��ȡ����ȡ���ĳ������
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
