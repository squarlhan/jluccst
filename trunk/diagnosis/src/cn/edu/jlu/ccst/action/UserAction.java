package cn.edu.jlu.ccst.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import cn.edu.jlu.ccst.model.User;
import cn.edu.jlu.ccst.service.UserService;

import cn.edu.jlu.ccst.model.BackwardandResult;
import cn.edu.jlu.ccst.service.RuleBRService;

import java.util.Map;



@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

	private UserService userService; 
	private User user;
	private List<User> userlist;
	private Set set1;
	
	
	private RuleBRService rulebrService; 
	
	private List<BackwardandResult> backwardandResultlist;
	
	private List<String> backwardandResultlist1;
	private List<String> backwardandResultlist2;
	
	
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
	public Set getSet1() {
		return set1;
	}
	public void setSet1(Set set1) {
		this.set1 = set1;
	}
	public List getBackwardandResultlist1() {
		return backwardandResultlist1;
	}

	public void setBackwardandResultlist1(List backwardandResultlist1) {
		this.backwardandResultlist1 = backwardandResultlist1;
	}
	public List getBackwardandResultlist2() {
		return backwardandResultlist2;
	}

	public void setBackwardandResultlist2(List backwardandResultlist2) {
		this.backwardandResultlist2 = backwardandResultlist2;
	}
	public RuleBRService getRulebrService() {
		return rulebrService;
	}
	@Resource
	public void setRulebrService(RuleBRService rulebrService) {
		this.rulebrService = rulebrService;
	}
	public List<BackwardandResult> getBackwardandResultlist() {
		return backwardandResultlist;
	}
	public void setBackwardandResultlist(
			List<BackwardandResult> backwardandResultlist) {
		this.backwardandResultlist = backwardandResultlist;
	}
	
	public String execute() {
		User flag1;
		backwardandResultlist = rulebrService.findAll();
		Set<String> set1=new HashSet();
		Set<String> set2=new HashSet();
	 for(BackwardandResult brt:backwardandResultlist){
		set1.add(brt.getNouns());
		set2.add(brt.getVerb());
	}
	 backwardandResultlist1=new ArrayList();
	 backwardandResultlist2=new ArrayList();
	 backwardandResultlist1.addAll(set1);
	 backwardandResultlist2.addAll(set2);
		flag1=userService.exits(user);
		System.out.print(backwardandResultlist+"998989388974932");
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
		public String logoff() {
			ActionContext.getContext().getSession().remove("us");
			
			System.out.println("注销成功2！");
			return "logoffusersuccess";
		}
		

	
}
