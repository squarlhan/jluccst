package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Backward;
import cn.edu.jlu.ccst.model.BackwardandReason;
/**
 * 规则与原因关联表数据库操作接口
 * @author Woden
 *
 */
public interface BackwardReasonInter {
	
	/**
	 * 通过规则信息查找规则与原因对应关系
	 * @param bw 规则
	 * @return 规则与原因对应关系列表
	 */
	public List<BackwardandReason> find(Backward bw);
/**
 * 存储或更改一个规则与原因对应关系
 * @param backwardandReason 要持久化的规则与原因对应关系
 */
	public void save(BackwardandReason backwardandReason);
/**
 * 通过id查找规则与原因对应关系
 * @param id 规则与原因对应关系id
 * @return 规则与原因对应关系列表
 */
	public BackwardandReason find(int id);
	/**
	 * 通过id删除规则与原因对应关系
	 * @param id 规则与原因对应关系id
	 */
	public void remove(int id);
	


}
