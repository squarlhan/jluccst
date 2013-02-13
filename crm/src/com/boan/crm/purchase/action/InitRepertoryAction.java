package com.boan.crm.purchase.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.common.Message;
import com.boan.crm.purchase.model.InitRepertory;
import com.boan.crm.purchase.model.Repertory;
import com.boan.crm.purchase.service.IInitRepertoryService;
import com.boan.crm.purchase.service.IPurchaseBatchService;
import com.boan.crm.purchase.service.IPurchaseRecordService;
import com.boan.crm.purchase.service.IRepertoryService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * 初始库存
 * 
 * @author Administrator
 * 
 */
@Controller("initRepertoryAction")
@Scope("prototype")
public class InitRepertoryAction extends BaseActionSupport {

	private static final long serialVersionUID = 8647018776119896946L;
	@Resource
	private IInitRepertoryService initRepertoryService = null;

	private Pagination<InitRepertory> pagination = new Pagination<InitRepertory>();

	private Message message = new Message();

	private InitRepertory initRepertory = null;

	private String[] ids = null;

	private String companyId = null;

	/**
	 * 显示初始库存列表
	 * 
	 * @return
	 */
	public String showInitRepertoryList() throws Exception {
		companyId = sessionCompanyId;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		pagination = initRepertoryService.findForPage(map, pagination);
		return "show-init-info-list";
	}

	/**
	 * 显示录入界面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showInitRepertoryInfo() throws Exception {
		if( StringUtils.isNotBlank(initRepertory.getId()) ){
			initRepertory = initRepertoryService.get(initRepertory.getId());
		}
		if(  initRepertory  == null) {
			initRepertory = new InitRepertory();
		}
		return "show-init-info";
	}

	/**
	 * 保存初始库存
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveInitRepertoryInfo() throws Exception {
		initRepertory.setCompanyId(sessionCompanyId);
		Calendar cal = Calendar.getInstance();
		initRepertory.setCreateTime(cal);
		initRepertoryService.save(initRepertory);
		message.setContent("数据保存成功！");
		return "save-success";
	}

	/**
	 * 删除初始库存
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteInitRepertory() throws Exception {
		initRepertoryService.delete(ids);
		return this.showInitRepertoryList();
	}

	public Pagination<InitRepertory> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<InitRepertory> pagination) {
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

	public IInitRepertoryService getInitRepertoryService() {
		return initRepertoryService;
	}

	public void setInitRepertoryService(IInitRepertoryService initRepertoryService) {
		this.initRepertoryService = initRepertoryService;
	}

	public InitRepertory getInitRepertory() {
		return initRepertory;
	}

	public void setInitRepertory(InitRepertory initRepertory) {
		this.initRepertory = initRepertory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}
}
