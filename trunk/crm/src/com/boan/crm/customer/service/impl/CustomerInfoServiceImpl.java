/**
 * 
 */
package com.boan.crm.customer.service.impl;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customer.dao.ICustomerInfoDAO;
import com.boan.crm.customer.model.BusinessProgressKey;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.sellrecord.service.ISellRecordService;
import com.boan.crm.utils.calendar.CurrentDateTime;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 * 客户信息服务接口实现类
 */
@Service("customerInfoService")
public class CustomerInfoServiceImpl implements ICustomerInfoService{
	@Autowired
	@Qualifier("customerInfoDao")
	private ICustomerInfoDAO customerInfoDao;
	/**
	 * 权限接口
	 */
	@Autowired
	@Qualifier("dataDictionaryService")
	private IDataDictionaryService dataDictionaryService = null;
	
	/**
	 * 权限接口
	 */
	@Autowired
	@Qualifier("contractPersonService")
	private IContractPersonService contractPersonService = null;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	@Autowired
	@Qualifier("sellRecordService")
	private ISellRecordService sellRecordService;
	
	@Override
	public void deleteCustomerInfo(String... ids) {
		//customerInfoDao.delete(ids);
		for(int i=0;i<ids.length ;i++)
		{
			Map<String,String> values = new HashMap<String,String>();
			values.put("customerId", ids[i]);
			customerInfoDao.executeHql("update CustomerInfo set deleteFlag = 1 where id = :customerId",values);
		}
	}

