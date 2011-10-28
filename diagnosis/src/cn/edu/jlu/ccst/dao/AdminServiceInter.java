package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Admin;

public interface AdminServiceInter {
	
	public List<Admin> findAll();

	public void save(Admin admin);

	public void remove(int id);

	public Admin find(Admin admin);
	 
	
	


}
