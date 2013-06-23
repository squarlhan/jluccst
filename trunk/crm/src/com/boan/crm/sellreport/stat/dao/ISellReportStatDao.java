/**
 * Copyright (c) 2013 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)ISellReportStatDao.java 1.1 2013-6-22
 */

package com.boan.crm.sellreport.stat.dao;

import java.util.List;

import com.boan.crm.sellreport.stat.model.SalesPerformanceRank;
import com.boan.crm.utils.dao.IBaseDao;

/**
 * XXX 类
 * @author XXX
 * @version 1.0.0
 */
public interface ISellReportStatDao extends IBaseDao{

	/**
	 * 根据时间段查询某公司某部门下业务员的销售排名情况
	 * @param beginDate 开始时间
	 * @param endDate  结束时间
	 * @param companyId 公司id
	 * @param deptId 部门id
	 * @return 销售排名信息数组
	 */
	public List<SalesPerformanceRank> querySalesPerformanceRank(String beginDate , String endDate, String companyId,String deptId);
}

