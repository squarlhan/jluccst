package cn.edu.jlu.ccst.dao;


import cn.edu.jlu.ccst.model.Dcshistory;
/**
 * DCS历史数据数据库操作接口
 * @author Woden
 *
 */
public interface DcshistoryInter {
	/**
	 * 存储或更改一个DCS历史数据
	 * @param dcshistory 待持久化DCS历史数据
	 */
	 public void save(Dcshistory dcshistory);
}
