package cn.edu.jlu.ccst.dao;

import java.util.Date;
import java.util.List;

import cn.edu.jlu.ccst.model.MotoErrorlog;

public interface MotoErrorlogInter {
	 public void save(MotoErrorlog motoErrorlog);
	 public List<MotoErrorlog> findAll();
	 public List<MotoErrorlog> findbyequipment(String equip);
	 public List<MotoErrorlog> findbypara(String para);
	 public List<MotoErrorlog> findbytime(String date1,String date2);
	 public List<MotoErrorlog> findbyorder(String para,String date1,String date2);
}