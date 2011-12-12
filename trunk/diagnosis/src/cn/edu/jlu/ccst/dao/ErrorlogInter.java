package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Errorlog;

public interface ErrorlogInter {
	 public void save(Errorlog errorlog);
	 public List<Errorlog> findAll();
	 public List<Errorlog> findbyequipment(String equip);
}