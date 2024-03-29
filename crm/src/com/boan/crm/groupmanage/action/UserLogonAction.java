/**
 * Copyright (c) 2010 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)LogonAction.java 1.1 Jun 8, 2010
 */

package com.boan.crm.groupmanage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.boan.crm.backstagemanage.common.ProductType;
import com.boan.crm.backstagemanage.model.Company;
import com.boan.crm.backstagemanage.service.ICompanyService;
import com.boan.crm.common.Message;
import com.boan.crm.common.UserType;
import com.boan.crm.groupmanage.common.HMAC_MD5;
import com.boan.crm.groupmanage.common.MenuKey;
import com.boan.crm.groupmanage.common.MenuPopedomType;
import com.boan.crm.groupmanage.common.RoleFlag;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.model.EkeyUser;
import com.boan.crm.groupmanage.model.Menu;
import com.boan.crm.groupmanage.model.Role;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.security.CheckProductKey;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IEkeyUserService;
import com.boan.crm.groupmanage.service.IMenuService;
import com.boan.crm.groupmanage.service.IPopedomService;
import com.boan.crm.groupmanage.service.IRoleService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.utils.md5.MakeMd5;
import com.opensymphony.xwork2.ActionSupport;

/**
 * XXX 类
 * 
 * @author XXX
 * @version 1.0.0
 */
@Controller("userLogonAction")
@Scope("prototype")
public class UserLogonAction extends ActionSupport {
	/**
	 * 用户接口
	 */
	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;
	/**
	 * 权限接口
	 */
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	/**
	 * 获取公司名称
	 */
	@Autowired
	@Qualifier("companyService")
	private ICompanyService companyService = null;
	/**
	 * 获取部门名称
	 */
	@Autowired
	@Qualifier("deptService")
	private IDeptmentService deptService = null;
	/**
	 * 获取菜单数据
	 */
	@Autowired
	@Qualifier("menuService")
	private IMenuService menuService = null;
	/**
	 * key用户接口
	 */
	@Autowired
	@Qualifier("ekeyUserService")
	private IEkeyUserService ekeyUserService = null;

	@Autowired
	@Qualifier("roleService")
	private IRoleService roleService = null;

	private Message message = new Message();

	private String userId = null;

	private String username = null;

	private String password = null;

	private String userCName = null;

	private String fullGroupName = null;

	private String oldPassword = null;

	private String newPassword = null;

	private String companyName = null;

	private String deptId = null;
	
	private String deptName = null;

	private String factoryName = null;

	private String workshopName = null;

	private String suffix = "";

	private String hashToken = null;

	private String randomData = "";

	private String keySn = null;

	private List<Menu> menuList = null;

	private String topImage = "";

	private String isSuperUser = null;

	private String desktopUrl = "";

	private boolean isHashPopedom01 = false;

	private boolean isHashPopedom02 = false;

	private boolean isHashPopedom03 = false;

