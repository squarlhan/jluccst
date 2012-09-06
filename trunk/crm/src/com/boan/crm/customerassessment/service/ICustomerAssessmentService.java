/**
 * 
 */
package com.boan.crm.customerassessment.service;


import java.util.List;

import com.boan.crm.customer.analysis.model.AnalysisCustomer;
import com.boan.crm.customerassessment.model.CustomerAssessment;

/**
 * @author luojx
 *
 */
public interface ICustomerAssessmentService {
	/**
	 * 根据客户评估结果
	 * @param customer
	 * @return　CustomerAssessment
	 */
	public CustomerAssessment customerAssessmentById(AnalysisCustomer customer);
	
	/**
	 * 根据客户列表评估结果
	 * @param customer
	 * @return　CustomerAssessment
	 */
	public List<CustomerAssessment> customerAssessmentByCustomerList(List<AnalysisCustomer> customerList);
}
