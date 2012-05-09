package cn.edu.jlu.ccst.service;


import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.Pre_dssServiceInter;
import cn.edu.jlu.ccst.dao.Pre_dssServiceImpl;
import cn.edu.jlu.ccst.model.Dss_advice;
import cn.edu.jlu.ccst.model.Pre_dss;
/**
 * 工艺实时数据服务
 */
@Component("pre_dssService")
public class Pre_dssService {
	/**
	 * 工艺实时数据实例
	 */
	private Pre_dss pre_dss;
	/**
	 * 工艺实时数据接口
	 */
	private Pre_dssServiceInter pre_dssServiceImpl;

	

	

	public Pre_dss getPre_dss() {
		return pre_dss;
	}
	@Resource
	public void setPre_dss(Pre_dss pre_dss) {
		this.pre_dss = pre_dss;
	}

	public Pre_dssServiceInter getPre_dssServiceImpl() {
		return pre_dssServiceImpl;
	}
	@Resource
	public void setPre_dssServiceImpl(Pre_dssServiceInter pre_dssServiceImpl) {
		this.pre_dssServiceImpl = pre_dssServiceImpl;
	}

	public void save(Pre_dss pre_dss) {
	
		pre_dssServiceImpl.save(pre_dss);
	}
	
	public void delete(Pre_dss pre_dss) {
		
		pre_dssServiceImpl.delete(pre_dss);
	}
	/**
	 * 根据名称查找工艺实时数据
	 * @param name 设备名称
	 * @return 工艺实时数据列表
	 */
	public List<Pre_dss> findbyname(String name) {
		List<Pre_dss> resultlist = new ArrayList();
		resultlist = pre_dssServiceImpl.findByname(name);
		return resultlist;
	}
	/**
	 * 查找工艺实时数据
	 * @return 工艺实时数据列表
	 */
	public List<Pre_dss> findAll() {
		List<Pre_dss> resultlist = new ArrayList();
		resultlist = pre_dssServiceImpl.findAll();
		return resultlist;
	}
	/**
	 * 根据批次查找工艺实时数据
	 * @return 工艺实时数据列表
	 */
	public List<Pre_dss> findBysimu_time() {
		List<Pre_dss> resultlist = new ArrayList();
		resultlist = pre_dssServiceImpl.findBysimu_time();
		return resultlist;
	}
	/**
	 * 查找批次时间
	 * @return 时间列表
	 */
	public List<String> findsimu_time() {
		List<String> resultlist = new ArrayList();
		resultlist = pre_dssServiceImpl.findsimu_time();
		return resultlist;
	}
	
	
}