/**
 * 
 */
package com.boan.crm.customer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customer.dao.ICustomerInfoDAO;
import com.boan.crm.customer.dao.ICustomerVisitInfoDAO;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.model.CustomerVisitInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerVisitInfoService;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.utils.calendar.CalendarUtils;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 * 客户跟进信息服务接口实现类
 */
@Service("customerVisitInfoService")
public class CustomerVisitInfoServiceImpl implements ICustomerVisitInfoService{
	@Autowired
	@Qualifier("customerVisitInfoDao")
	private ICustomerVisitInfoDAO customerVisitInfoDao;
	@Autowired
	@Qualifier("customerInfoDao")
	private ICustomerInfoDAO customerInfoDao;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("contractPersonService")
	private IContractPersonService contractPersonService;
	@Autowired
	@Qualifier("dataDictionaryService")
	private IDataDictionaryService dataDictionaryService = null;
	
	@Override
	public void deleteCustomerVisitInfo(String... ids) {
		customerVisitInfoDao.delete(ids);
	}

	@Override
	public List<CustomerVisitInfo> findAllCustomerVisitInfo() {
		return customerVisitInfoDao.find("from customerVisitInfoDao order by VisitTime asc", new Object[0]);
	}
	
	@Override
	public List<CustomerVisitInfo> findAllCustomerVisitInfoByCustomerId(String customerId) {
		return customerVisitInfoDao.find("from customerVisitInfoDao where customerId = :customerId order by VisitTime asc", customerId);
	}
	
	@Override
	public Pagination<CustomerVisitInfo> findCustomerVisitInfoForPage(
			Map<String, ?> values, Pagination<CustomerVisitInfo> pagination) {
		StringBuilder hql = new StringBuilder();
		hql.append( "from CustomerVisitInfo where 1=1");
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
		if(values.get("visitOption") != null)
		{
			hql.append(" and visitOption = :visitOption ");
		}
		if(values.get("customerName") != null)
		{
			hql.append(" and customerId in (select id from CustomerInfo where customerName like :customerName)");
		}
		if(values.get("beginDate") != null)
		{
			hql.append(" and visitTime >= :beginDate ");
		}
		if(values.get("endDate") != null)
		{
			hql.append(" and visitTime <= :endDate ");
		}
		if(values.get("deptId") != null)
		{
			hql.append(" and salesmanId in (select id from User where deptId =:deptId) ");
		}
		hql.append(" order by visitTime asc");
		List<CustomerVisitInfo> data = customerVisitInfoDao.findForPage(hql.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		hql.delete(0, hql.length());
		hql.append(" select count(*) from CustomerVisitInfo where 1=1 " );
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
		if(values.get("visitOption") != null)
		{
			hql.append(" and visitOption = :visitOption ");
		}
		if(values.get("customerName") != null)
		{
			hql.append(" and customerId in (select id from CustomerInfo where customerName like :customerName )");
		}
		if(values.get("beginDate") != null)
		{
			hql.append(" and visitTime >= :beginDate ");
		}
		if(values.get("endDate") != null)
		{
			hql.append(" and visitTime <= :endDate ");
		}
		if(values.get("deptId") != null)
		{
			hql.append(" and salesmanId in (select id from User where deptId =:deptId) ");
		}
		int totalRows = customerVisitInfoDao.findCountForPage(hql.toString(), values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		
		List<CustomerVisitInfo> list = pagination.getData();
		if(list != null && list.size() > 0)
		{
			for(int i=0;i< list.size();i++)
			{
				CustomerVisitInfo customerVisitInfo = list.get(i);
				try
				{
					CustomerInfo customer = customerInfoDao.get(customerVisitInfo.getCustomerId());
					if(customer != null)
					{
						customerVisitInfo.setCustomerName(customer.getCustomerName());
						
						DataDictionary dc = dataDictionaryService.get(customer.getProgressId());
						if(dc != null)
						{
							customerVisitInfo.setProgress(dc.getName());
						}else
						{
							customerVisitInfo.setProgress("");
						}
					}
					customerVisitInfo.setSalesman(userService.getUserById(customerVisitInfo.getSalesmanId()).getUserCName());
					customerVisitInfo.setPerson(contractPersonService.get(customerVisitInfo.getVisitPersonId()));
					
					
					customerVisitInfo.setVisitTimeStr(CalendarUtils.toLongStringNoSecond(customerVisitInfo.getVisitTime()));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return pagination;
	}

	@Override
	public CustomerVisitInfo get(String id) {
		return customerVisitInfoDao.get(id);
	}

	@Override
	public void save(CustomerVisitInfo customerInfo) {
		customerVisitInfoDao.saveOrUpdate(customerInfo);
	}
}
