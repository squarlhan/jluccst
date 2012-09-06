/**
 * 
 */
package com.boan.crm.customer.analysis.service;

import com.boan.crm.customer.analysis.model.AnalysisCustomer;

/**
 * @author luojx
 *
 */
public interface IAnalysisEngineService {
	
	public double analysisResult();
	/**
	 * 根据计算出的值，取结论
	 * @param value
	 * @return　String
	 */
	public String getResultByValue(double value);
	public void setEnter(AnalysisCustomer customer);
}
