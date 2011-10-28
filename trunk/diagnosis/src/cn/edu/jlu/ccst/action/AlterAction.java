package cn.edu.jlu.ccst.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.dao.AdminServiceImpl;
import cn.edu.jlu.ccst.model.Admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component("alterAction")
public class AlterAction extends ActionSupport {
	private Admin admin;
	private String newpassword;
	private String renewpassword;
	private String currentpassword;
	private AdminServiceImpl adminServiceImpl;
	public Admin getAdmin() {
		return admin;
	}
	@Resource
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getRenewpassword() {
		return renewpassword;
	}

	public void setRenewpassword(String renewpassword) {
		this.renewpassword = renewpassword;
	}

	public String getCurrentpassword() {
		return currentpassword;
	}

	public void setCurrentpassword(String currentpassword) {
		this.currentpassword = currentpassword;
	}

	

	public AdminServiceImpl getAdminServiceImpl() {
		return adminServiceImpl;
	}
	@Resource
	public void setAdminServiceImpl(AdminServiceImpl adminServiceImpl) {
		this.adminServiceImpl = adminServiceImpl;
	}



	
	/*@Resource
	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public UserServiceImpl getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setRenewpassword(String renewpassword) {
		this.renewpassword = renewpassword;
	}

	public String getRenewpassword() {
		return renewpassword;
	}

	@Resource
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}*/

	public String execute () {
		Admin oldadmin = (Admin) ActionContext.getContext().getSession()
				.get("ad");
		
		System.out.println("++++"+oldadmin+"+++++");
		if (oldadmin.getPassword().equals(currentpassword)) {
			admin.setPassword(newpassword);
			admin.setId(oldadmin.getId());
			admin.setUsername(oldadmin.getUsername());
			adminServiceImpl.save(admin);
			
			
			ActionContext actionContext = ActionContext.getContext();
	        Map session = actionContext.getSession();
	        session.put("ad", admin);
			return SUCCESS;
		} else {
			
			return ERROR;
		}
		/*admin.setUsername(username);
		if (currentpassword.equals(password)) {
			Admin person = adminServiceImpl.findBYusername(admin);
			userServiceImpl.update(person.getId());
			return SUCCESS;
		} else{
			setTip("The password is not correct!");
			return ERROR;*/
		}
	}

/*	public void setCurrentpassword(String currentpassword) {
		this.currentpassword = currentpassword;
	}

	public String getCurrentpassword() {
		return currentpassword;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTip() {
		return tip;
	}

	*/

	


