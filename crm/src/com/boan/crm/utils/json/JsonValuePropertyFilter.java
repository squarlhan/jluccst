package com.boan.crm.utils.json;

import net.sf.json.util.PropertyFilter;

/**
 * 演示类-如何过滤指定属性
 * 
 * @author XXX
 * @version 1.0.0
 */
public class JsonValuePropertyFilter implements PropertyFilter {
	private String fieldName;

	public JsonValuePropertyFilter(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public boolean apply(Object arg0, String arg1, Object arg2) {
		if (arg1.equals(fieldName)) {
			return true; // 表示这个属性将被过滤掉
		}
		return false;
	}
}
