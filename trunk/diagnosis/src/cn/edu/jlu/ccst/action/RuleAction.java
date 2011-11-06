package cn.edu.jlu.ccst.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.jlu.ccst.model.*;
import cn.edu.jlu.ccst.service.MailUtil;
import cn.edu.jlu.ccst.service.RuleService;
import cn.edu.jlu.ccst.service.UserService;

@Component("ruleAction")
@Scope("prototype")
public class RuleAction extends ActionSupport {

	
	private RuleService ruleService; 
	
	
	
	private List<Backward> backlist;
	private Backward rule;
	private List<String> reason_noun;
	private List<String> result_noun;
	private List<String> reason_verb;
	private List<String> result_verb;
	private List<String> sugg;

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
		
		backlist = ruleService.findAll();
		
		ActionContext.getContext().getSession().put("backs", backlist);
		return SUCCESS;
		}
	
	public String addRule(){
		List<BackwardandReason> breason = new ArrayList();
		List<BackwardandResult> bresult = new ArrayList();
		for(int i = 0 ;i<=result_noun.size()-1;i++){
			BackwardandResult brt  = new BackwardandResult();
			brt.setBid(rule);
			brt.setNouns(result_noun.get(i).trim());
			brt.setVerb(result_verb.get(i).trim());
			if(result_noun.get(i).trim().length()>0&&result_verb.get(i).trim().length()>0){
				bresult.add(brt);
			}
			
		}
		for(int i = 0 ;i<=reason_noun.size()-1;i++){
			BackwardandReason brs  = new BackwardandReason();
			brs.setBid(rule);
			brs.setNouns(reason_noun.get(i).trim());
			brs.setVerb(reason_verb.get(i).trim());
			brs.setSugg(sugg.get(i).trim());
			if(reason_noun.get(i).trim().length()>0&&
					reason_verb.get(i).trim().length()>0&&
					sugg.get(i).trim().length()>0){
				breason.add(brs);
			}
			
		}
		rule.setReasons(breason);
		rule.setResults(bresult);
		ruleService.save(rule);
		backlist = ruleService.findAll();
		return SUCCESS;
	}
	public String  backList() {
		backlist = ruleService.findAll();
		return SUCCESS;
	}
	

}
