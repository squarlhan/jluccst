package com.boan.crm.groupmanage.service;

import java.util.List;

import com.boan.crm.groupmanage.model.Menu;

/**
 * 菜单管理类
 * 
 * @author Administrator
 * 
 */
public interface IMenuService {
	/**
	 * 根据key获取菜单
	 * 
	 * @param key
	 * @return
	 */
	public Menu getMenuByKey(String key);

	/**
	 * 获取所有菜单列表
	 * 
	 * @return
	 */
	public List<Menu> getAllMenuList();

	/**
	 * 根据产品类型取所有菜单
	 * 
	 * @param productType
	 * @return
	 */

	public List<Menu> getMenuListByProductType(int productType);
	
	/**
	 * 根据产品类型取指定层级的菜单
	 * 
	 * @param productType
	 * @param levelNum
	 * @return
	 */

	public List<Menu> getOneLevelMenuListByProductType(int productType, int levelNum);
}
