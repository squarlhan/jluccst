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
import cn.edu.jlu.ccst.service.DcsDscribService;
import cn.edu.jlu.ccst.service.RuleService;
import cn.edu.jlu.ccst.service.UserService;

@Component("ruleAction")
@Scope("prototype")
public class RuleAction extends ActionSupport {

	private DcsDscribService dcsDscribService;
	private RuleService ruleService; 
	private BackwardandResult  result;
	private List<BackwardandReason> reasonlist;
	
	
	private List<Backward> backlist;
	private Backward rule;
	private List<String> reason_noun;
	private List<String> result_noun;
	private List<String> reason_verb;
	private List<String> result_verb;
	private List<String> sugg;
	private String resultn;
	private int resultv_value;
    
	
	private List<String> namelist;
	
	
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
	public String getResultn() {
		return resultn;
	}
	public void setResultn(String resultn) {
		this.resultn = resultn;
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
		reasonlist=ruleService.findreasons(temp);
		return "go";
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
	
	public String newAdd(){
		
		String resultv = resultv_value==0?"过高":"过低";
		
		List<DcsDscrib> dcslist = dcsDscribService.findbyname(resultn);
		
		
		List<BackwardandReason> breason = new ArrayList();
		List<BackwardandResult> bresult = new ArrayList();
        //新建规则前件
		BackwardandResult brt = new BackwardandResult();
		brt.setBid(rule);
		brt.setNouns(resultn.trim());
		brt.setVerb(resultv.trim());
		if (resultn.trim().length() > 0
				&& resultv.trim().length() > 0) {
			bresult.add(brt);
		}
		//新建规则后件
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
		if(resultv_value==0){
			List<BackwardandUpper> bus= new ArrayList();
			for(DcsDscrib dd:dcslist){
				BackwardandUpper bu = new BackwardandUpper(rule, dd);
				bus.add(bu);
				dd.getUppers().add(bu);
				dcsDscribService.save(dd);
			}
			rule.setUppers(bus);
		}else{
			List<BackwardandLower> bls= new ArrayList();
			for(DcsDscrib dd:dcslist){
				BackwardandLower bl = new BackwardandLower(rule, dd);
				bls.add(bl);
				dd.getLowers().add(bl);
				dcsDscribService.save(dd);
			}
			rule.setLowers(bls);
		}
		
		ruleService.save(rule);
		namelist = dcsDscribService.findallname();
		return "input";
	}
	public String  backList() {
		backlist = ruleService.findAll();
		return SUCCESS;
	}
	

}
