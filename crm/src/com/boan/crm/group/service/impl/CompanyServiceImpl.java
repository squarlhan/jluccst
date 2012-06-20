/*
 * @(#)GroupCompanyServiceImpl.java 1.1 2012-3-9
 */

package com.boan.crm.group.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.group.dao.ICompanyDao;
import com.boan.crm.group.model.Company;
import com.boan.crm.group.service.ICompanyService;
import com.boan.crm.utils.page.Pagination;

/**
 * 公司服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */
@Service("companyService")
public class CompanyServiceImpl implements ICompanyService{

	
	@Autowired
	@Qualifier("companyDao")
	private ICompanyDao companyDao;

	@Override
	
	/**
	 * 取得公司编号
	 */
	public Company get(String id) {
		
		return companyDao.get(id);
	}

	@Override
	
	/**
	 * 根据公司编号删除公司
	 */
	public void deleteGroupCompany(String... ids) {
		
		companyDao.delete(ids);
	}

	@Override
	
	/**
	 * 保存公司
	 */
	public void save(Company table1) {
	
		companyDao.save(table1);
	}
	/**
	 * 修改公司信息
	 */
	public void update(Company company){
		companyDao.update(company);
	}
	
	@Override
	/**
	 * 分页查询公司
	 */
	public Pagination<Company> findCompanyForPage(Map<String, ?> values,Pagination<Company> pagination){
		
		String hql = "from Company order by sortIndex asc, createTime asc";
		List<Company> data = companyDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from Company";
		int totalRows = companyDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	@Override
	public boolean isExistSameName( String id, String name )
	{
		return companyDao.isExistSameName( id, name );
	}

	@Override
	public List<Company> queryAllCompanysByRootId( String rootId )
	{
		return companyDao.queryAllCompanysByRootId( rootId );
	}

}

