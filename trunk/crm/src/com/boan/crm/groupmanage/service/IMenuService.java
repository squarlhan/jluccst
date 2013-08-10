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
	 * 保存和更新
	 * 
	 * @param menu
	 */
	public void saveOrUpdateMenu(Menu menu);

	/**
	 * 根据key获取菜单
	 * 
	 * @param key
	 * @return
	 */
	public Menu getMenuByKey(String key);

	/**
	 * 根据id获取菜单
	 * 
	 * @param id
	 * @return
	 */
	public Menu getMenuById(String id);

	/**
	 * 删除菜单
	 * 
	 * @param ids
	 */
	public void deleteMenuByIds(String[] ids);
	/**
	 * 根据父key删作所有子菜单
	 * @param keys
	 */
	public void deleteMenuByParentKey(int productId, String[] keys );

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
	 * 根据父key，取所有菜单
	 * 
	 * @param parentKey
	 * @return
	 */
	public List<Menu> getMenuListByParentKey(int productId, String parentKey);

	/**
	 * 根据产品类型取指定层级的菜单
	 * 
	 * @param productId
	 * @param levelNum
	 * @return
	 */

	public List<Menu> getOneLevelMenuListByProductType(int productId,String[] popedomType, int levelNum);

	/**
	 * 保存排序菜单项
	 * 
	 * @param menuIds
	 */
	public void saveSortMenu(String[] menuIds);
	/**
	 * 一个产品下是否有同Key菜单
	 * @param productId
	 * @param menuKey
	 * @return
	 */
	boolean isExistSameKey(int productId, String menuKey, String id);
}
