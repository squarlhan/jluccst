/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)PointDataInfo.java 1.1 2012-3-6
 */
package com.boan.crm.backstagemanage.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.backstagemanage.common.LogType;
import com.boan.crm.backstagemanage.common.ProductType;
import com.boan.crm.backstagemanage.model.Company;
import com.boan.crm.backstagemanage.model.Log;
import com.boan.crm.backstagemanage.service.ICompanyService;
import com.boan.crm.common.Message;
import com.boan.crm.customer.analysis.service.IAnalysisResultService;
import com.boan.crm.customer.analysis.service.IFuzzyInfoService;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.groupmanage.common.RoleFlag;
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.model.Role;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IRoleService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.sms.service.ISMSManageService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * 公司管理Action
 * 
 * @author YangGY
 * @version 1.0.0
 */
@Controller("companyAction")
@Scope("prototype")
public class CompanyAction extends BaseActionSupport {
	/**
	 * 公司Service
	 */
	@Autowired
	@Qualifier("companyService")
	private ICompanyService service = null;
	/**
	 * 部门Service
	 */
	@Autowired
	@Qualifier("deptService")
	private IDeptmentService deptService = null;
	/**
	 * 用户Service
	 */
	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;

	/**
	 * 角色Service
	 */
	@Autowired
	@Qualifier("roleService")
	private IRoleService roleService = null;

	/**
	 * 角色Service
	 */
	@Autowired
	@Qualifier("dataDictionaryService")
	private IDataDictionaryService dataDictionaryService = null;

	/**
	 * 短信Service
	 */
	@Autowired
	@Qualifier("SMSManageService")
	private ISMSManageService SMSManageService = null;
	
	/**
	 * 模糊项Service
	 */
	@Autowired
	@Qualifier("fuzzyInfoService")
	private IFuzzyInfoService fuzzyInfoService = null;
	/**
	 * 模糊项Service
	 */
	@Autowired
	@Qualifier("analysisResultService")
	private IAnalysisResultService analysisResultService = null;
	
	/**
	 * 显示分页
	 */
	private Pagination<Company> pagination = new Pagination<Company>();

	/**
	 * 页面对象
	 */
	private Company company = null;

	/**
	 * 所选对象的id
	 */
	private String[] ids = null;

	/**
	 * 提示
	 */
	private Message message = new Message();

	/**
	 * 公司列表
	 */
	private List<Company> companyList = null;
	/**
	 * 部门列表
	 */
	private List<Deptment> deptList = null;

	/**
	 * 短信服务激活标识
	 */
	private String smsActivation = null;
	
	/**
	 * 试用限制
	 */
	private String trialFlag = null;
	
	/**
	 * 产品列表
	 */
	private List<ProductType> productTypeList = ProductType.getProductTypeList();

	/**
	 * 显示公司列表
	 * 
	 * @return
	 */
	public String openCompany() throws Exception {
		pagination = service.findCompanyForPage(null, pagination);
		// 判断组下是否有部门
		if (pagination != null && pagination.getData() != null && pagination.getData().size() > 0) {
			List<Deptment> ls = null;
			int count = 0;
			for (int i = 0; i < pagination.getData().size(); i++) {
				ls = deptService.queryAllDeptmentsByCompanyId(pagination.getData().get(i).getId());
				if (ls != null && ls.size() > 0) {
					// 判断部门
					pagination.getData().get(i).setDeleteFlag(1);
				} else {
					// 判断公司下是否有直属用户
					count = userService.queryUserListCount(pagination.getData().get(i).getId(), null);
					if (count > 0) {
						pagination.getData().get(i).setDeleteFlag(1);

					}
				}
			}
		}
		return SUCCESS;
	}

	/**
	 * 打开添加页面
	 * 
	 * @return
	 */
	public String openAddCompany() {
		return SUCCESS;
	}

