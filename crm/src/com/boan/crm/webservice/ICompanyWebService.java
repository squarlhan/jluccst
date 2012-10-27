package com.boan.crm.webservice;

import java.util.List;

import com.boan.crm.webservice.model.CompanyInfo;

/**
 * 客户在线查询服务接口类
 * @author XXX
 */
public interface ICompanyWebService {
	/**
	 * 保存客户信息
	 * @param companyInfos
	 */
	public void importCompanys(List<CompanyInfo> companyInfos);
}