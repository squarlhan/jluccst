package cn.edu.jlu.ccst.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;


import cn.edu.jlu.ccst.dao.AdminServiceImpl;
import cn.edu.jlu.ccst.dao.AdminServiceInter;
import cn.edu.jlu.ccst.model.Admin;
import cn.edu.jlu.ccst.model.User;
@Component("adminService")
public class AdminService {
	private Admin admin;
	private AdminServiceInter adminServiceImpl;
	private String newpassword;
	
	private String renewpassword;
	private String currentpassword;
	


	public String getRenewpassword() {
		return renewpassword;
	}
	public void setRenewpassword(String renewpassword) {
		this.renewpassword = renewpassword;
	}
	public String getCurrentpassword() {
		return currentpassword;
	}
	public void setCurrentpassword(String currentpassword) {
		this.currentpassword = currentpassword;
	}
	public Admin getAdmin() {
		return admin;
	}
    @Resource
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	
	
	
	
	public AdminServiceInter getAdminServiceImpl() {
		return adminServiceImpl;
	}
	 @Resource
	public void setAdminServiceImpl(AdminServiceInter adminServiceImpl) {
		this.adminServiceImpl = adminServiceImpl;
	}
	public void save(Admin admin) {
		System.out.println("ADMIN:"+admin.getUsername()+" ; "+admin.getPassword());
		adminServiceImpl.save(admin);
	}
	
	public List<Admin> findall() {
		List<Admin> resultlist = new ArrayList();
		resultlist = adminServiceImpl.findAll();
		return resultlist;
	}
	
	public Admin exits(Admin admin){
		Admin u1=adminServiceImpl.find(admin);
		
		if(u1!=null)
			return u1;
		else return null;
	}	
	
   
	
	
	
}
