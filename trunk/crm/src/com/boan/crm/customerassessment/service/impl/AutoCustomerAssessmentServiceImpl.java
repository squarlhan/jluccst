/**
 * 
 */
package com.boan.crm.customerassessment.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customer.analysis.model.AnalysisCustomer;
import com.boan.crm.customer.analysis.service.IAnalysisEngineService;
import com.boan.crm.customer.dao.IContractPersonDAO;
import com.boan.crm.customerassessment.dao.IAutoAssessmentSettingDAO;
import com.boan.crm.customerassessment.dao.IAutoCustomerAssessmentDAO;
import com.boan.crm.customerassessment.model.AutoAssessmentSetting;
import com.boan.crm.customerassessment.model.AutoCustomerAssessment;
import com.boan.crm.customerassessment.model.CustomerAssessment;
import com.boan.crm.customerassessment.service.IAutoAssessmentSettingService;
import com.boan.crm.customerassessment.service.IAutoCustomerAssessmentService;

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
		return autoCustomerAssessmentDao.find(" from AutoAssessmentSetting where companyId = :companyId ", companyId);
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
			autoCustomerAssessmentDao.executeHql("delete from AutoCustomerAssessment where customerId = :customerId",idMap);
		}
	}
}
