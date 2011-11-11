package cn.edu.jlu.ccst.service;



import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.BackwardLowerInter;

import cn.edu.jlu.ccst.model.BackwardandLower;

@Component("backLowerService")
public class BackLowerService {
	private BackwardandLower backwardandLower;
	private BackwardLowerInter backwardLowerImpl;

	


	

	public BackwardandLower getBackwardandLower() {
		return backwardandLower;
	}



	@Resource


	public void setBackwardandLower(BackwardandLower backwardandLower) {
		this.backwardandLower = backwardandLower;
	}






	public BackwardLowerInter getBackwardLowerImpl() {
		return backwardLowerImpl;
	}




	@Resource

	public void setBackwardLowerImpl(BackwardLowerInter backwardLowerImpl) {
		this.backwardLowerImpl = backwardLowerImpl;
	}






	/*public UserServiceInter getUserServiceImpl() {
		return userServiceImpl;
	}
@Resource
	public void setUserServiceImpl(UserServiceInter userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
public User getUser() {
		return user;
	}
	@Resource
	public void setUser(User user) {
		this.user = user;
	}
*/
	public void save(BackwardandLower backwardandLower) {
	//	System.out.println("USER:"+user.getUsername()+" ; "+user.getPassword());
		
		
		backwardLowerImpl.save(backwardandLower);   
	}
	
	
}