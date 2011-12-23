package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Pre_history;

public interface Pre_historyServiceInter {
	public List<Pre_history> findByname(String name);
	 public void delete(Pre_history Pre_history);
	 public List<Pre_history> findAll();
	 public void save(Pre_history Pre_history);
	 public List<Pre_history> findBysimu_time();
	 public List<String> findsimu_time();
}
