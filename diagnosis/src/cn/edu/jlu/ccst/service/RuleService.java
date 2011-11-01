package cn.edu.jlu.ccst.service;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.RuleServiceImpl;
import cn.edu.jlu.ccst.dao.RuleServiceInter;
import cn.edu.jlu.ccst.model.*;
@Component("ruleService")
public class RuleService {
	
	private Backward backward;
	
	private RuleServiceInter ruleServiceImpl;

	

	public Backward getBackward() {
		return backward;
	}
	@Resource
	public void setBackward(Backward backward) {
		this.backward = backward;
	}

	public RuleServiceInter getRuleServiceInter() {
		return ruleServiceImpl;
	}
	@Resource
	public void setRuleServiceInter(RuleServiceInter ruleServiceImpl) {
		this.ruleServiceImpl = ruleServiceImpl;
	}

	public void save(Backward backward) {
		System.out.println("Rule:"+backward.getName()+" ; "+backward.getMemo());
		ruleServiceImpl.save(backward);
	}
	
	public List<Backward> findAll() {
		List<Backward> resultlist = new ArrayList();
		resultlist = ruleServiceImpl.findAll();
		return resultlist;
	}
}
