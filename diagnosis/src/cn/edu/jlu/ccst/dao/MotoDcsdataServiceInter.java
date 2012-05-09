package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.MotoDcsdata;

/**
 * 自动采集的DCS数据数据库操作接口
 * @author Woden
 *
 */
public interface MotoDcsdataServiceInter {
/**
 * 通过设备名找到相关数据
 * @param equipment 设备名
 * @return 数据列表
 */
	public List<MotoDcsdata> findByequipment(String equipment) ;
	/**
	 * 存储或更改一个自动采集的DCS数据
	 * @param motoDcsdata 要持久化的自动采集的DCS数据
	 */
	public void save(MotoDcsdata motoDcsdata);
	/**
	 * 得到所有的自动采集的DCS数据
	 * @return 数据列表
	 */
	public List<MotoDcsdata> findAll();
	/**
	 *  删除一个自动采集的DCS数据
	 * @param motoDcsdata 要删除的自动采集的DCS数据
	 */
	public void delete(MotoDcsdata motoDcsdata);
}