	/**
	 * 添加一个新公司
	 * 
	 * @return
	 */
	public String toAddCompany() {
		// 验证用户名是否重复
		boolean b = service.isExistSameName(company.getId(), company.getCompanyName());
		// 如果存在，则提示
		if (b) {
			message.setContent("相同公司名称已存在，请重新输入！");
			return ERROR;
		} else {
			if ("1".equals(smsActivation)) {
				// 公司短信服务状态
				company.setSmsActivationStatus(1);

				if (company.getSmsSN() != null && !company.getSmsSN().trim().equals("") && company.getSmsKey() != null && !company.getSmsKey().trim().equals("") && company.getSmsPassword() != null && !company.getSmsPassword().trim().equals("")) {
					SMSManageService.initClient(company.getSmsSN(), company.getSmsPassword(), company.getSmsKey());
					// 激活短信账号
					SMSManageService.activateAccount(company.getSmsPassword());
					// 关闭当前短信客户端连接
					SMSManageService.closeClientSocket();
				}
			} else {
				// 公司短信服务状态
				company.setSmsActivationStatus(0);

				if (company.getSmsSN() != null && !company.getSmsSN().trim().equals("") && company.getSmsKey() != null && !company.getSmsKey().trim().equals("")) {
					SMSManageService.initClient(company.getSmsSN(), company.getSmsPassword(), company.getSmsKey());
					// 注销短信账号
					SMSManageService.logoutAccount(company.getSmsSN(), company.getSmsKey());
					// 关闭当前短信客户端连接
					SMSManageService.closeClientSocket();
				}
			}
			//试用限制
			if( "1".equals(trialFlag) ){
				company.setTrialFlag(1);
			}else
			{
				company.setTrialFlag(0);
			}
			service.save(company);
			message.setContent("公司信息保存成功！");
			// 为新建的公司建一个公司管理员角色
			Role role = new Role();
			role.setCompanyId(company.getId());
			role.setCreateTime(Calendar.getInstance());
			role.setRoleName("公司管理员");
			role.setRoleKey(RoleFlag.GONG_SI_GUAN_LI_YUAN);
			role.setSortIndex(0);
			roleService.save(role);
			//创建一个默认部门领导角色
			Role deptRole = new Role();
			deptRole.setCompanyId(company.getId());
			deptRole.setCreateTime(Calendar.getInstance());
			deptRole.setRoleName("部门领导");
			deptRole.setRoleKey(RoleFlag.BU_MEN_LING_DAO);
			deptRole.setSortIndex(0);
			roleService.save(deptRole);
			//创建一个默认公司领导角色
			Role companyRole = new Role();
			companyRole.setCompanyId(company.getId());
			companyRole.setCreateTime(Calendar.getInstance());
			companyRole.setRoleName("公司领导");
			companyRole.setRoleKey(RoleFlag.GONG_SI_LING_DAO);
			companyRole.setSortIndex(0);
			roleService.save(companyRole);
			//创建一个默认业务员角色
			Role businessRole = new Role();
			businessRole.setCompanyId(company.getId());
			businessRole.setCreateTime(Calendar.getInstance());
			businessRole.setRoleName("业务员");
			businessRole.setRoleKey(RoleFlag.YE_WU_YUAN);
			businessRole.setSortIndex(0);
			roleService.save(businessRole);

			List<DataDictionary> dataDictionary = dataDictionaryService.findAllDataDictionaryByCompanyId("");
			if (dataDictionary != null && dataDictionary.size() > 0) {
				// 创建数据字典
				DataDictionary newObj = null;
				for (DataDictionary dd : dataDictionary) {
					newObj = new DataDictionary();
					newObj.setName(dd.getName());
					newObj.setRemark(dd.getRemark());
					newObj.setSortIndex(dd.getSortIndex());
					newObj.setCompanyId(company.getId());
					newObj.setTypeFlag(dd.getTypeFlag());
					dataDictionaryService.save(newObj);
				}
			}
			
			//创建模糊项和评估结论
			fuzzyInfoService.saveMainFuzzyInfoToCompany(company.getId());
			analysisResultService.saveMainFuzzyResultInfoToCompany(company.getId());
			
			// 保存日志开始
			Log log = new Log();
			log.setLogType(LogType.INFO);
			log.setLogContent("[" + company.getCompanyName() + "]" + "公司信息添加成功");
			super.saveLog(log);
			// 保存日志结束
			return SUCCESS;
		}
	}

	/**
	 * 打开修改公司信息页面
	 * 
	 * @return
	 */
	public String openModifyCompany() {
		String id = company.getId();
		company = service.get(id);
		return SUCCESS;
	}

