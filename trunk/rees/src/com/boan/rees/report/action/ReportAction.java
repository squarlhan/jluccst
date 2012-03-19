package com.boan.rees.report.action;

import java.util.ArrayList;
import java.util.Calendar;
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
	 * 分页列表
	 */
	Pagination<PersonReport> pagination = new Pagination<PersonReport>();
	
	@Autowired
	@Qualifier("personReportService")
	private IPersonReportService personReportService;
	
	/**
	 * 显示设备列表
	 * @return
	 */
	public String openReport(){
//		Map<String,String> values =new HashMap<String, String>();
//		values.put("dataInfo","90");
		List<PersonReport> li = new ArrayList<PersonReport>();
		PersonReport p = new PersonReport();
		p.setReportPerson("eeee");
		p.setReportDate(Calendar.getInstance());
		li.add(p);
		pagination.setData(li);
		//pagination = personReportService.findPersonReportForPage(null, pagination);
		return this.SUCCESS;
	}

	public Pagination<PersonReport> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<PersonReport> pagination) {
		this.pagination = pagination;
	}


}
