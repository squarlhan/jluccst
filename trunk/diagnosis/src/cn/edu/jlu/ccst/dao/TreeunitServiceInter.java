package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Treeunit;
/**
 * 树形结构数据库接口
 * @author Woden
 *
 */
public interface TreeunitServiceInter {
	/**
	 * 通过父亲节点查找所有子节点
	 * @param father 父节点名称
	 * @return 所有子节点
	 */
	 public List<String> findallchild(String father);
}
