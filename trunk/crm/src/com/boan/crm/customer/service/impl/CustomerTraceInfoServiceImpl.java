/**
 * 
 */
package com.boan.crm.customer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customer.dao.ICustomerInfoDAO;
import com.boan.crm.customer.dao.ICustomerTraceInfoDAO;
import com.boan.crm.customer.model.BusinessProgressKey;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.model.CustomerTraceInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerTraceInfoService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.utils.calendar.CalendarUtils;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 * 客户跟进信息服务接口实现类
 */
@Service("customerTraceInfoService")
public class CustomerTraceInfoServiceImpl implements ICustomerTraceInfoService{
	@Autowired
	@Qualifier("customerTraceInfoDao")
	private ICustomerTraceInfoDAO customerTraceInfoDao;
	
	@Autowired
	@Qualifier("customerInfoDao")
	private ICustomerInfoDAO customerInfoDao;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("contractPersonService")
	private IContractPersonService contractPersonService;
	
	@Override
	public void deleteCustomerTraceInfo(String... ids) {
		customerTraceInfoDao.delete(ids);
	}
	@Override
	public void deleteAllCustomerTraceInfoByCustomerId(String customerId) {
		Map<String,String> values = new HashMap<String,String>();
		values.put("customerId", customerId);
		customerTraceInfoDao.executeHql("update CustomerTraceInfo set deleteFlag = 1 where customerId = :customerId",values);
	}
	
	
	@Override
	public List<CustomerTraceInfo> findAllCustomerTraceInfo() {
		return customerTraceInfoDao.find("from CustomerTraceInfo where deleteFlag = 0 order by traceTime asc", new Object[0]);
	}
	
	@Override
	public List<CustomerTraceInfo> findAllCustomerTraceInfoByCustomerId(String customerId) {
		Map<String,String> values = new HashMap<String,String>();
		values.put("customerId", customerId);
		return customerTraceInfoDao.find("from CustomerTraceInfo where customerId = :customerId and deleteFlag = 0 order by traceTime asc", values);
	}
	
	@Override
	public int findCustomerTraceInfoCount(Map<String, ?> values) {
		StringBuilder hql = new StringBuilder();
		if(values.get("showAllFlag") != null && values.get("showAllFlag").equals("1"))
		{
			hql.append(" select count(*) from CustomerTraceInfo where 1=1 " );
		}else{
			hql.append(" select count(*) from CustomerTraceInfo where 1=1 and (deleteFlag = 0 )" );
		}
		
		if(values.get("companyId") != null)
		{
			hql.append(" and companyId = :companyId ");
		}
		if(values.get("customerId") != null)
		{
			hql.append(" and customerId = :customerId ");
		}
		if(values.get("salesmanId") != null)
		{
			hql.append(" and salesmanId = :salesmanId ");
		}
		if(values.get("traceOption") != null)
		{
			hql.append(" and traceOption = :traceOption ");
		}
		if(values.get("customerName") != null)
		{
			hql.append(" and customerId in (select id from CustomerInfo where customerName like :customerName )");
		}
		if(values.get("beginDate") != null && values.get("endDate") != null)
		{
			hql.append(" and traceTime between :beginDate and :endDate");
		}
		if(values.get("deptId") != null)
		{
			hql.append(" and salesmanId in (select id from User where deptId =:deptId) ");
		}
		if(values.get("traceFlag") != null && values.get("traceFlag").equals("1"))
		{
			hql.append(" and traceFlag = '1' ");
		}else if(values.get("traceFlag") != null && values.get("traceFlag").equals("0"))
		{
			hql.append(" and (traceFlag = '0' or traceFlag is null) ");
		}
		
		int totalRows = customerTraceInfoDao.findCountForPage(hql.toString(), values);
		return totalRows;
	}
	
