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
import com.boan.crm.customerassessment.model.AutoAssessmentSetting;
import com.boan.crm.customerassessment.model.CustomerAssessment;
import com.boan.crm.customerassessment.service.IAutoAssessmentSettingService;

/**
 * @author luojx
 *
 */
@Service("autoAssessmentSettingService")
public class AutoAssessmentSettingServiceImpl implements IAutoAssessmentSettingService{
	@Autowired
	@Qualifier("autoAssessmentSettingDao")
	private IAutoAssessmentSettingDAO autoAssessmentSettingDao;
	/**
	 * 根据客户id删除联系人
	 * @param ids
	 */
	@Override
	public AutoAssessmentSetting findAutoAssessmentSettingByCompanyId(String companyId)
	{	
		Map<String ,String > values = new HashMap<String ,String >();
		values.put("companyId", companyId);
		List<AutoAssessmentSetting> list = autoAssessmentSettingDao.find(" from AutoAssessmentSetting where companyId = :companyId ", values);
		if(list != null && list.size() > 0)
		{
			return list.get(0);
		}
		return null;
	}
	/**
	 * 保存设置
	 * @param autoAssessmentSetting
	 */
	public void save(AutoAssessmentSetting autoAssessmentSetting)
	{
		autoAssessmentSettingDao.save(autoAssessmentSetting);
	}
}
