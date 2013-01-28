package com.boan.crm.groupmanage.dao;

import java.util.List;

import com.boan.crm.groupmanage.model.Menu;

/**
 * 菜单管理类
 * 
 * @author Administrator
 * 
 */
public interface IMenuDao {
	/**
	 * 保存和更新
	 * @param menu
	 */
	public void saveOrUpdateMenu( Menu menu);
	/**
	 * 根据key获取菜单
	 * 
	 * @param key
	 * @return
	 */
	public Menu getMenuByKey(String key);
	
	/**
	 * 根据id获取菜单
	 * @param id
	 * @return
	 */
	public Menu getMenuById( String id );
	/**
	 * 删除菜单
	 * @param ids
	 */
	public void deleteMenuByIds( String[] ids );

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
	 * @param productId
	 * @param levelNum
	 * @return
	 */

	public List<Menu> getOneLevelMenuListByProductType(int productId, int levelNum);
	/**
	 * 根据父key，取所有菜单
	 * @param parentKey
	 * @return
	 */
	public List<Menu> getMenuListByParentKey(String parentKey);
	/**
	 * 存储排序菜单
	 * @param menuIds
	 */
	public void saveSortMenu(String[] menuIds);
}
