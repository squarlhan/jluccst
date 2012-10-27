package com.boan.crm.finance.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.backstagemanage.common.LogType;
import com.boan.crm.backstagemanage.model.Log;
import com.boan.crm.common.Message;
import com.boan.crm.finance.model.Finance;
import com.boan.crm.finance.service.IFinanceService;
import com.boan.crm.purchase.model.PurchaseBatch;
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

	private IFinanceService financeService = null;

	private Pagination<Finance> pagination = new Pagination<Finance>();

	private String beginDate;
	
	private String endDate;
	
	private Message message = new Message();

	private String[] financeIds = null;

	/**
	 * 显示供应商列表
	 * 
	 * @return
	 */
	public String showFinanceList() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", sessionCompanyId);
		pagination = financeService.findForPage(map, pagination);
		return SUCCESS;
	}

	/**
	 * 保存
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveFinance() throws Exception {
		Finance finance = new Finance();
		finance.setCompanyId(sessionCompanyId);
		Date date = new Date();
		finance.setCreateTime(date);
		financeService.saveOrUpdate(finance);
		message.setContent("财务清单保存成功！");
		// 保存日志开始
		Log log = new Log();
		log.setLogType(LogType.INFO);
		log.setLogContent("[" + finance.getBeginDate() + "-" + finance.getEndDate() + "]" + "财务清单保存成功");
		super.saveLog(log);
		
		return this.showFinanceList();
	}

	/**
	 * 删除记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteFinance() throws Exception {
		if (financeIds != null && financeIds.length > 0) {
			Finance finance = null;
			Log log = null;
			for (int i = 0; i < financeIds.length; i++) {
				finance = financeService.get(financeIds[i]);
				if (finance != null) {
					log = new Log();
					log.setLogType(LogType.INFO);
					log.setLogContent("[" + finance.getBeginDate() + "-" + finance.getEndDate() + "]" + "财务清单删除成功");
					super.saveLog(log);
				}
			}
		}
		financeService.delete(financeIds);
		return this.showFinanceList();
	}

	public Pagination<Finance> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Finance> pagination) {
		this.pagination = pagination;
	}

	public IFinanceService getFinanceService() {
		return financeService;
	}

	public void setFinanceService(IFinanceService financeService) {
		this.financeService = financeService;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String[] getFinanceIds() {
		return financeIds;
	}

	public void setFinanceIds(String[] financeIds) {
		this.financeIds = financeIds;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
