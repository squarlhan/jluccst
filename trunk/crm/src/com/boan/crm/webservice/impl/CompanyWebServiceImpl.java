package com.boan.crm.webservice.impl;

import java.util.List;

import javax.jws.WebService;

import com.boan.crm.webservice.ICompanyWebService;
import com.boan.crm.webservice.model.CompanyInfo;

/**
 * @author XXX
 */
@WebService
public class CompanyWebServiceImpl implements ICompanyWebService {

	@Override
	public boolean exist(String companyName) {
		return false;
	}

	@Override
	public void importCompanys(List<CompanyInfo> companyInfos) {
		// TODO Auto-generated method stub
		
	}

}