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
import com.boan.crm.utils.calendar.CurrentDateTime;

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
	
	private String customerIds = null;
	private	List<CustomerAssessment> listResult = null;
	private String totalComsumption = "";
	private String consumptionTimes = "";
	private String introduceTimes = "";
	private String payments = "";
	private String level = "";
	public List<CustomerAssessment> getListResult() {
		return listResult;
	}
	public void setListResult(List<CustomerAssessment> listResult) {
		this.listResult = listResult;
	}
	public String getCustomerIds() {
		return customerIds;
	}
	public void setCustomerIds(String customerIds) {
		this.customerIds = customerIds;
	}
	public String customerAnalysisList()
	{
		
		return SUCCESS;
	}
	public String customerAnalysis()
	{
		List<AnalysisCustomer> customerList = new ArrayList<AnalysisCustomer>();
		String[] customerArray = customerIds.split(",");
		for(int i=0;i<customerArray.length;i++)
		{
			AnalysisCustomer analysisCustomer = new AnalysisCustomer();
			CustomerInfo customer = customerInfoService.get(customerArray[i]);
			analysisCustomer.setId(customer.getId());
			analysisCustomer.setCustomerName(customer.getCustomerName());
			if(totalComsumption.equals("1"))
			{
				analysisCustomer.setTotalConsumption(sellRecordService.getConsumptionMoney(customer.getId()));
			}
			if(consumptionTimes.equals("1"))
			{
				analysisCustomer.setConsumptionTimes(sellRecordService.getConsumptionCount(customer.getId()));
			}
			if(payments.equals("1"))
			{
				Calendar t1 = Calendar.getInstance();
				Calendar t2 = Calendar.getInstance();
				
				String t22 = CurrentDateTime.getCurrentDate();
				String t11 = t22.split("-")[0]+"-1-1";
				analysisCustomer.setPayments(sellRecordService.getConsumptionDebt(customer.getId(),t11,t22));
			}
			if(level.equals("1"))
			{
				if(customer.getLevelId() != null && customer.getLevelId().length() > 0)
				{
					analysisCustomer.setDevelopDegree(Double.parseDouble(customer.getLevelId()));
				}
			}
			if(introduceTimes.equals("1"))
			{
				analysisCustomer.setIntroduceCustomerTime(customer.getIntroduceTimes());
			}
			
			analysisCustomer.setCompanyId(sessionCompanyId);
			
			customerList.add(analysisCustomer);
		}
		
		listResult = customerAssessmentService.customerAssessmentByCustomerList(customerList);
		
		
		return SUCCESS;
	}
	public String getTotalComsumption() {
		return totalComsumption;
	}
	public void setTotalComsumption(String totalComsumption) {
		this.totalComsumption = totalComsumption;
	}
	public String getConsumptionTimes() {
		return consumptionTimes;
	}
	public void setConsumptionTimes(String consumptionTimes) {
		this.consumptionTimes = consumptionTimes;
	}
	public String getIntroduceTimes() {
		return introduceTimes;
	}
	public void setIntroduceTimes(String introduceTimes) {
		this.introduceTimes = introduceTimes;
	}
	public String getPayments() {
		return payments;
	}
	public void setPayments(String payments) {
		this.payments = payments;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
}
