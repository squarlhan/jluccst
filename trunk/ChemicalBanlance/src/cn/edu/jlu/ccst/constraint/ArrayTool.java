package cn.edu.jlu.ccst.constraint;

import java.util.ArrayList;

public class ArrayTool {
	/**
	 * ����int����
	 * @param source
	 * @return ���ƺ������ɵ�����
	 */
	public static int[][] copy(int[][] source){
		int length=source.length;
		int[][] result=new int[length][];
		for(int i=0;i<length;i++){
			result[i]=new int[source[i].length];
			for(int j=0;j<result[i].length;j++){
				result[i][j]=source[i][j];
			}
		}
		return result;
	}
	/**
	 * ����int����
	 * @param source
	 * @return ���ƺ������ɵ�����
	 */
	public static int[] copy(int[] source){
		int length=source.length;
		int[] result=new int[length];
		for(int i=0;i<length;i++){
			result[i]=source[i];
		}
		return result;
	}
	
	/**
	 * ����int����source��Ŀ������object
	 * @param object
	 * @param source
	 */
	public static void copy(int[] object,int[] source){
		int length=source.length;
		object=new int[length];
		for(int i=0;i<length;i++){
			object[i]=source[i];
		}
	}
	public static void copyIntArray(int[] object,int[] source){
		for(int i=0;i<source.length;i++){
			object[i]=source[i];
		}
	}
	/**
	 * ����range����int���飬����ֵΪ0---��range-1������
	 * @param range
	 * @return
	 */
	public static int[] fill(int range){
		int[] result=new int[range];
		for(int i=0;i<range;i++){
			result[i]=i;
		}
		return result;
	}
	public static int[] fill(int start,int end){
		int range=end-start;
		int[] result=new int[range];
		for(int i=0;i<range;i++){
			result[i]=i+start;
		}
		return result;
	}
	
	/**
	 * ����range���int����object������ֵΪ0---��range-1������
	 * @param object
	 * @param range
	 */
	public static void fill(int[] object,int value){
		for(int i=0;i<object.length;i++){
			object[i]=value;
		}
	}
	
	/**
	 * ����range���int����object������ֵΪ0---��range-1������
	 * @param object
	 * @param range
	 */
	public static void fillRange(int[] object,int range){
		object=new int[range];
		for(int i=0;i<range;i++){
			object[i]=i;
		}
	}
	
	/**
	 * ����boolean����
	 * @param source
	 * @return
	 */
	public static boolean[] copy(boolean[] source){
		int length=source.length;
		boolean[] result=new boolean[length];
		for(int i=0;i<length;i++){
			result[i]=source[i];
		}
		return result;
	}

	/**
	 * ����boolean����source��object
	 * @param object
	 * @param source
	 */
	public static void copy(boolean[] object,boolean[] source){
		int length=source.length;
		object=new boolean[length];
		for(int i=0;i<length;i++){
			object[i]=source[i];
		}
	}
	
	/**
	 * ����value��length�õ�һ������Ϊlength�µ�boolean���飬������Ԫ�ص�ֵΪvalue
	 * @param value
	 * @param length
	 * @return
	 */
	public static boolean[] fill(boolean value,int length){
		boolean[] result=new boolean[length];
		if(value){
			for(int i=0;i<length;i++)
			result[i]=true;
		}
		return result;
	}
	
	/**
	 * ����value���object����
	 * @param object
	 * @param value
	 */
	public static void fill(boolean[] object,boolean value){
		int length=object.length;
		for(int i=0;i<length;i++){
			object[i]=value;
		}
//		int length=object.length;
//		if(value){
//			for(int i=0;i<length;i++){
//				object[i]=true;
//			}
//		}else{
//			object=new boolean[length];
//		}
	}
	
	/**
	 * ����value���object����
	 * @param object
	 * @param value
	 */
	public static void fillValue(int[] object,int value){
		int length=object.length;
		for(int i=0;i<length;i++){
			object[i]=value;
		}
	}
	/**
	 * �������listת��������
	 * @param list
	 * @return
	 */
	public static int[] convertIntegerArray(ArrayList<Integer> list){
		int[] result=new int[list.size()];
		for(int i=0;i<result.length;i++){
			result[i]=list.get(i);
		}
		return result;
	}
	
	/**
	 * �������listת��������
	 * @param list
	 * @return
	 */
	public static String[] convertStringArray(ArrayList<String> list){
		String[] result=new String[list.size()];
		for(int i=0;i<result.length;i++){
			result[i]=list.get(i);
		}
		return result;
	}
	
	public static boolean sameArray(int[] a1,int[] a2){
		if(a1.length!=a2.length)
			return false;
		for(int i=0;i<a1.length;i++){
			if(a1[i]!=a2[i])
				return false;
		}
		return true;
	}
}
