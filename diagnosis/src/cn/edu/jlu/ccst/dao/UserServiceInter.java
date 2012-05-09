package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.User;
/**
 * 用户数据库操作接口
 * @author Woden
 *
 */
public interface UserServiceInter {
	/**
	 * 得到所有用户
	 * @return 用户列表
	 */
	public List<User> findAll();
/**
 * 保存或者更改一个用户
 * @param user 待持久化的用户
 */
	public void save(User user);
/**
 * 根据用户id删除一个用户
 * @param id
 */
	public void remove(int id);
/**
 * 通过用户id信息查找用户
 * @param user 包含用户id信息
 * @return 用户
 */
	public User find(User user);
	/**
	 * 更改用户信息
	 * @param user 用户信息
	 */
	public void updateUser(User user); 
	/**
	 * 通过用户id得到用户
	 * @param id 用户id
	 * @return 用户
	 */
	public User find(int id);
	/**
	 * 通过用户名信息查找用户
	 * @param user 包含用户名信息
	 * @return 用户
	 */
	public User finduser(User user);
	/**
	 * 通过用户部分信息查找用户
	 * @param user 包含用户部分信息
	 * @return 用户列表
	 */
	public List<User> searchUser(User user);
	/**
	 * 通过用户名信息查找用户
	 * @param user 包含用户名信息
	 * @return 管理员用户
	 */
	public User findadmin(User user);
	/**
	 * 通过用户名信息查找用户
	 * @param user 包含用户名信息
	 * @return 专家用户
	 */
	public User findprof(User user);
	


}
