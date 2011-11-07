package cn.edu.jlu.ccst.dao;

import java.util.List;

import javax.persistence.Query;

import cn.edu.jlu.ccst.model.Backward;
import cn.edu.jlu.ccst.model.BackwardandResult;

public interface RuleBRServiceInter {
	
	public List<BackwardandResult> findAll() ;

	public void save(BackwardandResult backwardandresult);

	

	public BackwardandResult find(int id);

	public List<String> findAllnoun() ;
	public List<String> findAllverb(String noun);

	

}
