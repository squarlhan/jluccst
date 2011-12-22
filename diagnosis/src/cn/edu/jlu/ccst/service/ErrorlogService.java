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
	private String equip;
	
	
	
	
	
	public String getEquip() {
		return equip;
	}
	public void setEquip(String equip) {
		this.equip = equip;
	}
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


    public List<Errorlog> findAll() {
		List<Errorlog> resultlist = new ArrayList();
		resultlist = errorlogImpl.findAll();
		return resultlist;
	}
  public List<Errorlog> findbyequipment(String equip){
	  List<Errorlog> resultlist = new ArrayList();
		resultlist = errorlogImpl.findbyequipment(equip);
		//if(resultlist.size()<1)resultlist = findAll();
		return resultlist; 
	  
  }
  
 /* public List<Errorlog> findbypara(String para){
	  List<Errorlog> resultlist = new ArrayList();
		resultlist = errorlogImpl.findbypara(para);
		if(resultlist.size()<1)resultlist = findAll();
		return resultlist; 
	  
  }
  public List<Errorlog> findbytime(Date date1,Date date2){
	  List<Errorlog> resultlist = new ArrayList();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String a = formatter.format(date1);
		String b = formatter.format(date2);
	 //  String a=date1.toString(); 
	 // String b= date2.toString();
		resultlist = errorlogImpl.findbytime(a, b);
		if(resultlist.size()<1)resultlist = findAll();
		return resultlist; 
	  
  }*/

  public List<Errorlog> findbyorder(String para,Date date1,Date date2){
	  List<Errorlog> resultlist1 = new ArrayList();
	  List<Errorlog> resultlist2 = new ArrayList();
	  List<Errorlog> resultlist = new ArrayList();
	  
	  
	  if(date1==null||date2==null)
	    {resultlist = errorlogImpl.findbypara(para);}
	  else {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		  String a = formatter.format(date1);
		  String b = formatter.format(date2);
		  resultlist=errorlogImpl.findbyorder(para,a,b);}
            return resultlist;
  }

	public void save(Errorlog errorlog) {
	
		
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(currentTime);
			errorlog.setTime(dateString);
	        
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