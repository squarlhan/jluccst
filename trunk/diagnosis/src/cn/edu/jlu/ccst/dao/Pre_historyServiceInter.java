package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Pre_history;
/**
 * 工艺对接数据错误日志数据库操作接口
 * @author Woden
 *
 */
public interface Pre_historyServiceInter {
	/**
	 * 通过设备名查找错误日志
	 * @param name 设备名
	 * @return 错误日志泪飙
	 */
	public List<Pre_history> findByname(String name);
	/**
	 * 删除一个错误数据
	 * @param Pre_history 要删除的数据
	 */
	 public void delete(Pre_history Pre_history);
	 /**
	  * 得到所有的错误日志
	  * @return 错误日志列表
	  */
	 public List<Pre_history> findAll();
	 /**
	  * 存储或更改一个错误日志
	  * @param Pre_history  待持久化错误日志
	  */
	 public void save(Pre_history Pre_history);
	 /**
	  * 查找最新的错误日志
	  * @return 错误日志列表
	  */
	 public List<Pre_history> findBysimu_time();
	 /**
	  * 查找最新的时间
	  * @return 最新的时间
	  */
	 public List<String> findsimu_time();
}
