package com.boan.crm.purchase.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.common.Message;
import com.boan.crm.purchase.model.Repertory;
import com.boan.crm.purchase.service.IPurchaseBatchService;
import com.boan.crm.purchase.service.IPurchaseRecordService;
import com.boan.crm.purchase.service.IRepertoryService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * 库存清单
 * 
 * @author Administrator
 * 
 */
@Controller("repertoryAction")
@Scope("prototype")
public class RepertoryAction extends BaseActionSupport {

	@Resource
	private IPurchaseBatchService purchaseBatchService = null;
	@Resource
	private IPurchaseRecordService purchaseRecordService = null;
	@Resource
	private IRepertoryService repertoryService = null;

	private Pagination<Repertory> pagination = new Pagination<Repertory>();

	private Message message = new Message();

	private String companyId = null;

	/**
	 * 显示采购记录
	 * 
	 * @return
	 */
	public String showRepertoryList() throws Exception {
		companyId = sessionCompanyId;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		pagination = repertoryService.findForPage(map, pagination);
		// 供应商记录
		return SUCCESS;
	}

	public IPurchaseBatchService getPurchaseBatchService() {
		return purchaseBatchService;
	}

	public void setPurchaseBatchService(IPurchaseBatchService purchaseBatchService) {
		this.purchaseBatchService = purchaseBatchService;
	}

	public IPurchaseRecordService getPurchaseRecordService() {
		return purchaseRecordService;
	}

	public void setPurchaseRecordService(IPurchaseRecordService purchaseRecordService) {
		this.purchaseRecordService = purchaseRecordService;
	}

	public Pagination<Repertory> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Repertory> pagination) {
		this.pagination = pagination;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}
