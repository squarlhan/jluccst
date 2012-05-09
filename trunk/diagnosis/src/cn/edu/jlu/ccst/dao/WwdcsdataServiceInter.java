package cn.edu.jlu.ccst.dao;

import java.util.List;

import cn.edu.jlu.ccst.model.Wwdcsdata;
/**
 * 古老的DCS数据数据库操作接口
 * @author Woden
 *
 */
public interface WwdcsdataServiceInter {
	
	/**
	 * 存储或更改一个古老的DCS数据
	 * @param wwdcsdata 要持久化的古老的DCS数据
	 */
	public void save(Wwdcsdata wwdcsdata);

/**
 * 查找最新的dcs数据
 * @param wwdcsdata dcs数据大部分信息
 * @return dcs数据
 */
	 public Wwdcsdata findbytime(Wwdcsdata wwdcsdata);
	
	
	


}
