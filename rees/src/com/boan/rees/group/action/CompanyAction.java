package com.boan.rees.group.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.group.model.Company;
import com.boan.rees.group.service.ICompanyService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;

@Controller("companyAction")
@Scope("prototype")
public class CompanyAction extends BaseActionSupport{	
	@Autowired
	@Qualifier("companyService")
	private ICompanyService service;
	/**
	 * 显示分页
	 */
	Pagination<Company> pagination = new Pagination<Company>();		
	/**
	 * 页面对象
	 */
	private Company company;
	/**
	 * 所选对象的id
	 */
	String[] ids;
	
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

	//*********************操作*************************************
	/**
	 * 显示公司列表
	 * @return
	 */	
	public String openCompany(){
		pagination = service.findCompanyForPage(null, pagination);
		return SUCCESS;
	}	
	/**
	 * 打开添加页面
	 * @return
	 */
	public String openAddCompany(){
		return SUCCESS;
	}
	/**
	 * 添加一个新公司
	 * @return
	 */
	public String toAddCompany(){
			service.save(company);
		return SUCCESS;
	}
	/**
	 * 打开修改公司信息页面
	 * @return
	 */
	public String openModifyCompany(){
		String id= company.getId();
		company=service.get(id);
		return SUCCESS;
	}
	/**
	 * 修改公司信息
	 * @return
	 */
	public String toModifyCompany(){
		service.update(company);
		return SUCCESS;
	}
	/**
	 * 删除公司
	 * @return
	 */
	public String deleteCompany(){
		service.deleteGroupCompany(ids);
		return NONE;
	}
}
