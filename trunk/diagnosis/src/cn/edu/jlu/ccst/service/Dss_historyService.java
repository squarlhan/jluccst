package cn.edu.jlu.ccst.service;


import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.Dss_historyServiceImpl;
import cn.edu.jlu.ccst.dao.Dss_historyServiceInter;
import cn.edu.jlu.ccst.dao.TreeunitServiceInter;
import cn.edu.jlu.ccst.model.Dss_history;
import cn.edu.jlu.ccst.model.Errorlog;
/**
 * 工艺历史数据服务类
 */
@Component("dss_historyService")
public class Dss_historyService {
	/**
	 * 工艺历史数据实例
	 */
	private Dss_history dss_history;
	/**
	 * 工艺历史数据服务类
	 */
	private Dss_historyServiceInter dss_historyServiceImpl;
	/**
	 * 树形菜单服务类
	 */
	private TreeunitServiceInter TreeunitServiceImpl;

	
public TreeunitServiceInter getTreeunitServiceImpl() {
		return TreeunitServiceImpl;
	}

    @Resource
	public void setTreeunitServiceImpl(TreeunitServiceInter treeunitServiceImpl) {
		TreeunitServiceImpl = treeunitServiceImpl;
	}

    public Dss_history getDss_history() {
		return dss_history;
	}
    @Resource
	public void setDss_history(Dss_history dss_history) {
		this.dss_history = dss_history;
	}
   
    public Dss_historyServiceInter getDss_historyServiceImpl() {
		return dss_historyServiceImpl;
	}
    @Resource
	public void setDss_historyServiceImpl(
			Dss_historyServiceInter dss_historyServiceImpl) {
		this.dss_historyServiceImpl = dss_historyServiceImpl;
	}

    public void save(Dss_history dss_history) {
		
		dss_historyServiceImpl.save(dss_history);
	}
    /**
     * 查找所有工艺历史数据
     * @return 工艺历史数据列表
     */
    public List<Dss_history> findAll() {
		List<Dss_history> resultlist = new ArrayList();
		resultlist = dss_historyServiceImpl.findAll();
		return resultlist;
	}
    /**
     * 根据名称查找工艺历史数据服务类
     * @return 工艺历史数据列表 
     */
	public List<Dss_history> findbyname(String name) {
		List<Dss_history> resultlist = new ArrayList();
		resultlist = dss_historyServiceImpl.findbyName(name);
	//	if(resultlist.size()<1)resultlist = findAll();
		return resultlist;
	}
	
	/**
     * 根据批次查找工艺历史数据服务类
     * @return 工艺历史数据列表 
     */
	public List<Dss_history> findsimu_time() {
		List<Dss_history> resultlist = new ArrayList();
		resultlist = dss_historyServiceImpl.findsimu_time();
		return resultlist;
	}
	/**
     * 根据参数查找工艺历史数据服务类
     * @return 工艺历史数据列表 
     */
	 public List<Dss_history> findbypara(String para){
		  List<Dss_history> resultlist = new ArrayList();
			resultlist = dss_historyServiceImpl.findbypara(para);
		//	if(resultlist.size()<1)resultlist = findAll();
			return resultlist; 
		  
	  }
	 /**
	     * 根据树形节点名称查找工艺历史数据服务类
	     * @return 工艺历史数据列表 
	     */
	 public List<Dss_history> findbyunit(String unit){
		  List<Dss_history> resultlist1 = new ArrayList();
		  List<String> resultlist2 = new ArrayList();
		  List<Dss_history> resultlist3 = new ArrayList();
		  List<Dss_history> resultlist4 = new ArrayList();
			resultlist2 = TreeunitServiceImpl.findallchild(unit);
			
			//int count=0;
			for(String a:resultlist2){
				resultlist1=dss_historyServiceImpl.findbypara(a);
				
			//	System.out.println(resultlist1.size());
					resultlist3.addAll(resultlist3.size(), resultlist1);
				//	count=count+resultlist1.size();
			}
			
			//if(resultlist.size()<1)resultlist = findAll();
			return resultlist3; 
		  
	  }
	  
	
}