package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Admin;
import cn.edu.jlu.ccst.model.DcsDscrib;

public interface DcsDscribServiceInter {
	
	
	public List<String> findAllname() ;
	public void save(DcsDscrib dcsDscrib);
	public List<DcsDscrib> findbyname(String name) ;
	public List<DcsDscrib> findbyitem(int item) ;
	public List<DcsDscrib> findbyname(String eque, String item) ;
	
	


}
