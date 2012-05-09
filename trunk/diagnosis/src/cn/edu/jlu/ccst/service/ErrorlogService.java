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
import cn.edu.jlu.ccst.dao.TreeunitServiceInter;
import cn.edu.jlu.ccst.model.Treeunit;
/**
 * 故障日志服务类
 */
@Component("errorlogService")
public class ErrorlogService {
	/**
     *故障日志实例
     */
	private Errorlog errorlog;
	/**
    *故障日志接口
    */
	private ErrorlogInter errorlogImpl;
	/**
    *dcs描述服务类
    */
	private DcsDscribServiceInter dcsDscribServiceImpl;
	/**
    *设备名称历史变量
    */
    private String equip;
    /**
    *树形菜单服务类
    */
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

    /**
    *查找所有故障日志
    *@return 故障日志列表
    */
    public List<Errorlog> findAll() {
		List<Errorlog> resultlist = new ArrayList();
		resultlist = errorlogImpl.findAll();
		return resultlist;
	}
    /**
    *根据设备查找故障日志
    *@param equip 设备参数名称
    *@return 故障日志列表
    */
  public List<Errorlog> findbyequipment(String equip){
	  List<Errorlog> resultlist = new ArrayList();
		resultlist = errorlogImpl.findbyequipment(equip);
		//if(resultlist.size()<1)resultlist = findAll();
		return resultlist; 
	  
  }
  /**
   *根据树形节点查找故障日志
   *@param unit 树形节点名称
   *@return 故障日志列表
   */
  public List<Errorlog> findbyunit(String unit){
	  List<Errorlog> resultlist1 = new ArrayList();
	  List<String> resultlist2 = new ArrayList();
	  List<Errorlog> resultlist3 = new ArrayList();
	  List<Errorlog> resultlist4 = new ArrayList();
		resultlist2 = TreeunitServiceImpl.findallchild(unit);
		
		//int count=0;
		for(String a:resultlist2){
			resultlist1=errorlogImpl.findbyequipment(a);
			
		//	System.out.println(resultlist1.size());
				resultlist3.addAll(resultlist3.size(), resultlist1);
			//	count=count+resultlist1.size();
		}
		
		//if(resultlist.size()<1)resultlist = findAll();
		return resultlist3; 
	  
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
  /**
   *根据参数、日期查找故障日志
   *@param para 参数名称
   *@param date1 开始日期
   *@param date2 结束日期
   *@return 故障日志列表
   
   */
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
  /**
   *保存故障日志
   *@param errorlog 故障日志实体
   */
	public void save(Errorlog errorlog) {
	
		
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(currentTime);
			errorlog.setTime(dateString);
	        
			errorlogImpl.save(errorlog);
	}
	 /**
	    *将规则转化存入故障日志中
	    *@param Dcsdata 故障日志实体
	    */
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