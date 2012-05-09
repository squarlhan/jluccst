package cn.edu.jlu.ccst.service;


import java.util.ArrayList;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.UserServiceInter;

import cn.edu.jlu.ccst.model.User;
/**
 * 用户服务类
 */
@Component("userService")
public class UserService {
	/**
	 * 用户实例
	 */
	private User user;
	/**
	 * 用户服务接口
	 */
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
	/**
	 * 保存用户
	 */
	public void save(User user) {
		//System.out.println("USER:"+user.getUsername()+" ; "+user.getPassword());
		userServiceImpl.save(user);
	}
	/**
	 * 查找所有用户
	 * @return 用户列表
	 */
	public List<User> findall() {
		List<User> resultlist = new ArrayList();
		resultlist = userServiceImpl.findAll();
		return resultlist;
	}
	/**
	 * 判断用户是否存在
	 * @return 用户
	 */
	public User exits(User user){
		User u1=userServiceImpl.find(user);
		
		if(u1!=null)
			return u1;
		else return null;
	}
	/**
	 * 判断管理员是否存在
	 * @return 管理员
	 */
	public User exitsadmin(User user){
		User u1=userServiceImpl.findadmin(user);
		
		if(u1!=null)
			return u1;
		else return null;
	}
	/**
	 * 判断专家是否存在
	 * @return 专家
	 */
	public User exitsprof(User user){
		User u1=userServiceImpl.findprof(user);
		
		if(u1!=null)
			return u1;
		else return null;
	}
	/**
	 * 根据id查找用户
	 * @return 用户
	 */
	public User findbyid(int id){
		 return userServiceImpl.find(id);
    }
	/**
	 * 根据用户名查找用户
	 * @return 用户
	 */
	public User findbyusername(User user){
		return userServiceImpl.finduser(user);
	}
	/**
	 * 根据id删除用户
	 
	 */
	 public void removebyid(int id){
		  userServiceImpl.remove(id);
	 }
	 /**
		 * 更新用户
		 * @return 用户
		 */
	 public void updateuser(User user){
		  userServiceImpl.updateUser(user);
	 }
	 /**
		 * 搜索用户
		 * @return 用户
		 */
	 public List<User> search(User user) {
		 return userServiceImpl.searchUser(user);
	 }
}