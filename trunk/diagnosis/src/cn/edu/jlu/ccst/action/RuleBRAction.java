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
/**
 * 专家使用的规则和结果对应表相关操作
 * @author Woden
 *
 */
@Component("rulebrAction")
@Scope("prototype")
public class RuleBRAction extends ActionSupport {
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
	 * 用户页面需要的联动下拉框数据
	 */
	private Map nvs;
	/**
	 * 从用户页面得到的规则结果名词
	 */
	private String noun;
	/**
	 * 从用页面得到的设备分组列表
	 */
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

	/**
	 * 检查是否是是专家用户
	 * @return 是返回true,否则返回false
	 */
	public boolean checkprof() {
		ActionContext actionContext = ActionContext.getContext();
		Map user = actionContext.getSession();
		User us = (User) user.get("pr");
		if (us != null) {
			return true;
		} else
			return false;
	}
/**
 * 跳转到规则推理页面
 */
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
	/**
	 * 通过设备分组过滤规则
	 * @return 规则列表
	 */
	public String findbynounp() {
		// nb=rulebrService.getalloptions();
		if (checkprof()) {
			  try {
				   String tunit= new String(unit.getBytes("ISO-8859-1"),"UTF-8");
			       nvs = rulebrService.getbynvsp(tunit);
			
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
	/**
	 * 通过现象名词过滤规则
	 * @return 规则列表
	 */
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