	/**
	 * 验证密码
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logonValid() throws Exception {
		String md5 = MakeMd5.MD5(password);
		boolean b = false;
		// 验证产品是否过期
		CheckProductKey productKey = new CheckProductKey();
		if (productKey.getProductKey()) {
			message.setContent(CheckProductKey.message);
			return ERROR;
		}
		try {
			b = userService.logonValid(username, md5);
		} catch (Exception e) {
			e.printStackTrace();
			message.setContent("数据库连接失败，请联系管理员！");
			return ERROR;
		}
		if (b) {
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = userService.queryUserByUsername(username);
			ServletContext servletContext = session.getServletContext();
			WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
			if (user != null) {
				if (user.getUserType() == UserType.ADMINISTRATOR) {
					message.setContent("您是超级管理员，请使用身份锁登录！");
					// return ERROR;
				}
				String roleId = user.getRoleId();
				String[] popedomKeys = null;
				Role role = null;
				if (StringUtils.isNotBlank(roleId)) {
					// 获取权限串
					popedomKeys = popedomService.queryPopedomsByRoleId(roleId);
					// 获取角色对象
					role = roleService.get(roleId);
				}
				;
				// 创建userSession对象
				UserSession userSession = new UserSession();
				userSession.setUserId(user.getId());
				userSession.setUsername(user.getUsername());
				userSession.setUserCName(user.getUserCName());
				userSession.setDeptId(user.getDeptId());
				userSession.setCompanyId(user.getCompanyId());
				userSession.setUserType(user.getUserType());
				userSession.setPopedomKeys(popedomKeys);
				userSession.setUserPhone(user.getPhone());
				userSession.setProductSuffix(productKey.getProductSuffix());
				if (role != null) {
					userSession.setRoleKey(role.getRoleKey());
				}
				// 默认是销售团队管理系统
				userSession.setProductType(ProductType.TEAM_MANAGE);
				if (companyService != null) {
					if (StringUtils.isNotBlank(user.getCompanyId())) {
						Company company = companyService.get(user.getCompanyId());
						if (company != null) {
							userSession.setCompanyName(company.getCompanyName());
							userSession.setCompanyTrialFlag(company.getTrialFlag());
							userSession.setProductType(company.getProductType());
						}
						if (company.checkServiceTerm()) {
							message.setContent("您的账号已过试用期，请联系软件供应商！");
							return ERROR;
						}
					}
				}
				if (deptService != null) {
					if (StringUtils.isNotBlank(user.getDeptId())) {
						Deptment deptment = deptService.get(user.getDeptId());
						if (deptment != null) {
							userSession.setDeptName(deptment.getDeptName());
						}
					}
				}
				// 创建Session
				session.setAttribute("userSession", userSession);
				// 单位为秒,设置为一天
				session.setMaxInactiveInterval(60 * 60 * 1);
				// 创建Cookies
				// Cookie myCookie = new Cookie( "loginUserName",
				// user.getUsername());
				// myCookie.setMaxAge(60 * 60 * 24 * 30); //设置Cookie有效期为30天
				// ServletActionContext.getResponse().addCookie(myCookie);
				return SUCCESS;
			} else {
				message.setContent("登录失败，请检查用户名及密码！");

				return ERROR;
			}
		} else {
			message.setContent("登录失败，请检查用户名及密码！");
			return ERROR;
		}
	}

	/**
	 * 验证密码，为手机提供果断json数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logonValidForPhone() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String md5 = MakeMd5.MD5(password);
		boolean b = false;
		// 验证产品是否过期
		CheckProductKey productKey = new CheckProductKey();
		if (productKey.getProductKey()) {
			// message.setContent(CheckProductKey.message);
			// return ERROR;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("status", "failure");
			request.setAttribute("map", map);
			return "show-common-map";
		}
		try {
			b = userService.logonValid(username, md5);
		} catch (Exception e) {
			e.printStackTrace();
			// message.setContent("数据库连接失败，请联系管理员！");
			// return ERROR;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("status", "failure");
			request.setAttribute("map", map);
			return "show-common-map";
		}
		if (b) {
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = userService.queryUserByUsername(username);
			ServletContext servletContext = session.getServletContext();
			WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
			if (user != null) {
				if (user.getUserType() == UserType.ADMINISTRATOR) {
					message.setContent("您是超级管理员，请使用身份锁登录！");
					// return ERROR;
				}
				String roleId = user.getRoleId();
				String[] popedomKeys = null;
				Role role = null;
				if (StringUtils.isNotBlank(roleId)) {
					// 获取权限串
					popedomKeys = popedomService.queryPopedomsByRoleId(roleId);
					// 获取角色对象
					role = roleService.get(roleId);
				}
				;
				// 创建userSession对象
				UserSession userSession = new UserSession();
				userSession.setUserId(user.getId());
				userSession.setUsername(user.getUsername());
				userSession.setUserCName(user.getUserCName());
				userSession.setDeptId(user.getDeptId());
				userSession.setCompanyId(user.getCompanyId());
				userSession.setUserType(user.getUserType());
				userSession.setPopedomKeys(popedomKeys);
				userSession.setUserPhone(user.getPhone());
				userSession.setProductSuffix(productKey.getProductSuffix());
				if (role != null) {
					userSession.setRoleKey(role.getRoleKey());
				}
				// 默认是销售团队管理系统
				userSession.setProductType(ProductType.TEAM_MANAGE);
				if (companyService != null) {
					if (StringUtils.isNotBlank(user.getCompanyId())) {
						Company company = companyService.get(user.getCompanyId());
						if (company != null) {
							userSession.setCompanyName(company.getCompanyName());
							userSession.setCompanyTrialFlag(company.getTrialFlag());
							userSession.setProductType(company.getProductType());
						}
						if (company.checkServiceTerm()) {
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("status", "failure");
							request.setAttribute("map", map);
							return "show-common-map";
							// message.setContent("您的账号已过试用期，请联系软件供应商！");
							// return ERROR;
						}
					}
				}
				if (deptService != null) {
					if (StringUtils.isNotBlank(user.getDeptId())) {
						Deptment deptment = deptService.get(user.getDeptId());
						if (deptment != null) {
							userSession.setDeptName(deptment.getDeptName());
						}
					}
				}
				// 创建Session
				session.setAttribute("userSession", userSession);
				// 单位为秒,设置为一天
				session.setMaxInactiveInterval(60 * 60 * 1);
				// 创建Cookies
				// Cookie myCookie = new Cookie( "loginUserName",
				// user.getUsername());
				// myCookie.setMaxAge(60 * 60 * 24 * 30); //设置Cookie有效期为30天
				// ServletActionContext.getResponse().addCookie(myCookie);

				// 构造Json串
				// （1）返回list
				// List<UserSession> list = xxxxService.getxxxList();
				// int totalCount = 10;
				// request.setAttribute("list", list);
				// request.setAttribute("totalCount", totalCount);
				// return "show-common-list";

				// （2）返回map
				Map<String, Object> map = new HashMap<String, Object>();
				int userType = 0;
				if (RoleFlag.YE_WU_YUAN.equalsIgnoreCase(userSession.getRoleKey())) {
					// 业务员
					map.put("user_group", "1");
					userType = 1;
				} else if (RoleFlag.BU_MEN_LING_DAO.equalsIgnoreCase(userSession.getRoleKey())) {
					// 部门领导
					map.put("user_group", "2");
					map.put("departId", userSession.getDeptId());
					userType = 2;
				} else if (RoleFlag.GONG_SI_LING_DAO.equalsIgnoreCase(userSession.getRoleKey())) {
					map.put("user_group", "3");
					userType = 3;
				} else {
					userType = -1;
				}
				//公司id
				map.put("company_id", userSession.getCompanyId());
				if (userType == -1) {
					map.put("status", "failure");
				} else {
					map.put("status", "success");
					map.put("user_id", userSession.getUserId());
					map.put("user_name", userSession.getUsername());
					map.put("ch_name", userSession.getUserCName());
				}
				request.setAttribute("map", map);
				return "show-common-map";

				// （3）返回object
				// List<UserSession> list = new ArrayList<UserSession>();
				// list.add(userSession);
				// request.setAttribute("object", list);
				// return "show-common-object";
			} else {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("status", "failure");
				request.setAttribute("map", map);
				return "show-common-map";
				// message.setContent("登录失败，请检查用户名及密码！");
				// return ERROR;
			}
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("status", "failure");
			request.setAttribute("map", map);
			return "show-common-map";
			// message.setContent("登录失败，请检查用户名及密码！");
			// return ERROR;
		}
	}

	/**
	 * 根据用户id获取用户职务及权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showUserDutyAndPopedomForPhone() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = null;
		StringBuffer sb   = new StringBuffer();
		sb.append("{");
		if( StringUtils.isNotBlank(userId) )
		{
			user = userService.getUserById(userId);
		}
		if (user != null) {
			String roleKey = null;
			if (StringUtils.isNotBlank(user.getRoleId())) {
				// 获取权限串
				String[] popedomKeys = popedomService.queryPopedomsByRoleId(user.getRoleId());
				// 获取角色对象
				Role role = roleService.get(user.getRoleId());
				if (role != null) {
					roleKey = role.getRoleKey();
					sb.append("\"user_position\":" + "[" );
					sb.append("{\"value\":\""+ role.getRoleName() +"\",\"id\":\""+role.getId()+"\"}");
					sb.append( "]");
				}else
				{
					sb.append("\"user_position\":" + "[]" );
				}
			}else
			{
				sb.append("\"user_position\":" + "[]" );
			}
			// （2）返回map
			int userType = 0;
			String userTypeName = null;
			if (RoleFlag.YE_WU_YUAN.equalsIgnoreCase(roleKey)) {
				// 业务员
				userType = 1;
				userTypeName = "业务员";
			} else if (RoleFlag.BU_MEN_LING_DAO.equalsIgnoreCase(roleKey)) {
				// 部门领导
				userType = 2;
				userTypeName = "部门领导";
			} else if (RoleFlag.GONG_SI_LING_DAO.equalsIgnoreCase(roleKey)) {
				//公司领导
				userType = 3;
				userTypeName = "公司领导";
			} else {
				userType = -1;
				userTypeName = "非法用户";
			}
			sb.append(",\"user_group\":" + "[" );
			sb.append("{\"value\":\""+ userTypeName +"\",\"id\":\""+userType+"\"}");
			sb.append( "]");

		} else {
			sb.append("\"user_position\":" + "[],\"user_group\":" + "[]" );
		}
		sb.append("}");
		request.setAttribute("info", sb.toString());
		return "show-common-string";
	}

	/**
	 * 身份验证成功后，转入桌面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logonMain() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session != null && session.getAttribute("userSession") != null) {
			suffix = ((UserSession) session.getAttribute("userSession")).getProductSuffix();
		}
		return SUCCESS;
	}

	/**
	 * 显示桌面地址
	 * 
	 * @return
	 */
	public String showDesktop() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		isHashPopedom01 = popedomService.isHasPopedom(userSession.getUserId(), String.valueOf(userSession.getUserType()), MenuKey.DESKTOP_CUSTOMER, userSession.getPopedomKeys());
		isHashPopedom02 = popedomService.isHasPopedom(userSession.getUserId(), String.valueOf(userSession.getUserType()), MenuKey.DESKTOP_PLAN_MANAGER, userSession.getPopedomKeys());
		isHashPopedom03 = popedomService.isHasPopedom(userSession.getUserId(), String.valueOf(userSession.getUserType()), MenuKey.DESKTOP_SALES_STAT, userSession.getPopedomKeys());
		// 返回桌面地址
		/*
		 * if (isHashPopedom01) { desktopUrl = "desktop01"; } else if
		 * (isHashPopedom02) { desktopUrl = "desktop02"; } else if
		 * (isHashPopedom03) { desktopUrl = "desktop03"; } else { desktopUrl =
		 * "sysdesktop"; }
		 */
		// 业务员
		if (RoleFlag.YE_WU_YUAN.equalsIgnoreCase(userSession.getRoleKey())) {
			if (isHashPopedom01) {
				desktopUrl = "desktop01";
			} else {
				if (isHashPopedom03) {
					desktopUrl = "desktop03";
				} else if (isHashPopedom02) {
					desktopUrl = "desktop02";
				} else {
					desktopUrl = "sysdesktop";
				}
			}
		}
		// 部门领导
		else if (RoleFlag.BU_MEN_LING_DAO.equalsIgnoreCase(userSession.getRoleKey())) {
			if (isHashPopedom02) {
				desktopUrl = "desktop02";
			} else {
				if (isHashPopedom03) {
					desktopUrl = "desktop03";
				} else if (isHashPopedom01) {
					desktopUrl = "desktop01";
				} else {
					desktopUrl = "sysdesktop";
				}
			}
		}
		// 公司领导
		else if (RoleFlag.GONG_SI_LING_DAO.equalsIgnoreCase(userSession.getRoleKey())) {
			if (isHashPopedom03) {
				desktopUrl = "desktop03";
			} else {
				if (isHashPopedom02) {
					desktopUrl = "desktop02";
				} else if (isHashPopedom01) {
					desktopUrl = "desktop01";
				} else {
					desktopUrl = "sysdesktop";
				}
			}
			// 其他用户
		} else {
			if (isHashPopedom03) {
				desktopUrl = "desktop03";
			} else if (isHashPopedom02) {
				desktopUrl = "desktop02";
			} else if (isHashPopedom01) {
				desktopUrl = "desktop01";
			} else {
				desktopUrl = "sysdesktop";
			}
		}
		return desktopUrl;
	}

	/**
	 * 返回指定桌面页面
	 * 
	 * @return
	 */
	public String showDesktopPage() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		isHashPopedom01 = popedomService.isHasPopedom(userSession.getUserId(), String.valueOf(userSession.getUserType()), MenuKey.DESKTOP_CUSTOMER, userSession.getPopedomKeys());
		isHashPopedom02 = popedomService.isHasPopedom(userSession.getUserId(), String.valueOf(userSession.getUserType()), MenuKey.DESKTOP_PLAN_MANAGER, userSession.getPopedomKeys());
		isHashPopedom03 = popedomService.isHasPopedom(userSession.getUserId(), String.valueOf(userSession.getUserType()), MenuKey.DESKTOP_SALES_STAT, userSession.getPopedomKeys());
		deptId = userSession.getDeptId();
		return desktopUrl;
	}

	/**
	 * 身份验证成功后，转入桌面的top页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logonTop() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session != null && session.getAttribute("userSession") != null) {
			UserSession userSession = (UserSession) session.getAttribute("userSession");
			// 判断是否是超级管理员
			boolean superFlag = popedomService.isSuperAdministrator(userSession.getUserId(), String.valueOf(userSession.getUserType()));
			if (superFlag) {
				isSuperUser = "true";
			}
			fullGroupName = "→";
			if (StringUtils.isNotBlank(((UserSession) session.getAttribute("userSession")).getUserCName())) {
				userCName = ((UserSession) session.getAttribute("userSession")).getUserCName();
			}
			if (StringUtils.isNotBlank(((UserSession) session.getAttribute("userSession")).getCompanyName())) {
				companyName = ((UserSession) session.getAttribute("userSession")).getCompanyName();
				fullGroupName += companyName + "→";
			}
			if (StringUtils.isNotBlank(((UserSession) session.getAttribute("userSession")).getDeptName())) {
				deptName = ((UserSession) session.getAttribute("userSession")).getDeptName();
				fullGroupName += deptName + "→";
			}
			fullGroupName = fullGroupName.substring(1, fullGroupName.length());
			if (fullGroupName.length() > 0) {
				fullGroupName = fullGroupName.substring(0, fullGroupName.length() - 1);
			}
			fullGroupName = StringUtils.defaultIfEmpty(fullGroupName, "超级管理组");
			int productType = ((UserSession) session.getAttribute("userSession")).getProductType();
			if (productType == 0) {
				topImage = "top_crm.jpg";
			} else if (productType == 1) {
				topImage = "top_erp.jpg";
			} else {
				topImage = "top_team.jpg";
			}
		} else {
			topImage = "top_team.jpg";
		}

		return SUCCESS;
	}

	/**
	 * 显示菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logonMenu() throws Exception {

		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");

		int productId = userSession.getProductType();
		boolean superFlag = popedomService.isSuperAdministrator(userSession.getUserId(), String.valueOf(userSession.getUserType()));
		boolean comanyFlag = popedomService.isCompanyAdministrator(userSession.getUserId(), String.valueOf(userSession.getUserType()));
		// 如果是系统管理员，则只取超级管理员菜单
		if (superFlag) {
			menuList = menuService.getOneLevelMenuListByProductType(productId, new String[]{MenuPopedomType.ONLY_SUPER_ADMIN}, 1);
			if (menuList == null || menuList.size() == 0) {
				menuList = new ArrayList<Menu>();
			}
			menuList.addAll(menuService.getOneLevelMenuListByProductType(productId, new String[]{MenuPopedomType.OPEN}, 1));
		} else {
			// 如果是公司管理员，则要取出公司级菜单
			if (menuList == null || menuList.size() == 0) {
				menuList = new ArrayList<Menu>();
			}
			if (comanyFlag) {
				menuList.addAll(menuService.getOneLevelMenuListByProductType(productId, new String[]{ MenuPopedomType.ONLY_COMPANY_ADMIN}, 1));
			}
			menuList.addAll(menuService.getOneLevelMenuListByProductType(productId, new String[]{MenuPopedomType.OPEN}, 1));
			if (menuList == null || menuList.size() == 0) {
				menuList = new ArrayList<Menu>();
			}

			List<Menu> menuCommonList = menuService.getOneLevelMenuListByProductType(productId, new String[]{MenuPopedomType.COMMON}, 1);
			if (menuCommonList != null && menuCommonList.size() > 0) {
				for (int i = 0; i < menuCommonList.size(); i++) {
					if (MenuPopedomType.COMMON.equals(menuCommonList.get(i).getPopedomType())) {
						boolean hasPopedomFlag = popedomService.isHasPopedom(userSession.getUserId(), String.valueOf(userSession.getUserType()), menuCommonList.get(i).getMenuKey(), userSession.getPopedomKeys());
						if (hasPopedomFlag) {
							menuList.add(menuCommonList.get(i));
						}
					}
				}
			}
		}
		if (menuList != null && menuList.size() > 0) {
			List<Menu> subMenuList = null;
			List<Menu> subHasMenuList = null;

			for (int i = 0; i < menuList.size(); i++) {
				subMenuList = menuService.getMenuListByParentKey(productId, menuList.get(i).getMenuKey());
				if (subMenuList != null && subMenuList.size() > 0) {
					subHasMenuList = new ArrayList<Menu>();
					for (int j = 0; j < subMenuList.size(); j++) {
						if (superFlag) {
							if (MenuPopedomType.ONLY_SUPER_ADMIN.equals(subMenuList.get(j).getPopedomType())) {
								subHasMenuList.add(subMenuList.get(j));
								continue;
							}
						}
						if (comanyFlag) {
							if (MenuPopedomType.ONLY_COMPANY_ADMIN.equals(subMenuList.get(j).getPopedomType())) {
								subHasMenuList.add(subMenuList.get(j));
								continue;
							}
						}
						if (MenuPopedomType.OPEN.equals(subMenuList.get(j).getPopedomType())) {
							subHasMenuList.add(subMenuList.get(j));
							continue;
						}
						if (MenuPopedomType.COMMON.equals(subMenuList.get(j).getPopedomType())) {
							boolean hasPopedomFlag = popedomService.isHasPopedom(userSession.getUserId(), String.valueOf(userSession.getUserType()), subMenuList.get(j).getMenuKey(), userSession.getPopedomKeys());
							if (hasPopedomFlag) {
								subHasMenuList.add(subMenuList.get(j));
								continue;
							}
						}
					}
				}
				menuList.get(i).setSubMenuList(subHasMenuList);
				// menuList.get(i).setSubMenuList(subMenuList);
			}
		}
		return SUCCESS;
	}

	/**
	 * 退出登录,释放session资源
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		session.invalidate();
		return SUCCESS;
	}

	/**
	 * PIN登录页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String pinLogin() throws Exception {
		// 生成访问随机数
		char Upper = 'z';
		char Lower = 'a';
		Random r = new Random();
		for (int i = 0; i < 20; i++) {
			int tempval = (int) ((int) Lower + (r.nextFloat() * ((int) (Upper - Lower))));
			randomData += new Character((char) tempval).toString();
		}
		return SUCCESS;
	}

	/**
	 * PIN登录页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String pinLoginValid() throws Exception {
		boolean b = false;
		User user = null;
		// 验证产品是否过期
		CheckProductKey productKey = new CheckProductKey();
		if (productKey.getProductKey()) {
			message.setContent(CheckProductKey.message);
			return ERROR;
		}
		try {
			// 对以下三个关键数据进行处理
			// keySn
			// randomData
			// hashToken
			EkeyUser ekeyUser = ekeyUserService.getEkeyUserById(keySn);
			if (ekeyUser != null) {
				// 获取数据库当中的值
				if (ekeyUser.getKey() != null && !"".equals(ekeyUser.getKey()) && randomData != null && !"".equals(randomData)) {
					// 处理
					HMAC_MD5 hm = new HMAC_MD5(ekeyUser.getKey().getBytes());
					hm.addData(randomData.getBytes());
					hm.sign();
					// 获得客户端Hash串与后台数据库当中的数据Hash处理后,进行对比
					// Md5PasswordEncoder.encodePassword(password, sn_random);
					// !
					/*
					 * if (!hashToken.equals(hm.toString())) {
					 * message.setContent("您正在使用的是非法身份锁，请联系管理员！"); return ERROR;
					 * }
					 */
				}
				String eKeyUserId = ekeyUser.getUserId();
				user = userService.getUserById(eKeyUserId);
				if (user != null) {
					// if (user.getUserType() == UserType.ADMINISTRATOR) {
					// b = true;
					// }
					b = true;
				} else {
					message.setContent("当前身份锁用户并不存在，请联系管理员！");
					return ERROR;
				}
			} else {
				message.setContent("获取身份锁用户失败，请联系管理员！");
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setContent("数据库连接失败，请联系管理员！");
			return ERROR;
		}
		if (b) {
			HttpSession session = ServletActionContext.getRequest().getSession();
			if (user.getUserType() == UserType.ADMINISTRATOR) {
				message.setContent("您是超级管理员，请使用身份锁登录！");
				// return ERROR;
			}
			String roleId = user.getRoleId();
			String[] popedomKeys = null;
			Role role = null;
			if (StringUtils.isNotBlank(roleId)) {
				// 获取权限串
				popedomKeys = popedomService.queryPopedomsByRoleId(roleId);
				// 获取角色对象
				role = roleService.get(roleId);
			}
			;
			// 创建userSession对象
			UserSession userSession = new UserSession();
			userSession.setUserId(user.getId());
			userSession.setUsername(user.getUsername());
			userSession.setUserCName(user.getUserCName());
			userSession.setDeptId(user.getDeptId());
			userSession.setCompanyId(user.getCompanyId());
			userSession.setUserType(user.getUserType());
			userSession.setPopedomKeys(popedomKeys);
			userSession.setUserPhone(user.getPhone());
			userSession.setProductSuffix(productKey.getProductSuffix());
			if (role != null) {
				userSession.setRoleKey(role.getRoleKey());
			}
			// 默认是销售团队管理系统
			userSession.setProductType(ProductType.TEAM_MANAGE);
			if (companyService != null) {
				if (StringUtils.isNotBlank(user.getCompanyId())) {
					Company company = companyService.get(user.getCompanyId());
					if (company != null) {
						userSession.setCompanyName(company.getCompanyName());
						userSession.setCompanyTrialFlag(company.getTrialFlag());
						userSession.setProductType(company.getProductType());
					}
					if (company.checkServiceTerm()) {
						message.setContent("您的账号已过试用期，请联系软件供应商！");
						return ERROR;
					}
				}
			}
			if (deptService != null) {
				if (StringUtils.isNotBlank(user.getDeptId())) {
					Deptment deptment = deptService.get(user.getDeptId());
					if (deptment != null) {
						userSession.setDeptName(deptment.getDeptName());
					}
				}
			}
			// 创建Session
			session.setAttribute("userSession", userSession);
			// 单位为秒,设置为一天
			session.setMaxInactiveInterval(60 * 60 * 1);
			// 创建Cookies
			// Cookie myCookie = new Cookie( "loginUserName",
			// user.getUsername());
			// myCookie.setMaxAge(60 * 60 * 24 * 30); //设置Cookie有效期为30天
			// ServletActionContext.getResponse().addCookie(myCookie);
			return SUCCESS;
		} else {
			message.setContent("登录异常，请联系管理员！！");
			return ERROR;
		}
	}

	/**
	 * 显示修改个人资料的页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showModify() throws Exception {
		return SUCCESS;
	}

	/**
	 * 修改个人资料
	 * 
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session != null && session.getAttribute("userSession") != null) {

			UserSession userSession = (UserSession) session.getAttribute("userSession");
			User user = userService.getUserById(userSession.getUserId());
			String md5 = MakeMd5.MD5(oldPassword);
			String newMd5 = MakeMd5.MD5(newPassword);
			if (md5.equals(user.getPassword())) {
				user.setPassword(newMd5);
				userService.saveOrUpdateUser(user);
				message.setContent("密码修改成功，下次登录时请使用新密码！");
			} else {
				message.setContent("原密码不正确，请重新输入！");
				return ERROR;
			}
		}
		return SUCCESS;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserCName() {
		return userCName;
	}

	public void setUserCName(String userCName) {
		this.userCName = userCName;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IPopedomService getPopedomService() {
		return popedomService;
	}

	public void setPopedomService(IPopedomService popedomService) {
		this.popedomService = popedomService;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getWorkshopName() {
		return workshopName;
	}

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	public String getFullGroupName() {
		return fullGroupName;
	}

	public void setFullGroupName(String fullGroupName) {
		this.fullGroupName = fullGroupName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public ICompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}

	public IDeptmentService getDeptService() {
		return deptService;
	}

	public void setDeptService(IDeptmentService deptService) {
		this.deptService = deptService;
	}

	public String getRandomData() {
		return randomData;
	}

	public void setRandomData(String randomData) {
		this.randomData = randomData;
	}

	public String getHashToken() {
		return hashToken;
	}

	public void setHashToken(String hashToken) {
		this.hashToken = hashToken;
	}

	public IEkeyUserService getEkeyUserService() {
		return ekeyUserService;
	}

	public void setEkeyUserService(IEkeyUserService ekeyUserService) {
		this.ekeyUserService = ekeyUserService;
	}

	public String getKeySn() {
		return keySn;
	}

	public void setKeySn(String keySn) {
		this.keySn = keySn;
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

	public String getTopImage() {
		return topImage;
	}

	public void setTopImage(String topImage) {
		this.topImage = topImage;
	}

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public String getIsSuperUser() {
		return isSuperUser;
	}

	public void setIsSuperUser(String isSuperUser) {
		this.isSuperUser = isSuperUser;
	}

	public String getDesktopUrl() {
		return desktopUrl;
	}

	public void setDesktopUrl(String desktopUrl) {
		this.desktopUrl = desktopUrl;
	}

	public boolean getHashPopedom01() {
		return isHashPopedom01;
	}

	public void setHashPopedom01(boolean isHashPopedom01) {
		this.isHashPopedom01 = isHashPopedom01;
	}

	public boolean getHashPopedom02() {
		return isHashPopedom02;
	}

	public void setHashPopedom02(boolean isHashPopedom02) {
		this.isHashPopedom02 = isHashPopedom02;
	}

	public boolean getHashPopedom03() {
		return isHashPopedom03;
	}

	public void setHashPopedom03(boolean isHashPopedom03) {
		this.isHashPopedom03 = isHashPopedom03;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

}
