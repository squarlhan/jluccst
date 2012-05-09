package cn.edu.jlu.ccst.service;


import java.util.ArrayList;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.Pre_historyServiceInter;
import cn.edu.jlu.ccst.dao.Pre_historyServiceImpl;
import cn.edu.jlu.ccst.model.Pre_dss;
import cn.edu.jlu.ccst.model.Pre_history;
/**
 * 工艺实时数据历史服务类

 */
@Component("pre_historyService")
public class Pre_historyService {
	/**
	 * 工艺实时数据历史实例

	 */
	private Pre_history pre_history;
	/**
	 * 工艺实时数据历史接口
	 */
	private Pre_historyServiceInter pre_historyServiceImpl;

	

	

	public Pre_history getPre_history() {
		return pre_history;
	}
	@Resource
	public void setPre_history(Pre_history pre_history) {
		this.pre_history = pre_history;
	}

	public Pre_historyServiceInter getPre_historyServiceImpl() {
		return pre_historyServiceImpl;
	}
	@Resource
	public void setPre_historyServiceImpl(Pre_historyServiceInter pre_historyServiceImpl) {
		this.pre_historyServiceImpl = pre_historyServiceImpl;
	}

	public void save(Pre_history pre_history) {
	
		pre_historyServiceImpl.save(pre_history);
	}
	
	public void delete(Pre_history pre_history) {
		
		pre_historyServiceImpl.delete(pre_history);
	}
	/**
	 * 根据名称查找工艺实时数据历史
	 * @return 工艺实时数据历史列表
	 */
	public List<Pre_history> findbyname(String name) {
		List<Pre_history> resultlist = new ArrayList();
		resultlist = pre_historyServiceImpl.findByname(name);
		return resultlist;
	}
	/**
	 * 查找工艺实时数据历史
	 * @return 工艺实时数据历史列表
	 */
	public List<Pre_history> findAll() {
		List<Pre_history> resultlist = new ArrayList();
		resultlist = pre_historyServiceImpl.findAll();
		return resultlist;
	}
	/**
	 * 根据批次查找工艺实时数据历史
	 * @return 工艺实时数据历史列表
	 */
	public List<Pre_history> findBysimu_time() {
		List<Pre_history> resultlist = new ArrayList();
		resultlist = pre_historyServiceImpl.findBysimu_time();
		return resultlist;
	}
	/**
	 * 查找批次时间
	 * @return 批次时间列表
	 */
	public List<String> findsimu_time() {
		List<String> resultlist = new ArrayList();
		resultlist = pre_historyServiceImpl.findsimu_time();
		return resultlist;
	}
	/**
	 * 保存工艺实时数据历史
	
	 */
	public void saveall(List<Pre_dss> pds){
		String simtime = "";
		if(pds!=null&&pds.size()>0){
			simtime = pds.get(0).getSimu_time();
		}else{
			return;
		}
		List<String> sts = findsimu_time();
		if(sts.indexOf(simtime)>=0){
			return;
		}else{
			for(Pre_dss pd:pds){
				Pre_history temp = new Pre_history();
				temp.setName(pd.getName());
				temp.setSeqno(pd.getSeqno());
				temp.setSimu_time(pd.getSimu_time());
				temp.setValue(pd.getValue());
				save(temp);
			}
			
		}
	}
	
	
}