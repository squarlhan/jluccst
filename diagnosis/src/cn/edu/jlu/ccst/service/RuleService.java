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
@Component("ruleService")
public class RuleService {
	
	private Backward backward;
	private InferenceEngine inferenceEngine;
	private RuleServiceInter ruleServiceImpl;
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

	public void delete(Backward backward){
		if(backward.getBid()>0){
		     ruleServiceImpl.remove(backward.getBid());
		}
	}
	
	public void save(Backward backward) {
		     ruleServiceImpl.save(backward);
	}
	public Backward find(Backward backward){
		if(backward.getBid()>0){
			return ruleServiceImpl.find(backward.getBid()) ;
		}
		return null;
	}
	public List<Backward> findAll() {
		List<Backward> resultlist = new ArrayList();
		resultlist = ruleServiceImpl.findAll();
		return resultlist;
	}
	
	public List<Backward> findbynamep(String name) {
		List<Backward> results = new ArrayList();
		List<String> jiedians = treeunitServiceImpl.findallchild(name);
		for(String jiedian:jiedians){
			List<Backward> temp =  findbyname(jiedian);
			results.addAll(temp);
		}
		return results;
	}
	
	public List<Backward> findbyname(String name) {
		List<Backward> resultlist = new ArrayList();
		resultlist = ruleServiceImpl.findbyname(name);
	//	if(resultlist.size()<1)resultlist=findAll();
		return resultlist;
	}
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
