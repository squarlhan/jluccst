/**
 * 
 */
package com.boan.crm.customersearch.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customersearch.dao.ICustomerLibInfoDAO;
import com.boan.crm.customersearch.model.CustomerLibInfo;
import com.boan.crm.customersearch.service.IContractPersonLibService;
import com.boan.crm.customersearch.service.ICustomerLibInfoService;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 * 客户信息服务接口实现类
 */
@Service("customerLibInfoService")
public class CustomerLibInfoServiceImpl implements ICustomerLibInfoService{
	@Autowired
	@Qualifier("customerLibInfoDao")
	private ICustomerLibInfoDAO customerLibInfoDao; 
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
	@Qualifier("contractPersonLibService")
	private IContractPersonLibService contractPersonService = null;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Override
	public void deleteCustomerLibInfo(String... ids) {
		customerLibInfoDao.delete(ids);
	}

	@Override
	public List<CustomerLibInfo> findAllCustomerLibInfo() {
		return customerLibInfoDao.find("from CustomerLibInfo order by registerTime asc", new Object[0]);
	}

	@Override
	public Pagination<CustomerLibInfo> findCustomerLibInfoForPage(
			Map<String, ?> values, Pagination<CustomerLibInfo> pagination) {
		StringBuilder hql = new StringBuilder();
		hql.append( "from CustomerLibInfo where 1=1");
		
		if(values.get("mainIndustry") != null)
		{
			hql.append(" and mainIndustry like '%"+values.get("mainIndustry") +"%' ");
		}
		if(values.get("provinceId") != null)
		{
			hql.append(" and province = :provinceId ");
		}
		if(values.get("cityId") != null)
		{
			hql.append(" and city = :cityId ");
		}
		if(values.get("areaId") != null)
		{
			hql.append(" and area = :areaId ");
		}
		
		hql.append(" order by registerTime asc");
		List<CustomerLibInfo> data = customerLibInfoDao.findForPage(hql.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		hql.delete(0, hql.length());
		hql.append(" select count(*) from CustomerLibInfo where 1=1 " );
		if(values.get("mainIndustry") != null)
		{
			hql.append(" and mainIndustry like '%"+values.get("mainIndustry") +"%' ");
		}
		if(values.get("provinceId") != null)
		{
			hql.append(" and province = :provinceId ");
		}
		if(values.get("cityId") != null)
		{
			hql.append(" and city = :cityId ");
		}
		if(values.get("areaId") != null)
		{
			hql.append(" and area = :areaId ");
		}
		
		int totalRows = customerLibInfoDao.findCountForPage(hql.toString(), values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		
		List<CustomerLibInfo> list = pagination.getData();
		if(list != null && list.size() > 0)
		{
			for(int i=0;i< list.size();i++)
			{
				CustomerLibInfo customerLibInfo = list.get(i);
				DataDictionary d1 = dataDictionaryService.get(customerLibInfo.getCategoryId());
				if(d1 != null)
				{
					customerLibInfo.setCategory(d1.getName());
				}
				
				d1 = dataDictionaryService.get(customerLibInfo.getMaturityId()); 
				if(d1 != null)
				{
					customerLibInfo.setMaturity(d1.getName());
				}
				d1 = dataDictionaryService.get(customerLibInfo.getSourceId());
				if(d1 != null)
				{
					customerLibInfo.setSource(d1.getName());
				}
				
				try
				{
					User salesman = userService.getUserById(customerLibInfo.getSalesmanId());
					if(salesman != null)
					{
						customerLibInfo.setSalesman(salesman.getUserCName());
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				customerLibInfo.setContractPersonList(contractPersonService.findAllContractPersonLibInfoByCustomerId(customerLibInfo.getId()));
				
			}
		}
		return pagination;
	}

	@Override
	public CustomerLibInfo get(String id) {
		return customerLibInfoDao.get(id);
	}

	@Override
	public void save(CustomerLibInfo CustomerLibInfo) {
		customerLibInfoDao.saveOrUpdate(CustomerLibInfo);
	}
}
