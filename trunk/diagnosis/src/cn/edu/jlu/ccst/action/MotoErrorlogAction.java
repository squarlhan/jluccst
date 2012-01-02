package cn.edu.jlu.ccst.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.model.MotoErrorlog;
import cn.edu.jlu.ccst.service.MotoErrorlogService;
import com.opensymphony.xwork2.ActionSupport;

@Component("motoerrorlogAction")
@Scope("prototype")
public class MotoErrorlogAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<MotoErrorlog> motoerrorlist;
	private MotoErrorlogService motoerrorlogService;
   private String equip;
   private String unit;
   private String parameter;
   
   private Date date1;
   private Date date2;
   
   
   
   
   
   
	




	public String getUnit() {
	return unit;
}



public void setUnit(String unit) {
	this.unit = unit;
}



	public Date getDate1() {
	return date1;
}



public void setDate1(Date date1) {
	this.date1 = date1;
}



public Date getDate2() {
	return date2;
}



public void setDate2(Date date2) {
	this.date2= date2;
}



	public String getParameter() {
	return parameter;
}



public void setParameter(String parameter) {
	this.parameter = parameter;
}



	public String getEquip() {
	return equip;
}



public void setEquip(String equip) {
	this.equip = equip;
}




	public List<MotoErrorlog> getMotoerrorlist() {
	return motoerrorlist;
}



public void setMotoerrorlist(List<MotoErrorlog> motoerrorlist) {
	this.motoerrorlist = motoerrorlist;
}



public MotoErrorlogService getMotoerrorlogService() {
	return motoerrorlogService;
}


@Resource
public void setMotoerrorlogService(MotoErrorlogService motoerrorlogService) {
	this.motoerrorlogService = motoerrorlogService;
}

public String execute() {
	motoerrorlist = motoerrorlogService.findAll();
	
	return "OK";
	

}

	public String findbyequipment(){
		try {
			String keyword= new String(equip.getBytes("ISO-8859-1"),"UTF-8");
			motoerrorlist = motoerrorlogService.findbyequipment(keyword);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "OK";
	}
	
	
	public String findbyunit(){
		try {
			String keyword= new String(unit.getBytes("ISO-8859-1"),"UTF-8");
			motoerrorlist = motoerrorlogService.findbyunit(keyword);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "OK";
	}
	
	
	
     public String findbyorder(){
    	 motoerrorlist=motoerrorlogService.findbyorder(parameter,date1, date2);
	 return "OK";
}	
	
		
	

}
