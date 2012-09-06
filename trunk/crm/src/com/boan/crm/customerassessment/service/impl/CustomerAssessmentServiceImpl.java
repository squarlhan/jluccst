/**
 * 
 */
package com.boan.crm.customerassessment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.boan.crm.customer.analysis.model.AnalysisCustomer;
import com.boan.crm.customer.analysis.service.AnalysisEngine;
import com.boan.crm.customerassessment.model.CustomerAssessment;
import com.boan.crm.customerassessment.service.ICustomerAssessmentService;

/**
 * @author luojx
 *
 */
@Service("customerAssessmentService")
public class CustomerAssessmentServiceImpl implements ICustomerAssessmentService{
	/**
	 * 根据客户Id评估结果
	 * @param customer
	 * @return　CustomerAssessment
	 */
	public CustomerAssessment customerAssessmentById(AnalysisCustomer customer)
	{
		CustomerAssessment assessment =  new CustomerAssessment();
		AnalysisEngine engine = new AnalysisEngine();
		engine.setEnter(customer);
		double value = engine.analysisResult();
		String result = engine.getResultByValue(value);
		
		assessment.setCustomerId(customer.getId());
		assessment.setCustomerName(customer.getCustomerName());
		assessment.setResultValue(value);
		assessment.setResult(result);
		
		return assessment;
	}
	
	/**
	 * 根据客户列表评估结果
	 * @param customer
	 * @return　CustomerAssessment
	 */
	public List<CustomerAssessment> customerAssessmentByCustomerList(List<AnalysisCustomer> customerList)
	{
		List<CustomerAssessment> listResult = new ArrayList<CustomerAssessment>();
		for(int i=0;i<customerList.size();i++)
		{
			CustomerAssessment assessment = new CustomerAssessment();
			AnalysisCustomer customer = customerList.get(i);
			AnalysisEngine engine = new AnalysisEngine();
			engine.setEnter(customer);
			double value = engine.analysisResult();
			String result = engine.getResultByValue(value);
			
			assessment.setCustomerId(customer.getId());
			assessment.setCustomerName(customer.getCustomerName());
			assessment.setResultValue(value);
			assessment.setResult(result);
			
			listResult.add(assessment);
		}
		return listResult;
	}

}