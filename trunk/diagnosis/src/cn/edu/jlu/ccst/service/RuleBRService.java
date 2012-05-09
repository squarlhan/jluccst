package cn.edu.jlu.ccst.service;

import java.io.UnsupportedEncodingException;
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
import cn.edu.jlu.ccst.dao.TreeunitServiceInter;
import cn.edu.jlu.ccst.model.*;
/**
 * 规则后件服务类
 */
@Component("rulebrService")
public class RuleBRService {
	/**
	 * 规则现象实例
	 */
	private BackwardandResult backwardandresult;
	/**
	 * 规则通用服务类接口
	 */
	private RuleBRServiceInter rulebrServiceImpl;
	/**
	 * 规则名词临时变量
	 */
	private String noun;
	/**
	* 树形菜单服务接口
	 */
	private TreeunitServiceInter treeunitServiceImpl;
	

	
	public TreeunitServiceInter getTreeunitServiceImpl() {
		return treeunitServiceImpl;
	}
	@Resource
	public void setTreeunitServiceImpl(TreeunitServiceInter treeunitServiceImpl) {
		this.treeunitServiceImpl = treeunitServiceImpl;
	}
	public BackwardandResult getBackwardandresult() {
		return backwardandresult;
	}

	
	
	
	
	public String getNoun() {
		return noun;
	}





	public void setNoun(String noun) {
		this.noun = noun;
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
	
	 * ruleServiceImpl.save(backward); }
	 */
	/**
	 *查找所有规则现象
	 *@return 现象列表
	 */
	public List<BackwardandResult> findAll() {
		List<BackwardandResult> resultlist = new ArrayList();
		resultlist = rulebrServiceImpl.findAll();

		return resultlist;
	}
	/**
	 * 查找根据名词查找现象
	 * @return 相应名词
	 */

	public Map getallnvs() {
		Map result = new HashMap();

		List<String> nounses = rulebrServiceImpl.findAllnoun();

		for (String str : nounses) {
			List<String> verb = rulebrServiceImpl.findAllverb(str);
			result.put(str, verb);
		}

		return result;
	}
	/**
	 * 查找对应名词预处理
	 *  @return 相应名词
	 */
	public Map getbynvsp(String unit) {
		Map result = new HashMap();
		List<String> jiedians = treeunitServiceImpl.findallchild(unit);
		for(String jiedian:jiedians){
			List<String> nounses = rulebrServiceImpl.findbynoun(jiedian);

			for (String str : nounses) {
				List<String> verb = rulebrServiceImpl.findAllverb(str);
				result.put(str, verb);
			}
		}
		if(result==null||result.size()<1)result=getallnvs();
		return result;
	}
	/**
	 * 查找对应名词
	 *  @return 相应名词
	 */
	public Map getbynvs(String noun) {
		Map result = new HashMap();

		List<String> nounses = rulebrServiceImpl.findbynoun(noun);

		for (String str : nounses) {
			List<String> verb = rulebrServiceImpl.findAllverb(str);
			result.put(str, verb);
		}

		if(result==null||result.size()<1)result=getallnvs();
		return result;
	}
}

