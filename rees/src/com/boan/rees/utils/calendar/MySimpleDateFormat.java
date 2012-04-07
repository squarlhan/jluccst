/**
 * Copyright (c) 2010 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
package com.boan.rees.utils.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class MySimpleDateFormat
{
	/**
	 * 根据指定的时间字符串获取一个相应的Calendar实现对象
	 * @param dateTimeStr
	 * 格式类似为: yyyy-MM-dd hh:mm:ss，时间格式请参见JDK关于时间格式文档
	 * @return Calendar
	 * 若输入参数故dateTimeStr不符合时间格式／或该参数为空意义，则方法返回null指针
	 */
	public static Calendar parse( String dateTimeStr )
	{
		Calendar cal = null;
		String tmpDateTimeStr = StringUtils.trimToEmpty( dateTimeStr );
		String formatter = "yyyy-MM-dd HH:mm:ss";
		if( StringUtils.isNotBlank( tmpDateTimeStr ) )
		{
			SimpleDateFormat format = new SimpleDateFormat( formatter );
			try
			{
				Date date = format.parse( tmpDateTimeStr );
				cal=Calendar.getInstance();
				cal.setTime(date);
			}
			catch( Exception e ) {
				e.printStackTrace();
			}
		}
		return cal;
	}
	/**
	 * 根据指定的时间字符串获取一个相应的Calendar实现对象，时间为一天的第一秒
	 * @param dateTimeStr
	 * 格式类似为: yyyy-MM-dd hh:mm:ss，时间格式请参见JDK关于时间格式文档
	 * @return Calendar
	 * 若输入参数故dateTimeStr不符合时间格式／或该参数为空意义，则方法返回null指针
	 */
	public static Calendar parseToBeginTime( String dateTimeStr )
	{
		Calendar cal = null;
		String tmpDateTimeStr = StringUtils.trimToEmpty( dateTimeStr );
		int pos = tmpDateTimeStr.indexOf(" ");
		if( pos > 0 )
		{
			tmpDateTimeStr = tmpDateTimeStr.substring(0, pos) + " 00:00:01";
		}
		String formatter = "yyyy-MM-dd HH:mm:ss";
		if( StringUtils.isNotBlank( tmpDateTimeStr ) )
		{
			SimpleDateFormat format = new SimpleDateFormat( formatter );
			try
			{
				Date date = format.parse( tmpDateTimeStr );
				cal=Calendar.getInstance();
				cal.setTime(date);
			}
			catch( Exception e ) {
				e.printStackTrace();
			}
		}
		return cal;
	}
	/**
	 * 根据指定的时间字符串获取一个相应的Calendar实现对象，时间为一天的最后一秒
	 * @param dateTimeStr
	 * 格式类似为: yyyy-MM-dd hh:mm:ss，时间格式请参见JDK关于时间格式文档
	 * @return Calendar
	 * 若输入参数故dateTimeStr不符合时间格式／或该参数为空意义，则方法返回null指针
	 */
	public static Calendar parseToEndTime( String dateTimeStr )
	{
		Calendar cal = null;
		String tmpDateTimeStr = StringUtils.trimToEmpty( dateTimeStr );
		int pos = tmpDateTimeStr.indexOf(" ");
		if( pos > 0 )
		{
			tmpDateTimeStr = tmpDateTimeStr.substring(0, pos) + " 23:59:59";
		}
		String formatter = "yyyy-MM-dd HH:mm:ss";
		if( StringUtils.isNotBlank( tmpDateTimeStr ) )
		{
			SimpleDateFormat format = new SimpleDateFormat( formatter );
			try
			{
				Date date = format.parse( tmpDateTimeStr );
				cal=Calendar.getInstance();
				cal.setTime(date);
			}
			catch( Exception e ) {
				e.printStackTrace();
			}
		}
		return cal;
	}
	/**
	 * 根据指定的时间字符串获取一个相应的Calendar实现对象
	 * @param dateTimeStr
	 * @param formatter
	 * 格式类似为: yyyy-MM-dd hh:mm:ss，时间格式请参见JDK关于时间格式文档
	 * @return Calendar
	 * 若输入参数故dateTimeStr不符合时间格式／或该参数为空意义，则方法返回null指针
	 */
	public static Calendar parse( String dateTimeStr, String formatter )
	{
		Calendar cal = null;
		String tmpDateTimeStr = StringUtils.trimToEmpty( dateTimeStr );
		String tmpFormatter = StringUtils.trimToEmpty( formatter );
		if( StringUtils.isNotBlank( tmpDateTimeStr ) )
		{
			SimpleDateFormat format = new SimpleDateFormat( formatter );
			if( StringUtils.isNotBlank( tmpFormatter )  )
				format = new SimpleDateFormat( formatter );
			else
				format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
			try
			{
				Date date = format.parse( tmpDateTimeStr );
				cal=Calendar.getInstance();
				cal.setTime(date);
			}
			catch( Exception e ) {
				format = new SimpleDateFormat( "yyyy-MM-dd HH:mm" );
				try
				{
					Date date = format.parse( tmpDateTimeStr );
					cal=Calendar.getInstance();
					cal.setTime(date);
				}
				catch( Exception ex ) {
					ex.printStackTrace();
				}
			}
		}
		return cal;
	}
	/**
	 * 将指定时间累加天数，后获取一个新的Calendar实例
	 * @param calendar
	 * @param appendDays
	 * @return
	 */
	public static Calendar parseToDateTime( Calendar calendar, int appendDays )
	{
		Calendar newcal = Calendar.getInstance();
		newcal.add(Calendar.DAY_OF_YEAR, appendDays);
		return newcal;
	}
	/**
	 * 判断输入的时间格式字符串是否转换成时间对象成功
	 * @param dateTimeStr
	 * 格式：yyyy-MM-dd
	 * @return boolean
	 * 返回true表示输入的时间格式字符串合法，反之返回false
	 */
	public static boolean dateTimeSimpleValidate( String dateTimeStr )
	{
		boolean result = true;
		if( StringUtils.isNotBlank( dateTimeStr ) )
		{
			SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );
			try
			{
				format.parse( dateTimeStr );
			}
			catch( Exception ex )
			{
				result = false;
			}
		}
		else
			result = false;
		return result;
	}
	
	/**
	 * 判断输入的时间格式字符串是否转换成时间对象成功
	 * @param dateTimeStr
	 * 格式：yyyy-MM-dd hh:mm:ss
	 * @return boolean
	 * 返回true表示输入的时间格式字符串合法，反之返回false
	 */
	public static boolean dateTimeFullValidate( String dateTimeStr )
	{
		boolean result = true;
		if( StringUtils.isNotBlank( dateTimeStr ) )
		{
			SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );
			try
			{
				format.parse( dateTimeStr );
			}
			catch( Exception ex )
			{
				result = false;
			}
		}
		else
			result = false;
		return result;
	}

	public static void main( String[] args ) throws Exception
	{
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );
//		try
//		{
//			System.out.println( "测试：" + format.parse( "2008-1-03 21:2:1" ).toLocaleString() );
////			Calendar cal = Calendar.getInstance();
////			System.out.println( cal.getTime().toLocaleString() );
////			cal.add( Calendar.DAY_OF_YEAR, 90 );
////			System.out.println( cal.getTime().toLocaleString() );
////			System.out.println( cal.getTimeZone() );
//			Date d = new Date();
//			String mydate = ( d.getYear() + 1900 ) + "-" + ( d.getMonth() + 1 ) + "-" + d.getDate();
//			System.out.println( MySimpleDateFormat.parseToDate( mydate  + " 23:56:56", "yyyy-MM-dd hh:mm:ss" ).toLocaleString() );
//		}
//		catch( Exception ex )
//		{
//			ex.printStackTrace();
//		}
//		System.out.println( "**************" );
//		format = new SimpleDateFormat( "yyyy-MM-dd" );
//		Calendar cc = Calendar.getInstance();
//		System.out.println( format.format( cc.getTime() ) );
		//Calendar d1 = MySimpleDateFormat.getMyDate(MySimpleDateFormat.parse( "2008-7-22 23:56:56", "yyyy-MM-dd hh:mm:ss" ));
		//System.out.println( d1.getTime().toLocaleString() );
		//Calendar d2 = MySimpleDateFormat.parse( "2008-7-21 0:0:0", "yyyy-MM-dd hh:mm:ss" );
		//System.out.println( MySimpleDateFormat.diffDate( d2, d1 ) );
	}
}
