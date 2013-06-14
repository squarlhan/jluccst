package com.boan.crm.utils.json;

import java.lang.reflect.Method;

/**
 * XXX 类
 * 
 * @author XXX
 * @version 1.0.0
 */
public class JsonValueInvisibleFilter extends AbstractMethodFilter {
	// 过滤条件，标注中有符合这个条件的property将被过滤掉
	private String _sGUIID;

	public JsonValueInvisibleFilter(final String guiid) {
		_sGUIID = guiid;
	}

	public boolean apply(final Method method) {
		if (_sGUIID == null || _sGUIID.equals("")) {
			return false; // 表示不做限制
		}

		if (method.isAnnotationPresent(JsonValueInvisible.class)) {
			JsonValueInvisible anno = method.getAnnotation(JsonValueInvisible.class);
			String[] value = anno.value();
			for (int i = 0; i < value.length; i++) {
				if (_sGUIID.equals(value[i])) {
					return true;
				}
			}
		}
		return false;
	}
}