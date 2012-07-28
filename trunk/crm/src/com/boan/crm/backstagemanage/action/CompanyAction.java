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
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.backstagemanage.common.LogType;
import com.boan.crm.backstagemanage.model.Company;
import com.boan.crm.backstagemanage.model.Log;
import com.boan.crm.backstagemanage.service.ICompanyService;
import com.boan.crm.common.Message;
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.service.IDeptmentService;
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
	 * 显示公司列表
	 * 
	 * @return
	 */
	public String openCompany() {
		pagination = service.findCompanyForPage(null, pagination);
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
			service.save(company);
			message.setContent("公司信息保存成功！");
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
			service.update(company);
			message.setContent("公司信息保存成功！");
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
}
