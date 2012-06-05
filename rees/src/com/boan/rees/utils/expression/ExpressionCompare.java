/*
 * @(#)ExpressionCompare.java 1.1 2012-5-1
 */

package com.boan.rees.utils.expression;

import java.util.ArrayList;
import java.util.List;

/**
 * 表达式比较
 * @author ZhuYF
 * @version 1.0.0
 */
public class ExpressionCompare {

	/**
	 * 单逻辑符号逻辑比较
	 * @param expression 100>10; 如表达式为空则返回 true
	 * @return true：表达式成立 false：表达式不成立
	 */
	public static boolean compare(String expression) {
		if(expression==null ||expression.equals("")){
			return true;
		}
		//表达式长度
		int len = expression.length();
		//表达式中的逻辑符号
		String logic_sign = "";
		//逻辑符号左侧数据
		double d_left = 0;
		//逻辑符号右侧数据
		double d_right = 0;
		
//		String[] logic_sign_old = new String[]{"<=",">=","!=","<>","=","<",">"};
//		String[] logic_sign_new = new String[]{"≤","≥","≠","<>","=","<",">"};
		
		//逻辑符号数组
		List<String> logic_sign_list = new ArrayList<String>();
		logic_sign_list.add("≤");
		logic_sign_list.add("≥");
		logic_sign_list.add("=");
		logic_sign_list.add("≠");
		logic_sign_list.add("<>");
		logic_sign_list.add("<");
		logic_sign_list.add(">");
		//提取表达式中的逻辑符号
		for (int i = 0; i < len; i++) {
			String s = String.valueOf(expression.charAt(i));
			if ( logic_sign_list.contains(s)) {
				for (int j = i; j < len; j++) {
					String ts = String.valueOf(expression.charAt(j));
					if (logic_sign_list.contains(ts)) {
						logic_sign += ts;
					} else {
						break;
					}
				}
			}
		}

		//获取逻辑符号左右的数据值
		String[] data = expression.split(logic_sign);
		d_left = new Double(data[0]);
		d_right = new Double(data[1]);

		//计算逻辑
		if ("<".equals(logic_sign)) {
			if (d_left < d_right)
				return true;
		} else if (">".equals(logic_sign)) {
			if (d_left > d_right)
				return true;
		} else if ("=".equals(logic_sign)) {
			if (d_left == d_right)
				return true;
		} else if ("≥".equals(logic_sign) || ">=".equals(logic_sign) ) {
			if (d_left >= d_right)
				return true;
		} else if ("≤".equals(logic_sign) || "<=".equals(logic_sign) ) {
			if (d_left <= d_right)
				return true;
		} else if ("<>".equals(logic_sign) || "!=".equals(logic_sign)) {
			if (d_left != d_right)
				return true;
		}
		return false;
	}
	
	/**
	 * 判断参数数据是否在表达式范围内
	 * @param expression 100>paramName>10， 如果表达式为空则返回 true
	 * @param paramName 表达式中参数名称
	 * @param paramValue 表达式中参数的数值
	 * @return true：在表达式范围内 false：不在表达式范围内
	 */
	public static boolean compare(String expression, String paramName,String paramValue) {
		//返回结果
		boolean result = false;
		if(expression==null ||expression.equals("")){
			result = true;
		} else if(expression.contains(paramName)){
			expression = expression.replaceAll("＝", "=").replaceAll("＞", ">").replaceAll("＜", "<").replaceAll("<=", "≤").replaceAll(">=", "≥").replaceAll("!=", "≠").replaceAll("<>", "≠");
			//获取参数位置
			int index = expression.indexOf(paramName);
			//截取左边的表达式
			String left_expression = expression.substring(index).equals(paramName) ? "" : expression.substring(index);
			//截取右边的表达式
			String right_expression = expression.substring(0,index+paramName.length()).equals(paramName) ? "" : expression.substring(0,index+paramName.length());
			//替换左边表达式中的变量
			left_expression = left_expression.replaceAll(paramName, paramValue);
			//替换右边表达式中的变量
			right_expression = right_expression.replaceAll(paramName, paramValue);
			//逻辑计算
			result = compare(left_expression) && compare(right_expression);
			expression = expression.replaceAll(paramName, paramValue);
			//System.out.println(expression + " : " + result );
		}else{
			System.out.println("表达式 ：" + expression + " 错误！" );
		}
		return result;
	}
}

