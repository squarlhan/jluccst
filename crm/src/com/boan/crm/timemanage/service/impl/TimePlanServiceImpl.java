package com.boan.crm.timemanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.timemanage.dao.ITimePlanAndTrackOrVisitRelationDao;
import com.boan.crm.timemanage.dao.ITimePlanDao;
import com.boan.crm.timemanage.model.TimePlan;
import com.boan.crm.timemanage.model.TimePlanAndTrackOrVisitRelation;
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
	
	@Autowired
	@Qualifier("timePlanAndTrackOrVisitRelationDao")
	private ITimePlanAndTrackOrVisitRelationDao timePlanAndTrackOrVisitRelationDao;
	
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
	
	/**
	 * 获取最近的时间计划
	 * @param id
	 */
	public TimePlan getLastTimePlan(Map<String, ?> params){
		StringBuffer strb = new StringBuffer( " where 1=1 ");
		
		if(params.containsKey("personId")){
			if(params.get("personId")!=null ){
				strb.append(" And  personId=:personId");
			}
		}
		if(params.containsKey("organId")){
			if(params.get("organId")!=null ){
				strb.append(" And organId=:organId");
			}
		}
		if(params.containsKey("planType")){
			if(params.get("planType")!=null ){
				strb.append(" And planType=:planType");
			}
		}
		String hql = "from TimePlan "+strb.toString()+" order by createTime desc,submitTime desc";
		List<TimePlan> data = timePlanDao.find(hql, params);
		if(data!=null && data.size()>0){
			return data.get(0);
		}
		return null;
	}
	
	/**
	 * 按条件查询时间计划
	 */
	public List<TimePlan> findTimePlan( Map<String, ?> values){
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
		List<TimePlan> data = timePlanDao.find(hql, values);
		hql = "select count(*) from TimePlan" +strb.toString();
		return data;
	}
	
	/**
	 * 判断根据计划的内容类型，将信息添加到对应属性中保存，flag：0,info保存到明日计划中， flag：1 info保存到今日总结中
	 * @param timePlan 时间计划对象
	 * @param flag 0:明日计划  1：今日总结
	 * @param info 存入的具体信息，要存入时间计划对象的那个planContent属性还是memo属性中以flag为准
	 * @param trackOrVisitId 跟踪或回访Id
	 */
	public void saveOrUpdateTimePlan(TimePlan timePlan , int flag ,String info,String trackOrVisitId){
		if(flag==0){
			timePlan.setPlanContent(info);
		}
		if(flag==1){
			timePlan.setMemo(info);
		}
		timePlanDao.saveOrUpdate(timePlan );
		TimePlanAndTrackOrVisitRelation relation = new TimePlanAndTrackOrVisitRelation();
		timePlanAndTrackOrVisitRelationDao.save(relation);
	}
	
	/**
	 * 根据跟踪或回访Id查询是否有对应的时间计划信息
	 * @param trackOrVisitId
	 * @return
	 */
	public boolean hasTimePlanForTrackOrVisit(String trackOrVisitId){
		String hql = "from TimePlanAndTrackOrVisitRelation where  trackOrVisitId=:trackOrVisitId";
		Map param = new HashMap();
		param.put("trackOrVisitId", trackOrVisitId);
		List list = timePlanAndTrackOrVisitRelationDao.find(hql,param );
		if(list!=null && list.size()>0){
			return true;
		}else{
			return false;
		}
	}
}
