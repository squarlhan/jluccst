package cn.edu.jlu.ccst.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.dao.DcsDscribServiceImpl;
import cn.edu.jlu.ccst.dao.DcsDscribServiceInter;
import cn.edu.jlu.ccst.model.*;

@Component("dcsDscribService")
public class DcsDscribService {

	private DcsDscrib dDcsDscrib;
	private DcsDscribServiceInter dcsDscribServiceImpl;



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

	

	public DcsDscrib getdDcsDscrib() {
		return dDcsDscrib;
	}


	@Resource
	public void setdDcsDscrib(DcsDscrib dDcsDscrib) {
		this.dDcsDscrib = dDcsDscrib;
	}



	public DcsDscribServiceInter getDcsDscribServiceImpl() {
		return dcsDscribServiceImpl;
	}


	@Resource
	public void setDcsDscribServiceImpl(DcsDscribServiceInter dcsDscribServiceImpl) {
		this.dcsDscribServiceImpl = dcsDscribServiceImpl;
	}


	public List<String> findallname() {
		List<String> name = dcsDscribServiceImpl.findAllname();
		
		return name;
	}
	
		
}
