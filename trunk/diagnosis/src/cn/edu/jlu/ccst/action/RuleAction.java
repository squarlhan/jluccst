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

import cn.edu.jlu.ccst.model.*;
import cn.edu.jlu.ccst.service.DcsDscribService;
import cn.edu.jlu.ccst.service.RuleService;
import cn.edu.jlu.ccst.service.UserService;

@Component("ruleAction")
@Scope("prototype")
public class RuleAction extends ActionSupport {

	private DcsDscribService dcsDscribService;
	private RuleService ruleService;
	private BackwardandResult result;
	private List<BackwardandReason> reasonlist;
	
	private List<Backward> backlist;
	private Backward rule;
	private List<String> reason_noun;
	private List<String> result_noun;
	private List<String> reason_verb;
	private List<String> result_verb;
	private List<String> sugg;
	private String resultn1;
	private String resultn2;
	private int resultv_value;
	private String name;
	private List<String> namelist;
    
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResultn1() {
		return resultn1;
	}

	public void setResultn1(String resultn1) {
		this.resultn1 = resultn1;
	}

	public String getResultn2() {
		return resultn2;
	}

	public void setResultn2(String resultn2) {
		this.resultn2 = resultn2;
	}

	public List<String> getNamelist() {
		return namelist;
	}

	public void setNamelist(List<String> namelist) {
		this.namelist = namelist;
	}

	public DcsDscribService getDcsDscribService() {
		return dcsDscribService;
	}

	@Resource
	public void setDcsDscribService(DcsDscribService dcsDscribService) {
		this.dcsDscribService = dcsDscribService;
	}

	public int getResultv_value() {
		return resultv_value;
	}

	public void setResultv_value(int resultv_value) {
		this.resultv_value = resultv_value;
	}

	public Backward getRule() {
		return rule;
	}

	public void setRule(Backward rule) {
		this.rule = rule;
	}

	public List<Backward> getBacklist() {
		return backlist;
	}

	public void setBacklist(List<Backward> backlist) {
		this.backlist = backlist;
	}

	public RuleService getRuleService() {
		return ruleService;
	}

	@Resource
	public void setRuleService(RuleService ruleService) {
		this.ruleService = ruleService;
	}

	public BackwardandResult getResult() {
		return result;
	}

	public void setResult(BackwardandResult result) {
		this.result = result;
	}

	public List<BackwardandReason> getReasonlist() {
		return reasonlist;
	}

	public void setReasonlist(List<BackwardandReason> reasonlist) {
		this.reasonlist = reasonlist;
	}

	public List<String> getReason_noun() {
		return reason_noun;
	}

	public void setReason_noun(List<String> reason_noun) {
		this.reason_noun = reason_noun;
	}

	public List<String> getResult_noun() {
		return result_noun;
	}

	public void setResult_noun(List<String> result_noun) {
		this.result_noun = result_noun;
	}

	public List<String> getReason_verb() {
		return reason_verb;
	}

	public void setReason_verb(List<String> reason_verb) {
		this.reason_verb = reason_verb;
	}

	public List<String> getResult_verb() {
		return result_verb;
	}

	public void setResult_verb(List<String> result_verb) {
		this.result_verb = result_verb;
	}

	public List<String> getSugg() {
		return sugg;
	}

	public void setSugg(List<String> sugg) {
		this.sugg = sugg;
	}

	public String execute() {
		List<BackwardandResult> temp = new ArrayList();
		temp.add(result);
		reasonlist = ruleService.findreasons(temp);
		return "go";
	}

	public String getall() {
		if (checkprof()) {
			backlist = ruleService.findAll();
			return "list";
		}else{
			return "unproflogin";
		}
	}
	
