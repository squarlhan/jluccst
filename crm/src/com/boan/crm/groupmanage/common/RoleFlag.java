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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;

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
	 * 部门管理员
	 */
	public static String BU_MEN_GUAN_LI_YUAN = "BU_MEN_GUAN_LI_YUAN";

	/**
	 * 公司管理员
	 */
	public static String GONG_SI_GUAN_LI_YUAN = "GONG_SI_GUAN_LI_YUAN";

	/**
	 * 关键标识
	 */
	private static String[] roleEn = { GONG_SI_GUAN_LI_YUAN, BU_MEN_GUAN_LI_YUAN, YE_WU_YUAN };
	/**
	 * 中文名称
	 */
	private static String[] roleCn = { "公司管理员", "部门管理员", "业务员" };

	/**
	 * 获取角色标识实体
	 * 
	 * @return
	 */
	public static Map<String, String> getRoleFlagList() {
		Map<String, String> map = new LinkedHashMap<String, String>();
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
