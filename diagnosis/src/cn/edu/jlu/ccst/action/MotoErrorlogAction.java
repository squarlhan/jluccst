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
/**
 * 自动采集DSC数据错误日志相关操作，业用户交互并返回相应页面
 */
@Component("motoerrorlogAction")
@Scope("prototype")
public class MotoErrorlogAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 与用户交互的错误日志列表
	 */
	private List<MotoErrorlog> motoerrorlist;
	/**
	 * 错误日志相关服务
	 */
	private MotoErrorlogService motoerrorlogService;
	/**
	 * 从用户页面得到的设备名
	 */
   private String equip;
   /**
    * 从用户页面得到的设备分组
    */
   private String unit;
   /**
    * 从用户页面得到的设备参数
    */
   private String parameter;
   /**
    * 从用户页面得到的时间起点
    */
   private Date date1;
   /**
    * 从用户页面得到的时间起点
    */
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
/**
 * 得到所有错误日志
 */
public String execute() {
	motoerrorlist = motoerrorlogService.findAll();
	
	return "OK";
	

}
/**
 * 通过设备名得到相关错误日志
 * @return 错误日志列表
 */
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
	
	/**
	 * 通过设备分组名得到相关错误日志
	 * @return 错误日志列表
	 */
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
	
	
	/**
	 * 通过时间段得到相关错误日志
	 * @return 错误日志列表
	 */
     public String findbyorder(){
    	 motoerrorlist=motoerrorlogService.findbyorder(parameter,date1, date2);
	 return "OK";
}	
	
		
	

}
