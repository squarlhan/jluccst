package cn.edu.jlu.ccst.service;


import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.Dss_adviceServiceImpl;
import cn.edu.jlu.ccst.dao.Dss_adviceServiceInter;
import cn.edu.jlu.ccst.model.Dss_advice;

@Component("dss_adviceService")
public class Dss_adviceService {
	private Dss_advice dss_advice;
	private Dss_adviceServiceInter dss_adviceServiceImpl;

	

	

	

	public Dss_advice getDss_advice() {
		return dss_advice;
	}
    @Resource
	public void setDss_advice(Dss_advice dss_advice) {
		this.dss_advice = dss_advice;
	}

	public Dss_adviceServiceInter getDss_adviceServiceImpl() {
		return dss_adviceServiceImpl;
	}
	 @Resource
	public void setDss_adviceServiceImpl(
			Dss_adviceServiceInter dss_adviceServiceImpl) {
		this.dss_adviceServiceImpl = dss_adviceServiceImpl;
	}

	public void save(Dss_advice dss_advice) {
	
		dss_adviceServiceImpl.save(dss_advice);
	}
	
	
	
	public void deleteall(){
		dss_adviceServiceImpl.deleteall();
	}
	
	
	public List<String> findsimu_time() {
		List<String> resultlist = new ArrayList();
		resultlist = dss_adviceServiceImpl.findsimu_time();
		return resultlist;
	}
	
	
}