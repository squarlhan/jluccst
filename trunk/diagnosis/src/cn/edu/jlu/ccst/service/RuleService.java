package cn.edu.jlu.ccst.service;


import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.RuleServiceImpl;
import cn.edu.jlu.ccst.dao.RuleServiceInter;
import cn.edu.jlu.ccst.dao.TreeunitServiceInter;
import cn.edu.jlu.ccst.model.*;
/**
 * 规则通用服务类
 */
@Component("ruleService")
public class RuleService {
	/**
	 * 规则实例
	 */
	private Backward backward;
	/**
	 * 推理机服务
	 */
	private InferenceEngine inferenceEngine;
	/**
	 * 规则服务类接口
	 */
	private RuleServiceInter ruleServiceImpl;
	/**
	 * 树形菜单节点服务
	 */
	private TreeunitServiceInter treeunitServiceImpl;
	public TreeunitServiceInter getTreeunitServiceImpl() {
		return treeunitServiceImpl;
	}
	@Resource
	public void setTreeunitServiceImpl(TreeunitServiceInter treeunitServiceImpl) {
		this.treeunitServiceImpl = treeunitServiceImpl;
	}
	

	public InferenceEngine getInferenceEngine() {
		return inferenceEngine;
	}
	@Resource
	public void setInferenceEngine(InferenceEngine inferenceEngine) {
		this.inferenceEngine = inferenceEngine;
	}
	public Backward getBackward() {
		return backward;
	}
	@Resource
	public void setBackward(Backward backward) {
		this.backward = backward;
	}

	public RuleServiceInter getRuleServiceImpl() {
		return ruleServiceImpl;
	}
	@Resource
	public void setRuleServiceImpl(RuleServiceInter ruleServiceImpl) {
		this.ruleServiceImpl = ruleServiceImpl;
	}
	/**
	 * 删除规则
	 */
	public void delete(Backward backward){
		if(backward.getBid()>0){
		     ruleServiceImpl.remove(backward.getBid());
		}
	}
	/**
	 * 保存规则
	 */
	public void save(Backward backward) {
		     ruleServiceImpl.save(backward);
	}
	/**
	 * 查找规则
	 * @return 规则
	 */
	public Backward find(Backward backward){
		if(backward.getBid()>0){
			return ruleServiceImpl.find(backward.getBid()) ;
		}
		return null;
	}
	/**
	 * 查找所有规则
	 * @return 规则
	 */
	public List<Backward> findAll() {
		List<Backward> resultlist = new ArrayList();
		resultlist = ruleServiceImpl.findAll();
		return resultlist;
	}
	/**
	 * 根据名称查找规则预处理
	 * @return 规则列表
	 */
	public List<Backward> findbynamep(String name) {
		List<Backward> results = new ArrayList();
		List<String> jiedians = treeunitServiceImpl.findallchild(name);
		for(String jiedian:jiedians){
			List<Backward> temp =  findbyname(jiedian);
			results.addAll(temp);
		}
		return results;
	}
	/**
	 * 查找规则
	 * @return 规则列表
	 */
	public List<Backward> findbyname(String name) {
		List<Backward> resultlist = new ArrayList();
		resultlist = ruleServiceImpl.findbyname(name);
	//	if(resultlist.size()<1)resultlist=findAll();
		return resultlist;
	}
	/**
	 * 根据现象查找原因
	 * @return 现象列表
	 */
	public List<BackwardandReason> findreasons(List<BackwardandResult> enters) {
		List<BackwardandReason> resultlist = new ArrayList();
		List<BackwardandReason> process = new ArrayList();
		for(BackwardandResult brt:enters){
			BackwardandReason brs = new BackwardandReason();
			brs.setNouns(brt.getNouns());
			brs.setVerb(brt.getVerb());
			process.add(brs);
		}
		inferenceEngine.setEnter(enters);
		inferenceEngine.setProcess(process);
		inferenceEngine.setBackwardrule(ruleServiceImpl.findAll());
		inferenceEngine.Inference("result to reason","fulfill");
		resultlist = inferenceEngine.getEnding();
		Collections.sort(resultlist,
				new Comparator<BackwardandReason>() {
					public int compare(BackwardandReason mapping1,
							BackwardandReason mapping2) {
						return ((Double)mapping2.getCf_reason()).compareTo(
								(Double)mapping1.getCf_reason());
					}
				});
		return resultlist;
	}
}
