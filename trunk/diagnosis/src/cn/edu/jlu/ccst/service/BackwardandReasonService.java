package cn.edu.jlu.ccst.service;



import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.dao.BackwardReasonInter;

import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.DcsDscrib;

/**
 * 规则原因服务类
 */
@Component("backwardandReasonService")
public class BackwardandReasonService {

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
	/**
	 * 更新规则原因
	 */
	public void update(BackwardandReason backwardandReason){
		backwardReasonImpl.save(backwardandReason);
	}
	/**
	 * 根据id删除规则原因
	 */
	public void removebyid(int id){
		backwardReasonImpl.remove(id);
	 }
	/**
	 * 根据id查找规则原因
	 * @return 规则原因
	 */
	public BackwardandReason findbyid(int id){
		 return backwardReasonImpl.find(id);
   } 
}
