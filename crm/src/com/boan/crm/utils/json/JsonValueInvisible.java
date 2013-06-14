package com.boan.crm.utils.json;

import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * XXX 类
 * 
 * @author XXX
 * @version 1.0.0
 */
@Documented
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonValueInvisible {
	public String[] value();
}

// 为myBean中需要过滤的属性get方法（或者is方法）加上Invisible标注
