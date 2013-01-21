/**
 * 
 */
package com.boan.crm.customer.model;

/**
 * @author luojx
 *
 */
public class CustomerStaticInfo {
	/**
	 * 客户来源
	 */
	public static int CUSTOMER_SOURCE = 2;
	/**
	 * 客户分类
	 */
	public static int CUSTOMER_CATEGORY = 0;
	/**
	 * 客户成熟度
	 */
	public static int CUSTOMER_MATURITY = 4;
	/**
	 * 客户业务进展
	 */
	public static int CUSTOMER_PROGRESS = 7;
	/**
	 * 客户开发程度
	 */
	public static int CUSTOMER_LEVEL = 11;
	
	private int key = 100;
	private String category = "";
	private int count = 0;
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
