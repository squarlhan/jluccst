/**
 * Copyright (c) 2010 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)LogonAction.java 1.1 Jun 8, 2010
 */

package com.boan.crm.groupmanage.action;

import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.boan.crm.backstagemanage.model.Company;
import com.boan.crm.backstagemanage.service.ICompanyService;
import com.boan.crm.common.Message;
import com.boan.crm.common.UserType;
import com.boan.crm.groupmanage.common.HMAC_MD5;
import com.boan.crm.groupmanage.common.Md5PasswordEncoder;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.model.EkeyUser;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.security.CheckProductKey;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IEkeyUserService;
import com.boan.crm.groupmanage.service.IPopedomService;
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
	 * key用户接口
	 */
	@Autowired
	@Qualifier("ekeyUserService")
	private IEkeyUserService ekeyUserService = null;

	private Message message = new Message();

	private String username = null;

	private String password = null;

	private String userCName = null;

	private String fullGroupName = null;

	private String oldPassword = null;

	private String newPassword = null;

	private String companyName = null;

	private String deptName = null;

	private String factoryName = null;

	private String workshopName = null;

	private String suffix = "";

	private String hashToken = null;

	private String randomData = "";

	private String keySn = null;

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
				// 获取权限串
				String roleId = user.getRoleId();
				String[] popedomKeys = popedomService.queryPopedomsByRoleId(roleId);
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
				if (companyService != null) {
					if (StringUtils.isNotBlank(user.getCompanyId())) {
						Company company = companyService.get(user.getCompanyId());
						if (company != null) {
							userSession.setCompanyName(company.getCompanyName());
							userSession.setCompanyTrialFlag(company.getTrialFlag());
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
	 * 身份验证成功后，转入桌面的top页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logonTop() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session != null && session.getAttribute("userSession") != null) {
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
					//Md5PasswordEncoder.encodePassword(password, sn_random);
					//!
					/*
					if (!hashToken.equals(hm.toString())) {
						message.setContent("您正在使用的是非法身份锁，请联系管理员！");
						return ERROR;
					}
					*/
				}
				String eKeyUserId = ekeyUser.getUserId();
				user = userService.getUserById(eKeyUserId);
				if (user != null) {
					if (user.getUserType() == UserType.ADMINISTRATOR) {
						b = true;
					}
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
			ServletContext servletContext = session.getServletContext();
			WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
			if (user != null) {
				// 获取权限串
				String roleId = user.getRoleId();
				String[] popedomKeys = popedomService.queryPopedomsByRoleId(roleId);
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
				if (companyService != null) {
					if (StringUtils.isNotBlank(user.getCompanyId())) {
						Company company = companyService.get(user.getCompanyId());
						if (company != null) {
							userSession.setCompanyName(company.getCompanyName());
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

}
