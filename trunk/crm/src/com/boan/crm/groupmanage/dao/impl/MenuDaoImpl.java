package com.boan.crm.groupmanage.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.boan.crm.groupmanage.dao.IMenuDao;
import com.boan.crm.groupmanage.model.Menu;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * 菜单DaoImpl
 * 
 * @author Administrator
 * 
 */
@Repository("menuDao")
public class MenuDaoImpl extends BaseDao<Menu, String> implements IMenuDao {

	@Override
	public Menu getMenuByKey(String key) {
		String hql = "from Menu where key = :key";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", key);
		List<Menu> menuList = super.find(hql, map);
		Menu menu = null;
		if (menuList != null && menuList.size() > 0) {
			menu = menuList.get(0);
		}
		return menu;
	}

	@Override
	public List<Menu> getAllMenuList() {
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		hql = "from Menu  order by fullSortIndex";
		return super.find(hql, map);
	}

	@Override
	public List<Menu> getMenuListByProductType(int productType) {
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		hql = "from Menu where productType = :productType order by sortIndex";
		map.put("productType", productType);
		return super.find(hql, map);
	}

	@Override
	public List<Menu> getOneLevelMenuListByProductType(int productType, int levelNum) {
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		hql = "from Menu where productType = :productType and levelNum = :levelNum order by sortIndex";
		map.put("productType", productType);
		map.put("levelNum", levelNum);
		return super.find(hql, map);
	}

}
