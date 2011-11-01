package cn.edu.jlu.ccst.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import cn.edu.jlu.ccst.model.Admin;
import cn.edu.jlu.ccst.service.MailUtil;
import cn.edu.jlu.ccst.service.AdminService;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.jlu.ccst.model.User;
import cn.edu.jlu.ccst.service.UserService;


@Component("adminAction")
@Scope("prototype")
public class AdminAction extends ActionSupport {
	private UserService userService;
	private List<User> userlist;
	

	
	private AdminService adminService; 
	private Admin admin;
	private MailUtil mailUtil;

	public MailUtil getMailUtil() {
		return mailUtil;
	}
	@Resource
	public void setMailUtil(MailUtil mailUtil) {
		this.mailUtil = mailUtil;
	}

	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public AdminService getAdminService() {
		return adminService;
	}
	
	@Resource
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	
	
	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	
	
	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	
	public String execute() {
		Admin flag1;
		userlist = userService.findall();
		flag1=adminService.exits(admin);
		System.out.print(admin);
		if(flag1==null){
			
		  return "loginerror";}
		 else {
			 ActionContext actionContext = ActionContext.getContext();
	        Map session = actionContext.getSession();
	        session.put("ad", flag1);
	        return SUCCESS;}
		
		}
	
	


}
