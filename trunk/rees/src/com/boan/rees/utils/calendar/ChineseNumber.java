/**
 * Copyright (c) 2010 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
package com.boan.rees.utils.calendar;

/**
 * @author XXX
 *
 */
public interface ChineseNumber
{
	public static final String[] LOWERCASE_FIGURE = { "〇", "一", "二", "三", "四", "五", "六", "七", "八", "九" }; 
	public static final String[] UPERCASE_FIGURE = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	public static final String[] FIGURE_SCALE = { "点", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾", "佰", "仟" };
	public static final String[] FIGURE_SCALE2 = { "点", "十", "百", "千", "万", "十", "百", "千", "亿" };
	public static final String[] MONEY_SCALE = { "分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾", "佰", "仟" };
}
