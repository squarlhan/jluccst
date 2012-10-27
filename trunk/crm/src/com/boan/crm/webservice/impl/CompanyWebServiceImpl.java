package com.boan.crm.webservice.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customersearch.model.ContractPersonLibInfo;
import com.boan.crm.customersearch.model.CustomerLibInfo;
import com.boan.crm.customersearch.service.IContractPersonLibService;
import com.boan.crm.customersearch.service.ICustomerLibInfoService;
import com.boan.crm.utils.myenum.ProvinceEnum;
import com.boan.crm.webservice.ICompanyWebService;
import com.boan.crm.webservice.model.CompanyInfo;

/**
 * @author XXX
 */
@WebService
public class CompanyWebServiceImpl implements ICompanyWebService {

	@Autowired
	@Qualifier("customerLibInfoService")
	private ICustomerLibInfoService customerLibInfoService; 
	
	// 客户联系人接口类
	@Autowired
	@Qualifier("contractPersonLibService")
	private IContractPersonLibService contractpersonService;
	
	@Override
	public void importCompanys(List<CompanyInfo> companyInfos) {
		if(companyInfos!=null && companyInfos.size()>0){
			
			for(CompanyInfo ci:companyInfos){
				//获取省份名称
				String province = ci.getProvince();
				
				String provincKey = ProvinceEnum.getKeyByName(province);
				System.out.println("省份Key"+provincKey);
				if(provincKey!=null){
					//判断公司是否存在
					boolean flag = customerLibInfoService.existCustomerInLib(province,ci.getCompanyName());
					if(!flag){
						CustomerLibInfo customerLibInfo = new CustomerLibInfo();
						customerLibInfo.setProvince(ci.getProvince());
						customerLibInfo.setCity(ci.getCity());
						customerLibInfo.setAddress(ci.getAddress());
						customerLibInfo.setFax(ci.getFax());
						customerLibInfo.setCustomerName(ci.getCompanyName());
						customerLibInfo.setMainIndustry(ci.getCompanyType());
						//保存客户到客户库
						customerLibInfoService.save(province, customerLibInfo);
		
						ContractPersonLibInfo contractPersonLibInfo = new  ContractPersonLibInfo();
						contractPersonLibInfo.setDeptOrDuty(ci.getDuty());
						contractPersonLibInfo.setCustomerId(customerLibInfo.getId());
						contractPersonLibInfo.setPhone(ci.getPhone());
						contractPersonLibInfo.setTel(ci.getTel());
						contractPersonLibInfo.setPersonName(ci.getContact());
						//公司网站用不上现在
						ci.getWebsite();
						//保存客户联系人到客户联系人库
						contractpersonService.save(province,contractPersonLibInfo);
					}
				}
			}
		}
	}

//	public void importCompanys(List<CompanyInfo> companyInfos,String province) {
//		if(companyInfos!=null && companyInfos.size()>0){
//			
//			for(CompanyInfo ci:companyInfos){
//				String provincKey = ProvinceEnum.getKeyByName(province);
//				System.out.println("省份Key"+provincKey);
//				if(provincKey!=null){
//					//判断公司是否存在
//					boolean flag = customerLibInfoService.existCustomerInLib(province,ci.getCompanyName());
//					if(!flag){
//						CustomerLibInfo customerLibInfo = new CustomerLibInfo();
//						customerLibInfo.setProvince(ci.getProvince());
//						customerLibInfo.setCity(ci.getCity());
//						customerLibInfo.setAddress(ci.getAddress());
//						customerLibInfo.setFax(ci.getFax());
//						customerLibInfo.setCustomerName(ci.getCompanyName());
//						customerLibInfo.setMainIndustry(ci.getCompanyType());
//						//保存客户到客户库
//						customerLibInfoService.save(province, customerLibInfo);
//		
//						ContractPersonLibInfo contractPersonLibInfo = new  ContractPersonLibInfo();
//						contractPersonLibInfo.setDeptOrDuty(ci.getDuty());
//						contractPersonLibInfo.setCustomerId(customerLibInfo.getId());
//						contractPersonLibInfo.setPhone(ci.getPhone());
//						contractPersonLibInfo.setTel(ci.getTel());
//						contractPersonLibInfo.setPersonName(ci.getContact());
//						//公司网站用不上现在
//						ci.getWebsite();
//						//保存客户联系人到客户联系人库
//						contractpersonService.save(province,contractPersonLibInfo);
//					}
//				}
//			}
//		}
//	}
}