package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.BackwardandResult;
/**
 * 规则与结果关联表数据库操作接口
 * @author Woden
 *
 */
public interface BackwardResultInter {
	
	/**
	 * 通过部分规则信息查找规则与结果对应关系
	 * @param br 规则与结果对应关系
	 * @return 规则与结果对应关系列表
	 */
	public List<BackwardandResult> find(BackwardandResult br);
	/**
	 * 查找所有规则与结果对应关系
	 * @return 规则与结果对应关系列表
	 */
	public List<BackwardandResult> findAll();


	
	
	


}
