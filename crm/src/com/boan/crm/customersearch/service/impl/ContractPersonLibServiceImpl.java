/**
 * 
 */
package com.boan.crm.customersearch.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customersearch.dao.IContractPersonLibDAO;
import com.boan.crm.customersearch.model.ContractPersonLibInfo;
import com.boan.crm.customersearch.service.IContractPersonLibService;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 *　联系人服务接口实现类
 */
@Service("contractPersonLibService")
public class ContractPersonLibServiceImpl implements IContractPersonLibService {
	@Autowired
	@Qualifier("contractPersonLibDao")
	private IContractPersonLibDAO contractPersonDao;
	@Override
	public void deleteContractPersonLibInfo(String... ids) {
		contractPersonDao.delete(ids);
	}
	/**
	 * 根据客户id删除联系人
	 * @param ids
	 */
	@Override
	public void deleteContractPersonLibInfoByCustomerIds(String... ids)
	{	
		for(int i=0;i<ids.length;i++)
		{
			Map<String,String> idMap = new HashMap<String,String>();
			idMap.put("customerId", ids[i]);
			contractPersonDao.executeHql("delete from ContractPersonLibInfo where customerId = :customerId",idMap);
		}
	}
	@Override
	public List<ContractPersonLibInfo> findAllContractPersonLibInfoByCustomerId(String customerId) {
		Map<String,String> idMap = new HashMap<String,String>();
		idMap.put("customerId", customerId);
		return contractPersonDao.find("from ContractPersonLibInfo where customerId = :customerId order by sort_index asc", idMap);
	}

	@Override
	public Pagination<ContractPersonLibInfo> findContractPersonLibInfoForPage(
			Map<String, ?> values, Pagination<ContractPersonLibInfo> pagination) {
		String hql = "from ContractPersonLibInfo order by sortIndex asc";
		List<ContractPersonLibInfo> data = contractPersonDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from ContractPersonLibInfo order by sortIndex asc";
		int totalRows = contractPersonDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	@Override
	public ContractPersonLibInfo get(String id) {
		return contractPersonDao.get(id);
	}

	@Override
	public void save(ContractPersonLibInfo table1) {
		contractPersonDao.saveOrUpdate(table1);
	}
}
