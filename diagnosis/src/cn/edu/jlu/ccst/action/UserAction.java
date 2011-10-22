package cn.edu.jlu.ccst.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import cn.edu.jlu.ccst.model.User;
import cn.edu.jlu.ccst.service.MailUtil;
import cn.edu.jlu.ccst.service.UserService;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

	private UserService userService; 
	private User user;
	private List<User> userlist;
	private MailUtil mailUtil;

	public MailUtil getMailUtil() {
		return mailUtil;
	}
	@Resource
	public void setMailUtil(MailUtil mailUtil) {
		this.mailUtil = mailUtil;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String execute() {
		userlist = userService.findall();
		return SUCCESS;
		}

	public String  addUser() {
		if(userService.exits(user.getUsername())){
			return ERROR;
		}
		userService.save(user);
		userlist = userService.findall();

		mailUtil.setToEmail("squarlhan@163.com");
		mailUtil.setTitle("mail with and spring");
		mailUtil.send();
		return SUCCESS;
	}

}
