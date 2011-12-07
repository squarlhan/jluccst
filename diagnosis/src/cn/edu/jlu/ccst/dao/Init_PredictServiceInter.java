package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Init_Predict;

public interface Init_PredictServiceInter {
	 public void delete(Init_Predict duizhao);
	 public List<Init_Predict> findAll();
	 public void save(Init_Predict duizhao);
	 public List<String> findbyjiedian(String jiedian);
}
