/*
 * @(#)GroupCompanyServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import com.boan.rees.demo.model.DemoModel;
import com.boan.rees.group.dao.ICompanyDao;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.dao.IFactoryDao;
import com.boan.rees.group.model.Company;
import com.boan.rees.group.service.ICompanyService;
import com.boan.rees.utils.page.Pagination;

/**
 * 公司服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("groupCompanyService")
public class CompanyServiceImpl implements ICompanyService{

	
	@Autowired
	@Qualifier("groupCompanyDao")
	private ICompanyDao groupCompanyDao;
	@Override
	/**
	 * 查找全部公司
	 */
	public List<Company> findAllGroupCompany() {
		
		return groupCompanyDao.findAll();
	}

	@Override
	
	/**
	 * 取得公司编号
	 */
	public Company get(String id) {
		
		return groupCompanyDao.get(id);
	}

	@Override
	
	/**
	 * 根据公司编号删除公司
	 */
	public void deleteGroupCompany(String... ids) {
		
		groupCompanyDao.delete(ids);
	}

	@Override
	
	/**
	 * 保存公司
	 */
	public void save(Company table1) {
	
		groupCompanyDao.save(table1);
	}
	
	@Override
	/**
	 * 分页查询公司
	 */
	public Pagination<Company> findCompanyForPage(Map<String, ?> values,Pagination<Company> pagination){
		
		String hql = "from Company";
		List<Company> data = groupCompanyDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from Company";
		int totalRows = groupCompanyDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

}

