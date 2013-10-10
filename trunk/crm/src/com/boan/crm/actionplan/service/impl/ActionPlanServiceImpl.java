package com.boan.crm.actionplan.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.actionplan.dao.IActionPlanDao;
import com.boan.crm.actionplan.model.ActionPlan;
import com.boan.crm.actionplan.service.IActionPlanService;
import com.boan.crm.utils.page.Pagination;

@Service("actionPlanService")
public class ActionPlanServiceImpl implements IActionPlanService {
		@Autowired
		@Qualifier("actionPlanDao")
		private IActionPlanDao actionPlanDao;
		
		/**
		 * 保存或修改行动计划
		 * @param ActionPlan
		 */
		public void saveOrUpdateActionPlan(ActionPlan actionPlan){
			actionPlanDao.saveOrUpdate(actionPlan);
		}
		
		/**
		 * 保存或修改行动计划,用于跟进/回访信息的保存
		 * @param trackOrVisitId 跟进/回访Id
		 * @param planOrSummarizeInfo 要保存到行动计划中的计划或总结信息
		 * @param companyId 当前公司Id 
		 * @param employeeId 当前业务员Id 
		 * @param employeeName  当前业务员名称
		 * @param deptId 当前业务员部门Id
		 * @param deptName 当前业务员部门名称
		 * @param infoType 信息类型（3：跟进  4：回访）
		 * @param submitTime 提交时间
		 */
		public void saveOrUpdateActionPlan(String trackOrVisitId ,String planOrSummarizeInfo , String companyId ,String employeeId,String employeeName , String deptId, String deptName,String infoType ,Calendar submitTime){
			ActionPlan actionPlan = new ActionPlan();
			//根据跟进/回访Id查询行动计划，判断是否是第一次保存
			List<ActionPlan> actinoPlanList = actionPlanDao.findByProperty("trackOrVisitId", trackOrVisitId);
			//如果是第一次保存，，即行动计划中不存在跟进/回访信息，则添加行动计划，并将信息保存到行动计划的计划字段中
			if(actinoPlanList==null || actinoPlanList.size()==0){
				actionPlan.setOrganId(companyId);
				actionPlan.setPersonId(employeeId);
				actionPlan.setEmployeeId(employeeId);
				actionPlan.setEmployeeName(employeeName);
				actionPlan.setDeptId(deptId);
				actionPlan.setDeptName(deptName);
				actionPlan.setPlanType(infoType);
				actionPlan.setSubmitTime(submitTime);
				actionPlan.setPlanContent(planOrSummarizeInfo);//保存计划字段中
				actionPlan.setCreateTime(Calendar.getInstance());
				actionPlanDao.saveOrUpdate(actionPlan);
			}else{
				//如果是修改行动计划，即行动计划中已经存在跟进/回访信息，则将信息保存到总结字段中
				actionPlan = actinoPlanList.get(0);
				if(actionPlan!=null){
					//actionPlan.setPlanContent(null);
					actionPlan.setMemo(planOrSummarizeInfo);
					actionPlanDao.saveOrUpdate(actionPlan);//保存计划字段中
				}
			}
		}
		
		 /**
		  * 通过Id删除行动计划
		  * @param id
		  */
		public void deleteActionPlan(String... id){
			actionPlanDao.delete(id);
		}
		
		/**
		 * 通过id查询行动计划
		 * @param id
		 */
		public ActionPlan getActionPlanById(String id){
			return actionPlanDao.get(id);
		}
		
		/**
		 * 按分页查询行动计划
		 */
		public Pagination<ActionPlan> findActionPlanForPage( Map<String, ?> values, Pagination<ActionPlan> pagination){
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
			if(values.containsKey("beginTime") ){
				strb.append(" And  submitTime>=:beginTime ");
			}
			if(values.containsKey("endTime")){
				strb.append("  And submitTime<=:endTime");
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
			
			String hql = "from ActionPlan "+strb.toString()+" order by createTime desc";
			List<ActionPlan> data = actionPlanDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
			hql = "select count(*) from ActionPlan" +strb.toString()+" order by createTime desc";
			int totalRows = actionPlanDao.findCountForPage(hql, values);
			pagination.setTotalRows(totalRows);
			pagination.setData(data);
			return pagination;
		}
}
