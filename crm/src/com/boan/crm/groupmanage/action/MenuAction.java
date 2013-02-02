package com.boan.crm.groupmanage.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.backstagemanage.common.LogType;
import com.boan.crm.backstagemanage.common.ProductType;
import com.boan.crm.backstagemanage.model.Log;
import com.boan.crm.common.Message;
import com.boan.crm.groupmanage.common.MenuPopedomType;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.model.Menu;
import com.boan.crm.groupmanage.model.Role;
import com.boan.crm.groupmanage.service.IMenuService;
import com.boan.crm.groupmanage.service.IPopedomService;
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
	
	/**
	 * 权限接口
	 */
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	private List<Menu> menuList = null;
	
	private String parentKey = null;
	
	private List<ProductType> productList = null;//ProductType.getProductTypeList();
	
	private List<MenuPopedomType> popedomTypeList = MenuPopedomType.getMenuPopedomTypeList();

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
			menu.setProductId(Integer.parseInt(productId));
			menu.setParentKey(parentKey);
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
		// 验证Key是否重复
		boolean b = menuService.isExistSameKey(menu.getProductId(), StringUtils.trim(menu.getMenuKey()), menu.getId());
		// 如果存在，则提示
		if (b) {
			message.setContent("相同菜单关键字已存在，请重新输入！");
			return "save-error";
		} else {
			if( "0".equals(menu.getParentKey()) ){
				menu.setLevelNum(1);
			}else{
				menu.setLevelNum(2);
			}
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
	 * 显示一级菜单列表，用于菜单管理，只用于超级管理员
	 * @return
	 */
	public String showRootMenuList() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		boolean b = popedomService.isSuperAdministrator(userSession.getUserId(), String.valueOf(userSession.getUserType()));
		menuList = new ArrayList<Menu>();
		if( b  ){
			List<Menu> menuList1 = menuService.getOneLevelMenuListByProductType(ProductType.CRM, null,1);
			if( menuList1 != null && menuList1.size() > 0 )
			{
				menuList.addAll(menuList1);
			}
			List<Menu> menuList2 = menuService.getOneLevelMenuListByProductType(ProductType.ERP, null, 1);
			if( menuList2 != null && menuList2.size() > 0 )
			{
				menuList.addAll(menuList2);
			}
			List<Menu> menuList3 = menuService.getOneLevelMenuListByProductType(ProductType.TEAM_MANAGE, null, 1);
			if( menuList3 != null && menuList3.size() > 0 )
			{
				menuList.addAll(menuList3);
			}	
			productList = ProductType.getProductTypeList();
		}
		/*
		else{
			int productId = userSession.getProductType();
			List<Menu> menuListx = menuService.getOneLevelMenuListByProductType(productId,MenuPopedomType.ONLY_COMPANY_ADMIN, 1);
			menuListx.addAll( menuService.getOneLevelMenuListByProductType(productId,MenuPopedomType.COMMON, 2) );
			if( menuListx != null && menuListx.size() > 0 )
			{
				menuList.addAll(menuListx);
			}
			ProductType type = new ProductType();
			type.setName(ProductType.getMean(productId));
			type.setNum(productId);
			productList = new ArrayList<ProductType>();
			productList .add(type);
		}*/
		return "show-root-menu-tree";
	}
	/**
	 * 删除菜单
	 * 
	 * @return
	 */
	public String deleteMenu() {
		if (menuIds != null && menuIds.length > 0) {
			Menu rl = null;
			Log log = null;
			for (int i = 0; i < menuIds.length; i++) {
				rl = menuService.getMenuById(menuIds[i]);
				if (rl != null) {
					menuService.deleteMenuByParentKey(rl.getProductId() , new String[]{rl.getMenuKey()});
					log = new Log();
					log.setLogType(LogType.INFO);
					log.setLogContent("[" + rl.getMenuName() + "]" + "菜单信息删除成功");
					super.saveLog(log);
				}
			}
		}
		menuService.deleteMenuByIds(menuIds);
		return this.showMenuList();
	}
	/**
	 * 显示菜单列表，用于菜单管理
	 * @return
	 */
	public String showMenuList() {
		menuList = menuService.getMenuListByParentKey(Integer.parseInt(productId), parentKey);
		return "show-menu-list";
	}
	/**
	 * 显示菜单列表，用于权限分配
	 * @return
	 */
	public String showMenuListForPopedom(){
		ProductType type = new ProductType();
		type.setName(ProductType.getMean(Integer.parseInt(productId)));
		type.setNum(Integer.parseInt(productId));
		productList = new ArrayList<ProductType>();
		productList .add(type);
		
		menuList = menuService.getOneLevelMenuListByProductType(Integer.parseInt(productId), null,1);
		List<Menu> subMenuList = null;
		for( int i = 0; i < menuList.size(); i++ ){
			subMenuList = menuService.getMenuListByParentKey(Integer.parseInt(productId), menuList.get(i).getMenuKey());
			if( subMenuList  != null && subMenuList .size() > 0){
				menuList.addAll(subMenuList);
			}
		}
		return "show-menu-list-for-popedom";
	}
	/**
	 * 显示可排序的菜单
	 * @return
	 */
	public String showSortMenuList(){
		menuList = menuService.getMenuListByParentKey(Integer.parseInt(productId), parentKey);
		return "show-sort-menu-list";
	}
	/**
	 * 保存排序好的菜单
	 * @return
	 */
	public String saveSortMenu(){
		menuService.saveSortMenu(menuIds);
		message.setContent("菜单排序成功！");
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

	public List<MenuPopedomType> getPopedomTypeList() {
		return popedomTypeList;
	}

	public void setPopedomTypeList(List<MenuPopedomType> popedomTypeList) {
		this.popedomTypeList = popedomTypeList;
	}

	public IPopedomService getPopedomService() {
		return popedomService;
	}

	public void setPopedomService(IPopedomService popedomService) {
		this.popedomService = popedomService;
	}

}
