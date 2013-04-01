package com.boan.crm.sellreport.monthly.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.sellreport.monthly.dao.IMonthlyItemInfoDao;
import com.boan.crm.sellreport.monthly.dao.IMonthlyMainInfoDao;
import com.boan.crm.sellreport.monthly.model.MonthlyMainInfo;
import com.boan.crm.sellreport.monthly.service.IMonthlyMainInfoService;
import com.boan.crm.sellreport.weekly.model.WeeklyMainInfo;
import com.boan.crm.utils.page.Pagination;

@Service("monthlyMainInfoService")
public class MonthlyMainInfoServiceImpl implements IMonthlyMainInfoService{

	@Autowired
	@Qualifier("monthlyMainInfoDao")
	private IMonthlyMainInfoDao monthlyMainInfoDao;
	
	@Autowired
	@Qualifier("monthlyItemInfoDao")
	private IMonthlyItemInfoDao monthlyItemInfoDao;
	
	/**
	 * 保存或修改月计划信息
	 * @param obj
	 */
	public void saveOrUpdateMonthlyMainInfo(MonthlyMainInfo obj){
		monthlyMainInfoDao.saveOrUpdate(obj);
	}
	
	/**
	 * 根据月计划Id查询月计划信息
	 * @param id
	 * @return
	 */
	public MonthlyMainInfo getMonthlyMainInfoById(String id){
		return monthlyMainInfoDao.get(id);
	}
	
	/**
	 * 根据计划人Id查询月计划信息
	 * @param personId
	 * @return
	 */
	public List<MonthlyMainInfo>  getMonthlyMainInfoListByPersonId(String personId){
		return monthlyMainInfoDao.findByProperty("personId", personId);
	}
	
	/**
	 * 按分页查询月计划信息
	 */
	public Pagination<MonthlyMainInfo> findMonthlyMainInfoForPage( Map<String, ?> values, Pagination<MonthlyMainInfo> pagination){
		StringBuffer strb = new StringBuffer( " where 1=1 ");
		if(values!=null){
			if(values.containsKey("personId")){
				strb.append(" and  personId=:personId  ");
			}
			if(values.containsKey("deptId")){
				strb.append(" and  deptId=:deptId  ");
			}
			if(values.containsKey("planInterzoneBegin")){
				strb.append(" and  planInterzoneBegin ='"+values.get("planInterzoneBegin")+"'  ");
			}
			if(values.containsKey("personName")){
				strb.append(" and  personName like '%"+values.get("personName")+"%'  ");
			}
		}
		String hql = "from MonthlyMainInfo "+strb.toString()+" order by createTime desc";
		List<MonthlyMainInfo> data = monthlyItemInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from MonthlyMainInfo" +strb.toString();
		int totalRows = monthlyItemInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	 /**
	  * 通过Id删除月计划信息
	  * @param id
	  */
	public void deleteMonthlyMainInfoByIds(String... ids){
		monthlyMainInfoDao.delete(ids);
	}
	
	/**
	 *查询最近月计划项信息
	 * @param 
	 * @return
	 */
	public MonthlyMainInfo getLastMonthlyMainInfo(Map<String, ?> params){
		StringBuffer strb = new StringBuffer( " where 1=1 ");
		if(params!=null){
			if(params.containsKey("personId")){
				strb.append(" and  personId=:personId  ");
			}
			if(params.containsKey("planInterzoneBegin") && params.containsKey("planInterzoneEnd")){
				strb.append(" and  planInterzoneBegin >='"+params.get("planInterzoneBegin")+"'  ");
				strb.append(" and  planInterzoneEnd >='"+params.get("planInterzoneBegin")+"'  ");
				
				strb.append(" and  planInterzoneBegin <='"+params.get("planInterzoneEnd")+"'  ");
				strb.append(" and  planInterzoneEnd <='"+params.get("planInterzoneEnd")+"'  ");
			}
		}
		String hql = "from MonthlyMainInfo "+strb.toString()+" order by createTime desc";
		List<MonthlyMainInfo> data = monthlyMainInfoDao.find(hql, params);
		if(data!=null && data.size()>0){
			return data.get(0);
		}
		return null;
	}
}
