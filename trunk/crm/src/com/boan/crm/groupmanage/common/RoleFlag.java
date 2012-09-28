/**
 * Copyright (c) 2010 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)RoleFlag 1.1 Jun 11, 2010
 */
package com.boan.crm.groupmanage.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * XXX 类
 * 
 * @author XXX
 * @version 1.0.0
 */
public class RoleFlag {
	/**
	 * 业务员
	 */
	public static String YE_WU_YUAN = "YE_WU_YUAN";

	/**
	 * 业务员中文名称
	 */
	private static String[] roleEn = { YE_WU_YUAN };
	/**
	 * 业务员中文名称
	 */
	private static String[] roleCn = { "系统业务员" };

	/**
	 * 获取角色标识实体
	 * 
	 * @return
	 */
	public static Map<String, String> getRoleFlagList() {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < roleEn.length; i++) {
			map.put(roleEn[i], roleCn[i]);
		}
		return map;
	}

	/**
	 * 根据英文标识取中文名称
	 * 
	 * @param en
	 * @return
	 */
	public static String getRoleCnByRoleEn(String en) {
		Map<String, String> map = RoleFlag.getRoleFlagList();
		return map.get(en);
	}

	public static void main(String[] args) {
		System.out.print(RoleFlag.getRoleFlagList());
	}
}