	/**
	 * 修改公司信息
	 * 
	 * @return
	 */
	public String toModifyCompany() {
		// 验证用户名是否重复
		boolean b = service.isExistSameName(company.getId(), company.getCompanyName());
		// 如果存在，则提示
		if (b) {
			message.setContent("相同公司名称已存在，请重新输入！");
			return ERROR;
		} else {
			if ("1".equals(smsActivation)) {
				// 公司短信服务状态
				company.setSmsActivationStatus(1);
				if (company.getSmsSN() != null && !company.getSmsSN().trim().equals("") && company.getSmsKey() != null && !company.getSmsKey().trim().equals("") && company.getSmsPassword() != null && !company.getSmsPassword().trim().equals("")) {
					// 激活短信账号
					SMSManageService.initClient(company.getSmsSN(), company.getSmsPassword(), company.getSmsKey());
					SMSManageService.activateAccount(company.getSmsPassword());
					// 关闭当前短信客户端连接
					SMSManageService.closeClientSocket();
				}
			} else {
				// 公司短信服务状态
				company.setSmsActivationStatus(0);
				if (company.getSmsSN() != null && !company.getSmsSN().trim().equals("") && company.getSmsKey() != null && !company.getSmsKey().trim().equals("")) {
					SMSManageService.initClient(company.getSmsSN(), company.getSmsPassword(), company.getSmsKey());
					// 注销短信账号
					SMSManageService.logoutAccount(company.getSmsSN(), company.getSmsKey());
					// 关闭当前短信客户端连接
					SMSManageService.closeClientSocket();
				}
			}
			//试用限制
			if( "1".equals(trialFlag) ){
				company.setTrialFlag(1);
			}else
			{
				company.setTrialFlag(0);
			}
			service.update(company);
			message.setContent("公司信息保存成功！");
			List<DataDictionary> dataDictionary = dataDictionaryService.findAllDataDictionaryByCompanyId(StringUtils.trimToEmpty(company.getId()));
			if (dataDictionary != null && dataDictionary.size() > 0) {
				// 存在不维护了
			} else {
				// 创建数据字典
				List<DataDictionary> initObjs = dataDictionaryService.findAllDataDictionaryByCompanyId("");
				if (initObjs != null && initObjs.size() > 0) {
					DataDictionary newObj = null;
					for (DataDictionary dd : initObjs) {
						newObj = new DataDictionary();
						newObj.setName(dd.getName());
						newObj.setRemark(dd.getRemark());
						newObj.setSortIndex(dd.getSortIndex());
						newObj.setCompanyId(company.getId());
						newObj.setTypeFlag(dd.getTypeFlag());
						dataDictionaryService.save(newObj);
					}
				}
			}
			// 保存日志开始
			Log log = new Log();
			log.setLogType(LogType.INFO);
			log.setLogContent("[" + company.getCompanyName() + "]" + "公司信息保存成功");
			super.saveLog(log);
			// 保存日志结束
			return SUCCESS;
		}
	}

	/**
	 * 删除公司
	 * 
	 * @return
	 */
	public String deleteCompany() {
		// 保存日志开始
		if (ids != null && ids.length > 0) {
			Company com = null;
			Log log = null;
			for (int i = 0; i < ids.length; i++) {
				com = service.get(ids[i]);
				if (com != null) {
					log = new Log();
					log.setLogType(LogType.INFO);
					log.setLogContent("[" + com.getCompanyName() + "]" + "公司信息删除成功");
					super.saveLog(log);
				}
			}
		}
		// 保存日志结束
		service.deleteGroupCompany(ids);
		return NONE;
	}

	/**
	 * 获取所有公司列表
	 * 
	 * @return
	 */
	public String showCompanyTreeForUser() {
		companyList = service.queryAllCompanys();
		deptList = new ArrayList<Deptment>();
		if (companyList != null && companyList.size() > 0) {
			List<Deptment> ls = null;
			for (int i = 0; i < companyList.size(); i++) {
				ls = deptService.queryAllDeptmentsByCompanyId(companyList.get(i).getId());
				if (ls != null && ls.size() > 0) {
					deptList.addAll(ls);
				}
			}
		}
		return "company-tree-for-user";
	}

	/**
	 * 获取所有公司列表以及部门列表
	 * 
	 * @return
	 */
	public String showCompanyTreeForDept() {
		companyList = service.queryAllCompanys();
		deptList = new ArrayList<Deptment>();
		if (companyList != null && companyList.size() > 0) {
			List<Deptment> ls = null;
			for (int i = 0; i < companyList.size(); i++) {
				ls = deptService.queryAllDeptmentsByCompanyId(companyList.get(i).getId());
				if (ls != null && ls.size() > 0) {
					deptList.addAll(ls);
				}
			}
		}
		return "company-tree-for-dept";
	}

	/**
	 * 获取所有公司列表，用于维护角色
	 * 
	 * @return
	 */
	public String showCompanyTreeForRole() {
		companyList = service.queryAllCompanys();
		return "company-tree-for-role";
	}

	/**
	 * 获取所有公司列表，用于权限分配
	 * 
	 * @return
	 */
	public String showCompanyTreeForPopedom() {
		companyList = service.queryAllCompanys();
		return "company-tree-for-popedom";
	}

	/**
	 * 修改自己的公司档案
	 * 
	 * @return
	 */
	public String openMyCompanyAction() {
		if (StringUtils.isNotBlank(sessionCompanyId)) {
			company = service.get(sessionCompanyId);
			return "show-my-company";
		}
		return NONE;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Pagination<Company> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Company> pagination) {
		this.pagination = pagination;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	public List<Deptment> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Deptment> deptList) {
		this.deptList = deptList;
	}

	public String getSmsActivation() {
		return smsActivation;
	}

	public void setSmsActivation(String smsActivation) {
		this.smsActivation = smsActivation;
	}

	public String getTrialFlag() {
		return trialFlag;
	}

	public void setTrialFlag(String trialFlag) {
		this.trialFlag = trialFlag;
	}

	public List<ProductType> getProductTypeList() {
		return productTypeList;
	}

	public void setProductTypeList(List<ProductType> productTypeList) {
		this.productTypeList = productTypeList;
	}
}
