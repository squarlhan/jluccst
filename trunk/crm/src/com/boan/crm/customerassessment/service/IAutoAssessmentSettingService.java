/**
 * 
 */
package com.boan.crm.customerassessment.service;


import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.boan.crm.customer.analysis.model.AnalysisCustomer;
import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.customerassessment.model.AutoAssessmentSetting;
import com.boan.crm.customerassessment.model.CustomerAssessment;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 *
 */
public interface IAutoAssessmentSettingService {
	/**
	 * 根据单位Id查找设置
	 * @param companyId
	 * @return List<AutoAssessmentSetting>
	 */
	public AutoAssessmentSetting findAutoAssessmentSettingByCompanyId(String companyId);
	
	/**
	 * 自动评估
	 * @param companyId
	 * @param t
	 */
	public void saveAutoAssessment(String companyId,Calendar t);
	/**
	 * 保存设置
	 * @param autoAssessmentSetting
	 */
	public void save(AutoAssessmentSetting autoAssessmentSetting);
	

}
