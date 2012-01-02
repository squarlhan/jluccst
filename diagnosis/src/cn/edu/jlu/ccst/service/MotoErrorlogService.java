package cn.edu.jlu.ccst.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.DcsDscribServiceInter;

import cn.edu.jlu.ccst.dao.MotoErrorlogInter;
import cn.edu.jlu.ccst.model.DcsDscrib;
import cn.edu.jlu.ccst.model.MotoDcsdata;
import cn.edu.jlu.ccst.model.MotoErrorlog;
import cn.edu.jlu.ccst.dao.TreeunitServiceInter;
import cn.edu.jlu.ccst.model.Treeunit;

@Component("motoerrorlogService")
public class MotoErrorlogService {
	private MotoErrorlog motoerrorlog;
	private MotoErrorlogInter motoerrorlogImpl;
	private DcsDscribServiceInter dcsDscribServiceImpl;
	private String equip;
	private TreeunitServiceInter TreeunitServiceImpl;
	
	
	
	
	public TreeunitServiceInter getTreeunitServiceImpl() {
		return TreeunitServiceImpl;
	}
	  @Resource
	public void setTreeunitServiceImpl(TreeunitServiceInter treeunitServiceImpl) {
		TreeunitServiceImpl = treeunitServiceImpl;
	}
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



    public MotoErrorlog getMotoerrorlog() {
		return motoerrorlog;
	}
	public void setMotoerrorlog(MotoErrorlog motoerrorlog) {
		this.motoerrorlog = motoerrorlog;
	}
	public MotoErrorlogInter getMotoerrorlogImpl() {
		return motoerrorlogImpl;
	}
	@Resource
	public void setMotoerrorlogImpl(MotoErrorlogInter motoerrorlogImpl) {
		this.motoerrorlogImpl = motoerrorlogImpl;
	}
	public List<MotoErrorlog> findAll() {
		List<MotoErrorlog> resultlist = new ArrayList();
		resultlist = motoerrorlogImpl.findAll();
		return resultlist;
	}
  public List<MotoErrorlog> findbyequipment(String equip){
	  List<MotoErrorlog> resultlist = new ArrayList();
		resultlist = motoerrorlogImpl.findbyequipment(equip);
		//if(resultlist.size()<1)resultlist = findAll();
		return resultlist; 
	  
  }
  
  public List<MotoErrorlog> findbyunit(String unit){
	  List<MotoErrorlog> resultlist1 = new ArrayList();
	  List<String> resultlist2 = new ArrayList();
	  List<MotoErrorlog> resultlist3 = new ArrayList();
	  List<MotoErrorlog> resultlist4 = new ArrayList();
		resultlist2 = TreeunitServiceImpl.findallchild(unit);
		
		
		for(String a:resultlist2){
			resultlist1=motoerrorlogImpl.findbyequipment(a);
			
		
				resultlist3.addAll(resultlist3.size(), resultlist1);	
		}
		
		return resultlist3; 
	  
  }


  public List<MotoErrorlog> findbyorder(String para,Date date1,Date date2){
	  List<MotoErrorlog> resultlist1 = new ArrayList();
	  List<MotoErrorlog> resultlist2 = new ArrayList();
	  List<MotoErrorlog> resultlist = new ArrayList();
	  
	  
	  if(date1==null||date2==null)
	    {resultlist = motoerrorlogImpl.findbypara(para);}
	  else {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		  String a = formatter.format(date1);
		  String b = formatter.format(date2);
		  resultlist=motoerrorlogImpl.findbyorder(para,a,b);}
            return resultlist;
  }

	public void save(MotoErrorlog errorlog) {
	
		
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(currentTime);
			errorlog.setTime(dateString);
	        
			motoerrorlogImpl.save(errorlog);
	}
	
	public String validateinput(MotoDcsdata motocsdata) {
		List<DcsDscrib> dcsDscribs = dcsDscribServiceImpl.findbyname(motocsdata.getEquipment(), motocsdata.getItem());
		if (dcsDscribs != null && dcsDscribs.size() > 0) {
			DcsDscrib db = dcsDscribs.get(0);
			if (motocsdata.getValue() > db.getUpper()){
				
				return "upper";}
			if (motocsdata.getValue() < db.getLower()){
				
				return "lower";}
	}
		
                 return "normal";}
	}