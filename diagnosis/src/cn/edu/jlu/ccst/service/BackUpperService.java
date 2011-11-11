package cn.edu.jlu.ccst.service;



import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.BackwardUpperInter;

import cn.edu.jlu.ccst.model.BackwardandUpper;

@Component("backUpperService")
public class BackUpperService {
	private BackwardandUpper backwardandUpper;
	private BackwardUpperInter backwardUpperImpl;

	


	



	public BackwardandUpper getBackwardandUpper() {
		return backwardandUpper;
	}





	@Resource


	public void setBackwardandUpper(BackwardandUpper backwardandUpper) {
		this.backwardandUpper = backwardandUpper;
	}








	public BackwardUpperInter getBackwardUpperImpl() {
		return backwardUpperImpl;
	}





	@Resource

	public void setBackwardUpperImpl(BackwardUpperInter backwardUpperImpl) {
		this.backwardUpperImpl = backwardUpperImpl;
	}







	public void save(BackwardandUpper BackwardandUpper) {
	//	System.out.println("USER:"+user.getUsername()+" ; "+user.getPassword());
		
		
		backwardUpperImpl.save(backwardandUpper);   
	}
	
	
}