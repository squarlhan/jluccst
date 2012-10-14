package com.boan.crm.timemanage.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.timemanage.dao.ITimePlanDao;
import com.boan.crm.timemanage.model.TimePlan;
import com.boan.crm.timemanage.service.ITimePlanService;
import com.boan.crm.utils.page.Pagination;
/**
 * 时间管理数据库服务接口实现
 * @author YF
 *
 */
@Service("timePlanService")
public class TimePlanServiceImpl implements ITimePlanService {
	@Autowired
	@Qualifier("timePlanDao")
	private ITimePlanDao timePlanDao;
	
	/**
	 * 保存或修改时间计划
	 * @param timePlan
	 */
	public void saveOrUpdateTimePlan(TimePlan timePlan){
		timePlanDao.saveOrUpdate(timePlan);
	}
	
	 /**
	  * 通过Id删除时间计划
	  * @param id
	  */
	public void deleteTimePlan(String... id){
		timePlanDao.delete(id);
	}
	
	/**
	 * 通过id查询时间计划
	 * @param id
	 */
	public TimePlan getTimePlanById(String id){
		return timePlanDao.get(id);
	}
	
	/**
	 * 按分页查询时间计划
	 */
	public Pagination<TimePlan> findTimePlanForPage( Map<String, ?> values, Pagination<TimePlan> pagination){
		StringBuffer strb = new StringBuffer( " where 1=1 ");
		
		if(values.containsKey("personId")){
			if(values.get("personId")!=null ){
				strb.append(" And  personId=:personId");
			}
		}
		if(values.containsKey("organId")){
			if(values.get("organId")!=null ){
				strb.append(" And organId=:organId");
			}
		}
		
		if(values.containsKey("employeeName")){
			if(values.get("employeeName")!=null ){
				strb.append(" And employeeName like '%"+values.get("employeeName")+"%'");
			}
		}
		if(values.containsKey("planType")){
			if(values.get("planType")!=null && !values.get("planType").equals("-1")){
				strb.append(" And  planType=:planType");
			}
		}
		if(values.containsKey("beginTime") && values.containsKey("endTime")){
			strb.append(" And  submitTime>=:beginTime And submitTime<=:endTime");
		}

		if(values.containsKey("deptId")){
			if(values.get("deptId")!=null ){
				strb.append(" And  deptId=:deptId");
			}
		}
		if(values.containsKey("employeeId")){
			if(values.get("employeeId")!=null ){
				strb.append(" And  employeeId=:employeeId");
			}
		}
		
		String hql = "from TimePlan "+strb.toString()+" order by createTime desc";
		List<TimePlan> data = timePlanDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from TimePlan" +strb.toString();
		int totalRows = timePlanDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
}
