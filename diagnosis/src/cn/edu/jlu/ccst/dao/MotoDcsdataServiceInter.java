package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.MotoDcsdata;


public interface MotoDcsdataServiceInter {

	public List<MotoDcsdata> findByequipment(String equipment) ;
	public void save(MotoDcsdata motoDcsdata);
	public List<MotoDcsdata> findAll();
	public void delete(MotoDcsdata motoDcsdata);
}
