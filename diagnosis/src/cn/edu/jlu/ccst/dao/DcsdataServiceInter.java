package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Dcsdata;
import cn.edu.jlu.ccst.model.User;

public interface DcsdataServiceInter {

	public List<Dcsdata> findByequipment(String equipment) ;
	public void save(Dcsdata dcsdata);
	public List<Dcsdata> findAll();
}
