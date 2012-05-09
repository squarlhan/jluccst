package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Pre_dss;
/**
 * 从工艺对接得到的数据数据库相关操作接口
 * @author Woden
 *
 */
public interface Pre_dssServiceInter {
	/**
	 * 通过设备名得到工艺数据
	 * @param name 设备名
	 * @return 工艺数据列表
	 */
	public List<Pre_dss> findByname(String name);
	/**
	 * 删除一个工艺数据
	 * @param pre_dss 要删除的工艺数据
	 */
	 public void delete(Pre_dss pre_dss);
	 /**
	  * 得到所有的工艺数据
	  * @return 工艺数据列表
	  */
	 public List<Pre_dss> findAll();
	 /**
	  * 存储或更改一个工艺数据
	  * @param pre_dss 要持久化的工艺数据
	  */
	 public void save(Pre_dss pre_dss);
	 /**
	  * 得到最新的工艺数据
	  * @return 工艺数据列表
	  */
	 public List<Pre_dss> findBysimu_time();
	 /**
	  * 得到最新的时间
	  * @return 最新的时间
	  */
	 public List<String> findsimu_time();
}
