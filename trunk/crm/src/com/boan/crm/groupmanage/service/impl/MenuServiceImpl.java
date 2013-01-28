package com.boan.crm.groupmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.groupmanage.dao.IMenuDao;
import com.boan.crm.groupmanage.model.Menu;
import com.boan.crm.groupmanage.service.IMenuService;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {
	@Autowired
	@Qualifier("menuDao")
	private IMenuDao menuDao = null;

	@Override
	public Menu getMenuByKey(String key) {
		return menuDao.getMenuByKey(key);
	}

	@Override
	public List<Menu> getAllMenuList() {
		return menuDao.getAllMenuList();
	}

	@Override
	public List<Menu> getMenuListByProductType(int productType) {
		return menuDao.getMenuListByProductType(productType);
	}

	@Override
	public List<Menu> getOneLevelMenuListByProductType(int productId,
			int levelNum) {
		return menuDao.getOneLevelMenuListByProductType(productId, levelNum);
	}

	@Override
	public List<Menu> getMenuListByParentKey(String parentKey) {
		return menuDao.getMenuListByParentKey(parentKey);
	}

	@Override
	public void saveOrUpdateMenu(Menu menu) {
		menuDao.saveOrUpdateMenu(menu);
	}

	@Override
	public Menu getMenuById(String id) {
		return menuDao.getMenuById(id);
	}

	@Override
	public void deleteMenuByIds(String[] ids) {
		menuDao.deleteMenuByIds(ids);
	}

	@Override
	public void saveSortMenu(String[] menuIds) {
		menuDao.saveSortMenu(menuIds);
	}

}
