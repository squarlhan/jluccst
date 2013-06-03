/**
 * 
 */
package com.boan.crm.customerassessment.service.impl;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customer.analysis.model.AnalysisCustomer;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.customerassessment.dao.IAutoAssessmentSettingDAO;
import com.boan.crm.customerassessment.model.AutoAssessmentSetting;
import com.boan.crm.customerassessment.model.AutoCustomerAssessment;
import com.boan.crm.customerassessment.model.CustomerAssessment;
import com.boan.crm.customerassessment.service.IAutoAssessmentSettingService;
import com.boan.crm.customerassessment.service.IAutoCustomerAssessmentService;
import com.boan.crm.customerassessment.service.ICustomerAssessmentService;
import com.boan.crm.sellrecord.service.ISellRecordService;
import com.boan.crm.utils.calendar.CurrentDateTime;

/**
 * @author luojx
 *
 */
@Service("autoAssessmentSettingService")
public class AutoAssessmentSettingServiceImpl implements IAutoAssessmentSettingService{
	@Autowired
	@Qualifier("autoAssessmentSettingDao")
	private IAutoAssessmentSettingDAO autoAssessmentSettingDao;
	
	@Resource
	private ICustomerInfoService customerInfoService;
	@Resource
	private ISellRecordService sellRecordService;
	@Autowired
	@Qualifier("customerAssessmentService")
	private ICustomerAssessmentService customerAssessmentService;
	@Autowired
	@Qualifier("autoCustomerAssessmentService")
	private IAutoCustomerAssessmentService autoCustomerAssessmentService;
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
	 * 自动评估
	 * @param companyId
	 * @param t
	 */
	public void saveAutoAssessment(String companyId,Calendar t)
	{
		AutoAssessmentSetting setting = findAutoAssessmentSettingByCompanyId(companyId);
		if(setting != null)
		{
			Calendar beginTime = setting.getBeginTime();
			if(t.after(beginTime))
			{
				if(setting.getOptions() == 1)
				{
					//每天
					Calendar t2 = Calendar.getInstance();
					
					t2.set(Calendar.HOUR_OF_DAY, beginTime.get(Calendar.HOUR_OF_DAY));
					t2.set(Calendar.MINUTE, beginTime.get(Calendar.MINUTE));
					
					if(t.get(Calendar.YEAR) == t2.get(Calendar.YEAR) && t.get(Calendar.MONTH) == t2.get(Calendar.MONTH) && t.get(Calendar.DATE) == t2.get(Calendar.DATE) && t.get(Calendar.HOUR_OF_DAY) == t2.get(Calendar.HOUR_OF_DAY)&& t.get(Calendar.MINUTE) == t2.get(Calendar.MINUTE))
					{
						System.out.println("=====按每天执行自动评估！");
						saveAutoAssessmentByCompany( setting ,companyId);
					}
				}else if(setting.getOptions() == 2)
				{
					//每周
					int weekNum = beginTime.get(Calendar.DAY_OF_WEEK);
					
					if(t.get(Calendar.DAY_OF_WEEK) == weekNum)
					{
						Calendar t2 = Calendar.getInstance();
						t2.set(Calendar.HOUR_OF_DAY, beginTime.get(Calendar.HOUR_OF_DAY));
						t2.set(Calendar.MINUTE, beginTime.get(Calendar.MINUTE));
						
						if(t.get(Calendar.YEAR) == t2.get(Calendar.YEAR) && t.get(Calendar.MONTH) == t2.get(Calendar.MONTH) && t.get(Calendar.DATE) == t2.get(Calendar.DATE) && t.get(Calendar.HOUR_OF_DAY) == t2.get(Calendar.HOUR_OF_DAY)&& t.get(Calendar.MINUTE) == t2.get(Calendar.MINUTE))
						{
							System.out.println("=====按周执行自动评估！");
							saveAutoAssessmentByCompany( setting ,companyId);
						}
					}
					
				}else if(setting.getOptions() == 3)
				{
					//每月
					int dayNum = beginTime.get(Calendar.DAY_OF_MONTH);
					
					if(t.get(Calendar.DAY_OF_MONTH) == dayNum)
					{
						Calendar t2 = Calendar.getInstance();
						t2.set(Calendar.HOUR_OF_DAY, beginTime.get(Calendar.HOUR_OF_DAY));
						t2.set(Calendar.MINUTE, beginTime.get(Calendar.MINUTE));
						
						if(t.get(Calendar.YEAR) == t2.get(Calendar.YEAR) && t.get(Calendar.MONTH) == t2.get(Calendar.MONTH) && t.get(Calendar.DATE) == t2.get(Calendar.DATE) && t.get(Calendar.HOUR_OF_DAY) == t2.get(Calendar.HOUR_OF_DAY)&& t.get(Calendar.MINUTE) == t2.get(Calendar.MINUTE))
						{
							System.out.println("=====按月执行自动评估！");
							saveAutoAssessmentByCompany( setting ,companyId);
						}
					}
				}
			}
		}
	}
	/**
	 * 自动评估
	 * @param setting
	 * @param companyId
	 */
	private void saveAutoAssessmentByCompany(AutoAssessmentSetting setting,String companyId)
	{
		List<CustomerInfo> listCustomer = customerInfoService.findAllCustomerInfoByCompanyId(companyId);
		if(listCustomer != null  && listCustomer.size() > 0)
		{
			String item = setting.getItem();
			String totalComsumption = "";
			String consumptionTimes = "";
			String payments = "";
			String level = "";
			String introduceTimes = "";
			
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
			
			for(int i = 0;i< listCustomer.size();i++)
			{
				AnalysisCustomer analysisCustomer = new AnalysisCustomer();
				CustomerInfo customer = listCustomer.get(i);
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
					String t22 = CurrentDateTime.getCurrentDate();
					String t11 = t22.split("-")[0]+"-1-1";
					analysisCustomer.setPayments(sellRecordService.getConsumptionDebt(customer.getId(),t11,t22));
				}
				if(level.equals("1"))
				{
					if(customer.getLevelId() != null && customer.getLevelId().length() > 0)
					{
						NumberFormat f = NumberFormat.getPercentInstance();
						double dlevel = 0;
						try
						{
							dlevel = f.parse(customer.getLevelId()).doubleValue(); 
						}catch(Exception ex)
						{
							
						}
						analysisCustomer.setDevelopDegree(dlevel);
					}
				}
				if(introduceTimes.equals("1"))
				{
					analysisCustomer.setIntroduceCustomerTime(customer.getIntroduceTimes());
				}
				
				analysisCustomer.setCompanyId(companyId);
				
				AutoCustomerAssessment autoCustomerAssessment = new AutoCustomerAssessment();
				autoCustomerAssessment.setCompanyId(companyId);
				autoCustomerAssessment.setAssessmentTime(Calendar.getInstance());
				autoCustomerAssessment.setConsumptionTimes(analysisCustomer.getConsumptionTimes());
				autoCustomerAssessment.setCustomerId(analysisCustomer.getId());
				autoCustomerAssessment.setCustomerName(analysisCustomer.getCustomerName());
				autoCustomerAssessment.setDevelopDegree(analysisCustomer.getDevelopDegree());
				autoCustomerAssessment.setIntroduceCustomerTime(analysisCustomer.getIntroduceCustomerTime());
				autoCustomerAssessment.setPaymentsTimes(analysisCustomer.getPaymentsTimes());
				autoCustomerAssessment.setPayments(analysisCustomer.getPayments());
				autoCustomerAssessment.setTotalConsumption(analysisCustomer.getTotalConsumption());
				
				CustomerAssessment assessmentResult = customerAssessmentService.customerAssessmentById(analysisCustomer);
				if(assessmentResult != null)
				{
					autoCustomerAssessment.setResult(assessmentResult.getResult());
					Double value = assessmentResult.getResultValue();
					BigDecimal b = new BigDecimal(value);  
					value = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
					autoCustomerAssessment.setResultValue(value);
				}
				
				autoCustomerAssessmentService.save(autoCustomerAssessment);
				
				customer.setMaturity(assessmentResult.getResult());
				customer.setMaturityId(assessmentResult.getResult());
				customerInfoService.save(customer);
			}
		}
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
