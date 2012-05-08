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


/**
 * 用户相关操作, 与用户交互并返回相应页面
 * @author Woden
 *
 */
@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {
	/**
	 * 用户相关服务
	 */
	private UserService userService; 
	/**
	 * 与用户交互用的用户实例
	 */
	private User user;
	/**
	 * 与用户交互用的用户列表
	 */
	private List<User> userlist;
	/**
	 * 与用户交互用的用户集合
	 */
	private Set set1;
	/**
	 * 规则描述相关服务
	 */
	private DcsDscribService dcsDscribService;
	
	/**
	 * 规则与结果相关服务
	 */
	private RuleBRService rulebrService; 
	/**
	 * 与用户交互用的规则和结果对应列表
	 */
	private List<BackwardandResult> backwardandResultlist;
	/**
	 * 与用户交互用的规则结果名词列表
	 */
	private List<String> backwardandResultlist1;
	/**
	 * 与用户交互用的规则结果动词列表
	 */
	private List<String> backwardandResultlist2;
	/**
	 * 规则相关服务
	 */
	private RuleService ruleService; 
	/**
	 *  从用页面得到的规则名列表
	 */
	private List<String> namelist;
	/**
	 * 与用户交互用的规则列表
	 */
	private List<Backward> backlist;
	/**
	 *  从用页面得到新密码
	 */
	private String newpassword;
	/**
	 *  从用页面得到新密码
	 */
    private String renewpassword;
    /**
	 *  从用页面得到老密码
	 */
	private String currentpassword;
	/**
	 * 用户页面需要的联动下拉框数据
	 */
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
	/**
	 * 普通用户登录操作
	 */
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
	
	/**
	 * 检查用户是否是普通用户
	 * @return 是返回true,否则返回false
	 */
	public boolean checkuser(){
		ActionContext actionContext = ActionContext.getContext();
        Map user = actionContext.getSession();
        User us = (User) user.get("us");
		if(us!=null){
			return true;
		}
		else return false;
	}
	/**
	 * 检查用户是否是管理员用户
	 * @return 是返回true,否则返回false
	 */
	public boolean checkadmin(){
		ActionContext actionContext = ActionContext.getContext();
        Map user = actionContext.getSession();
        User ad = (User) user.get("ad");
		if(ad!=null){
			return true;
		}
		else return false;
	}
	/**
	 * 检查用户是否是专家用户
	 * @return 是返回true,否则返回false
	 */
	public boolean checkprof(){
		ActionContext actionContext = ActionContext.getContext();
        Map user = actionContext.getSession();
        User pr = (User) user.get("pr");
		if(pr!=null){
			return true;
		}
		else return false;
	}
/**
 * 删除一个用户
 * @return 用户列表
 */
	public String deleteUser() {
		    
		   user =this.userService.findbyid(user.getId());
		   this.userService.removebyid(user.getId());
		   userlist = userService.findall();
			return "deletesuccess";

		}
	/**
	 * 管理员更新一个用户
	 * @return 用户列表
	 */
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
		userlist = userService.findall();
		return "success";
		
	}
	/**
	 * 用户密码重置
	 * @return 用户列表
	 */
	public String chUser() {                   //密码重置
			user = this.userService.findbyid(user.getId());
			user.setPassword((user.getJid()));
			
			this.userService.updateuser(user);
			userlist = userService.findall();
			return "resetsuccess";

		}
	/**
	 * 查找用户
	 * @return 用户列表
	 */
	public String searchUser() {
			userlist = userService.findall();
			userlist = this.userService.search(user);
			if (userlist == null || userlist.size() == 0) {
				return "searcherror";
			} else {
				
				return SUCCESS;
			}
		}

	/**
	 * 新建一个用户
	 * @return 用户列表
	 */
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
			 
			
		
	/**
	 * 得到所有用户
	 * @return 用户列表
	 */
		public String  userList() {
			if(checkadmin()){
			userlist = userService.findall();
			return SUCCESS;}
			else return "unadminlogin";
		}
		/**
		 * 普通用户更改自己信息
		 * @return 用户列表
		 */
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
		
		/**
		 * 普通用户注销
		 * @return 登录页面
		 */
		public String logoff() {
			
			if(checkuser()){
			ActionContext.getContext().getSession().remove("us");
			
			
			return "logoffusersuccess";}
			else return "unuserlogin";
		}
   
		
/*************************************管理员操作*************************************************************/		
		
		
		
		/**
		 * 管理员用户登陆操作
		 * @return 用户管理页面
		 */
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
		/**
		 *管理员用户更改自己信息
		 * @return 用户列表
		 */
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
	/**
	 * 管理员用户注销
	 * @return 登录页面
	 */
	 public String adminlogoff() {
				
				if(checkadmin()){
				ActionContext.getContext().getSession().remove("ad");
				
				
				return "logoffadminsuccess";}
				else return "unadminlogin";
			}
			
	 /*************************************专家操作*************************************************************/		
		
		
		
		/**
		 * 专家用户登陆操作
		 * @return 规则管理页面
		 */
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
	 /**
		 * 专家用户更改自己信息
		 * @return 用户列表
		 */
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
	/**
	 * 专家用户注销
	 * @return 登录页面
	 */
	 public String proflogoff() {
				
				if(checkprof()){
				ActionContext.getContext().getSession().remove("pr");
				
			
				return "logoffprofsuccess";}
				else return "unproflogin";
			}
	
}
