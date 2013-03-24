package com.boan.crm.sellreport.weekly.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.sellreport.weekly.dao.IWeeklyItemInfoDao;
import com.boan.crm.sellreport.weekly.dao.IWeeklyMainInfoDao;
import com.boan.crm.sellreport.weekly.model.WeeklyMainInfo;
import com.boan.crm.sellreport.weekly.service.IWeeklyMainInfoService;
import com.boan.crm.utils.page.Pagination;

@Service("weeklyMainInfoService")
public class WeeklyMainInfoServiceImpl implements IWeeklyMainInfoService{

	@Autowired
	@Qualifier("weeklyMainInfoDao")
	private IWeeklyMainInfoDao weeklyMainInfoDao;
	
	@Autowired
	@Qualifier("weeklyItemInfoDao")
	private IWeeklyItemInfoDao weeklyItemInfoDao;
	
	/**
	 * 保存或修改周计划信息
	 * @param obj
	 */
	public void saveOrUpdateWeeklyMainInfo(WeeklyMainInfo obj){
		weeklyMainInfoDao.saveOrUpdate(obj);
	}
	
	/**
	 * 根据周计划Id查询周计划信息
	 * @param id
	 * @return
	 */
	public WeeklyMainInfo getWeeklyMainInfoById(String id){
		return weeklyMainInfoDao.get(id);
	}
	
	/**
	 * 根据计划人Id查询周计划信息
	 * @param personId
	 * @return
	 */
	public List<WeeklyMainInfo>  getWeeklyMainInfoListByPersonId(String personId){
		return weeklyMainInfoDao.findByProperty("personId", personId);
	}
	
	/**
	 * 按分页查询周计划信息
	 */
	public Pagination<WeeklyMainInfo> findWeeklyMainInfoForPage( Map<String, ?> values, Pagination<WeeklyMainInfo> pagination){
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
		String hql = "from WeeklyMainInfo "+strb.toString()+" order by createTime desc";
		List<WeeklyMainInfo> data = weeklyItemInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from WeeklyMainInfo" +strb.toString();
		int totalRows = weeklyItemInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	 /**
	  * 通过Id删除周计划信息
	  * @param id
	  */
	public void deleteWeeklyMainInfoByIds(String... ids){
		weeklyMainInfoDao.delete(ids);
	}
	
	 /**
	  * 获取最近周计划信息
	  * @param id
	  */
	public WeeklyMainInfo getLastWeeklyMainInfo( Map<String, ?> params){
		StringBuffer strb = new StringBuffer( " where 1=1 ");
		if(params!=null){
			if(params.containsKey("personId")){
				strb.append(" and  personId=:personId  ");
			}
		}
		String hql = "from WeeklyMainInfo "+strb.toString()+" order by createTime desc";
		List<WeeklyMainInfo> data = weeklyItemInfoDao.find(hql, params);
		if(data!=null && data.size()>0){
			return data.get(0);
		}
		return null;
	}
}
