package com.boan.crm.finance.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.utils.action.BaseActionSupport;

/**
 * 财务清单
 * 
 * @author Administrator
 * 
 */
@Controller("financeAction")
@Scope("prototype")
public class FinanceAction extends BaseActionSupport {
	/**
	 * 显示供应商列表
	 * 
	 * @return
	 */
	public String showFinanceList() throws Exception {
		//Map<String, Object> map = new HashMap<String, Object>();
		return SUCCESS;
	}
}
