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



@Component("rulebrAction")
@Scope("prototype")
public class RuleBRAction extends ActionSupport {

	
	
	private RuleBRService rulebrService; 
	
	private List<BackwardandResult> backwardandResultlist;
	
	private List<String> backwardandResultlist1;
	private List<String> backwardandResultlist2;
	
	
	
	
	
	
	
 
	
	
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
	  return "rulesuccess";
		}

	

	

	
}
