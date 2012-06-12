/*
 * @(#)DateConverter.java 1.1 2012-4-6
 */

package com.boan.crm.utils.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * 时间类型转换
 * @author ZhuYF
 * @version 1.0.0
 */
public class CalendarConverter extends StrutsTypeConverter
{
	private static SimpleDateFormat sf=new SimpleDateFormat( "yyyy-MM-dd" ); 
	/**
	 * 从字符串转化为Calendar类型
	 */
	public Object convertFromString( Map arg0, String[] arg1, Class arg2 )
	{
		if( "".equals( arg1[0] )  )
		{
			return null;
		}
		try
		{
			Date date=sf.parse( arg1[0] );
			Calendar ca=Calendar.getInstance();
			ca.setTime( date );
			return ca;
		}
		catch( ParseException e )
		{
			throw new TypeConversionException(e.getMessage()+"["+arg1+"-class:"+arg2+"]");
			
		}
	}
	/**
	 * 从calendar转化为字符串
	 */
	public String convertToString( Map arg0, Object arg1 )
	{
		Calendar ca=(Calendar)arg1;
		return sf.format( ca.getTime() );
	}

}

