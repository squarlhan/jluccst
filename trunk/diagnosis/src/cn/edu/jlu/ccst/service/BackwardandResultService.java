package cn.edu.jlu.ccst.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.dao.BackwardReasonInter;
import cn.edu.jlu.ccst.dao.BackwardResultInter;
import cn.edu.jlu.ccst.model.Backward;
import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.BackwardandResult;
import cn.edu.jlu.ccst.model.User;
/**
 * 规则现象服务类
 */
@Component("backwardandResultService")
public class BackwardandResultService {
	/**
	 * 规则现象实例
	 */
	private BackwardResultInter backwardResultImpl;
	/**
	 * 规则原因实例
	 */
	private BackwardReasonInter backwardReasonImpl;

	public BackwardReasonInter getBackwardReasonImpl() {
		return backwardReasonImpl;
	}
	@Resource
	public void setBackwardReasonImpl(BackwardReasonInter backwardReasonImpl) {
		this.backwardReasonImpl = backwardReasonImpl;
	}
	public BackwardResultInter getBackwardResultImpl() {
		return backwardResultImpl;
	}
	@Resource
	public void setBackwardResultImpl(BackwardResultInter backwardResultImpl) {
		this.backwardResultImpl = backwardResultImpl;
	}
	/**
	 * 根据现象查找规则原因
	 * @param br 现象实体
	 * @return 原因列表
	 */
	public List<BackwardandReason> findbyresult(BackwardandResult br){
		List<BackwardandReason> results= new ArrayList();
		List<BackwardandResult> bresults = backwardResultImpl.find(br);
		for(BackwardandResult bresult:bresults){
			Backward bw = bresult.getBid();
			results.addAll(backwardReasonImpl.find(bw));
		}
		return results;
	}
	/**
	 * 查找所有规则原因
	 * @return 原因列表
	 */
	public List<BackwardandResult> findall() {
		List<BackwardandResult> resultlist = new ArrayList();
		resultlist = backwardResultImpl.findAll();
		return resultlist;
	}
	
}
