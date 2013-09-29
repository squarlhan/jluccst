package com.boan.crm.actionplan.service.impl;

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
