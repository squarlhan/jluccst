package com.boan.crm.utils.json;

import java.util.Map;
import java.lang.reflect.Method;
import net.sf.json.util.PropertyFilter;

/**
 * XXX 类
 * 
 * @author XXX
 * @version 1.0.0
 */
public abstract class AbstractMethodFilter implements PropertyFilter {

	public abstract boolean apply(final Method method);

	public boolean apply(final Object source, final String name, final Object value) {
		if (source instanceof Map) {
			return false;
		}
		String propName = name.substring(0, 1).toUpperCase() + name.substring(1);
		Class clz = source.getClass();
		String methodName = "get" + propName;
		Method method = null;
		try {
			method = clz.getMethod(methodName, (Class[]) null); // 寻找属性的get方法
		} catch (NoSuchMethodException nsme) {
			String methodName2 = "is" + propName; // 寻找is方法
			try {
				method = clz.getMethod(methodName2, (Class[]) null);
			} catch (NoSuchMethodException ne) {
				System.out.println(ne.getMessage());
				return true;
			}
		}
		return apply(method);
	}
}
