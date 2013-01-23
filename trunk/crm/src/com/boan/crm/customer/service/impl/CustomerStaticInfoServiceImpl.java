/**
 * 
 */
package com.boan.crm.customer.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customer.dao.ICustomerStaticInfoDAO;
import com.boan.crm.customer.model.CustomerStaticInfo;
import com.boan.crm.customer.service.ICustomerStaticInfoService;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.service.IDataDictionaryService;

/**
 * @author luojx
 * 客户信息服务接口实现类
 */
@Service("customerStaticInfoService")
public class CustomerStaticInfoServiceImpl implements ICustomerStaticInfoService{
	@Autowired
	@Qualifier("customerStaticInfoDao")
	private ICustomerStaticInfoDAO customerStaticInfoDao;
	@Autowired
	@Qualifier("dataDictionaryService")
	private IDataDictionaryService dataDictionaryService;
	
	public List<CustomerStaticInfo> findAllCustomerStaticInfo(String companyId,int key)
	{
		List<CustomerStaticInfo> list = new ArrayList<CustomerStaticInfo>();
		StringBuilder hql = new StringBuilder();
		Map<String,String> values = new HashMap<String,String>();
		if(key == CustomerStaticInfo.CUSTOMER_SOURCE || key == CustomerStaticInfo.CUSTOMER_CATEGORY || key == CustomerStaticInfo.CUSTOMER_MATURITY || key == CustomerStaticInfo.CUSTOMER_PROGRESS)
		{
			List<DataDictionary> listDic = dataDictionaryService.findDataDictionaryByType(companyId, key);
			if(listDic != null && listDic.size() > 0)
			{
				for(int i=0;i<listDic.size();i++)
				{
					CustomerStaticInfo staticInfo = new CustomerStaticInfo();
					staticInfo.setKey(key);
					staticInfo.setCategory(listDic.get(i).getName());
					if(key == CustomerStaticInfo.CUSTOMER_SOURCE)
					{
						hql.delete(0, hql.length());
						hql.append("select Count(id) from CustomerInfo where companyId = :companyId and sourceId = :sourceId ");
						values.put("companyId", companyId);
						values.put("sourceId", listDic.get(i).getId());
					}else if(key == CustomerStaticInfo.CUSTOMER_CATEGORY)
					{
						hql.delete(0, hql.length());
						hql.append("select Count(id) from CustomerInfo where companyId = :companyId and categoryId = :categoryId ");
						values.put("companyId", companyId);
						values.put("categoryId", listDic.get(i).getId());
					}else if(key == CustomerStaticInfo.CUSTOMER_MATURITY)
					{
						hql.delete(0, hql.length());
						hql.append("select Count(id) from CustomerInfo where companyId = :companyId and maturityId = :maturityId ");
						values.put("companyId", companyId);
						values.put("maturityId", listDic.get(i).getId());
					}else if(key == CustomerStaticInfo.CUSTOMER_PROGRESS)
					{
						hql.delete(0, hql.length());
						hql.append("select Count(id) from CustomerInfo where companyId = :companyId and progressId = :progressId ");
						values.put("companyId", companyId);
						values.put("progressId", listDic.get(i).getId());
					}
					int count = customerStaticInfoDao.findCountForPage(hql.toString(), values);
					staticInfo.setCount(count);
					
					list.add(staticInfo);
					
				}
			}
		}else if(key == CustomerStaticInfo.CUSTOMER_LEVEL)
		{
			CustomerStaticInfo staticInfo1 = new CustomerStaticInfo();
			staticInfo1.setKey(key);
			staticInfo1.setCategory("10%");
			hql.append("select Count(id) from CustomerInfo where levelId = :levelId and companyId = :companyId");
			values.put("levelId", "10%");
			values.put("companyId", companyId);
			int count = customerStaticInfoDao.findCountForPage(hql.toString(), values);
			staticInfo1.setCount(count);
			list.add(staticInfo1);
			
			CustomerStaticInfo staticInfo2 = new CustomerStaticInfo();
			staticInfo2.setKey(key);
			staticInfo2.setCategory("20%");
			hql.delete(0, hql.length());
			hql.append("select Count(id) from CustomerInfo where levelId = :levelId and companyId = :companyId");
			values.put("levelId", "20%");
			values.put("companyId", companyId);
			count = customerStaticInfoDao.findCountForPage(hql.toString(), values);
			staticInfo2.setCount(count);
			list.add(staticInfo2);
			
			CustomerStaticInfo staticInfo3 = new CustomerStaticInfo();
			staticInfo3.setKey(key);
			staticInfo3.setCategory("30%");
			hql.delete(0, hql.length());
			hql.append("select Count(id) from CustomerInfo where levelId = :levelId and companyId = :companyId");
			values.put("levelId", "30%");
			values.put("companyId", companyId);
			count = customerStaticInfoDao.findCountForPage(hql.toString(), values);
			staticInfo3.setCount(count);
			list.add(staticInfo3);
			
			CustomerStaticInfo staticInfo4 = new CustomerStaticInfo();
			staticInfo4.setKey(key);
			staticInfo4.setCategory("40%");
			hql.delete(0, hql.length());
			hql.append("select Count(id) from CustomerInfo where levelId = :levelId and companyId = :companyId");
			values.put("levelId", "40%");
			values.put("companyId", companyId);
			count = customerStaticInfoDao.findCountForPage(hql.toString(), values);
			staticInfo4.setCount(count);
			list.add(staticInfo4);
			
			
			CustomerStaticInfo staticInfo5 = new CustomerStaticInfo();
			staticInfo5.setKey(key);
			staticInfo5.setCategory("50%");
			hql.delete(0, hql.length());
			hql.append("select Count(id) from CustomerInfo where levelId = :levelId and companyId = :companyId");
			values.put("levelId", "50%");
			values.put("companyId", companyId);
			count = customerStaticInfoDao.findCountForPage(hql.toString(), values);
			staticInfo5.setCount(count);
			list.add(staticInfo5);
			
			CustomerStaticInfo staticInfo6 = new CustomerStaticInfo();
			staticInfo6.setKey(key);
			staticInfo6.setCategory("60%");
			hql.delete(0, hql.length());
			hql.append("select Count(id) from CustomerInfo where levelId = :levelId and companyId = :companyId");
			values.put("levelId", "60%");
			values.put("companyId", companyId);
			count = customerStaticInfoDao.findCountForPage(hql.toString(), values);
			staticInfo6.setCount(count);
			list.add(staticInfo6);
			
			
			CustomerStaticInfo staticInfo7 = new CustomerStaticInfo();
			staticInfo7.setKey(key);
			staticInfo7.setCategory("70%");
			hql.delete(0, hql.length());
			hql.append("select Count(id) from CustomerInfo where levelId = :levelId and companyId = :companyId");
			values.put("levelId", "70%");
			values.put("companyId", companyId);
			count = customerStaticInfoDao.findCountForPage(hql.toString(), values);
			staticInfo7.setCount(count);
			list.add(staticInfo7);
			
			CustomerStaticInfo staticInfo8 = new CustomerStaticInfo();
			staticInfo8.setKey(key);
			staticInfo8.setCategory("80%");
			hql.delete(0, hql.length());
			hql.append("select Count(id) from CustomerInfo where levelId = :levelId and companyId = :companyId");
			values.put("levelId", "80%");
			values.put("companyId", companyId);
			count = customerStaticInfoDao.findCountForPage(hql.toString(), values);
			staticInfo8.setCount(count);
			list.add(staticInfo8);
			
			CustomerStaticInfo staticInfo9 = new CustomerStaticInfo();
			staticInfo9.setKey(key);
			staticInfo9.setCategory("90%");
			hql.delete(0, hql.length());
			hql.append("select Count(id) from CustomerInfo where levelId = :levelId and companyId = :companyId");
			values.put("levelId", "90%");
			values.put("companyId", companyId);
			count = customerStaticInfoDao.findCountForPage(hql.toString(), values);
			staticInfo9.setCount(count);
			list.add(staticInfo9);
			
			CustomerStaticInfo staticInfo10 = new CustomerStaticInfo();
			staticInfo10.setKey(key);
			staticInfo10.setCategory("100%");
			hql.delete(0, hql.length());
			hql.append("select Count(id) from CustomerInfo where levelId = :levelId and companyId = :companyId");
			values.put("levelId", "100%");
			values.put("companyId", companyId);
			count = customerStaticInfoDao.findCountForPage(hql.toString(), values);
			staticInfo10.setCount(count);
			list.add(staticInfo10);
			
		}
		
		return list;
	}
}