package com.boan.crm.groupmanage.common;

import java.util.ArrayList;
import java.util.List;

import com.boan.crm.backstagemanage.common.ProductType;

/**
 * 菜单的权限类型
 * 
 * @author Administrator
 * 
 */
public class MenuPopedomType {
	/**
	 * SUPER:只能超级管理员使用
	 */
	public static String ONLY_SUPER_ADMIN= "ONLY_SUPER_ADMIN";
	/**
	 * COMPANY:只能由公司管理员使用
	 */
	public static String ONLY_COMPANY_ADMIN = "ONLY_COMPANY_ADMIN";
	/**
	 * COMMON:普通菜单，但要通过权限分配才可用
	 */
	public static String COMMON = "COMMON";
	/**
	 * OPEN:谁都可以查看的菜单，不需要设置权限
	 */
	public static String OPEN = "OPEN";

	/**
	 * 关键字串
	 */
	private static String[] keys = {  "COMMON","ONLY_COMPANY_ADMIN","ONLY_SUPER_ADMIN",  "OPEN" };
	/**
	 * 静态整型字符的意思
	 */
	private static String[] means = { "普通菜单", "公司管理员菜单", "超级管理员菜单", "公开菜单" };

	/**
	 * 取得中文意思
	 * 
	 * @param logType
	 * @return
	 */
	public static String getMean(String menuType) {
		for( int i=0; i < keys.length; i++ ){
			if( keys[i].equals(menuType) ){
				return means[i];
			}
		}
		return null;
	}

	/**
	 * 标识号
	 */
	private String  key;
	/**
	 * 名称
	 */
	private String value;

	/**
	 * 返回列表
	 * 
	 * @return
	 */
	public static List<MenuPopedomType> getMenuPopedomTypeList() {
		List<MenuPopedomType> popedomTypeList = new ArrayList<MenuPopedomType>();
		MenuPopedomType type = null;
		for (int i = 0; i < means.length; i++) {
			type = new MenuPopedomType();
			type.setKey(keys[i]);
			type.setValue(means[i]);
			popedomTypeList.add(type);
		}
		return popedomTypeList;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
