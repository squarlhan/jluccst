/**
 * 
 */
package com.boan.crm.customerassessment.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customerassessment.dao.IAutoCustomerAssessmentDAO;
import com.boan.crm.customerassessment.model.AutoCustomerAssessment;
import com.boan.crm.customerassessment.service.IAutoCustomerAssessmentService;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 *
 */
@Service("autoCustomerAssessmentService")
public class AutoCustomerAssessmentServiceImpl implements IAutoCustomerAssessmentService{
	@Autowired
	@Qualifier("autoCustomerAssessmentDao")
	private IAutoCustomerAssessmentDAO autoCustomerAssessmentDao;
	/**
	 * 根据客户id删除联系人
	 * @param ids
	 */
	@Override
	public List<AutoCustomerAssessment> findAutoCustomerAssessmentByCompanyId(String companyId)
	{	
		Map<String,String> values = new HashMap<String,String>();
		values.put("companyId", companyId);
		return autoCustomerAssessmentDao.find(" from AutoCustomerAssessment where companyId = :companyId order by assessmentTime desc", values);
	}
	
	@Override
	public Pagination<AutoCustomerAssessment> findAutoCustomerAssessmentByCustomerId(Map<String,String> values,Pagination<AutoCustomerAssessment> pagination)
	{	
		StringBuilder hql = new StringBuilder();
		hql.append( "from AutoCustomerAssessment where 1=1");
		if(values.get("customerId") != null)
		{
			hql.append(" and customerId = :customerId ");
		}
		hql.append(" order by assessmentTime desc ");
		
		List<AutoCustomerAssessment> data = autoCustomerAssessmentDao.findForPage(hql.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		
		hql.delete(0, hql.length());
		hql.append(" from AutoCustomerAssessment where 1=1 " );
		if(values.get("customerId") != null)
		{
			hql.append(" and customerId = :customerId ");
		}
		
		List<Integer> list = autoCustomerAssessmentDao.find(hql.toString(), values);
		int totalRows = 0;
		if(list != null && list.size() > 0)
		{
			totalRows =list.size();
		}
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		
		return pagination;
	}
	@Override
	public Pagination<AutoCustomerAssessment> findAutoCustomerAssessmentByCompanyId(Map<String,String> values,Pagination<AutoCustomerAssessment> pagination)
	{	
		StringBuilder hql = new StringBuilder();
		hql.append( "from AutoCustomerAssessment where 1=1");
		hql.append(" and companyId = :companyId ");
		
		if(values.get("customerName") != null)
		{
			hql.append(" and customerName like :customerName ");
		}
		if(values.get("contractorName") != null)
		{
			hql.append(" and customerId in ( select customerId from ContractPersonInfo where personName like :contractorName) ");
		}
		if(values.get("userId") != null)
		{
			hql.append(" and customerId in ( select id from CustomerInfo where salesmanId =:userId or otherSalesmanId = :userId)");
		}
		if(values.get("deptId") != null)
		{
			hql.append(" and customerId in ( select id from CustomerInfo where salesmanId in (select id from User where deptId =:deptId )) ");
		}
		hql.append(" group by customerId  order by resultValue desc");
		List<AutoCustomerAssessment> data = autoCustomerAssessmentDao.findForPage(hql.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		if(data != null && data.size() > 0)
		{
			for (int i=0;i< data.size();i++)
			{
				AutoCustomerAssessment obj = data.get(i);
				hql.delete(0, hql.length());
				hql.append( "from AutoCustomerAssessment where customerId =:customerId order by resultValue desc ");
				Map<String,String> values1 = new HashMap<String,String>();
				values1.put("customerId", obj.getCustomerId());
				List<AutoCustomerAssessment> tempObjs = autoCustomerAssessmentDao.findForPage(hql.toString(), values1, pagination.getStartIndex(), pagination.getPageSize());
				if(tempObjs != null && tempObjs.size() > 0)
				{
					obj.setConsumptionTimes(tempObjs.get(0).getConsumptionTimes());
					obj.setDevelopDegree(tempObjs.get(0).getDevelopDegree());
					obj.setIntroduceCustomerTime(tempObjs.get(0).getIntroduceCustomerTime());
					obj.setPayments(tempObjs.get(0).getPayments());
					obj.setPaymentsTimes(tempObjs.get(0).getPaymentsTimes());
					obj.setResult(tempObjs.get(0).getResult());
					obj.setResultValue(tempObjs.get(0).getResultValue());
					obj.setTotalConsumption(tempObjs.get(0).getTotalConsumption());
				}
			}
		}
		hql.delete(0, hql.length());
		hql.append(" select count(*) from AutoCustomerAssessment where 1=1 " );
		hql.append(" and companyId = :companyId ");
		if(values.get("customerName") != null)
		{
			hql.append(" and customerName like :customerName ");
		}
		if(values.get("contractorName") != null)
		{
			hql.append(" and customerId in ( select customerId from ContractPersonInfo where personName like :contractorName) ");
		}
		if(values.get("userId") != null)
		{
			hql.append(" and customerId in ( select id from CustomerInfo where salesmanId =:userId or otherSalesmanId = :userId)");
		}
		if(values.get("deptId") != null)
		{
			hql.append(" and customerId in ( select id from CustomerInfo where salesmanId in (select id from User where deptId =:deptId )) ");
		}
		hql.append(" group by customerId");
		
		List<Integer> list = autoCustomerAssessmentDao.find(hql.toString(), values);
		int totalRows = 0;
		if(list != null && list.size() > 0)
		{
			totalRows =list.size();
		}
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		
		return pagination;
	}
	/**
	 * 保存设置
	 * @param autoAssessmentSetting
	 */
	@Override
	public void save(AutoCustomerAssessment autoCustomerAssessment)
	{
		autoCustomerAssessmentDao.save(autoCustomerAssessment);
	}
	@Override
	public void delete(String... ids)
	{	
		for(int i=0;i<ids.length;i++)
		{
			Map<String,String> idMap = new HashMap<String,String>();
			idMap.put("customerId", ids[i]);
			autoCustomerAssessmentDao.executeHql("delete from AutoCustomerAssessment where id = :customerId",idMap);
		}
	}
}
