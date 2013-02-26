/**
 * 
 */
package com.boan.crm.customerassessment.action;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.analysis.model.AnalysisCustomer;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.customerassessment.model.AutoAssessmentSetting;
import com.boan.crm.customerassessment.model.AutoCustomerAssessment;
import com.boan.crm.customerassessment.model.CustomerAssessment;
import com.boan.crm.customerassessment.service.IAutoAssessmentSettingService;
import com.boan.crm.customerassessment.service.IAutoCustomerAssessmentService;
import com.boan.crm.customerassessment.service.ICustomerAssessmentService;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.groupmanage.common.RoleFlag;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IPopedomService;
import com.boan.crm.sellrecord.service.ISellRecordService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.calendar.CalendarUtils;
import com.boan.crm.utils.calendar.CurrentDateTime;
import com.boan.crm.utils.page.Pagination;

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
	@Resource
	private IAutoAssessmentSettingService autoAssessmentSettingService;
	@Resource
	private IAutoCustomerAssessmentService autoCustomerAssessmentService;
	@Autowired
	@Qualifier("dataDictionaryService")
	private IDataDictionaryService dataDictionaryService = null;
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	
	
	private String customerIds = null;
	private	List<CustomerAssessment> listResult = null;
	private String totalComsumption = "";
	private String consumptionTimes = "";
	private String introduceTimes = "";
	private String payments = "";
	private String level = "";
	private String beginTime = "";
	private String optionFlag = "";
	private String customerId ="";
	private String customerName = "";
	private String option = "";
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	private List<DataDictionary> listCategory = null;
	private List<AutoCustomerAssessment> listCustomerAssessment = null;
	
	public List<DataDictionary> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<DataDictionary> listCategory) {
		this.listCategory = listCategory;
	}
	public String getContractorName() {
		return contractorName;
	}
	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	public String getCustomerCategory() {
		return customerCategory;
	}
	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}
	public String getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(String salesmanId) {
		this.salesmanId = salesmanId;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	private String chkAllCustomer = "";
	private String contractorName = "";
	private String customerCategory = "";
	private String salesmanId = "";
	private List<User> userList = null;
	
	private String[] ids = null;
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public String getChkAllCustomer() {
		return chkAllCustomer;
	}
	public void setChkAllCustomer(String chkAllCustomer) {
		this.chkAllCustomer = chkAllCustomer;
	}
	public String getOptionFlag() {
		return optionFlag;
	}
	public void setOptionFlag(String optionFlag) {
		this.optionFlag = optionFlag;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	private List<AutoCustomerAssessment> listAutoCustomer;
	public List<AutoCustomerAssessment> getListAutoCustomer() {
		return listAutoCustomer;
	}
	public void setListAutoCustomer(List<AutoCustomerAssessment> listAutoCustomer) {
		this.listAutoCustomer = listAutoCustomer;
	}
	public String customerAnalysisList()
	{
		return SUCCESS;
	}
	private Pagination<AutoCustomerAssessment> pagination = new Pagination<AutoCustomerAssessment>();
	
	public String customerAnalysisSetting()
	{
		String companyId = sessionCompanyId;
		autoAssessmentSetting = autoAssessmentSettingService.findAutoAssessmentSettingByCompanyId(companyId);
		if(autoAssessmentSetting != null)
		{
			String item = autoAssessmentSetting.getItem();
			String[] itemArray = item.split("_");
			if(itemArray[0].equals("1"))
			{
				totalComsumption = "1";
			}
			if(itemArray[1].equals("1"))
			{
				consumptionTimes = "1";
			}
			if(itemArray[2].equals("1"))
			{
				payments = "1";
			}
			if(itemArray[3].equals("1"))
			{
				level = "1";
			}
			if(itemArray[4].equals("1"))
			{
				introduceTimes = "1";
			}
			if(autoAssessmentSetting.getAllCustomerFlag() == 1)
			{
				chkAllCustomer = "1";
			}
			beginTime = CalendarUtils.toLongStringNoSecond(autoAssessmentSetting.getBeginTime());
		}else
		{
			autoAssessmentSetting = new AutoAssessmentSetting();
			Calendar time = Calendar.getInstance();
			time.add(Calendar.HOUR, 1);
			beginTime = CalendarUtils.toLongStringNoSecond(time);
			autoAssessmentSetting.setOptions(1);
		}
		
		return SUCCESS;
	}
	
	public Pagination<AutoCustomerAssessment> getPagination() {
		return pagination;
	}
	public void setPagination(Pagination<AutoCustomerAssessment> pagination) {
		this.pagination = pagination;
	}
	public String customerAnalysisSettingSave()
	{
		String item = "";
		if(totalComsumption.equals("1"))
		{
			item = "1_";
		}else
		{
			item = "0_";
		}
		if(consumptionTimes.equals("1"))
		{
			item = item + "1_";
		}else
		{
			item = item + "0_";
		}
		if(payments.equals("1"))
		{
			item = item + "1_";
		}else
		{
			item = item + "0_";
		}
		if(level.equals("1"))
		{
			item = item + "1_";
		}else
		{
			item = item + "0_";
		}
		if(introduceTimes.equals("1"))
		{
			item = item + "1";
		}else
		{
			item = item + "0";
		}
		autoAssessmentSetting.setItem(item);
		
		Calendar time = Calendar.getInstance();
		if(beginTime.indexOf(" ") != -1)
		{
			String[] timeArray = beginTime.split(" ")[1].split(":");
			String[] dayArray = beginTime.split(" ")[0].split("-");
			if(dayArray.length>0 && timeArray.length>0){
				time.set(Calendar.YEAR, Integer.parseInt(dayArray[0]));
				time.set(Calendar.MONTH, Integer.parseInt(dayArray[1]) - 1);
				time.set(Calendar.DATE, Integer.parseInt(dayArray[2]));
				time.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
				time.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
				time.set(Calendar.SECOND, 0);
			}
		}else
		{
			String[] dayArray1 = beginTime.split("-");
			time.set(Calendar.YEAR, Integer.parseInt(dayArray1[0]));
			time.set(Calendar.MONTH, Integer.parseInt(dayArray1[1]) - 1);
			time.set(Calendar.DATE, Integer.parseInt(dayArray1[2]));
			time.set(Calendar.HOUR_OF_DAY, 0);
			time.set(Calendar.MINUTE, 0);
			time.set(Calendar.SECOND, 0);
		}
		autoAssessmentSetting.setBeginTime(time);
		autoAssessmentSetting.setCompanyId(sessionCompanyId);
		if(chkAllCustomer.equals("1"))
		{
			autoAssessmentSetting.setAllCustomerFlag(1);
		}
		AutoAssessmentSetting temp = autoAssessmentSettingService.findAutoAssessmentSettingByCompanyId(sessionCompanyId);
		if(temp != null)
		{
			temp.setBeginTime(time);
			temp.setItem(autoAssessmentSetting.getItem());
			temp.setOptions(autoAssessmentSetting.getOptions());
			autoAssessmentSettingService.save(temp);
		}else
		{
			autoAssessmentSettingService.save(autoAssessmentSetting);
		}
		
		if(chkAllCustomer.equals("1"))
		{
			List<CustomerInfo> list = customerInfoService.findAllCustomerInfoByCompanyId(sessionCompanyId);
			if(list != null && list.size() > 0)
			{
				for(int i=0;i<list.size();i++)
				{
					AutoCustomerAssessment autoCustomerAssessment = new AutoCustomerAssessment();
					autoCustomerAssessment.setCompanyId(sessionCompanyId);
					autoCustomerAssessment.setCustomerId(list.get(i).getId());
					autoCustomerAssessment.setCustomerName(list.get(i).getCustomerName());
					autoCustomerAssessmentService.save(autoCustomerAssessment);
				}
			}
		}
		
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
					NumberFormat f = NumberFormat.getPercentInstance();
					double level = 0;
					try
					{
						level = f.parse(customer.getLevelId()).doubleValue(); 
					}catch(Exception ex)
					{
						
					}
					analysisCustomer.setDevelopDegree(level);
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
	public String autoAnalysisCustomerSave()
	{
		if(optionFlag.equals("all"))
		{
			List<CustomerInfo> list = customerInfoService.findAllCustomerInfoByCompanyId(sessionCompanyId);
			if(list != null && list.size() > 0)
			{
				for(int i=0;i<list.size();i++)
				{
					AutoCustomerAssessment autoCustomerAssessment = new AutoCustomerAssessment();
					autoCustomerAssessment.setCompanyId(sessionCompanyId);
					autoCustomerAssessment.setCustomerId(list.get(i).getId());
					autoCustomerAssessment.setCustomerName(list.get(i).getCustomerName());
					autoCustomerAssessmentService.save(autoCustomerAssessment);
				}
			}
		}else
		{
			AutoCustomerAssessment autoCustomerAssessment = new AutoCustomerAssessment();
			autoCustomerAssessment.setCompanyId(sessionCompanyId);
			autoCustomerAssessment.setCustomerId(customerId);
			autoCustomerAssessment.setCustomerName(customerName);
			autoCustomerAssessmentService.save(autoCustomerAssessment);
		}
		
		return SUCCESS;
	}
	
	public String staticAnalysisCustomer()
	{
		autoAssessmentSetting= autoAssessmentSettingService.findAutoAssessmentSettingByCompanyId(sessionCompanyId);
		return SUCCESS;
	}
	
	public String autoAnalysisCustomerList()
	{
		//客户分类： 传0
		listCategory = dataDictionaryService.findDataDictionaryByType(sessionCompanyId, 0);
		Map<String,String> values = new HashMap<String,String>();
		
		if(customerName != null && customerName.length() > 0)
		{
			values.put("customerName", "%"+customerName+"%");
		}
		if(contractorName != null && contractorName.length() > 0)
		{
			values.put("contractorName", "%"+contractorName+"%");
		}
		
		values.put("companyId", sessionCompanyId);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		
		try
		{
			if(popedomService.isHasPopedomByRoleKey( userSession , RoleFlag.YE_WU_YUAN ))
			{
				values.put("userId", sessionUserId);
			}else if(popedomService.isHasPopedomByRoleKey( userSession , RoleFlag.BU_MEN_LING_DAO ))
			{
				values.put("deptId", sessionDeptId);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return ERROR;
		}
		
		pagination = autoCustomerAssessmentService.findAutoCustomerAssessmentByCompanyId(values, pagination);
		
		return SUCCESS;
	}
	
	public String getCustomerAssessmentXMLByDay()
	{
		Map<String,String> values = new HashMap<String,String>();
		values.put("customerId", customerId);
		pagination = autoCustomerAssessmentService.findAutoCustomerAssessmentByCustomerId(values, pagination);
		listCustomerAssessment = pagination.getData();
		return SUCCESS;
	}
	
	public String getCustomerAssessmentXMLByWeek()
	{
		Map<String,String> values = new HashMap<String,String>();
		values.put("customerId", customerId);
		
		pagination = autoCustomerAssessmentService.findAutoCustomerAssessmentByCustomerId(values, pagination);
		listCustomerAssessment = pagination.getData();
		return SUCCESS;
	}
	
	public String getCustomerAssessmentXMLByMonth()
	{
		Map<String,String> values = new HashMap<String,String>();
		values.put("customerId", customerId);
		
		pagination = autoCustomerAssessmentService.findAutoCustomerAssessmentByCustomerId(values, pagination);
		listCustomerAssessment = pagination.getData();
		return SUCCESS;
	}
	
	public String deleteAnalysisCustomer()
	{
		autoCustomerAssessmentService.delete(ids);
		return SUCCESS;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	private AutoAssessmentSetting autoAssessmentSetting ;
	public AutoAssessmentSetting getAutoAssessmentSetting() {
		return autoAssessmentSetting;
	}
	public void setAutoAssessmentSetting(AutoAssessmentSetting autoAssessmentSetting) {
		this.autoAssessmentSetting = autoAssessmentSetting;
	}
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
