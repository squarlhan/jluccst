package cn.edu.jlu.ccst.dao;

import java.util.Date;
import java.util.List;

import cn.edu.jlu.ccst.model.MotoErrorlog;
/**
 * 自动采集的DCS数据错误日志数据库操作接口
 * @author Woden
 *
 */
public interface MotoErrorlogInter {
	/**
	 * 存储或更改一个错误日志
	 * @param motoErrorlog 待持久化错误日志
	 */
	 public void save(MotoErrorlog motoErrorlog);
	 /**
	  * 得到所有的错误日志
	  * @return 错误日志列表
	  */
	 public List<MotoErrorlog> findAll();
	 /**
	  * 通过设备名查找相关错误日志
	  * @param equip 设备名
	  * @return 错误日志列表
	  */
	 public List<MotoErrorlog> findbyequipment(String equip);
	 /**
	  * 通过参数名查找相关错误日志
	  * @param para 参数名
	  * @return 错误日志列表
	  */
	 public List<MotoErrorlog> findbypara(String para);
	 /**
	  * 通过时间段查找相关错误日志
	  * @param date1 开始时间
	  * @param date2 结束时间
	  * @return 错误日志列表
	  */
	 public List<MotoErrorlog> findbytime(String date1,String date2);
	 /**
	  * 通过时间段和参数名查找相关错误日志
	  * @param para 参数名
	  * @param date1 开始时间
	  * @param date2 结束时间
	  * @return 错误日志列表
	  */
	 public List<MotoErrorlog> findbyorder(String para,String date1,String date2);
}