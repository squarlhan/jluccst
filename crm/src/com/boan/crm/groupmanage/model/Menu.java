package com.boan.crm.groupmanage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 菜单对象
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "SYS_MENU")
public class Menu implements java.io.Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 771626582724932021L;
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	/**
	 * 菜单关键字
	 */
	@Column(name = "KEY", length = 100)
	private String key;
	/**
	 * 菜单值
	 */
	@Column(name = "VALUE", length = 100)
	private String value;
	/**
	 * 菜单名字
	 */
	@Column(name = "NAME", length = 100)
	private String name;
	/**
	 * 菜单你父关键字
	 */
	@Column(name = "PARENT_KEY", length = 100)
	private String parentKey;
	/**
	 * 所属产品id
	 */
	@Column(name = "PRODUCT_ID")
	private int productId;
	/**
	 * 菜单链接
	 */
	@Column(name = "URL", length = 200)
	private String url;

	/**
	 * 层级，从1开始
	 */
	@Column(name = "LEVEL_NUM")
	private int levelNum;
	/**
	 * 排序号
	 */
	@Column(name = "SORT_INDEX")
	private int sortIndex;
	/**
	 * 完整的在整个系统当中的排序
	 */
	@Column(name = "FULL_SORT_INDEX")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
