package com.boan.crm.servicemanage.service;

import java.util.Map;

import com.boan.crm.servicemanage.model.PointInfo;
import com.boan.crm.utils.page.Pagination;

/**
 * 积分管理接口类
 * @author XXX
 * @version 1.0.0
 */
public interface IPointInfoService {
	/**
	 * 获得总积分
	 * @param companyId 单位ID
	 * @return 总积分
	 */
	public int getTotalPoint(String companyId);
	/**
	 * 获得消费总额
	 * @param companyId 单位ID
	 * @return 消费总额
	 */
	public float getConsumptionAmount(String companyId);
	/**
	 * 根据消费ID获得积分对象 
	 * @param consumptionId 消费ID
	 * @return 积分对象
	 */
	public PointInfo getByConsumptionId(String consumptionId);
	/**
	 * 获得根据积分记录ID，获得积分对象
	 * @param id 积分记录ID
	 * @return 积分对象
	 */
	public PointInfo get(String id);

	/**
	 * 删除积分记录
	 * @param ids 积分记录ID
	 */
	public void deletePointInfo(String... ids);

	/**
	 * 保存积分记录信息
	 * @param obj 积分记录对象
	 */
	public void saveOrUpdate(PointInfo obj);

	/**
	 * 分页显示积分记录
	 * @param values 参数
	 * @param pagination 分页对象
	 * @return 积分记录对象集合
	 */
	public Pagination<PointInfo> findForPage(Map<String, ?> values, Pagination<PointInfo> pagination);
}
