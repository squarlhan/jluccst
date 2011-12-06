package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Pre_dss;

public interface Pre_dssServiceInter {
	public List<Pre_dss> findByname(String name);
	 public void delete(Pre_dss pre_dss);
	 public List<Pre_dss> findAll();
	 public void save(Pre_dss pre_dss);
	 public List<Pre_dss> findBysimu_time();
	 public List<String> findsimu_time();
}
