package cn.edu.jlu.ccst.service;


import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.Pre_dssServiceInter;
import cn.edu.jlu.ccst.dao.Pre_dssServiceImpl;
import cn.edu.jlu.ccst.model.Dss_advice;
import cn.edu.jlu.ccst.model.Pre_dss;

@Component("pre_dssService")
public class Pre_dssService {
	private Pre_dss pre_dss;
	private Pre_dssServiceInter pre_dssServiceImpl;

	

	

	public Pre_dss getPre_dss() {
		return pre_dss;
	}
	@Resource
	public void setPre_dss(Pre_dss pre_dss) {
		this.pre_dss = pre_dss;
	}

	public Pre_dssServiceInter getPre_dssServiceImpl() {
		return pre_dssServiceImpl;
	}
	@Resource
	public void setPre_dssServiceImpl(Pre_dssServiceInter pre_dssServiceImpl) {
		this.pre_dssServiceImpl = pre_dssServiceImpl;
	}

	public void save(Pre_dss pre_dss) {
		System.out.println("equipment:"+pre_dss.getName());
		pre_dssServiceImpl.save(pre_dss);
	}
	
	public void delete(Pre_dss pre_dss) {
		
		pre_dssServiceImpl.delete(pre_dss);
	}
	
	public List<Pre_dss> findbyname(String name) {
		List<Pre_dss> resultlist = new ArrayList();
		resultlist = pre_dssServiceImpl.findByname(name);
		return resultlist;
	}
	
	public List<Pre_dss> findAll() {
		List<Pre_dss> resultlist = new ArrayList();
		resultlist = pre_dssServiceImpl.findAll();
		return resultlist;
	}
	public List<Pre_dss> findByseqno() {
		List<Pre_dss> resultlist = new ArrayList();
		resultlist = pre_dssServiceImpl.findByseqno();
		return resultlist;
	}
	public List<Pre_dss> findseqno() {
		List<Pre_dss> resultlist = new ArrayList();
		resultlist = pre_dssServiceImpl.findseqno();
		return resultlist;
	}
	
	
}