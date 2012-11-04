/**
 * 
 */
package com.boan.crm.customerassessment.service;


import java.util.List;
import java.util.Map;

import com.boan.crm.customer.analysis.model.AnalysisCustomer;
import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.customerassessment.model.AutoAssessmentSetting;
import com.boan.crm.customerassessment.model.AutoCustomerAssessment;
import com.boan.crm.customerassessment.model.CustomerAssessment;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 *
 */
public interface IAutoCustomerAssessmentService {
	/**
	 * 根据单位Id查找
	 * @param companyId
	 * @return List<AutoAssessmentSetting>
	 */
	public List<AutoCustomerAssessment> findAutoCustomerAssessmentByCompanyId(String companyId);
	/**
	 * 根据单位Id查找
	 * @param companyId
	 * @return List<AutoAssessmentSetting>
	 */
	public Pagination<AutoCustomerAssessment> findAutoCustomerAssessmentByCompanyId(String companyId,Pagination<AutoCustomerAssessment> pagination);
	/**
	 * 保存
	 * @param autoAssessmentSetting
	 */
	public void save(AutoCustomerAssessment autoCustomerAssessment);
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String... ids);
	
}
