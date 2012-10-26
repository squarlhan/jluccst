package com.boan.crm.webservice;

import java.util.List;

import com.boan.crm.webservice.model.CompanyInfo;

/**
 * 客户在线查询服务接口类
 * @author XXX
 */
public interface ICompanyWebService {
	/**
	 * 根据公司名称判断是否在数据库中已经存在
	 * (如果保存客户信息时判断是否存在的话，该方案可不用实现)
	 * @param orderInfo
	 * @return 订单ID
	 */
	public boolean exist(String companyName);
	
	/**
	 * 保存客户信息
	 * @param companyInfos
	 */
	public void importCompanys(List<CompanyInfo> companyInfos);
}