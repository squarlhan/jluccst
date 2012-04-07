/**
 * Copyright (c) 2010 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)CurrentDateTime.java 1.1 2008-3-12
 */

package com.boan.rees.utils.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;


/**
 * CurrentDateTime.java 类
 * 
 * @author XXX
 * @version 1.0.0
 */
public class CurrentDateTime implements ChineseNumber
{
	private static CurrentDateTime instance = null;

	private static final String[] weeks = new String[] { "星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

	private CurrentDateTime() {
	}

	public static CurrentDateTime getInstance() {
		if (instance == null)
			instance = new CurrentDateTime();
		return instance;
	}

	/**
	 * 获取服务器当前系统时间表示的年月日中文的日期字符串
	 * 
	 * @return String 如：2008年03月20日
	 */
	public static String getChineseCurrentDate() {
		Calendar curDateTime = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(curDateTime.getTime());
	}
	/**
	 * 获取指定时间表示的年月日中文的日期字符串
	 * 
	 * @return String 如：2008年03月20日
	 */
	public static String getChineseCurrentDate(Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(calendar.getTime());
	}

	/**
	 * 获取服务器当前系统时间表示的年月日简化的日期字符串
	 * 
	 * @return String 如：2008-03-20
	 */
	public static String getCurrentDate() {
		Calendar curDateTime = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(curDateTime.getTime());
	}
	/**
	 * 获取指定时间表示的年月日简化的日期字符串
	 * 
	 * @return String 如：2008-03-20
	 */
	public static String getCurrentDate(Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(calendar.getTime());
	}
	/**
	 * 获取服务器当前系统时间表示的年、月、日和时、分、秒的简化的日期时间字符串
	 * 
	 * @return String 如：2008-03-20 18:20:10
	 */
	public static String getCurrentDateTime() {
		Calendar curDateTime = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(curDateTime.getTime());
	}
	/**
	 * 获取指定时间表示的年月日简化的日期字符串
	 * 
	 * @param calendar
	 *            Calendar对象实例
	 * @return String 如：2008-03-20 18:20:10
	 */
	public static String getCurrentDateTime(Calendar calendar) {
		if (calendar == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(calendar.getTime());
	}
	/**
	 * 获取当前时间表示的时间字符串
	 * 
	 * @param calendar
	 *            Calendar对象实例
	 * @return Stirng 如：18:20
	 */
	public static String getCurrentTime() {
		Calendar curDateTime = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(curDateTime.getTime());
	}
	
	/**
	 * 获取指定时间表示的时间字符串
	 * 
	 * @param calendar
	 *            Calendar对象实例
	 * @return Stirng 如：18:20
	 */
	public static String getCurrentTime(Calendar calendar) {
		if (calendar == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(calendar.getTime());
	}



	/**
	 * 获取服务器当前系统时间表示的年度的整型数值
	 * 
	 * @return int 如：2008
	 */
	public static int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	/**
	 * 获取指定的时间表示的年度的整型数值
	 * 
	 * @param calendar
	 *            Calendar对象实例
	 * @return int 如：2008
	 */
	public static int getCurrentYear(Calendar calendar) {
		if (calendar == null)
			return 0;
		return calendar.get(Calendar.YEAR);
	}
	/**
	 * 获取当前时间表示的月份的整形数值
	 * 
	 * @param calendar
	 *            Calendar对象实例
	 * @return int
	 */
	public static int getCurrentMonth() {
		Calendar curDateTime = Calendar.getInstance();
		return (curDateTime.get(Calendar.MONTH) + 1);
	}
	/**
	 * 获取指定时间表示的月份的整形数值
	 * 
	 * @param calendar
	 *            Calendar对象实例
	 * @return int
	 */
	public static int getCurrentMonth(Calendar calendar) {
		if (calendar == null)
			return 0;
		return (calendar.get(Calendar.MONTH) + 1);
	}

	/**
	 * 返回当天是星期几，如：星期一、星期二
	 * 
	 * @return
	 */
	public static String getCurrentWeek() {
		Calendar cale = Calendar.getInstance();
		return weeks[cale.get(Calendar.DAY_OF_WEEK) - 1];
	}

	/**
	 * 返回指定日期是星期几，如：星期一、星期二
	 * 
	 * @return
	 */
	public static String getCurrentWeek(Calendar cale) {
		return weeks[cale.get(Calendar.DAY_OF_WEEK) - 1];
	}

	/**
	 * 取得当前日期与星期
	 * 
	 * @return
	 */
	public static String getCurrentDateAndWeek() {
		Calendar cale = Calendar.getInstance();
		StringBuffer sb = new StringBuffer();
		sb.append(cale.get(Calendar.YEAR));
		sb.append("年");
		sb.append(cale.get(Calendar.MONTH) + 1);
		sb.append("月");
		sb.append(cale.get(Calendar.DAY_OF_MONTH));
		sb.append("日");
		sb.append(" ");
		sb.append(weeks[cale.get(Calendar.DAY_OF_WEEK) - 1]);
		return sb.toString();
	}
	
	/**
	 * 转换Calendar日期对象成为指定格式的字符串描述
	 * @param cal
	 * @param formatter
	 * @return String
	 */
	public static String formatDateTime( Calendar cal, String formatter )
	{
		String result = "";
		if( cal != null )
		{
			SimpleDateFormat format = null;
			if( StringUtils.isNotBlank( formatter ) )
			{
				format = new SimpleDateFormat( formatter );
			}
			else
			{
				format = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );
			}
			result = format.format( cal.getTime() );
		}
		return result;
	}
	
	/**
	 * 判断指定的日期（sourceTime）在累加上指定的天数（appendDays）后，是否小于目标日期（targetTime）
	 * 
	 * @param sourceTime
	 *            指定的日期，Calendar类型
	 * @param appendDays
	 *            累加上指定的天数
	 * @param targetTime
	 *            目标日期，Calendar类型
	 * @return
	 */
	public static boolean before(Calendar sourceTime, int appendDays, Calendar targetTime) {
		boolean result = false;
		Calendar tmpTime = sourceTime;
		tmpTime.add(Calendar.DAY_OF_YEAR, appendDays);
		result = tmpTime.before(targetTime);
		return result;
	}

	/**
	 * 比较两个日期值的大小
	 * 
	 * @param date1
	 * @param date2
	 * @return 0 两者相等 <0 前者时间在前 >0后者时间在前
	 */
	public static int compareBothDate(Calendar date1, Calendar date2) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String tempDate1 = format.format(date1.getTime());
		String tempDate2 = format.format(date2.getTime());
		int result = tempDate1.compareTo(tempDate2);
		return result;

	}

	/**
	 * 计算两个时间之间相隔天数
	 * 
	 * @param startday
	 *            开始时间
	 * @param endday
	 *            结束时间
	 * @return
	 */
	public static int getIntervalDays(Calendar startDate, Calendar endDate) {
		// 确保startDate在endDate之前
		if (startDate.after(endDate)) {
			Calendar cal = startDate;
			startDate = endDate;
			endDate = cal;
		}
		// 分别得到两个时间的毫秒数
		long sl = startDate.getTimeInMillis();
		long el = endDate.getTimeInMillis();

		long ei = el - sl;
		// 根据毫秒数计算间隔天数
		return (int) (ei / (1000 * 60 * 60 * 24));
	}
	/**
	 * 计算两个时间之间相隔的分钟数
	 * 
	 * @param startday
	 *            开始时间
	 * @param endday
	 *            结束时间
	 * @return
	 */
	public static int getIntervalMinutes( Calendar startDate, Calendar endDate )
	{
		// 确保startDate在endDate之前
		if( startDate.after( endDate ) )
		{
			Calendar cal = startDate;
			startDate = endDate;
			endDate = cal;
		}
		// 分别得到两个时间的毫秒数
		long sl = startDate.getTimeInMillis();
		long el = endDate.getTimeInMillis();

		long ei = el - sl;
		// 根据毫秒数计算间隔天数
		return ( int ) ( ei / ( 1000 * 60 ) );
	}
	public static void main(String[] args) throws Exception {
		// System.out.println( CurrentDateTime.getChineseCurrentDate2(
		// Calendar.getInstance() ) );
		Calendar cal1 = MySimpleDateFormat.parse("2007-12-27", "yyyy-MM-dd");
		Calendar cal2 = MySimpleDateFormat.parse("2007-12-23", "yyyy-MM-dd");
		// System.out.println( CurrentDateTime.before( cal1, 10, cal2 ) );
		// System.out.println( CurrentDateTime.getChineseCurrentDate2( cal1 ) );

		//Calendar c1 = CurrentDateTime.getNewDateTime(Calendar.getInstance(),-4);
		//Calendar c2 = Calendar.getInstance();
		//System.out.println( CurrentDateTime.getIntervalDays(c1, c2) );
	}
}
