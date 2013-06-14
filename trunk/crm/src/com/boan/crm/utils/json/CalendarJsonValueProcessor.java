package com.boan.crm.utils.json;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * XXX 类
 * 
 * @author XXX
 * @version 1.0.0
 */
public class CalendarJsonValueProcessor implements JsonValueProcessor {

	private String format = "yyyy-MM-dd";

	public CalendarJsonValueProcessor() {

	}

	public CalendarJsonValueProcessor(String format) {
		this.format = format;
	}

	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		return null;
	}

	public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
		if (value instanceof Calendar) {
			return new SimpleDateFormat(format).format(((Calendar) value).getTime());
		}
		return null;
	}

}
