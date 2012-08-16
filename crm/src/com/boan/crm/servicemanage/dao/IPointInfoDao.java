package com.boan.crm.servicemanage.dao;

import com.boan.crm.servicemanage.model.PointInfo;
import com.boan.crm.utils.dao.IBaseDao;

/**
 * 积分管理DAO接口
 * @author XXX
 * @version 1.0.0
 */
public interface IPointInfoDao extends IBaseDao<PointInfo,String> {
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
}