	@Override
	public List<CustomerInfo> findAllCustomerInfo() {
		return customerInfoDao.find("from CustomerInfo where deleteFlag = 0 order by registerTime asc", new Object[0]);
	}
	@Override
	public int findAllCustomerInfoCount(String companyId)
	{
		Map<String,String> values = new HashMap<String,String>();
		values.put("companyId", companyId);
		String hql = "select Count(id) from CustomerInfo where companyId = :companyId ";
		return customerInfoDao.findCountForPage(hql, values);
	}
	/**
	 * 查找全部客户个数
	 */
	@Override
	public int findAllCustomerInfoCount(String companyId,String deptId,String userId)
	{
		StringBuffer hql = new StringBuffer();
		if( deptId != null)
		{
			hql.append("select Count(id) from CustomerInfo where companyId = :companyId ");
		}else
		{
			hql.append("select Count(id) from CustomerInfo where companyId = :companyId and deleteFlag = 0 ");
		}
		Map<String,String> values = new HashMap<String,String>();
		values.put("companyId", companyId);
		if( deptId != null && deptId.length() > 0)
		{
			hql.append(" and salesmanId in (select id from User where deptId =:deptId ) ");
			values.put("deptId", deptId);
		}else
		{
			if(userId != null && userId.length() > 0)
			{
				hql.append(" and salesmanId = :userId ) ");
				values.put("userId", userId);
			}
		}
		
		return customerInfoDao.findCountForPage(hql.toString(), values);
	}
	/**
	 * 查找全部客户
	 */
	@Override
	public List<CustomerInfo> findAllCustomerInfoByCompanyId( String companyId )
	{
		Map<String,String> values = new HashMap<String,String>();
		values.put("companyId", companyId);
		
		return customerInfoDao.find("from CustomerInfo where companyId = :companyId order by registerTime asc",values );
	}
	/**
	 * 查找销售员自己的客户
	 */
	public List<CustomerInfo> findAllCustomerInfoBySalesmanId( String salesmanId )
	{
		Map<String,String> values = new HashMap<String,String>();
		values.put("salesmanId", salesmanId);
		
		return customerInfoDao.find("from CustomerInfo where salesmanId = :salesmanId and deleteFlag = 0  order by registerTime asc",values );
	}
	@Override
	public Pagination<CustomerInfo> findCustomerInfoForPage(
			Map<String, ?> values, Pagination<CustomerInfo> pagination) {
		StringBuilder hql = new StringBuilder();
		if(values.get("showAllFlag") != null && values.get("showAllFlag").equals("1"))
		{
			hql.append( "from CustomerInfo where 1=1 ");
		}else{
			hql.append( "from CustomerInfo where 1=1 and deleteFlag = 0 ");
		}
				
		if(values.get("companyId") != null)
		{
			hql.append(" and companyId = :companyId ");
		}
		if(values.get("salesmanId") != null)
		{
			hql.append(" and salesmanId = :salesmanId ");
		}
		if(values.get("customerName") != null)
		{
			hql.append(" and customerName like :customerName ");
		}
		if(values.get("contractorName") != null)
		{
			hql.append(" and id in ( select customerId from ContractPersonInfo where personName like :contractorName) ");
		}
		if(values.get("customerCategory") != null)
		{
			hql.append(" and categoryId = :customerCategory ");
		}
		if(values.get("deptId") != null)
		{
			hql.append(" and salesmanId in (select id from User where deptId =:deptId ) ");
		}
		
		hql.append(" order by registerTime asc");
		List<CustomerInfo> data = customerInfoDao.findForPage(hql.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		hql.delete(0, hql.length());
		if(values.get("showAllFlag") != null && values.get("showAllFlag").equals("1"))
		{
			hql.append(" select count(*) from CustomerInfo where 1=1 " );
		}else{
			hql.append(" select count(*) from CustomerInfo where 1=1 and deleteFlag = 0 " );
		}
		
		if(values.get("companyId") != null)
		{
			hql.append(" and companyId = :companyId ");
		}
		if(values.get("salesmanId") != null)
		{
			hql.append(" and salesmanId = :salesmanId ");
		}
		if(values.get("customerName") != null)
		{
			hql.append(" and customerName like :customerName ");
		}
		if(values.get("contractorName") != null)
		{
			hql.append(" and id in ( select customerId from ContractPersonInfo where personName like :contractorName) ");
		}
		if(values.get("customerCategory") != null)
		{
			hql.append(" and categoryId = :customerCategory ");
		}
		if(values.get("deptId") != null)
		{
			hql.append(" and salesmanId in (select id from User where deptId =:deptId ) ");
		}
		int totalRows = customerInfoDao.findCountForPage(hql.toString(), values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		
		List<CustomerInfo> list = pagination.getData();
		if(list != null && list.size() > 0)
		{
			for(int i=0;i< list.size();i++)
			{
				CustomerInfo customerInfo = list.get(i);
				DataDictionary d1 = dataDictionaryService.get(customerInfo.getCategoryId());
				if(d1 != null)
				{
					customerInfo.setCategory(d1.getName());
				}
				
				DataDictionary d2 = dataDictionaryService.get(customerInfo.getMaturityId());
				if(d2 != null)
				{
					customerInfo.setMaturity(d2.getName());
				}
				DataDictionary d3 = dataDictionaryService.get(customerInfo.getSourceId());
				if(d3 != null)
				{
					customerInfo.setSource(d3.getName());
				}
//				DataDictionary d4 = dataDictionaryService.get(customerInfo.getProgressId());
//				if(d4 != null)
//				{
					customerInfo.setProgress(BusinessProgressKey.getBusinessProgressNameByKey(customerInfo.getProgressId()));
//				}else
//				{
//					customerInfo.setProgress("");
//				}
				try
				{
					User salesman = userService.getUserById(customerInfo.getSalesmanId());
					if(salesman != null)
					{
						customerInfo.setSalesman(salesman.getUserCName());
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				customerInfo.setContractPersonList(contractPersonService.findAllContractPersonInfoByCustomerId(customerInfo.getId()));
				
				customerInfo.setTotalConsumption(sellRecordService.getConsumptionMoney(customerInfo.getId()));
				customerInfo.setConsumptionTimes(sellRecordService.getConsumptionCount(customerInfo.getId()));
				
				String t22 = CurrentDateTime.getCurrentDate();
				String t11 = t22.split("-")[0]+"-1-1";
				customerInfo.setPayments(sellRecordService.getConsumptionDebt(customerInfo.getId(),t11,t22));
				
				if(customerInfo.getLevelId() != null && customerInfo.getLevelId().length() > 0)
				{
					NumberFormat f = NumberFormat.getPercentInstance();
					double level = 0;
					try
					{
						level = f.parse(customerInfo.getLevelId()).doubleValue(); 
					}catch(Exception ex)
					{
					}
					customerInfo.setDevelopDegree(level);
				}
			}
		}
		return pagination;
	}

	@Override
	public CustomerInfo get(String id) {
		return customerInfoDao.get(id);
	}

	@Override
	public void save(CustomerInfo customerInfo) {
		customerInfoDao.saveOrUpdate(customerInfo);
	}
	
	@Override
	public Pagination<CustomerInfo> findCustomerInfoAndSellAmountForPage( Map<String, ?> values, Pagination<CustomerInfo> pagination) {
		StringBuilder hql = new StringBuilder();
		hql.append( "from CustomerInfo where 1=1 and deleteFlag = 0 ");
		if(values.get("companyId") != null)
		{
			hql.append(" and companyId = :companyId ");
		}
		if(values.get("salesmanId") != null)
		{
			hql.append(" and salesmanId = :salesmanId ");
		}
		if(values.get("customerName") != null)
		{
			hql.append(" and customerName like :customerName ");
		}
		if(values.get("contractorName") != null)
		{
			hql.append(" and id in ( select customerId from ContractPersonInfo where personName like :contractorName) ");
		}
		//销售额范围条件
		hql.append(" and id in ( select record.customerId  from SellRecord as record group by  record.customerId , record.bargainTime  having 1=1 ");
		
		if(values.get("queryBeginTime")!=null && !values.get("queryBeginTime").equals("")){
			hql. append( " and record.bargainTime >='"+values.get("queryBeginTime")+"' ");
		}
		if(values.get("queryEndTime")!=null && !values.get("queryEndTime").equals("")){
			hql. append( " and record.bargainTime <='"+values.get("queryEndTime")+"' ");
		}
		if(values.get("queryAmountBegin")!=null && !values.get("queryAmountBegin").equals("")){
			hql.append("  and sum(record.receivable) >= "+values.get("queryAmountBegin") );
		}
		if(values.get("queryAmountEnd")!=null && !values.get("queryAmountEnd").equals("")){
			hql.append(" and  sum(record.receivable) <= "+values.get("queryAmountEnd"));
		}
		if(values.get("queryIsArrearage")!=null && values.get("queryIsArrearage").equals("0")){
			hql.append(" and  sum(record.debt)  = 0");
		}
		if(values.get("queryIsArrearage")!=null && values.get("queryIsArrearage").equals("1")){
			hql.append(" and  sum(record.debt) > 0");
		}
		
		hql. append( " ) ");
		
		if(values.get("customerCategory") != null)
		{
			hql.append(" and categoryId = :customerCategory ");
		}
		if(values.get("deptId") != null)
		{
			hql.append(" and salesmanId in (select id from User where deptId =:deptId ) ");
		}
		
		hql.append(" order by registerTime asc");
		List<CustomerInfo> data = customerInfoDao.findForPage(hql.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		hql.delete(0, hql.length());
		
		
		
		hql.append(" select count(*) from CustomerInfo where 1=1 and deleteFlag = 0 " );
		if(values.get("companyId") != null)
		{
			hql.append(" and companyId = :companyId ");
		}
		if(values.get("salesmanId") != null)
		{
			hql.append(" and salesmanId = :salesmanId ");
		}
		if(values.get("customerName") != null)
		{
			hql.append(" and customerName like :customerName ");
		}
		if(values.get("contractorName") != null)
		{
			hql.append(" and id in ( select customerId from ContractPersonInfo where personName like :contractorName) ");
		}
		
		//销售额范围条件
		hql.append(" and id in ( select record.customerId  from SellRecord as record group by  record.customerId , record.bargainTime  having 1=1 ");
		
		if(values.get("queryBeginTime")!=null && !values.get("queryBeginTime").equals("")){
			hql. append( " and record.bargainTime >='"+values.get("queryBeginTime")+"' ");
		}
		if(values.get("queryEndTime")!=null && !values.get("queryEndTime").equals("")){
			hql. append( " and record.bargainTime <='"+values.get("queryEndTime")+"' ");
		}
		if(values.get("queryAmountBegin")!=null && !values.get("queryAmountBegin").equals("")){
			hql.append("  and sum(record.receivable) >= "+values.get("queryAmountBegin") );
		}
		if(values.get("queryAmountEnd")!=null && !values.get("queryAmountEnd").equals("")){
			hql.append(" and  sum(record.receivable) <= "+values.get("queryAmountEnd"));
		}
		if(values.get("queryIsArrearage")!=null && values.get("queryIsArrearage").equals("0")){
			hql.append(" and  sum(record.debt)  = 0");
		}
		if(values.get("queryIsArrearage")!=null && values.get("queryIsArrearage").equals("1")){
			hql.append(" and  sum(record.debt) > 0");
		}
		
		hql. append( " ) ");
				
		if(values.get("customerCategory") != null)
		{
			hql.append(" and categoryId = :customerCategory ");
		}
		if(values.get("deptId") != null)
		{
			hql.append(" and salesmanId in (select id from User where deptId =:deptId ) ");
		}
		int totalRows = customerInfoDao.findCountForPage(hql.toString(), values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		
		List<CustomerInfo> list = pagination.getData();
		if(list != null && list.size() > 0)
		{
			for(int i=0;i< list.size();i++)
			{
				CustomerInfo customerInfo = list.get(i);
				DataDictionary d1 = dataDictionaryService.get(customerInfo.getCategoryId());
				if(d1 != null)
				{
					customerInfo.setCategory(d1.getName());
				}
				
				DataDictionary d2 = dataDictionaryService.get(customerInfo.getMaturityId());
				if(d2 != null)
				{
					customerInfo.setMaturity(d2.getName());
				}
				DataDictionary d3 = dataDictionaryService.get(customerInfo.getSourceId());
				if(d3 != null)
				{
					customerInfo.setSource(d3.getName());
				}
				DataDictionary d4 = dataDictionaryService.get(customerInfo.getProgressId());
				if(d4 != null)
				{
					customerInfo.setProgress(d4.getName());
				}else
				{
					customerInfo.setProgress("");
				}
				try
				{
					User salesman = userService.getUserById(customerInfo.getSalesmanId());
					if(salesman != null)
					{
						customerInfo.setSalesman(salesman.getUserCName());
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				customerInfo.setContractPersonList(contractPersonService.findAllContractPersonInfoByCustomerId(customerInfo.getId()));
				
				customerInfo.setTotalConsumption(sellRecordService.getConsumptionMoney(customerInfo.getId()));
				String begin = values.get("queryBeginTime") ==null ? "" : values.get("queryBeginTime").toString();
				String end = values.get("queryEndTime") ==null ? "" : values.get("queryEndTime").toString();
				customerInfo.setTotalDebt(sellRecordService.getTotalDebt(customerInfo.getId(),begin , end));
				customerInfo.setConsumptionTimes(sellRecordService.getConsumptionCount(customerInfo.getId()));
				
				String t22 = CurrentDateTime.getCurrentDate();
				String t11 = t22.split("-")[0]+"-1-1";
				customerInfo.setPayments(sellRecordService.getConsumptionDebt(customerInfo.getId(),t11,t22));
				
				if(customerInfo.getLevelId() != null && customerInfo.getLevelId().length() > 0)
				{
					NumberFormat f = NumberFormat.getPercentInstance();
					double level = 0;
					try
					{
						level = f.parse(customerInfo.getLevelId()).doubleValue(); 
					}catch(Exception ex)
					{
					}
					customerInfo.setDevelopDegree(level);
				}
			}
		}
		return pagination;
	}
}
