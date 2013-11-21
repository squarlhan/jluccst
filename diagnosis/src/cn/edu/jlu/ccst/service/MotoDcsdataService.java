package cn.edu.jlu.ccst.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.dao.DcsDscribServiceInter;
import cn.edu.jlu.ccst.dao.Init_PredictServiceInter;
import cn.edu.jlu.ccst.dao.MotoDcsdataServiceInter;
import cn.edu.jlu.ccst.dao.TreeunitServiceInter;
import cn.edu.jlu.ccst.model.DcsDscrib;
import cn.edu.jlu.ccst.model.Dcsdata;
import cn.edu.jlu.ccst.model.Init_Predict;
import cn.edu.jlu.ccst.model.MotoDcsdata;

/**
*实时数据监控服务类
*@author catherine
*/
@Component("motodcsdataService")
public class MotoDcsdataService {
	private Init_PredictServiceInter init_predictServiceImpl;
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
	
	public Init_PredictServiceInter getInit_predictServiceImpl() {
		return init_predictServiceImpl;
	}
	@Resource
	public void setInit_predictServiceImpl(
			Init_PredictServiceInter init_predictServiceImpl) {
		this.init_predictServiceImpl = init_predictServiceImpl;
	}
	
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


	public List<MotoDcsdata> validatemoto(List<MotoDcsdata> input){
		List<MotoDcsdata> resultlist = new ArrayList();
		for(MotoDcsdata md:input){
			Init_Predict ip = init_predictServiceImpl.findbyid(md.getEquipment());
			if(ip!=null){
				String ipname = ip.getName();
				String ni = ipname.replace('.', ',');
				if (ni != null && ni.length() >= 1&&ni.indexOf(",")>0) {
					String[] niarray = ni.split(",");
					if (niarray.length == 2) {						
						MotoDcsdata temp = new MotoDcsdata();
						temp.setEquipment(niarray[0].trim());
						temp.setItem(niarray[1].trim());
						temp.setValue(md.getValue());
						resultlist.add(temp);
					}
				}
			}
		}
		return resultlist;
	}


	/**
	*查找所有实时数据
	*@return 实时数据列表
	*/
	public List<MotoDcsdata> findAll() {
		List<MotoDcsdata> resultlist = new ArrayList();
		resultlist = motodcsdataServiceImpl.findAll();
		return validatemoto(resultlist);
	}
	/**
	*查找所有实时数据预处理
	*@param keyword 关键字
	*@return 实时数据列表
	*/
	public JSONObject getalldcsddatap(String keyword) {
		List<MotoDcsdata> results = new ArrayList();
		List<String> jiedians = treeunitServiceImpl.findallchild(keyword);
		for(String jiedian:jiedians){
			List<MotoDcsdata> temp =  getalldcsddatanlist(jiedian);
			results.addAll(temp);
		}
		return list2json(validatemoto(results));
	}
	/**
	*查找所有实时数据预处理进行规则转化
	*@param keyword 关键字
	*@return 实时数据列表
	*/
	public JSONObject getalldcsddata(String keyword) {
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
			return list2json(fliterresults);
			}else{
				return list2json(results);
			}
		
	}
	/**
	*查找所有实时数据预处理进行规则转化
	*@param keyword 关键字
	*@return 实时数据列表
	*/
	
	public JSONObject getalldcsddatan(String keyword) {
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

			return list2json(fliterresults);
		
	}
	
	public List<MotoDcsdata> getalldcsddatanlist(String keyword) {
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
	
	private JSONObject list2json(List<MotoDcsdata> mylist){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", mylist.size()); 
        jsonMap.put("rows", mylist);
        return JSONObject.fromObject(jsonMap);
	}

	

}