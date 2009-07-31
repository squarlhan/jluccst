package cn.edu.jlu.ccst.sshclient.inter;

import java.util.List;

import cn.edu.jlu.ccst.sshclient.model.BaseClass;

/***
 * @author Woden
 *
 */

public interface BaseOperation {

	/**
	 * 
	 */
	boolean creat();
	/**

	 */
	boolean remove();
	/**
	 *
	 */
	boolean update();
	/**
	 *
	 */
	BaseClass load(String id);
	/**
	 *
	 */
	List<BaseClass> find(String name);
}
