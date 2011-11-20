package cn.edu.jlu.ccst.service;


import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.DcsdataServiceImpl;
import cn.edu.jlu.ccst.dao.DcsdataServiceInter;
import cn.edu.jlu.ccst.model.Dcsdata;

@Component("dcsdataService")
public class DcsdataService {
	private Dcsdata dcsdata;
	private DcsdataServiceInter dcsdataServiceImpl;

	

	public Dcsdata getDcsdata() {
		return dcsdata;
	}
	@Resource
	public void setDcsdata(Dcsdata dcsdata) {
		this.dcsdata = dcsdata;
	}

	public DcsdataServiceInter getDcsdataServiceImpl() {
		return dcsdataServiceImpl;
	}
	@Resource
	public void setDcsdataServiceImpl(DcsdataServiceInter dcsdataServiceImpl) {
		this.dcsdataServiceImpl = dcsdataServiceImpl;
	}

	public void save(Dcsdata dcsdata) {
		System.out.println("equipment:"+dcsdata.getEquipment());
		dcsdataServiceImpl.save(dcsdata);
	}
	
	public void delete(Dcsdata dcsdata) {
		
		dcsdataServiceImpl.delete(dcsdata);
	}
	
	public List<Dcsdata> findbyequipment(String equipment) {
		List<Dcsdata> resultlist = new ArrayList();
		resultlist = dcsdataServiceImpl.findByequipment(equipment);
		return resultlist;
	}
	
	public List<Dcsdata> findAll() {
		List<Dcsdata> resultlist = new ArrayList();
		resultlist = dcsdataServiceImpl.findAll();
		return resultlist;
	}
	
	
}