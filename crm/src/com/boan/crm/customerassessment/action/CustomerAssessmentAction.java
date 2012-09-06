/**
 * 
 */
package com.boan.crm.customerassessment.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.analysis.model.AnalysisCustomer;
import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.customerassessment.model.CustomerAssessment;
import com.boan.crm.customerassessment.service.ICustomerAssessmentService;
import com.boan.crm.sellrecord.service.ISellRecordService;
import com.boan.crm.utils.action.BaseActionSupport;

/**
 * @author luojx
 *
 */
@Controller("customerAssessmentAction")
@Scope("prototype")
public class CustomerAssessmentAction extends BaseActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5321204850710250609L;
	// 客户状态接口类
	@Resource
	private ICustomerAssessmentService customerAssessmentService;
	// 客户状态接口类
	@Resource
	private ICustomerInfoService customerInfoService;
	@Resource
	private ISellRecordService sellRecordService;
	
	private String[] customerIds = null;
	private	List<CustomerAssessment> listResult = null;
	
	public List<CustomerAssessment> getListResult() {
		return listResult;
	}
	public void setListResult(List<CustomerAssessment> listResult) {
		this.listResult = listResult;
	}
	public String[] getCustomerIds() {
		return customerIds;
	}
	public void setCustomerIds(String[] customerIds) {
		this.customerIds = customerIds;
	}
	public String customerAnalysisList()
	{
		
		return SUCCESS;
	}
	public String customerAnalysis()
	{
		List<AnalysisCustomer> customerList = new ArrayList<AnalysisCustomer>();
		for(int i=0;i<customerIds.length;i++)
		{
			AnalysisCustomer analysisCustomer = new AnalysisCustomer();
			CustomerInfo customer = customerInfoService.get(customerIds[i]);
			analysisCustomer.setId(customer.getId());
			analysisCustomer.setCustomerName(customer.getCustomerName());
			
			analysisCustomer.setTotalConsumption(sellRecordService.getConsumptionMoney(customer.getId()));
			analysisCustomer.setConsumptionTimes(sellRecordService.getConsumptionCount(customer.getId()));
			if(customer.getLevelId() != null && customer.getLevelId().length() > 0)
			{
				analysisCustomer.setDevelopDegree(Double.parseDouble(customer.getLevelId()));
			}
			analysisCustomer.setIntroduceCustomerTime(customer.getIntroduceTimes());
			
			customerList.add(analysisCustomer);
		}
		
		List<CustomerAssessment> listResult = customerAssessmentService.customerAssessmentByCustomerList(customerList);
		
		
		return SUCCESS;
	}
	
}
