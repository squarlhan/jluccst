package com.boan.crm.backstagemanage.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品类别
 * 
 * @author Administrator
 * 
 */
public class ProductType {
	/**
	 * CRM系统
	 */
	public static int CRM = 0;
	/**
	 * ERP系统
	 */
	public static int ERP = 1;
	/**
	 * 销售团队管理系统
	 */
	public static int TEAM_MANAGE = 2;
	/**
	 * 静态整型字符的意思
	 */
	private static String[] means = { "CRM管理系统", "ERP管理系统", "销售团队管理系统" };

	/**
	 * 取得中文意思
	 * 
	 * @param logType
	 * @return
	 */
	public static String getMean(int productType) {
		return means[productType];
	}

	/**
	 * 标识号
	 */
	private int num;
	/**
	 * 名称
	 */
	private String name;

	/**
	 * 返回日志类型列表
	 * 
	 * @return
	 */
	public static List<ProductType> getProductTypeList() {
		List<ProductType> productTypeList = new ArrayList<ProductType>();
		ProductType type = null;
		for (int i = 0; i < means.length; i++) {
			type = new ProductType();
			type.setNum(i);
			type.setName(means[i]);
			productTypeList.add(type);
		}
		return productTypeList;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}