package cn.edu.jlu.ccst.dao;

import java.util.List;

import javax.persistence.Query;

import cn.edu.jlu.ccst.model.Backward;
import cn.edu.jlu.ccst.model.BackwardandResult;
import cn.edu.jlu.ccst.model.Errorlog;
/**
 * 规则与结果关联表数据库操作接口
 * @author Woden
 *
 */
public interface RuleBRServiceInter {
    /**
     * 得到所有规则与结果关联表
     * @return 规则与结果关联列表
     */
	public List<BackwardandResult> findAll() ;
	/**
	 * 存储或更改一个规则与结果对应关系
	 * @param backwardandresult 要持久化的规则与结果对应关系
	 */
	public void save(BackwardandResult backwardandresult);
	/**
	 * 通过id查找规则与原因对应关系
	 * @param id 规则与原因对应关系id
	 * @return 规则与原因对应关系列表
	 */
	public BackwardandResult find(int id);
/**
 * 得到所有现象名词
 * @return 名词列表
 */
	public List<String> findAllnoun() ;
	/**
	 * 通过名词得到所有相关的现象动词
	 * @param noun 现象名词
	 * @return 动词列表
	 */
	public List<String> findAllverb(String noun);
	/**
	 * 通过名词部分信息得到所有相关的现象名词
	 * @param noun 现象名词
	 * @return 名词列表
	 */
	public List<String> findbynoun(String noun);
	

}
