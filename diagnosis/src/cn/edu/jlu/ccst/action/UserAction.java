package cn.edu.jlu.ccst.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import cn.edu.jlu.ccst.model.User;
import cn.edu.jlu.ccst.service.MailUtil;
import cn.edu.jlu.ccst.service.UserService;
import cn.edu.jlu.ccst.dao.UserServiceImpl;
import cn.edu.jlu.ccst.dao.UserServiceInter;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

	private UserService userService; 
	private User user;
	private List<User> userlist;
	private UserServiceInter userServiceImpl;
	
	public UserServiceInter getUserServiceImpl() {
		return userServiceImpl;
	}
	@Resource
	public void setUserServiceImpl(UserServiceInter userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

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
		boolean flag;
		userlist = userService.findall();
		flag=userService.exits(user);
		System.out.print(flag);
		if(flag==true){
			
		  return SUCCESS;}
		 else return ERROR;
		
		}
	public String deleteUser() {
		
		   user =this.userServiceImpl.find(user.getId());
		   this.userServiceImpl.remove(user.getId());
		   userlist = userService.findall();
			return SUCCESS;

		}
		

	public String chUser() {                   //密码重置
			user = this.userServiceImpl.find(user.getId());
			user.setPassword((user.getJid()));
			
			this.userServiceImpl.updateUser(user);
			userlist = userService.findall();
			return SUCCESS;

		}
	public String searchUser() {

			/*
			 * user.setUsername(this.getUsername()); user.setPhone(phone);
			 */
			userlist = userService.findall();
			userlist = this.userServiceImpl.searchUser(user);
			if (userlist == null || userlist.size() == 0) {
				return ERROR;
			} else {
				
				return SUCCESS;
			}
		}


	public String  addUser() {
			/*if(userService.exits(user.getUsername())){
				return ERROR;
			}*/
		
			if(userServiceImpl.find(user)!=null){
				
				return "adderror";
			}
			else if(user.getPassword().isEmpty()||user.getUsername().isEmpty())	
			   {return "addnullerror";}
			
			else { userService.save(user ) ;
			   userlist = userService.findall();}
			  return SUCCESS;}
		
			/*mailUtil.setToEmail("squarlhan@163.com");
			mailUtil.setTitle("mail with and spring");
			mailUtil.send();*/
			 
			
		
		
		public String  userList() {
			userlist = userService.findall();
			return SUCCESS;
		}

	
}
