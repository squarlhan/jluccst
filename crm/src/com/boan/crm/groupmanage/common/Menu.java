package com.boan.crm.groupmanage.common;

/**
 * 菜单对象
 * 
 * @author Administrator
 * 
 */
public class Menu {
	/**
	 * 菜单关键字
	 */
	private String key;
	/**
	 * 菜单值
	 */
	private String value;
	/**
	 * 菜单名字
	 */
	private String name;
	/**
	 * 菜单你父关键字
	 */
	private String parentKey;
	/**
	 * 所属产品id
	 */
	private int productId;
	/**
	 * 层级，从1开始
	 */
	private int levelNum;
	/**
	 * 排序号
	 */
	private int sortIndex;
	/**
	 * 完整的在整个系统当中的排序
	 */
	private int fullSortIndex;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentKey() {
		return parentKey;
	}

	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getLevelNum() {
		return levelNum;
	}

	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}

	public int getFullSortIndex() {
		return fullSortIndex;
	}

	public void setFullSortIndex(int fullSortIndex) {
		this.fullSortIndex = fullSortIndex;
	}

}
