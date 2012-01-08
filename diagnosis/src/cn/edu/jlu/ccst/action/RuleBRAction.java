package cn.edu.jlu.ccst.action;

import java.io.UnsupportedEncodingException;
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
	private Map nvs;
	private String noun;
    private String unit;
	
	
	

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	

	public String getNoun() {
		return noun;
	}

	public void setNoun(String noun) {
		this.noun = noun;
	}

	public Map getNvs() {
		return nvs;
	}

	public void setNvs(Map nvs) {
		this.nvs = nvs;
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

	
	public boolean checkprof() {
		ActionContext actionContext = ActionContext.getContext();
		Map user = actionContext.getSession();
		User us = (User) user.get("pr");
		if (us != null) {
			return true;
		} else
			return false;
	}

	public String execute() {
		// nb=rulebrService.getalloptions();
		if (checkprof()) {
			nvs = rulebrService.getallnvs();
			
			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			session.put("map", nvs);
			return "rulesuccess";
		}
		return "unproflogin";
		/*
		 * User flag1; backwardandResultlist = rulebrService.findAll();
		 * Set<String> set1=new HashSet(); Set<String> set2=new HashSet();
		 * for(BackwardandResult brt:backwardandResultlist){
		 * set1.add(brt.getNouns()); set2.add(brt.getVerb()); }
		 * backwardandResultlist1=new ArrayList(); backwardandResultlist2=new
		 * ArrayList(); backwardandResultlist1.addAll(set1);
		 * backwardandResultlist2.addAll(set2); return "rulesuccess";
		 */
	}

	public String findbynounp() {
		// nb=rulebrService.getalloptions();
		if (checkprof()) {
			  try {
				   String unit= new String(noun.getBytes("ISO-8859-1"),"UTF-8");
			       nvs = rulebrService.getbynvsp(unit);
			
			       ActionContext actionContext = ActionContext.getContext();
			       Map session = actionContext.getSession();
			       session.put("map", nvs);
			       return "rulesuccess";
		           } catch (UnsupportedEncodingException e) {
			          // TODO Auto-generated catch block
			            //e.printStackTrace();
		                                    } 
			  }
	         	return "unuserlogin";
		/*
		 * User flag1; backwardandResultlist = rulebrService.findAll();
		 * Set<String> set1=new HashSet(); Set<String> set2=new HashSet();
		 * for(BackwardandResult brt:backwardandResultlist){
		 * set1.add(brt.getNouns()); set2.add(brt.getVerb()); }
		 * backwardandResultlist1=new ArrayList(); backwardandResultlist2=new
		 * ArrayList(); backwardandResultlist1.addAll(set1);
		 * backwardandResultlist2.addAll(set2); return "rulesuccess";
		 */
	}
	
	public String findbynoun() {
		// nb=rulebrService.getalloptions();
		if (checkprof()) {
			  try {
				   String keyword= new String(noun.getBytes("ISO-8859-1"),"UTF-8");
			       nvs = rulebrService.getbynvs(keyword);
			
			       ActionContext actionContext = ActionContext.getContext();
			       Map session = actionContext.getSession();
			       session.put("map", nvs);
			       return "rulesuccess";
		           } catch (UnsupportedEncodingException e) {
			          // TODO Auto-generated catch block
			            //e.printStackTrace();
		                                    } 
			  }
	         	return "unproflogin";
		/*
		 * User flag1; backwardandResultlist = rulebrService.findAll();
		 * Set<String> set1=new HashSet(); Set<String> set2=new HashSet();
		 * for(BackwardandResult brt:backwardandResultlist){
		 * set1.add(brt.getNouns()); set2.add(brt.getVerb()); }
		 * backwardandResultlist1=new ArrayList(); backwardandResultlist2=new
		 * ArrayList(); backwardandResultlist1.addAll(set1);
		 * backwardandResultlist2.addAll(set2); return "rulesuccess";
		 */
	}
}
