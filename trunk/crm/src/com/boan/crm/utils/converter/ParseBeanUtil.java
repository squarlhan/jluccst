package com.boan.crm.utils.converter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 复制Pojo中的字段给另一个对象
 * @author ZYF
 *
 */
public class ParseBeanUtil {
	// 复制Bean内容
	@SuppressWarnings("unchecked")
	public static Object parseBean(Object objBean, Class clazz) {
		Object obj = null;
		Class classPojo = objBean.getClass();
		Class superClass=classPojo.getSuperclass();//获取父类类型
		
		try {
			obj = clazz.newInstance();
//			Field[] fields = classPojo.getDeclaredFields();
			
			Field[] fields =  clazz.getDeclaredFields();
			if(fields==null || fields.length==0){
				if(clazz.getSuperclass()!=null && !clazz.getSuperclass().toString().equals("")){
					fields = clazz.getSuperclass().getDeclaredFields();
				}
			}
			
			for (int i = 0; i < fields.length; i++) {
				String strGetMethod = "get"
						+ fields[i].getName().substring(0, 1).toUpperCase()
						+ fields[i].getName().substring(1);
				String strSetMethod = "set"
						+ fields[i].getName().substring(0, 1).toUpperCase()
						+ fields[i].getName().substring(1);
				Method getMethod = null;
				Method setMethod = null;
				try {
					getMethod = classPojo.getMethod(strGetMethod);
					setMethod = clazz.getMethod(strSetMethod,
							new Class[] { fields[i].getType() });
				} catch (Exception e) {
					getMethod = null;
					setMethod = null;
				}
				if (getMethod != null && setMethod != null) {
					try {
						setMethod.invoke(obj, new Object[] { getMethod.invoke( objBean) });
					} catch (Exception e) {
					}
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static Object parseMethod( Object one, Object two ){
		Method[] methods = one.getClass().getMethods();
		for(Method oneMethod : methods){
			if(oneMethod.getName().startsWith("set")){
				try {
					String methodName = "get" + oneMethod.getName().substring(3);
					Object o = two.getClass().getMethod(methodName).invoke(two);
					oneMethod.invoke(one, o);
				} catch (IllegalArgumentException e) {
					//e.printStackTrace();
				} catch (SecurityException e) {
					//e.printStackTrace();
				} catch (IllegalAccessException e) {
					//e.printStackTrace();
				} catch (InvocationTargetException e) {
					//e.printStackTrace();
				} catch (NoSuchMethodException e) {
					//e.printStackTrace();
				}
			}
		}
		return one;
	}
}
