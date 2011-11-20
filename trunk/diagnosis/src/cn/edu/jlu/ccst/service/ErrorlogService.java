package cn.edu.jlu.ccst.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.DcsDscribServiceInter;
import cn.edu.jlu.ccst.dao.ErrorlogImpl;
import cn.edu.jlu.ccst.dao.ErrorlogInter;
import cn.edu.jlu.ccst.model.DcsDscrib;
import cn.edu.jlu.ccst.model.Dcsdata;
import cn.edu.jlu.ccst.model.Errorlog;

@Component("errorlogService")
public class ErrorlogService {
	private Errorlog errorlog;
	private ErrorlogInter errorlogImpl;
	private DcsDscribServiceInter dcsDscribServiceImpl;
	
	
	
	
	
	
	public DcsDscribServiceInter getDcsDscribServiceImpl() {
		return dcsDscribServiceImpl;
	}
	  @Resource
	public void setDcsDscribServiceImpl(DcsDscribServiceInter dcsDscribServiceImpl) {
		this.dcsDscribServiceImpl = dcsDscribServiceImpl;
	}

	public Errorlog getErrorlog() {
		return errorlog;
	}

    public void setErrorlog(Errorlog errorlog) {
		this.errorlog = errorlog;
	}

    public ErrorlogInter getErrorlogImpl() {
		return errorlogImpl;
	}
    @Resource
	public void setErrorlogImpl(ErrorlogInter errorlogImpl) {
		this.errorlogImpl = errorlogImpl;
	}






	public void save(Errorlog errorlog) {
	
		
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = formatter.format(currentTime);
			errorlog.setSeqno(dateString);
	        
			errorlogImpl.save(errorlog);
	}
	
	public String validateinput(Dcsdata Dcsdata) {
		List<DcsDscrib> dcsDscribs = dcsDscribServiceImpl.findbyname(Dcsdata.getEquipment(), Dcsdata.getItem());
		if (dcsDscribs != null && dcsDscribs.size() > 0) {
			DcsDscrib db = dcsDscribs.get(0);
			if (Dcsdata.getValue() > db.getUpper()){
				
				return "upper";}
			if (Dcsdata.getValue() < db.getLower()){
				
				return "lower";}
	}
		
                 return "normal";}
	}