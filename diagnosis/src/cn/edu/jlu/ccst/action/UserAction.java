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



import cn.edu.jlu.ccst.model.Backward;
import cn.edu.jlu.ccst.model.User;
import cn.edu.jlu.ccst.service.DcsDscribService;
import cn.edu.jlu.ccst.service.RuleService;
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
	private DcsDscribService dcsDscribService;
	
	
	private RuleBRService rulebrService; 
	
	private List<BackwardandResult> backwardandResultlist;
	
	private List<String> backwardandResultlist1;
	private List<String> backwardandResultlist2;
	
	private RuleService ruleService; 
	private List<String> namelist;
	private List<Backward> backlist;
	
	private String newpassword;
    private String renewpassword;
	private String currentpassword;
	
	private Map nvs;
	
	
    public RuleService getRuleService() {
		return ruleService;
	}
    @Resource
	public void setRuleService(RuleService ruleService) {
		this.ruleService = ruleService;
	}
	public List<Backward> getBacklist() {
		return backlist;
	}
	public void setBacklist(List<Backward> backlist) {
		this.backlist = backlist;
	}
	public DcsDscribService getDcsDscribService() {
		return dcsDscribService;
	}
	@Resource
	public void setDcsDscribService(DcsDscribService dcsDscribService) {
		this.dcsDscribService = dcsDscribService;
	}
	public List<String> getNamelist() {
		return namelist;
	}
	public void setNamelist(List<String> namelist) {
		this.namelist = namelist;
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


	public Map getNvs() {
		return nvs;
	}
	public void setNvs(Map nvs) {
		this.nvs = nvs;
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
//		namelist=dcsDscribService.findallname();
//		backwardandResultlist = rulebrService.findAll();
//		backlist = ruleService.findAll();
		flag1=userService.exits(user);

		if(flag1==null){
			
		  return "loginerror";}
		 else {
			 ActionContext actionContext = ActionContext.getContext();
	        Map session = actionContext.getSession();
	        session.put("us", flag1);
	        
//	        nvs = rulebrService.getallnvs();
//			ActionContext actionContext1 = ActionContext.getContext();
//	        Map session1 = actionContext1.getSession();
//	        session1.put("map", nvs);
	        
	        
	        
	        return "loginsuccess";}
		
		}
	
	
	public boolean checkuser(){
		ActionContext actionContext = ActionContext.getContext();
        Map user = actionContext.getSession();
        User us = (User) user.get("us");
		if(us!=null){
			return true;
		}
		else return false;
	}
	public boolean checkadmin(){
		ActionContext actionContext = ActionContext.getContext();
        Map user = actionContext.getSession();
        User ad = (User) user.get("ad");
		if(ad!=null){
			return true;
		}
		else return false;
	}
	
	public boolean checkprof(){
		ActionContext actionContext = ActionContext.getContext();
        Map user = actionContext.getSession();
        User pr = (User) user.get("pr");
		if(pr!=null){
			return true;
		}
		else return false;
	}

	public String deleteUser() {
		    
		   user =this.userService.findbyid(user.getId());
		   this.userService.removebyid(user.getId());
		   userlist = userService.findall();
			return "deletesuccess";

		}
	public String update()	{
		User temp =this.userService.findbyid(user.getId());
		user.setDept(temp.getDept());
		user.setEmail(temp.getEmail());
		user.setJid(temp.getJid());
		user.setName(temp.getName());
		user.setPassword(temp.getPassword());
		user.setPhone(temp.getPhone());
		user.setUsername(temp.getUsername());
		userService.save(user);
		return "success";
		
	}

	public String chUser() {                   //密码重置
			user = this.userService.findbyid(user.getId());
			user.setPassword((user.getJid()));
			
			this.userService.updateuser(user);
			userlist = userService.findall();
			return "resetsuccess";

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
			if(checkadmin()){
			userlist = userService.findall();
			return SUCCESS;}
			else return "unadminlogin";
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
				user.setIsuser(olduser.getIsuser());
				user.setIsadmin(olduser.getIsadmin());
				user.setIsprof(olduser.getIsprof());
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
			
			if(checkuser()){
			ActionContext.getContext().getSession().remove("us");
			
			System.out.println("注销成功！");
			return "logoffusersuccess";}
			else return "unuserlogin";
		}
   
		
/*************************************管理员操作*************************************************************/		
		
		
		
		
		public String exitsadmin() {
			User flag1;
			userlist = userService.findall();
			flag1=userService.exitsadmin(user);
			
			if(flag1==null){
				
			  return "adminloginerror";}
			 else {
				 ActionContext actionContext = ActionContext.getContext();
		        Map session = actionContext.getSession();
		        session.put("ad", flag1);
		        return "adminsuccess";}
			
			}
	public String alterAdmin () {
				User olduser = (User) ActionContext.getContext().getSession()
						.get("ad");
				
				
				if (olduser.getPassword().equals(currentpassword)) {
					
					if(newpassword.isEmpty())
					{ return "adminnullpass";}
					user.setPassword(newpassword);
					user.setId(olduser.getId());
					user.setUsername(olduser.getUsername());
					user.setIsuser(olduser.getIsuser());
					user.setIsadmin(olduser.getIsadmin());
					user.setIsprof(olduser.getIsprof());
					userService.save(user);
					
					
					ActionContext actionContext = ActionContext.getContext();
			        Map session = actionContext.getSession();
			        session.put("ad", user);
					return "adminaltersuccess";
				} else {
					
					return 	"adminaltererror";
				}
				
				}
	 public String adminlogoff() {
				
				if(checkadmin()){
				ActionContext.getContext().getSession().remove("ad");
				
				System.out.println("注销成功2！");
				return "logoffadminsuccess";}
				else return "unadminlogin";
			}
			
	 /*************************************专家操作*************************************************************/		
		
		
		
		
	 public String exitsprof() {
			User flag1;
			userlist = userService.findall();
			flag1=userService.exitsprof(user);
			
			if(flag1==null){
				
			  return "profloginerror";}
			 else {
				 ActionContext actionContext = ActionContext.getContext();
		        Map session = actionContext.getSession();
		        session.put("pr", flag1);
		        return "profsuccess";}
			
			}
		
	public String alterProf () {
				User olduser = (User) ActionContext.getContext().getSession()
						.get("pr");
				
				
				if (olduser.getPassword().equals(currentpassword)) {
					
					if(newpassword.isEmpty())
					{ return "profnullpass";}
					user.setPassword(newpassword);
					user.setId(olduser.getId());
					user.setUsername(olduser.getUsername());
					user.setIsuser(olduser.getIsuser());
					user.setIsadmin(olduser.getIsadmin());
					user.setIsprof(olduser.getIsprof());
					userService.save(user);
					
					
					ActionContext actionContext = ActionContext.getContext();
			        Map session = actionContext.getSession();
			        session.put("pr", user);
					return "profaltersuccess";
				} else {
					
					return 	"profaltererror";
				}
				
				}
	 public String proflogoff() {
				
				if(checkprof()){
				ActionContext.getContext().getSession().remove("pr");
				
				System.out.println("注销成功3！");
				return "logoffprofsuccess";}
				else return "unproflogin";
			}
	
}