	public String findbyname(){
		try {
			String keyword= new String(name.getBytes("ISO-8859-1"),"UTF-8");
			backlist = ruleService.findbyname(keyword);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "list";
	}

	public String delRule() {
		ruleService.delete(rule);
		backlist = ruleService.findAll();
		return "list";
	}


	public String justgo() {
		return "gogogo";
	}
	
	public String godetail() {
		rule = ruleService.find(rule);
		if(rule.getResults()!=null&&rule.getResults().size()>0){
			result=rule.getResults().get(0);
		}
		
				
		reasonlist=rule.getReasons();
		System.out.println(rule.getReasons());
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("rule", rule);
		return "show";
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

	public String addRule() {
		List<BackwardandReason> breason = new ArrayList();
		List<BackwardandResult> bresult = new ArrayList();
		for (int i = 0; i <= result_noun.size() - 1; i++) {
			BackwardandResult brt = new BackwardandResult();
			brt.setBid(rule);
			brt.setNouns(result_noun.get(i).trim());
			brt.setVerb(result_verb.get(i).trim());
			if (result_noun.get(i).trim().length() > 0
					&& result_verb.get(i).trim().length() > 0) {
				bresult.add(brt);
			}

		}
		for (int i = 0; i <= reason_noun.size() - 1; i++) {
			BackwardandReason brs = new BackwardandReason();
			brs.setBid(rule);
			brs.setNouns(reason_noun.get(i).trim());
			brs.setVerb(reason_verb.get(i).trim());
			brs.setSugg(sugg.get(i).trim());
			if (reason_noun.get(i).trim().length() > 0
					&& reason_verb.get(i).trim().length() > 0
					&& sugg.get(i).trim().length() > 0) {
				breason.add(brs);
			}

		}
		rule.setReasons(breason);
		rule.setResults(bresult);
		ruleService.save(rule);
		backlist = ruleService.findAll();
		return SUCCESS;
	}

	public String newAdd() {
		rule = new Backward();
		String resultv = resultv_value == 0 ? "过高" : "过低";

		List<DcsDscrib> dcslist = dcsDscribService.findbyname(resultn2);

		List<BackwardandReason> breason = new ArrayList();
		List<BackwardandResult> bresult = new ArrayList();
		// 新建规则前件
		BackwardandResult brt = new BackwardandResult();
		brt.setBid(rule);
		brt.setNouns(resultn1.trim() + resultn2.trim());
		rule.setName(resultn1.trim());
		rule.setMemo(resultn2.trim() + resultv.trim());
		brt.setVerb(resultv.trim());
		if (resultn1.trim().length() > 0 && resultv.trim().length() > 0
				&& resultn2.trim().length() > 0) {
			bresult.add(brt);
		}
		// 新建规则后件
		for (int i = 0; i <= reason_noun.size() - 1; i++) {
			BackwardandReason brs = new BackwardandReason();
			brs.setBid(rule);
			brs.setNouns(reason_noun.get(i).trim());
			brs.setVerb(reason_verb.get(i).trim());
			brs.setSugg(sugg.get(i).trim());
			if (reason_noun.get(i).trim().length() > 0
					|| reason_verb.get(i).trim().length() > 0
					|| sugg.get(i).trim().length() > 0) {
				breason.add(brs);
			}

		}
		rule.setReasons(breason);
		rule.setResults(bresult);
//		ruleService.save(rule);
		if (resultv_value == 0) {
			List<BackwardandUpper> bus = new ArrayList();
			for (DcsDscrib dd : dcslist) {
				BackwardandUpper bu = new BackwardandUpper(rule, dd);
				bus.add(bu);
				dd.getUppers().add(bu);
				dcsDscribService.save(dd);
			}
			rule.setUppers(bus);
		} else {
			List<BackwardandLower> bls = new ArrayList();
			for (DcsDscrib dd : dcslist) {
				BackwardandLower bl = new BackwardandLower(rule, dd);
				bls.add(bl);
				dd.getLowers().add(bl);
				dcsDscribService.save(dd);
			}
			rule.setLowers(bls);
		}

		ruleService.save(rule);
		namelist = dcsDscribService.findallname();
		backlist = ruleService.findAll();
		return "input";
	}

	public String backList() {
		backlist = ruleService.findAll();
		return SUCCESS;
	}

}
