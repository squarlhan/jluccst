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

import cn.edu.jlu.ccst.model.Backward;
import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.User;

import cn.edu.jlu.ccst.service.BackwardandReasonService;
import cn.edu.jlu.ccst.service.RuleService;
import cn.edu.jlu.ccst.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;




@Component("backwardResonAction")
@Scope("prototype")
public class BackwardReasonAction extends ActionSupport {
 private  BackwardandReasonService backwardandReasonService;
 private RuleService ruleService;
 private  BackwardandReason backwardandReason;
 private List<String> reason_noun;
 private List<String> reason_verb;
 private List<String> sugg;
 private Backward rule;
 
 
public Backward getRule() {
	return rule;
}
public void setRule(Backward rule) {
	this.rule = rule;
}
public RuleService getRuleService() {
	return ruleService;
}
@Resource
public void setRuleService(RuleService ruleService) {
	this.ruleService = ruleService;
}
public List<String> getReason_verb() {
	return reason_verb;
}
public void setReason_verb(List<String> reason_verb) {
	this.reason_verb = reason_verb;
}

public List<String> getSugg() {
	return sugg;
}
public void setSugg(List<String> sugg) {
	this.sugg = sugg;
}
public List<String> getReason_noun() {
	return reason_noun;
}
public void setReason_noun(List<String> reason_noun) {
	this.reason_noun = reason_noun;
}
public BackwardandReason getBackwardandReason() {
	return backwardandReason;
}
public void setBackwardandReason(BackwardandReason backwardandReason) {
	this.backwardandReason = backwardandReason;
}
public BackwardandReasonService getBackwardandReasonService() {
	return backwardandReasonService;
}
 @Resource
public void setBackwardandReasonService(
		BackwardandReasonService backwardandReasonService) {
	this.backwardandReasonService = backwardandReasonService;
}

 public String update(){
	 
	 BackwardandReason temp = backwardandReasonService.findbyid(backwardandReason.getId());
	 try {
		String nouns= new String(backwardandReason.getNouns().getBytes("ISO-8859-1"),"UTF-8");
		String verb= new String(backwardandReason.getVerb().getBytes("ISO-8859-1"),"UTF-8"); 
		 String sugg= new String(backwardandReason.getSugg().getBytes("ISO-8859-1"),"UTF-8"); 
		 backwardandReason.setNouns(nouns);
		 backwardandReason.setSugg(sugg);
		 backwardandReason.setVerb(verb);
		 
		 if(temp.getId()>0){
			 backwardandReason.setBid(temp.getBid());
			 backwardandReasonService.update(backwardandReason);
			 rule = temp.getBid();
			 return "success";
		 }
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 
	
	 return "error";
	 
 }
 public String delete() {
	 
	 backwardandReason = backwardandReasonService.findbyid(backwardandReason.getId());
	 rule = backwardandReason.getBid();
	 backwardandReasonService.removebyid(backwardandReason.getId());
	
		return "success";

	}
	
 public String save(){
	 ActionContext actionContext = ActionContext.getContext();
     Map session = actionContext.getSession();
     rule = (Backward) session.get("rule");
	 for(int i = 0; i <= reason_noun.size() - 1; i++){
		 BackwardandReason brs = new BackwardandReason();
		 System.out.println("我是bid"+rule.getBid());
		    
		    brs.setBid(rule);
			brs.setNouns(reason_noun.get(i).trim());
			brs.setVerb(reason_verb.get(i).trim());
			brs.setSugg(sugg.get(i).trim());
//			List<BackwardandReason> aaa = rule.getReasons();
//			aaa.add(brs);
//			rule.setReasons(aaa);
			if (reason_noun.get(i).trim().length() > 0
					&& reason_verb.get(i).trim().length() > 0
					&& sugg.get(i).trim().length() > 0) { 
				backwardandReasonService.update(brs);
				
			}
	}
	 return "success";
	 
	 
	 
 }
	
	
}