	@Override
	public Pagination<CustomerTraceInfo> findCustomerTraceInfoForPage(
			Map<String, ?> values, Pagination<CustomerTraceInfo> pagination) {
		StringBuilder hql = new StringBuilder();
		if(values.get("showAllFlag") != null && values.get("showAllFlag").equals("1"))
		{
			hql.append( "from CustomerTraceInfo where 1=1 ");
		}else{
			hql.append( "from CustomerTraceInfo where 1=1 and (deleteFlag = 0 )");
		}
		if(values.get("companyId") != null)
		{
			hql.append(" and companyId = :companyId ");
		}
		if(values.get("customerId") != null)
		{
			hql.append(" and customerId = :customerId ");
		}
		if(values.get("salesmanId") != null)
		{
			hql.append(" and salesmanId = :salesmanId ");
		}
		if(values.get("traceOption") != null)
		{
			hql.append(" and traceOption = :traceOption ");
		}
		if(values.get("customerName") != null)
		{
			hql.append(" and customerId in (select id from CustomerInfo where customerName like :customerName)");
		}
		if(values.get("beginDate") != null)
		{
			hql.append(" and traceTime >= :beginDate ");
		}
		if(values.get("endDate") != null)
		{
			hql.append(" and traceTime <= :endDate ");
		}
		if(values.get("deptId") != null)
		{
			hql.append(" and salesmanId in (select id from User where deptId =:deptId) ");
		}
		if(values.get("traceFlag") != null && values.get("traceFlag").equals("1"))
		{
			hql.append(" and traceFlag = '1' ");
		}else if(values.get("traceFlag") != null && values.get("traceFlag").equals("0"))
		{
			hql.append(" and (traceFlag = '0' or traceFlag is null) ");
		}
		if(values.get("startTime") != null && values.get("endTime") != null)
		{
			hql.append(" and (traceTime between :startTime and :endTime) ");
		}
		hql.append(" order by traceTime desc,actualTraceTime");
		List<CustomerTraceInfo> data = customerTraceInfoDao.findForPage(hql.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		hql.delete(0, hql.length());
		if(values.get("showAllFlag") != null && values.get("showAllFlag").equals("1"))
		{
			hql.append(" select count(*) from CustomerTraceInfo where 1=1 " );
		}else{
			hql.append(" select count(*) from CustomerTraceInfo where 1=1 and (deleteFlag = 0 )" );
		}
		
		if(values.get("companyId") != null)
		{
			hql.append(" and companyId = :companyId ");
		}
		if(values.get("customerId") != null)
		{
			hql.append(" and customerId = :customerId ");
		}
		if(values.get("salesmanId") != null)
		{
			hql.append(" and salesmanId = :salesmanId ");
		}
		if(values.get("traceOption") != null)
		{
			hql.append(" and traceOption = :traceOption ");
		}
		if(values.get("customerName") != null)
		{
			hql.append(" and customerId in (select id from CustomerInfo where customerName like :customerName )");
		}
		if(values.get("beginDate") != null)
		{
			hql.append(" and traceTime >= :beginDate ");
		}
		if(values.get("endDate") != null)
		{
			hql.append(" and traceTime <= :endDate ");
		}
		if(values.get("deptId") != null)
		{
			hql.append(" and salesmanId in (select id from User where deptId =:deptId) ");
		}
		if(values.get("traceFlag") != null && values.get("traceFlag").equals("1"))
		{
			hql.append(" and traceFlag = '1' ");
		}else if(values.get("traceFlag") != null && values.get("traceFlag").equals("0"))
		{
			hql.append(" and (traceFlag = '0' or traceFlag is null) ");
		}
		if(values.get("startTime") != null && values.get("endTime") != null)
		{
			hql.append(" and (traceTime between :startTime and :endTime) ");
		}
		if(values.get("taskType") != null && values.get("taskType").equals("1"))
		{
			hql.append(" and traceFlag = 1 ");
		}else if(values.get("taskType") != null && values.get("taskType").equals("2"))
		{
			hql.append(" and traceFlag = 0 and traceTime >= :now ");
			
		}else if(values.get("taskType") != null && values.get("taskType").equals("3"))
		{
			hql.append(" and traceFlag = 0 and traceTime < :now ");
		}
		int totalRows = customerTraceInfoDao.findCountForPage(hql.toString(), values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		
		List<CustomerTraceInfo> list = pagination.getData();
		if(list != null && list.size() > 0)
		{
			for(int i=0;i< list.size();i++)
			{
				CustomerTraceInfo customerTraceInfo = list.get(i);
				try
				{
					CustomerInfo customer = customerInfoDao.get(customerTraceInfo.getCustomerId());
					if(customer != null)
					{
						customerTraceInfo.setCustomerName(customer.getCustomerName());
						if(customer.getProgressId() != null)
							customerTraceInfo.setProgress(BusinessProgressKey.getBusinessProgressNameByKey(customer.getProgressId()));
						else
							customerTraceInfo.setProgress("新建");
						
					}
					customerTraceInfo.setSalesman(userService.getUserById(customerTraceInfo.getSalesmanId()).getUserCName());
					customerTraceInfo.setPerson(contractPersonService.get(customerTraceInfo.getTracePersonId()));
					customerTraceInfo.setTraceTimeStr(CalendarUtils.toLongStringNoSecond(customerTraceInfo.getTraceTime()));
					if(customerTraceInfo.getActualTraceTime() != null)
						customerTraceInfo.setActualTraceTimeStr(CalendarUtils.toLongStringNoSecond(customerTraceInfo.getActualTraceTime()));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return pagination;
	}
	
	@Override
	public CustomerTraceInfo get(String id) {
		return customerTraceInfoDao.get(id);
	}

	@Override
	public void save(CustomerTraceInfo customerInfo) {
		customerTraceInfoDao.saveOrUpdate(customerInfo);
	}
}
