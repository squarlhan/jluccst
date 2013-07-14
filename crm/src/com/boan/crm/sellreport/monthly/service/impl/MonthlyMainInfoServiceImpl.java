package com.boan.crm.sellreport.monthly.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.sellreport.monthly.dao.IMonthlyItemInfoDao;
import com.boan.crm.sellreport.monthly.dao.IMonthlyMainInfoDao;
import com.boan.crm.sellreport.monthly.model.MonthlyMainInfo;
import com.boan.crm.sellreport.monthly.service.IMonthlyMainInfoService;
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
	 * 查询指定年、月的最后填写的月计划信息
	 * @param companyId 所属单位
	 * @param deptId 所属部门
	 * @param personId 计划填写人
	 * @param year 年份
	 * @param month 月份
	 * @param roleKey 角色关键字
	 * @return
	 */
	public MonthlyMainInfo getMonthlyMainInfoByMonth(String companyId, String deptId,String personId ,  int year , int month , String roleKey){
		String beginDate;
		String endDate;
		Calendar monthBegin = Calendar.getInstance();
		Calendar monthkEnd = Calendar.getInstance();
		
		monthBegin.set(Calendar.YEAR, year);
		monthBegin.set(Calendar.MONTH, month-1);
		monthBegin.set(Calendar.DAY_OF_MONTH, monthBegin.getMinimum(Calendar.DATE));
		beginDate = new SimpleDateFormat("yyyy-MM-dd").format(monthBegin.getTime());
		
		
		monthkEnd.set(Calendar.YEAR, year);
		monthkEnd.set(Calendar.MONTH, month-1);
		monthkEnd.set(Calendar.DAY_OF_MONTH, 1);
		int value = monthkEnd.getActualMaximum(Calendar.DAY_OF_MONTH);
		monthkEnd.set(Calendar.DAY_OF_MONTH, value);
		endDate= new SimpleDateFormat("yyyy-MM-dd").format(monthkEnd.getTime());
		String str="";
		String hql = " from MonthlyMainInfo A ,  User B , Role C where 1=1 and A.personId=B.id And B.roleId = C.id ";
		Map param = new HashMap();
		if(roleKey!=null && !roleKey.equals("")){
			param.put("roleKey", roleKey);
			str = str + " and C.roleKey=:roleKey " ;
		}
		if(companyId!=null && !companyId.equals("")){
			param.put("companyId", companyId);
			str = str + " and A.companyId=:companyId " ;
		}
		if(deptId!=null && !deptId.equals("")){
			param.put("deptId", deptId);
			str = str + " and A.deptId=:deptId " ;
		}
		if(personId!=null && !personId.equals("")){
			param.put("personId", personId);
			str = str + " and A.personId=:personId " ;
		}
		hql =  hql +str+" and  A.planInterzoneBegin >='"+beginDate+"'  and A.planInterzoneBegin <='"+endDate+"'  order by A.createTime desc";
		List data = monthlyMainInfoDao.find(hql, param);
		if((data!=null &&  data.size()>0 )){
			return  (MonthlyMainInfo)((Object[])data.get(0))[0];
		}
		return null;
	}
	
	/**
	 * 查询指定年、月的最后填写的月计划信息
	 * @param companyId 所属单位
	 * @param deptId 所属部门
	 * @param personId 计划填写人
	 * @param year 年份
	 * @param month 月份
	 * @param roleKey 角色关键字
	 * @return
	 */
	public MonthlyMainInfo getMonthlyMainInfoByMonth(String companyId, String deptId,String personId ,  Calendar startTime, Calendar endTime , String roleKey){
		String beginDate;
		String endDate;
		Calendar monthBegin = startTime;
		Calendar monthkEnd = endTime;

		beginDate = new SimpleDateFormat("yyyy-MM-dd").format(monthBegin.getTime());
		endDate= new SimpleDateFormat("yyyy-MM-dd").format(monthkEnd.getTime());
		String str="";
		String hql = " from MonthlyMainInfo A ,  User B , Role C where 1=1 and A.personId=B.id And B.roleId = C.id ";
		Map param = new HashMap();
		if(roleKey!=null && !roleKey.equals("")){
			param.put("roleKey", roleKey);
			str = str + " and C.roleKey=:roleKey " ;
		}
		if(companyId!=null && !companyId.equals("")){
			param.put("companyId", companyId);
			str = str + " and A.companyId=:companyId " ;
		}
		if(deptId!=null && !deptId.equals("")){
			param.put("deptId", deptId);
			str = str + " and A.deptId=:deptId " ;
		}
		if(personId!=null && !personId.equals("")){
			param.put("personId", personId);
			str = str + " and A.personId=:personId " ;
		}
		hql =  hql +str+" and  A.planInterzoneBegin >='"+beginDate+"'  and A.planInterzoneBegin <='"+endDate+"'  order by A.createTime desc";
		List data = monthlyMainInfoDao.find(hql, param);
		if((data!=null &&  data.size()>0 )){
			return  (MonthlyMainInfo)((Object[])data.get(0))[0];
		}
		return null;
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
