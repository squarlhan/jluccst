package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.DcsDscrib;
/**
 * 参数描述数据库操作接口
 * @author Woden
 *
 */
public interface DcsDscribServiceInter {
	
	/**
	 * 得到所有设备名
	 * @return 设备名列表
	 */
	public List<String> findAllname() ;
	/**
	 * 存储或更改一个参数描述
	 * @param dcsDscrib 待持久化的参数描述
	 */
	public void save(DcsDscrib dcsDscrib);
	/**
	 * 通过设备名查找参数描述
	 * @param name 设备名
	 * @return 参数描述列表
	 */
	public List<DcsDscrib> findbyname(String name) ;
	/**
	 * 通过参数名查找参数描述
	 * @param item 参数名
	 * @return 参数描述列表
	 */
	public List<DcsDscrib> findbyitem(int item) ;
	/**
	 * 通过设备名和参数名查找参数描述
	 * @param name 设备名
	 * @param item 参数名
	 * @return 参数描述列表
	 */
	public List<DcsDscrib> findbyname(String eque, String item) ;
	/**
	 * 得到所有参数描述
	 * @return 参数描述列表
	 */
	public List<DcsDscrib> findAll();
	/**
	 * 通过描述id得到参数描述
	 * @param id 参数描述id
	 * @return 参数描述
	 */
	public DcsDscrib find(int id) ;
	/**
	 * 通过描述id删除参数描述
	 * @param id 参数描述id
	 */
	public void remove(int id);
	/**
	 * 通过设备全名得到查找参数描述
	 * @param eque 设备全名
	 * @return 参数描述列表
	 */
	public List<DcsDscrib> findbyeque(String eque);
	/**
	 * 通过设备名模糊查找参数描述
	 * @param name 设备名
	 * @return 参数描述列表
	 */
	public List<DcsDscrib> findlikename(String name);
}
