package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Backward;
import cn.edu.jlu.ccst.model.BackwardandReason;

public interface BackwardReasonInter {
	
	
	public List<BackwardandReason> find(Backward bw);

	public void save(BackwardandReason backwardandReason);

	public BackwardandReason find(int id);
	public void remove(int id);
	


}
