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
/**
*实时数据故障日志服务类
*/
@Component("motoerrorlogService")
public class MotoErrorlogService {
	/**
	*实时数据故障日志实例
	*/
	private MotoErrorlog motoerrorlog;
	/**
	*实时数据故障日志接口
	*/
	private MotoErrorlogInter motoerrorlogImpl;
	/**
	*dcs描述数据服务类
	*/
	private DcsDscribServiceInter dcsDscribServiceImpl;
	/**
	*设备临时变量
	*/
	private String equip;
	/**
	*树形菜单服务
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
	/**
	 * 找到所有实时数据故障日志
	 * @return 故障日志列表
	 */
	public List<MotoErrorlog> findAll() {
		List<MotoErrorlog> resultlist = new ArrayList();
		resultlist = motoerrorlogImpl.findAll();
		return resultlist;
	}
	/**
	 * 根据设备名称找到所有实时数据故障日志
	 * @param equip 设备名称
	 * @return 故障日志列表
	 */
  public List<MotoErrorlog> findbyequipment(String equip){
	  List<MotoErrorlog> resultlist = new ArrayList();
		resultlist = motoerrorlogImpl.findbyequipment(equip);
		//if(resultlist.size()<1)resultlist = findAll();
		return resultlist; 
	  
  }
  /**
	 * 根据树形节点找到所有实时数据故障日志
	 * @param unit 树形节点名称
	 * @return 故障日志列表
	 */
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

  /**
	 * 根据参数、日期找到所有实时数据故障日志
	  *@param para 参数名称
   *@param date1 开始日期
   *@param date2 结束日期
	 * @return 故障日志列表
	 */
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
  /**
	 * 保存实时数据故障日志
	 * @param errorlog 故障日志实体
	 */ 
	public void save(MotoErrorlog errorlog) {
	
		
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(currentTime);
			errorlog.setTime(dateString);
	        
			motoerrorlogImpl.save(errorlog);
	}
	/**
	 *根据实时数据故障日志进行规则转化
	 *@param motocsdata 实时dcs实体
	 * @return 故障名词
	 */
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