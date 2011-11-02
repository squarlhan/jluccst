package cn.edu.jlu.ccst.service;


import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.UserServiceImpl;
import cn.edu.jlu.ccst.dao.UserServiceInter;
import cn.edu.jlu.ccst.model.Admin;
import cn.edu.jlu.ccst.model.User;
@Component("userService")
public class UserService {
	private User user;
	private UserServiceInter userServiceImpl;

	
public UserServiceInter getUserServiceImpl() {
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

	public void save(User user) {
		System.out.println("USER:"+user.getUsername()+" ; "+user.getPassword());
		userServiceImpl.save(user);
	}
	
	public List<User> findall() {
		List<User> resultlist = new ArrayList();
		resultlist = userServiceImpl.findAll();
		return resultlist;
	}
	
	public User exits(User user){
		User u1=userServiceImpl.find(user);
		
		if(u1!=null)
			return u1;
		else return null;
	}	
}
