package cn.edu.jlu.ccst.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.dao.DcsDscribServiceInter;
import cn.edu.jlu.ccst.dao.MotoDcsdataServiceInter;
import cn.edu.jlu.ccst.dao.TreeunitServiceInter;

import cn.edu.jlu.ccst.model.DcsDscrib;
import cn.edu.jlu.ccst.model.Dcsdata;
import cn.edu.jlu.ccst.model.MotoDcsdata;

/**
*实时数据监控服务类
*@author catherine
*/
@Component("motodcsdataService")
public class MotoDcsdataService {
	/**
	*实时数据监控实例
	*/
	private MotoDcsdata motodcsdata;
	/**
	*实时数据监控服务类
	*/
	private MotoDcsdataServiceInter motodcsdataServiceImpl;
	/**
	*dcs描述数据监控服务类
	*/
	private DcsDscribServiceInter dcsDscribServiceImpl;
	/**
	*树形节点服务类
	*/
  // private DcsDscrib dcsDscrib;
	private TreeunitServiceInter treeunitServiceImpl;
	

	
	public TreeunitServiceInter getTreeunitServiceImpl() {
		return treeunitServiceImpl;
	}
	@Resource
	public void setTreeunitServiceImpl(TreeunitServiceInter treeunitServiceImpl) {
		this.treeunitServiceImpl = treeunitServiceImpl;
	}
	

	public DcsDscribServiceInter getDcsDscribServiceImpl() {
		return dcsDscribServiceImpl;
	}



	@Resource
	public void setDcsDscribServiceImpl(DcsDscribServiceInter dcsDscribServiceImpl) {
		this.dcsDscribServiceImpl = dcsDscribServiceImpl;
	}




	public MotoDcsdata getMotodcsdata() {
		return motodcsdata;
	}




@Resource
	public void setMotodcsdata(MotoDcsdata motodcsdata) {
		this.motodcsdata = motodcsdata;
	}





	public MotoDcsdataServiceInter getMotodcsdataServiceImpl() {
		return motodcsdataServiceImpl;
	}




	@Resource
	public void setMotodcsdataServiceImpl(
			MotoDcsdataServiceInter motodcsdataServiceImpl) {
		this.motodcsdataServiceImpl = motodcsdataServiceImpl;
	}




	/**
	*查找所有实时数据
	*@return 实时数据列表
	*/
	public List<MotoDcsdata> findAll() {
		List<MotoDcsdata> resultlist = new ArrayList();
		resultlist = motodcsdataServiceImpl.findAll();
		return resultlist;
	}
	/**
	*查找所有实时数据预处理
	*@return 实时数据列表
	*/
	public List<MotoDcsdata> getalldcsddatap(String keyword) {
		List<MotoDcsdata> results = new ArrayList();
		List<String> jiedians = treeunitServiceImpl.findallchild(keyword);
		for(String jiedian:jiedians){
			List<MotoDcsdata> temp =  getalldcsddatan(jiedian);
			results.addAll(temp);
		}
		return results;
	}
	/**
	*查找所有实时数据预处理进行规则转化
	*@return 实时数据列表
	*/
	public List<MotoDcsdata> getalldcsddata(String keyword) {
		List<MotoDcsdata> allresults = new ArrayList();
		List<MotoDcsdata> results = new ArrayList();
		List<MotoDcsdata> fliterresults = new ArrayList();
		allresults =  this.findAll();
		for(MotoDcsdata dd:allresults){
			if(!dd.getItem().trim().equals("班次")){
				dd.setIsok("0");
				List<DcsDscrib> dcsDscribs = dcsDscribServiceImpl.findbyname(dd.getEquipment().trim(), dd.getItem().trim());
				if (dcsDscribs != null && dcsDscribs.size() > 0) {
					DcsDscrib db = dcsDscribs.get(0);
					// do sth...
					if(dd.getValue()>db.getUpper2()||dd.getValue()<db.getLower2()){
						dd.setIsok("3");
					}else if(dd.getValue()>db.getUpper1()||dd.getValue()<db.getLower1()){
						dd.setIsok("2");
					}else if(dd.getValue()>db.getUpper()||dd.getValue()<db.getLower()){
						dd.setIsok("1");
					}else{
						dd.setIsok("0");
					}
					if (keyword != null) {
						if(db.getName().contains(keyword)){
							fliterresults.add(dd);
						}
					}
					
				}
				results.add(dd);			
			}
		}
	
		if (fliterresults.size()>0) {
			return fliterresults;
			}else{
				return results;
			}
		
	}
	/**
	*查找所有实时数据预处理进行规则转化
	*@return 实时数据列表
	*/
	
	public List<MotoDcsdata> getalldcsddatan(String keyword) {
		List<MotoDcsdata> allresults = new ArrayList();
		List<MotoDcsdata> results = new ArrayList();
		List<MotoDcsdata> fliterresults = new ArrayList();
		allresults =  this.findAll();
		for(MotoDcsdata dd:allresults){
			if(!dd.getItem().trim().equals("班次")){
				dd.setIsok("0");
				List<DcsDscrib> dcsDscribs = dcsDscribServiceImpl.findbyname(dd.getEquipment().trim(), dd.getItem().trim());
				if (dcsDscribs != null && dcsDscribs.size() > 0) {
					DcsDscrib db = dcsDscribs.get(0);
					// do sth...
					if(dd.getValue()>db.getUpper2()||dd.getValue()<db.getLower2()){
						dd.setIsok("3");
					}else if(dd.getValue()>db.getUpper1()||dd.getValue()<db.getLower1()){
						dd.setIsok("2");
					}else if(dd.getValue()>db.getUpper()||dd.getValue()<db.getLower()){
						dd.setIsok("1");
					}else{
						dd.setIsok("0");
					}
					
				}
				if (keyword != null) {
					if(dd.getEquipment().contains(keyword)){
						fliterresults.add(dd);
					}
				}
				results.add(dd);			
			}
		}

			return fliterresults;
		
	}

	

}