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
/**
 * 规则相关操作, 与用户交互并返回相应页面
 * @author Woden
 *
 */
@Component("ruleAction")
@Scope("prototype")
public class RuleAction extends ActionSupport {
	/**
	 * 规则描述相关服务
	 */
	private DcsDscribService dcsDscribService;
	/**
	 * 规则相关服务
	 */
	private RuleService ruleService;
	/**
	 * 与用户交互用的规则和结果对应实例
	 */
	private BackwardandResult result;
	/**
	 * 与用户交互用的规则和原因对应表
	 */
	private List<BackwardandReason> reasonlist;
	/**
	 * 与用户交互用的规则表
	 */
	private List<Backward> backlist;
	/**
	 * 与用户交互用的规则实例
	 */
	private Backward rule;
	/**
	 * 从用页面得到的原因名词列表
	 */
	private List<String> reason_noun;
	/**
	 * 从用页面得到的结果名词列表
	 */
	private List<String> result_noun;
	/**
	 * 从用页面得到的原因动词列表
	 */
	private List<String> reason_verb;
	/**
	 * 从用页面得到的结果动词列表
	 */
	private List<String> result_verb;
	/**
	 * 从用页面得到的建议列表
	 */
	private List<String> sugg;
	/**
	 * 从用页面得到的等级列表
	 */
	private List<Double> cf_reason;
	/**
	 * 从用页面得到的结果名词
	 */
	private String resultn1;
	/**
	 * 从用页面得到的结果名词
	 */
	private String resultn2;
	/**
	 * 从用页面得到的结果动词数值
	 */
	private int resultv_value;
	/**
	 * 从用页面得到的设备名
	 */
	private String name;
	/**
	 * 从用页面得到的规则名列表
	 */
	private List<String> namelist;
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
	public List<Double> getCf_reason() {
		return cf_reason;
	}

	public void setCf_reason(List<Double> cf_reason) {
		this.cf_reason = cf_reason;
	}

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
/**
 * 通过现象得到所有原因并显示
 */
	public String execute() {
		List<BackwardandResult> temp = new ArrayList();
		temp.add(result);
		reasonlist = ruleService.findreasons(temp);
		return "go";
	}
/**
 * 得到所有规则
 * @return 规则列表页面
 */
	public String getall() {
		if (checkprof()) {
			backlist = ruleService.findAll();
			return "list";
		}else{
			return "unproflogin";
		}
	}
	/**
	 * 通过设备分组名得到相关规则
	 * @return 规则列表
	 */
	public String findbynamep(){
		try {
			String keyword= new String(unit.getBytes("ISO-8859-1"),"UTF-8");
			backlist = ruleService.findbynamep(keyword);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "list";
	}
	/**
	 * 通过设备名得到相关规则
	 * @return 规则列表
	 */
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
/**
 * 删除规则操作
 * @return 规则列表
 */
	public String delRule() {
		ruleService.delete(rule);
		backlist = ruleService.findAll();
		return "list";
	}

/**
 * 跳转到添加页面
 * @return 添加规则页面
 */
	public String justgo() {
		return "gogogo";
	}
	/**
	 * 跳转到查看规则详细信息页面
	 * @return 查看规则详细信息页面
	 */
	public String godetail() {
		rule = ruleService.find(rule);
		if(rule.getResults()!=null&&rule.getResults().size()>0){
			result=rule.getResults().get(0);
		}
		
				
		reasonlist=rule.getReasons();
	
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("rule", rule);
		return "show";
	}
/**
 * 检查用户是否合法
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
 * 添加规则操作
 * @return 规则列表
 */
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
			brs.setCf_reason(cf_reason.get(i));
			if (cf_reason.get(i) >= 0
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
	/**
	 * 添加规则操作, 根据下拉框
	 * @return 规则列表
	 */
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
			brs.setCf_reason(cf_reason.get(i));
			if (cf_reason.get(i) >= 0
					&& sugg.get(i).trim().length() > 0) {
				breason.add(brs);
			}

		}
		rule.setReasons(breason);
		rule.setResults(bresult);

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
