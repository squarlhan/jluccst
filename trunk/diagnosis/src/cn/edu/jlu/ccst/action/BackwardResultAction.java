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

/**
 * 规则和结果对应关系相关操作, 从jsp得到用户请求,本类调用相应服务实现该请求,并返回成功页面
 * @author Woden
 *
 */


@Component("backwardResultAction")
@Scope("prototype")
public class BackwardResultAction extends ActionSupport {
	/**
	 * 用户相关服务
	 */
	private UserService userService; 
	/**
	 * 得到的用户实例
	 */
	private User user;
	/**
	 * 实现联动下拉框需要的映射对象
	 */
	private Map nvs;
	/**
	 * 与jsp交互用的规则和结果对应关系表
	 */
	private List<BackwardandResult> backwardandResultlist;
	/**
	 * 规则和结果对应关系相关服务类
	 */
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

	/**
	 * 该action默认方法, 返回所有规则和结果对应关系
	 * @return 关系列表
	 */
	public String execute() {
		if(checkuser()){
			backwardandResultlist =backwardandResultService.findall();
			return "success";}
			else return "unuserlogin";
	}
	
	/**
	 * 检查请求该页面的用户是否合法
	 * @return 合法返回正常页面, 否则返回错误页面
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
}