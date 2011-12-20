package cn.edu.jlu.ccst.dao;
import java.util.List;

import cn.edu.jlu.ccst.model.Dss_history;
public interface Dss_historyServiceInter {
	 public void save(Dss_history dss_history);
	  public List<Dss_history> findsimu_time();
	  public List<Dss_history> findAll();
	    public List<Dss_history> findbyName(String name);
	    public List<Dss_history> findbypara(String para);
}
