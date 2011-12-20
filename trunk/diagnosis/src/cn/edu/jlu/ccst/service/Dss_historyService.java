package cn.edu.jlu.ccst.service;


import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.Dss_historyServiceImpl;
import cn.edu.jlu.ccst.dao.Dss_historyServiceInter;
import cn.edu.jlu.ccst.model.Dss_history;
import cn.edu.jlu.ccst.model.Errorlog;

@Component("dss_historyService")
public class Dss_historyService {
	private Dss_history dss_history;
	private Dss_historyServiceInter dss_historyServiceImpl;

	

	

	

	

	public Dss_history getDss_history() {
		return dss_history;
	}





@Resource
	public void setDss_history(Dss_history dss_history) {
		this.dss_history = dss_history;
	}






	public Dss_historyServiceInter getDss_historyServiceImpl() {
		return dss_historyServiceImpl;
	}





	@Resource
	public void setDss_historyServiceImpl(
			Dss_historyServiceInter dss_historyServiceImpl) {
		this.dss_historyServiceImpl = dss_historyServiceImpl;
	}






	public void save(Dss_history dss_history) {
		
		dss_historyServiceImpl.save(dss_history);
	}
	
	
	public List<Dss_history> findAll() {
		List<Dss_history> resultlist = new ArrayList();
		resultlist = dss_historyServiceImpl.findAll();
		return resultlist;
	}
	
	public List<Dss_history> findbyname(String name) {
		List<Dss_history> resultlist = new ArrayList();
		resultlist = dss_historyServiceImpl.findbyName(name);
		if(resultlist.size()<1)resultlist = findAll();
		return resultlist;
	}
	
	
	public List<Dss_history> findsimu_time() {
		List<Dss_history> resultlist = new ArrayList();
		resultlist = dss_historyServiceImpl.findsimu_time();
		return resultlist;
	}
	 public List<Dss_history> findbypara(String para){
		  List<Dss_history> resultlist = new ArrayList();
			resultlist = dss_historyServiceImpl.findbypara(para);
			if(resultlist.size()<1)resultlist = findAll();
			return resultlist; 
		  
	  }
	
}