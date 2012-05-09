package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Dcsdata;
import cn.edu.jlu.ccst.model.User;
/**
 * DCS数据数据库操作接口
 * @author Woden
 *
 */
public interface DcsdataServiceInter {
/**
 * 根据设备名查找DCS数据
 * @param equipment 设备名
 * @return DCS数据列表
 */
	public List<Dcsdata> findByequipment(String equipment) ;
	/**
	 * 根据 设备名,参数名查找DCS数据
	 * @param equipment 设备名
	 * @param item 参数名
	 * @return DCS数据列表
	 */
	public List<Dcsdata> findByitem(String equipment, String item) ;
	/**
	 * 保存或者更改一个DCS数据
	 * @param dcsdata 要持久化的DCS数据
	 */
	public void save(Dcsdata dcsdata);
	/**
	 * 得到所有的DCS数据
	 * @return DCS数据列表
	 */
	public List<Dcsdata> findAll();
	/**
	 * 删除一个DCS数据
	 * @param dcsdata 戴珊处的DCS数据
	 */
	public void delete(Dcsdata dcsdata);
}
