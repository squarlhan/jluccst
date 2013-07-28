/**
 * Copyright (c) 2013 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)SellReportStatDaoImpl.java 1.1 2013-6-22
 */

package com.boan.crm.sellreport.stat.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.boan.crm.sellreport.stat.dao.ISellReportStatDao;
import com.boan.crm.sellreport.stat.model.SalesPerformanceRank;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * XXX 类
 * @author XXX
 * @version 1.0.0
 */
@Repository("sellReportStatDao")
public class SellReportStatDaoImpl  extends BaseDao implements ISellReportStatDao {

	/**
	 * 根据时间段查询某公司某部门下业务员的销售排名情况
	 * @param beginDate 开始时间
	 * @param endDate  结束时间
	 * @param companyId 公司id
	 * @param deptId 部门id
	 * @return 销售排名信息数组
	 */
	public List<SalesPerformanceRank> querySalesPerformanceRank(String beginDate , String endDate, String companyId,String deptId){
		List<SalesPerformanceRank> returnList =null ;
		String sql = "" +
				" select A.SALESMAN_ID , A.SALESMAN_Name , A.DEPT_ID , B.DEPT_NAME , SUM( A.RECEIVABLE ) as sales_Amount from sell_record A LEFT JOIN group_deptment B on a.DEPT_ID =  B.id " +
				" where 1=1" ;
				if( deptId!=null && !deptId.equals("")){
					sql = sql + " and  A.DEPT_ID='"+deptId+"' " ;
				}
				sql = sql + " and  A.COMPANY_ID='"+companyId+"' " +
				" and A.BARGAIN_TIME>='"+beginDate+"' " +
				" and A.BARGAIN_TIME<='"+endDate +"' " +
				" GROUP BY A.SALESMAN_ID ORDER BY sales_Amount desc";
		List list = this.getSession().createSQLQuery(sql).list();
		if(list!=null && list.size()>0){
			returnList = new ArrayList<SalesPerformanceRank>();
			for(int i=0;i<list.size();i++){
				Object[] columns = (Object[])list.get(i);
				SalesPerformanceRank temp = new SalesPerformanceRank();
				temp.setSequenceNumber(i+1);
				temp.setSalesmanId( columns[0].toString() );
				temp.setSalesmanName(columns[1].toString() );
				temp.setDeptId(columns[2].toString() );
				temp.setDeptName(columns[3].toString() );
				temp.setSalesAmount(new BigDecimal(columns[4].toString() ));
				returnList.add(temp);
			}
		}
		return returnList;
	}
}

