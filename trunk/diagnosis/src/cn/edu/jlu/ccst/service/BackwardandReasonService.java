package cn.edu.jlu.ccst.service;



import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.dao.BackwardReasonInter;

import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.DcsDscrib;


@Component("backwardandReasonService")
public class BackwardandReasonService {

	
	private BackwardReasonInter backwardReasonImpl;

	public BackwardReasonInter getBackwardReasonImpl() {
		return backwardReasonImpl;
	}
	@Resource
	public void setBackwardReasonImpl(BackwardReasonInter backwardReasonImpl) {
		this.backwardReasonImpl = backwardReasonImpl;
	}
	
	public void update(BackwardandReason backwardandReason){
		backwardReasonImpl.save(backwardandReason);
	}
	public void removebyid(int id){
		backwardReasonImpl.remove(id);
	 }
	public BackwardandReason findbyid(int id){
		 return backwardReasonImpl.find(id);
   } 
}
