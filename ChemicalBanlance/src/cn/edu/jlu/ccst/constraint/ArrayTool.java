package cn.edu.jlu.ccst.constraint;

import java.util.ArrayList;

public class ArrayTool {
	/**
	 * 复制int数组
	 * @param source
	 * @return 复制后新生成的数组
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
	 * 复制int数组
	 * @param source
	 * @return 复制后新生成的数组
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
	 * 复制int数组source到目标数组object
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
	 * 根据range生成int数组，数组值为0---（range-1）递增
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
	 * 根据range填充int数组object，数组值为0---（range-1）递增
	 * @param object
	 * @param range
	 */
	public static void fill(int[] object,int value){
		for(int i=0;i<object.length;i++){
			object[i]=value;
		}
	}
	
	/**
	 * 根据range填充int数组object，数组值为0---（range-1）递增
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
	 * 复制boolean数组
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
	 * 复制boolean数组source到object
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
	 * 根据value和length得到一个长度为length新的boolean数组，其所有元素的值为value
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
	 * 根据value填充object数组
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
	 * 根据value填充object数组
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
	 * 将输入的list转化成数组
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
	 * 将输入的list转化成数组
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
