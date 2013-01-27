package com.boan.crm.groupmanage.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.backstagemanage.common.LogType;
import com.boan.crm.backstagemanage.common.ProductType;
import com.boan.crm.backstagemanage.model.Log;
import com.boan.crm.common.Message;
import com.boan.crm.groupmanage.model.Menu;
import com.boan.crm.groupmanage.model.Role;
import com.boan.crm.groupmanage.service.IMenuService;
import com.boan.crm.utils.action.BaseActionSupport;
/**
 * 菜单Action
 * @author Administrator
 *
 */
@Controller("menuAction")
@Scope("prototype")
public class MenuAction extends BaseActionSupport {
	@Autowired
	@Qualifier("menuService")
	private IMenuService menuService = null;
	
	private List<Menu> menuList = null;
	
	private String parentKey = null;
	
	private List<ProductType> productList = ProductType.getProductTypeList();

	private String[] ids = null;
	
	private Menu menu = null;

	private Message message = new Message();
	
	private String productId = null;
	
	private String[] menuIds = null;
	
	/**
	 * 打开菜单信息页
	 * 
	 * @return
	 */
	public String showMenuInfo() {
		if( StringUtils.isBlank(menu.getId()) ){
			menu = new Menu();
		}else{
			menu = menuService.getMenuById(menu.getId());
		}
		
		return "show-menu-info";
	}

	/**
	 * 保存菜单
	 * 
	 * @return
	 */
	public String saveMenu() {
		// 验证用户名是否重复
		//boolean b = service.isExistSameName(role.getId(), role.getRoleName(), role.getCompanyId());
		boolean b = false;
		// 如果存在，则提示
		if (b) {
			message.setContent("相同菜单关键字已存在，请重新输入！");
			return "save-error";
		} else {
			menuService.saveOrUpdateMenu(menu);
			message.setContent("菜单信息保存成功！");
			// 保存日志开始
			Log log = new Log();
			log.setLogType(LogType.INFO);
			log.setLogContent("[" + menu.getMenuName() + "]" + "菜单信息添加成功");
			super.saveLog(log);
			// 保存日志结束
			return "save-success";
		}
	}
	/**
	 * 显示一级菜单列表
	 * @return
	 */
	public String showRootMenuList() {
		menuList = menuService.getOneLevelMenuListByProductType(Integer.parseInt(productId), 1);
		return "show-root-menu-tree";
	}
	/**
	 * 删除菜单
	 * 
	 * @return
	 */
	public String deleteRole() {
		if (ids != null && ids.length > 0) {
			Menu rl = null;
			Log log = null;
			for (int i = 0; i < ids.length; i++) {
				rl = menuService.getMenuById(ids[i]);
				if (rl != null) {
					log = new Log();
					log.setLogType(LogType.INFO);
					log.setLogContent("[" + rl.getMenuName() + "]" + "菜单信息删除成功");
					super.saveLog(log);
				}
			}
		}
		menuService.deleteMenuByIds(ids);
		return this.showMenuList();
	}
	/**
	 * 显示菜单列表
	 * @return
	 */
	public String showMenuList() {
		menuList = menuService.getMenuListByParentKey(parentKey);
		return "show-menu-list";
	}
	/**
	 * 显示可排序的菜单
	 * @return
	 */
	public String showSortMenuList(){
		menuList = menuService.getMenuListByParentKey(parentKey);
		return "show-sort-menu-list";
	}
	/**
	 * 保存排序好的菜单
	 * @return
	 */
	public String saveSortMenu(){
		menuService.saveSortMenu(menuIds);
		return "save-sort-success";
	}
	public IMenuService getMenuService() {
		return menuService;
	}
	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	public String getParentKey() {
		return parentKey;
	}
	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}
	public List<ProductType> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductType> productList) {
		this.productList = productList;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String[] getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String[] menuIds) {
		this.menuIds = menuIds;
	}

}
