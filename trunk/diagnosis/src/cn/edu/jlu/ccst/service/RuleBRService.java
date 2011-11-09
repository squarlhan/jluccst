package cn.edu.jlu.ccst.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.dao.RuleBRServiceImpl;
import cn.edu.jlu.ccst.dao.RuleBRServiceInter;
import cn.edu.jlu.ccst.model.*;

@Component("rulebrService")
public class RuleBRService {

	private BackwardandResult backwardandresult;
	private RuleBRServiceInter rulebrServiceImpl;

	public BackwardandResult getBackwardandresult() {
		return backwardandresult;
	}

	@Resource
	public void setBackwardandresult(BackwardandResult backwardandresult) {
		this.backwardandresult = backwardandresult;
	}

	public RuleBRServiceInter getRulebrServiceImpl() {
		return rulebrServiceImpl;
	}

	@Resource
	public void setRulebrServiceImpl(RuleBRServiceInter rulebrServiceImpl) {
		this.rulebrServiceImpl = rulebrServiceImpl;
	}

	/*
	 * public Backward getBackward() { return backward; }
	 * 
	 * @Resource public void setBackward(Backward backward) { this.backward =
	 * backward; }
	 * 
	 * public RuleServiceInter getRuleServiceInter() { return ruleServiceImpl; }
	 * 
	 * @Resource public void setRuleServiceInter(RuleServiceInter
	 * ruleServiceImpl) { this.ruleServiceImpl = ruleServiceImpl; }
	 */

	/*
	 * public void save(BackwardandResult backward) {
	 * System.out.println("Rule:"+backward.getName()+" ; "+backward.getMemo());
	 * ruleServiceImpl.save(backward); }
	 */

	public List<BackwardandResult> findAll() {
		List<BackwardandResult> resultlist = new ArrayList();
		resultlist = rulebrServiceImpl.findAll();

		return resultlist;
	}

	public Map getallnvs() {
		Map result = new HashMap();

		List<String> nounses = rulebrServiceImpl.findAllnoun();

		for (String str : nounses) {
			List<String> verb = rulebrServiceImpl.findAllverb(str);
			result.put(str, verb);
		}

		return result;
	}
}
