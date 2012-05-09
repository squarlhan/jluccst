package cn.edu.jlu.ccst.dao;
import java.util.List;

import cn.edu.jlu.ccst.model.Dss_advice;
/**
 * 工艺对接数据数据库操作接口
 * @author Woden
 *
 */
public interface Dss_adviceServiceInter {
	/**
	 * 存储或更改一个工艺对接数据
	 * @param dss_advice 要持久化的工艺对接数据
	 */
	 public void save(Dss_advice dss_advice);
	 /**
	  * 查找最新的工艺对接数据时间
	  * @return 工艺对接数据时间
	  */
	  public List<String> findsimu_time();
	  /**
	   * 得到所有的工艺对接数据
	   * @return 工艺对接数据列表
	   */
	  public List<Dss_advice> findAll();
	  /**
	   * 删除所有工艺对接数据
	   */
	  public void deleteall();
}
