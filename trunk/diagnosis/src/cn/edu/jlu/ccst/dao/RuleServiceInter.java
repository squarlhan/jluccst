package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Backward;
import cn.edu.jlu.ccst.model.BackwardandResult;
/**
 * 规则数据库操作接口
 * @author Woden
 *
 */
public interface RuleServiceInter {
	/**
	 * 得到所有规则
	 * @return 规则列表
	 */
	public List<Backward> findAll();
	/**
	 * 存储或更改一个规则
	 * @param backward 要持久化的规则
	 */
	public void save(Backward backward);
/**
 * 通过id删除一个规则
 * @param id 规则id
 */
	public void remove(int id);
/**
 * 通过id查找一个规则
 * @param id 规则id
 * @return 规则
 */
	public Backward find(int id);
	/**
	 * 通过规则名查找规则
	 * @param name 规则名
	 * @return 规则列表
	 */
	public List<Backward> findbyname(String name);
	

}
