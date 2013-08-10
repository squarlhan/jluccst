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
		String hql = "from Menu where menuKey = :key";
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
		hql = "from Menu  order by sortIndex";
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
	public List<Menu> getOneLevelMenuListByProductType(int productId, String[] popedomType, int levelNum) {
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		if (popedomType != null && popedomType.length > 0) {
			hql = "from Menu where productId = :productId  and levelNum = :levelNum and popedomType in ( :popedomType ) order by sortIndex";
			map.put("popedomType", popedomType);
			/*
			hql = "from Menu where productId = :productId and popedomType in (";
			for (int i = 0; i < popedomType.length; i++) {
				if (i == 0) {
					hql += " :popedomType" + i;
				} else {
					hql += ", :popedomType" + i;
				}
				map.put("popedomType" + i, popedomType[i]);
			}
			hql += " ) and levelNum = :levelNum order by sortIndex";
			*/
		} else {
			hql = "from Menu where productId = :productId  and levelNum = :levelNum order by sortIndex";
		}
		map.put("productId", productId);
		map.put("levelNum", levelNum);
		return super.find(hql, map);
	}

	@Override
	public List<Menu> getMenuListByParentKey(int productId, String parentKey) {
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		hql = "from Menu where productId = :productId and parentKey = :parentKey order by sortIndex";
		map.put("productId", productId);
		map.put("parentKey", parentKey);
		return super.find(hql, map);
	}

	@Override
	public void saveOrUpdateMenu(Menu menu) {
		if (StringUtils.isNotBlank(menu.getId())) {
			super.update(menu);
		} else {
			super.save(menu);
		}
	}

	@Override
	public Menu getMenuById(String id) {
		return super.get(id);
	}

	@Override
	public void deleteMenuByIds(String[] ids) {
		super.delete(ids);
	}

	@Override
	public void saveSortMenu(String[] menuIds) {
		String hql = "update Menu set sortIndex = :sortIndex where id = :menuId";
		Map<String, Object> map = null;
		if (menuIds != null && menuIds.length > 0) {
			for (int i = 0; i < menuIds.length; i++) {
				map = new HashMap<String, Object>();
				map.put("menuId", menuIds[i]);
				map.put("sortIndex", i);
				super.executeHql(hql, map);
			}
		}
	}

	@Override
	public void deleteMenuByParentKey(int productId, String[] keys) {
		String hql = "delete Menu where productId = :productId and parentKey = :parentKey";
		Map<String, Object> map = null;
		if (keys != null && keys.length > 0) {
			for (int i = 0; i < keys.length; i++) {
				map = new HashMap<String, Object>();
				map.put("productId", productId);
				map.put("parentKey", keys[i]);
				super.executeHql(hql, map);
			}
		}
	}

	@Override
	public boolean isExistSameKey(int productId, String menuKey, String id) {
		boolean b = false;
		int rowCount = 0;
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productId", productId);
		map.put("menuKey", menuKey);
		if (StringUtils.isNotBlank(id)) {
			hql = "select count(id) from Menu where id <> :id and productId= :productId and menuKey = :menuKey";
			map.put("id", id);
		} else {
			hql = "select count(id) from Menu where productId = :productId and menuKey = :menuKey";
		}

		rowCount = super.findCountForPage(hql, map);
		if (rowCount > 0) {
			b = true;
		}
		return b;
	}

}
