package com.boan.rees.utils.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期处理类
 * 
 * @author leon
 * 
 */
public class CalendarUtils {
	/**
	 * 返回[1980-2-24 18:12:15]类型的字符串
	 * 
	 * @param obj
	 * @throws Exception
	 */
	public static String toLongString(Calendar cal) {
		String s = null;
		if (cal != null) {
			s = cal.get(cal.YEAR) + "-" + (cal.get(cal.MONTH) + 1) + "-"
					+ cal.get(cal.DAY_OF_MONTH) + " "
					+ cal.get(cal.HOUR_OF_DAY) + ":" + cal.get(cal.MINUTE)
					+ ":" + cal.get(cal.SECOND);
		} else {
			s = "";
		}
		return s;
	}

	/**
	 * 返回[1980-2-24]类型的字符串
	 * 
	 * @param obj
	 * @throws Exception
	 */
	public static String toString(Calendar cal) {
		String s = null;
		if (cal != null) {
			s = cal.get(cal.YEAR) + "-" + (cal.get(cal.MONTH) + 1) + "-"
					+ cal.get(cal.DAY_OF_MONTH);
		} else {
			s = "";
		}
		return s;
	}

	/**
	 * 字符串转换成Calendar日期格式，如2008-8-8
	 * 
	 * @param stringDate
	 * @return
	 */
	public static Calendar toCalendar(String stringDate) {
		Calendar calendar = null;
		Date date = null;
		SimpleDateFormat sdf = null;
		if (stringDate != null) {
			calendar = Calendar.getInstance();
			sdf = new SimpleDateFormat("yyyy-MM-dd");// 时间格式自己设置
			try {
				date = sdf.parse(stringDate);
				if (date != null)
					calendar.setTime(date);
			} catch (Exception e) {
			}
		}
		return calendar;
	}

	/**
	 * 字符串转换成Calendar日期格式，如2008-8-8 12:12:12
	 * 
	 * @param stringDate
	 * @return
	 */
	public static Calendar toLongCalendar(String stringDate) {
		Calendar calendar = null;
		Date date = null;
		SimpleDateFormat sdf = null;
		if (stringDate != null) {
			calendar = Calendar.getInstance();
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时间格式自己设置
			try {
				date = sdf.parse(stringDate);
				if (date != null)
					calendar.setTime(date);
			} catch (Exception e) {
			}
		}
		return calendar;
	}

	/**
	 * 指定时间间隔天数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int getDaysBetween(Calendar d1, Calendar d2) {
		if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
			java.util.Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			d1 = (Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);// 得到当年的实际天数
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	/**
	 * 得到几天前的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Calendar getBeforeCalendar(Calendar cal, int day) {
		cal.set(cal.DATE, cal.get(cal.DATE) - day);
		return cal;
	}

	/**
	 * 得到几天后的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Calendar getAfterCalendar(Calendar cal, int day) {
		cal.set(cal.DATE, cal.get(cal.DATE) + day);
		return cal;
	}

	/**
	 * 获取当前时间所在年的周数
	 * 
	 * @param cal
	 * @return
	 */
	public static int getWeekOfYear(Calendar cal) {
		Calendar c = cal;
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 获取当前时间所在年的最大周数
	 * 
	 * @param year
	 * @return
	 */
	public static int getMaxWeekNumOfYear(int year) {
		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
		return getWeekOfYear(c);
	}

	/**
	 * 获取某年的第几周的开始日期
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Calendar getFirstDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);
		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);
		return getFirstDayOfWeek(cal);
	}

	/**
	 * 获取某年的第几周的结束日期
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Calendar getLastDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);
		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);
		return getLastDayOfWeek(cal);
	}

	/**
	 * 获取当前时间所在周的开始日期
	 * 
	 * @param cal
	 * @return
	 */
	public static Calendar getFirstDayOfWeek(Calendar cal) {
		Calendar c = cal;
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c;
	}

	/**
	 * 获取当前时间所在周的结束日期
	 * 
	 * @param cal
	 * @return
	 */
	public static Calendar getLastDayOfWeek(Calendar cal) {
		Calendar c = cal;
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c;
	}

}
