package com.boan.rees.report.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.report.model.PersonReport;
import com.boan.rees.report.service.IPersonReportService;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 报表Action
 * @author zhaomengxue
 * @version 1.0.0
 */

@Controller("reportAction")
@Scope("prototype")
public class ReportAction extends ActionSupport{
	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("personReportService")
	private IPersonReportService service;
	/**
	 * 分页列表
	 */
	Pagination<PersonReport> pagination = new Pagination<PersonReport>();
	/**
	 * 页面对象
	 */
	private PersonReport report;
	/**
	 * 页面所选行的id
	 */
	private String[] ids;

	

	
	public PersonReport getReport() {
		return report;
	}

	public void setReport(PersonReport report) {
		this.report = report;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}
	
	public Pagination<PersonReport> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<PersonReport> pagination) {
		this.pagination = pagination;
	}


	/**
	 * 分页显示报表列表
	 * @return
	 */
	public String openReport(){
		pagination = service.findPersonReportForPage(new HashMap(), pagination);
		return this.SUCCESS;
	}

	
    /**
	 * 添加新报表
	 * @return
	 */
	public String toAddReport(){
		
		service.save(report);
		return SUCCESS;
	}
	/**
	 * 打开添加新报表页
	 * @return
	 */
	
	public String openAddReport (){
		return SUCCESS;
	}

	/**
	 * 删除报表数据
	 * @return
	 */
	public String deleteReport(){
		service.deletePersonReport(ids);
		return NONE;
	}
	
	/**
	 * 为修改报表页面做准备
	 * @return
	 */
	public String openModifyReport(){
		String id = report.getId();
		report = service.get(id);
		return SUCCESS;
	}
	
	/**
	 * 修改报表信息
	 * @return 
	 */
	public String toModifyReport(){
		
		service.update(report);
		return SUCCESS;
	}
	

	
}



