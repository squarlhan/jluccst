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
	private InferenceEngine inferenceEngine;
	private RuleServiceInter ruleServiceImpl;

	

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
		if(backward.getBid()>0){
		     ruleServiceImpl.save(backward);
		}
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
		return resultlist;
	}
}
