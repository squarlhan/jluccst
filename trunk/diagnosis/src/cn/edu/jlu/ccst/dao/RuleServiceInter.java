package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Backward;

public interface RuleServiceInter {
	
	public List<Backward> findAll();

	public void save(Backward backward);

	public void remove(int id);

	public Backward find(int id);
	

}
