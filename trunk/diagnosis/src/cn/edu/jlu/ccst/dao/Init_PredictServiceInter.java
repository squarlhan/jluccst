package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Init_Predict;
/**
 * 设备名和设备id关联表数据库操作接口
 * @author Woden
 *
 */
public interface Init_PredictServiceInter {
	/**
	 * 删除一个设备名和设备id关联
	 * @param duizhao 待删除的设备名和设备id关联
	 */
	 public void delete(Init_Predict duizhao);
	 /**
	  * 得到所有的设备名和设备id关联
	  * @return 设备名和设备id关联列表
	  */
	 public List<Init_Predict> findAll();
	 /**
	  * 存储或更改一个设备名和设备id关联
	  * @param duizhao 要持久化的设备名和设备id关联
	  */
	 public void save(Init_Predict duizhao);
	 /**
	  * 通过id找到关联
	  * @param jiedian 设备id
	  * @return 关联
	  */
	 public List<String> findbyjiedian(String jiedian);
	 
	 public Init_Predict findbyid(String id);
}
