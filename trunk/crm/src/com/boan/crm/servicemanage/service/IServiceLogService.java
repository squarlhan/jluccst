package com.boan.crm.servicemanage.service;

import java.util.Map;

import com.boan.crm.servicemanage.model.ServiceLog;
import com.boan.crm.utils.page.Pagination;

/**
 * 服务管理接口类
 * @author XXX
 * @version 1.0.0
 */
public interface IServiceLogService {
	/**
	 * 获得根据服务记录ID，获得服务对象
	 * @param id 服务记录ID
	 * @return 服务对象
	 */
	public ServiceLog get(String id);

	/**
	 * 删除服务记录
	 * @param ids 服务记录ID
	 */
	public void deleteServiceLog(String... ids);

	/**
	 * 保存服务记录信息
	 * @param obj 服务记录对象
	 */
	public void saveOrUpdate(ServiceLog obj);

	/**
	 * 分页显示服务记录
	 * @param values 参数
	 * @param pagination 分页对象
	 * @return 服务记录对象集合
	 */
	public Pagination<ServiceLog> findForPage(Map<String, ?> values, Pagination<ServiceLog> pagination);
}
