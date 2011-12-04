package cn.edu.jlu.ccst.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.model.BackwardandResult;
import cn.edu.jlu.ccst.model.User;
import cn.edu.jlu.ccst.service.BackwardandResultService;
import cn.edu.jlu.ccst.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;




@Component("backwardResultAction")
@Scope("prototype")
public class BackwardResultAction extends ActionSupport {
	private UserService userService; 
	private User user;
	private Map nvs;
	private List<BackwardandResult> backwardandResultlist;
	private BackwardandResultService backwardandResultService;
	
	
	
	
	public UserService getUserService() {
		return userService;
	}

  @Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Map getNvs() {
		return nvs;
	}


	public void setNvs(Map nvs) {
		this.nvs = nvs;
	}


	public List<BackwardandResult> getBackwardandResultlist() {
		return backwardandResultlist;
	}


	public void setBackwardandResultlist(
			List<BackwardandResult> backwardandResultlist) {
		this.backwardandResultlist = backwardandResultlist;
	}


	public BackwardandResultService getBackwardandResultService() {
		return backwardandResultService;
	}

	@Resource
	public void setBackwardandResultService(
			BackwardandResultService backwardandResultService) {
		this.backwardandResultService = backwardandResultService;
	}


	public String execute() {
		if(checkuser()){
			backwardandResultlist =backwardandResultService.findall();
			return "success";}
			else return "unuserlogin";
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
}