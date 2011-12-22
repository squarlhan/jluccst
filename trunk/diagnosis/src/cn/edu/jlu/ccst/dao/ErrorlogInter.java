package cn.edu.jlu.ccst.dao;

import java.util.Date;
import java.util.List;

import cn.edu.jlu.ccst.model.Errorlog;

public interface ErrorlogInter {
	 public void save(Errorlog errorlog);
	 public List<Errorlog> findAll();
	 public List<Errorlog> findbyequipment(String equip);
	 public List<Errorlog> findbypara(String para);
	 public List<Errorlog> findbytime(String date1,String date2);
	 public List<Errorlog> findbyorder(String para,String date1,String date2);
}