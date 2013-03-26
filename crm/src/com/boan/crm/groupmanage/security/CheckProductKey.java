package com.boan.crm.groupmanage.security;

import java.util.Calendar;

import com.boan.crm.utils.calendar.CurrentDateTime;
import com.boan.crm.utils.calendar.MySimpleDateFormat;

public class CheckProductKey {
	
	/**
	 * 登录方式,PIN码登录，则为true，否则为false
	 */
	public static boolean pinLogin = false;
	
	/**
	 * 正式版为1 ，试用版为0
	 */
	private String productKey = "1";
	
	/**
	 * 字符串型开始时间
	 */
	private  String productEndDate = "2013-12-31 00:00:00";
	
	/**
	 * 消息
	 */
	public static String message = null;

	/**
	 * 判断是否过期
	 * @return
	 */
	public  boolean getProductKey(){
		if( "1".equals(productKey ) ){
			//正式版
			message="";
			//!暂时先屏掉，让正式版也有期限，JHY
			//return false;
		}
		Calendar endDate = MySimpleDateFormat.parse(productEndDate);
		Calendar cal = Calendar.getInstance();
		int c = CurrentDateTime.compareBothDate(cal, endDate);
		if( c > 0){
			//过期
			message = "产品试用期已过，请联系软件供应商！" ;
			return true;
		}else{
			message = "";
			//没过期
			return false;
		}
	}
	/**
	 * 获取产品后缀
	 */
	public  String getProductSuffix() {
		if( "1".equals(productKey ) ){
			return "";
		}else{
			return "（试用版）";
		}
	}
	
	public static void main(String[] args){
		CheckProductKey productKey = new CheckProductKey();
		System.out.println(productKey.getProductKey());
	}
}
