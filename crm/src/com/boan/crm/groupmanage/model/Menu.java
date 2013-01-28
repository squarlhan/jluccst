package com.boan.crm.groupmanage.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.boan.crm.groupmanage.common.MenuPopedomType;

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
	@Column(name = "MENU_KEY", length = 100)
	private String menuKey;
	/**
	 * 菜单名字
	 */
	@Column(name = "MENU_NAME", length = 100)
	private String menuName;
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
	private int levelNum = 1;
	/**
	 * 排序号
	 */
	@Column(name = "SORT_INDEX")
	private int sortIndex;
	/**
	 * 菜单权限类型，SUPER:只能超级管理员使用，COMPANY:只能由公司管理员使用，COMMON:普通菜单，但要通过权限分配才可用，OPEN:谁都可以查看的菜单，不需要设置权限
	 */
	@Column(name = "POPEDOM_TYPE", length=50)
	private String popedomType;
	/**
	 * 完整的在整个系统当中的排序
	 */
	@Column(name = "FULL_SORT_INDEX")
	private int fullSortIndex;
	
	/**
	 * 所有子菜单列表
	 */
	@Transient
	private List<Menu> subMenuList;

	public Menu() {
		this.id = "";
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

	public String getPopedomType() {
		return popedomType;
	}

	public void setPopedomType(String popedomType) {
		this.popedomType = popedomType;
	}


	public String getMenuKey() {
		return menuKey;
	}


	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}


	public String getMenuName() {
		return menuName;
	}


	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}


	public List<Menu> getSubMenuList() {
		return subMenuList;
	}


	public void setSubMenuList(List<Menu> subMenuList) {
		this.subMenuList = subMenuList;
	}

	public String getPopedomTypeCn(){
		return MenuPopedomType.getMean(popedomType);
	}
}
