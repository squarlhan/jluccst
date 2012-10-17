package com.boan.crm.purchase.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.backstagemanage.common.LogType;
import com.boan.crm.backstagemanage.model.Log;
import com.boan.crm.backstagemanage.service.ICompanyService;
import com.boan.crm.common.Message;
import com.boan.crm.purchase.model.PurchaseBatch;
import com.boan.crm.purchase.service.IPurchaseBatchService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * 供应商维护
 * 
 * @author Administrator
 * 
 */
@Controller("purchaseBatchAction")
@Scope("prototype")
public class PurchaseAction extends BaseActionSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2674338931674827758L;

	@Resource
	private IPurchaseBatchService purchaseBatchService = null;

	@Resource
	private ICompanyService companyService = null;

	private Pagination<PurchaseBatch> pagination = new Pagination<PurchaseBatch>();

	private PurchaseBatch purchaseBatch = null;

	private Message message = new Message();

	private String companyId = null;

	private String[] purchaseBatchIds = null;

	/**
	 * 显示供应商
	 * 
	 * @return
	 */
	public String showPurchaseBatchInfo() {
		if (StringUtils.isBlank(purchaseBatch.getId())) {
			purchaseBatch = new PurchaseBatch();
		} else {
			purchaseBatch = purchaseBatchService.get(purchaseBatch.getId());
		}
		return SUCCESS;
	}

	/**
	 * 保存供应商
	 * 
	 * @return
	 */
	public String savePurchaseBatch() {
		Date date = new Date();
		if (StringUtils.isBlank(purchaseBatch.getId())) {
			purchaseBatch.setId(null);
		}
		purchaseBatch.setCompanyId(sessionCompanyId);
		purchaseBatch.setCompanyName(sessionCompanyName);
		purchaseBatch.setUserId(sessionUserId);
		purchaseBatch.setUserName(sessionUserCName);
		purchaseBatch.setCreateTime(date);
		try {
			purchaseBatchService.saveOrUpdate(purchaseBatch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		message.setContent("供应商信息保存成功！");
		// 保存日志开始
		Log log = new Log();
		log.setLogType(LogType.INFO);
		log.setLogContent("[" + purchaseBatch.getBatchName() + "]" + "供应信息保存成功");
		super.saveLog(log);
		// 保存日志结束
		return SUCCESS;
	}

	/**
	 * 显示供应商列表
	 * 
	 * @return
	 */
	public String showPurchaseBatchList() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		companyId = sessionCompanyId;
		map.put("companyId", companyId);
		pagination = purchaseBatchService.findForPage(map, pagination);
		return SUCCESS;
	}

	/**
	 * 删除供应商
	 * 
	 * @return
	 */
	public String deletePurchaseBatch() throws Exception {
		if (purchaseBatchIds != null && purchaseBatchIds.length > 0) {
			PurchaseBatch purchaseBatch = null;
			Log log = null;
			for (int i = 0; i < purchaseBatchIds.length; i++) {
				purchaseBatch = purchaseBatchService.get(purchaseBatchIds[i]);
				if (purchaseBatch != null) {
					log = new Log();
					log.setLogType(LogType.INFO);
					log.setLogContent("[" + purchaseBatch.getBatchName() + "]" + "信息删除成功");
					super.saveLog(log);
				}
			}
		}
		purchaseBatchService.delete(purchaseBatchIds);
		return NONE;
	}

	public IPurchaseBatchService getPurchaseBatchService() {
		return purchaseBatchService;
	}

	public void setPurchaseBatchService(IPurchaseBatchService purchaseBatchService) {
		this.purchaseBatchService = purchaseBatchService;
	}

	public ICompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}

	public Pagination<PurchaseBatch> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<PurchaseBatch> pagination) {
		this.pagination = pagination;
	}

	public PurchaseBatch getPurchaseBatch() {
		return purchaseBatch;
	}

	public void setPurchaseBatch(PurchaseBatch purchaseBatch) {
		this.purchaseBatch = purchaseBatch;
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

	public String[] getPurchaseBatchIds() {
		return purchaseBatchIds;
	}

	public void setPurchaseBatchIds(String[] purchaseBatchIds) {
		this.purchaseBatchIds = purchaseBatchIds;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
