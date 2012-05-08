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


/**
 * 后向规则原因相关操作，从jsp页面得到请求，调用相应的服务完成请求并返回页面
 * @author Woden
 *
 */

@Component("backwardResonAction")
@Scope("prototype")
public class BackwardReasonAction extends ActionSupport {
	/**
	 * 调用的后向规则原则相关服务
	 */
 private  BackwardandReasonService backwardandReasonService;
 /**
  * 规则通用服务
  */
 private RuleService ruleService;
/**
 * 后向规则实例
 */
 private  BackwardandReason backwardandReason;
 /**
  * 与jsp交互用的原因名词列表
  */
 private List<String> reason_noun;
 /**
  * 与jsp交互用的原因动词列表
  */
 private List<String> reason_verb;
 /**
  * 与jsp交互用的建议列表
  */
 private List<String> sugg;
 /**
  * 与jsp交互用的原因等级列表
  */
 private List<Double> cf_reason;
 /**
  * 与jsp交互用的后向规则
  */
 private Backward rule;
 
 
public List<Double> getCf_reason() {
	return cf_reason;
}
public void setCf_reason(List<Double> cf_reason) {
	this.cf_reason = cf_reason;
}
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
	/**
	 * 更改一个规则与原因对应关系
	 * @return 返回到保存成功页面
	 */
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
 /**
  * 删除一个规则与原因对应关系
  * @return 返回删除成功页面
  */
 public String delete() {
	 
	 backwardandReason = backwardandReasonService.findbyid(backwardandReason.getId());
	 rule = backwardandReason.getBid();
	 backwardandReasonService.removebyid(backwardandReason.getId());
	
		return "success";

	}
	/**
	 * 持久化一个规则与原因对应关系
	 * @return 返回到保存成功页面
	 */
 public String save(){
	 ActionContext actionContext = ActionContext.getContext();
     Map session = actionContext.getSession();
     rule = (Backward) session.get("rule");
	 for(int i = 0; i <= reason_noun.size() - 1; i++){
		 BackwardandReason brs = new BackwardandReason();
		 
		    brs.setBid(rule);
			brs.setNouns(reason_noun.get(i).trim());
			brs.setVerb(reason_verb.get(i).trim());
			brs.setSugg(sugg.get(i).trim());
			brs.setCf_reason(cf_reason.get(i));
//			List<BackwardandReason> aaa = rule.getReasons();
//			aaa.add(brs);
//			rule.setReasons(aaa);
			if ( cf_reason.get(i) >= 0
					&& sugg.get(i).trim().length() > 0) { 
				backwardandReasonService.update(brs);
				
			}
	}
	 return "success";
	 
	 
	 
 }
	
	
}