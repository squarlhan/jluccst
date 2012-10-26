package com.boan.crm.finance.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.finance.model.Finance;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * 财务清单
 * 
 * @author Administrator
 * 
 */
@Controller("financeAction")
@Scope("prototype")
public class FinanceAction extends BaseActionSupport {

	private Pagination<Finance> pagination = new Pagination<Finance>();

	/**
	 * 显示供应商列表
	 * 
	 * @return
	 */
	public String showFinanceList() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", sessionCompanyId);
		
		return SUCCESS;
	}

	public Pagination<Finance> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Finance> pagination) {
		this.pagination = pagination;
	}
}
