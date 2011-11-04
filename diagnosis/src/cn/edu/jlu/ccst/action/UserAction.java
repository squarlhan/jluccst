package cn.edu.jlu.ccst.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import cn.edu.jlu.ccst.model.User;
import cn.edu.jlu.ccst.service.MailUtil;
import cn.edu.jlu.ccst.service.UserService;


import java.util.Map;



@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

	private UserService userService; 
	private User user;
	private List<User> userlist;
	
	private String newpassword;
    private String renewpassword;
	private String currentpassword;
	
	
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
		User flag1;
		userlist = userService.findall();
		flag1=userService.exits(user);
		System.out.print(user);
		if(flag1==null){
			
		  return "loginerror";}
		 else {
			 ActionContext actionContext = ActionContext.getContext();
	        Map session = actionContext.getSession();
	        session.put("us", flag1);
	        return "loginsuccess";}
		
		}
	public String deleteUser() {
		    
		   user =this.userService.findbyid(user.getId());
		   this.userService.removebyid(user.getId());
		   userlist = userService.findall();
			return SUCCESS;

		}
		

	public String chUser() {                   //密码重置
			user = this.userService.findbyid(user.getId());
			user.setPassword((user.getJid()));
			
			this.userService.updateuser(user);
			userlist = userService.findall();
			return SUCCESS;

		}
	public String searchUser() {
			userlist = userService.findall();
			userlist = this.userService.search(user);
			if (userlist == null || userlist.size() == 0) {
				return "searcherror";
			} else {
				
				return SUCCESS;
			}
		}


	public String  addUser() {
			
		
			if(userService.findbyusername(user)!=null){
				
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
		
		public String alterUser () {
			User olduser = (User) ActionContext.getContext().getSession()
					.get("us");
			
			
			if (olduser.getPassword().equals(currentpassword)) {
				
				if(newpassword.isEmpty())
				{ return "nullpass";}
				user.setPassword(newpassword);
				user.setId(olduser.getId());
				user.setUsername(olduser.getUsername());
				userService.save(user);
				
				
				ActionContext actionContext = ActionContext.getContext();
		        Map session = actionContext.getSession();
		        session.put("us", user);
				return "altersuccess";
			} else {
				
				return 	"altererror";
			}
			
			}
		
		

	
}
