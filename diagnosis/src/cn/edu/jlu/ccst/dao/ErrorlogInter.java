package cn.edu.jlu.ccst.dao;

import java.util.Date;
import java.util.List;

import cn.edu.jlu.ccst.model.Errorlog;
/**
 * 错误日志数据库操作接口
 * @author Woden
 *
 */
public interface ErrorlogInter {
	/**
	 * 存储或更改一个错误日志
	 * @param errorlog 待持久化错误日志
	 */
	 public void save(Errorlog errorlog);
	 /**
	  * 得到所有的错误日志
	  * @return 错误日志列表
	  */
	 public List<Errorlog> findAll();
	 /**
	  * 通过设备名查找相关错误日志
	  * @param equip 设备名
	  * @return 错误日志列表
	  */
	 public List<Errorlog> findbyequipment(String equip);
	 /**
	  * 通过参数名查找相关错误日志
	  * @param para 参数名
	  * @return 错误日志列表
	  */
	 public List<Errorlog> findbypara(String para);
	 /**
	  * 通过时间段查找相关错误日志
	  * @param date1 开始时间
	  * @param date2 结束时间
	  * @return 错误日志列表
	  */
	 public List<Errorlog> findbytime(String date1,String date2);
	 /**
	  * 通过时间段和参数名查找相关错误日志
	  * @param para 参数名
	  * @param date1 开始时间
	  * @param date2 结束时间
	  * @return 错误日志列表
	  */
	 public List<Errorlog> findbyorder(String para,String date1,String date2);
}