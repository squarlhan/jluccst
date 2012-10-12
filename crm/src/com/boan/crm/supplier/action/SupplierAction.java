package com.boan.crm.supplier.action;

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
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.supplier.model.Supplier;
import com.boan.crm.supplier.service.ISupplierService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * 供应商维护
 * 
 * @author Administrator
 * 
 */
@Controller("supplierAction")
@Scope("prototype")
public class SupplierAction extends BaseActionSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2674338931674827758L;

	@Resource
	private ISupplierService supplierService = null;

	@Resource
	private ICompanyService companyService = null;

	private Pagination<Supplier> pagination = new Pagination<Supplier>();

	private Supplier supplier = null;

	private List<Supplier> supplierList = null;

	private Message message = new Message();

	private String companyId = null;

	private String[] supplierIds = null;

	/**
	 * 显示供应商
	 * 
	 * @return
	 */
	public String showSupplierInfo() {
		if (StringUtils.isBlank(supplier.getId())) {
			supplier = new Supplier();
		} else {
			supplier = supplierService.get(supplier.getId());
		}
		return SUCCESS;
	}

	/**
	 * 保存供应商
	 * 
	 * @return
	 */
	public String saveSupplier() {
		Date date = new Date();
		if (StringUtils.isBlank(supplier.getId())) {
			supplier.setId(null);
		}
		supplier.setCompanyId(sessionCompanyId);
		supplier.setCompanyName(sessionCompanyName);
		supplier.setUserId(sessionUserId);
		supplier.setUserName(sessionUserCName);
		supplier.setCreateTime(date);
		try {
			supplierService.saveOrUpdate(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		message.setContent("供应商信息保存成功！");
		// 保存日志开始
		Log log = new Log();
		log.setLogType(LogType.INFO);
		log.setLogContent("[" + supplier.getSupplierName() + "]" + "供应信息保存成功");
		super.saveLog(log);
		// 保存日志结束
		return SUCCESS;
	}

	/**
	 * 显示供应商列表
	 * 
	 * @return
	 */
	public String showSupplierList() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		companyId = sessionCompanyId;
		map.put("companyId", companyId);
		pagination = supplierService.findForPage(map, pagination);
		return SUCCESS;
	}

	/**
	 * 删除供应商
	 * 
	 * @return
	 */
	public String deleteSupplier() throws Exception {
		if (supplierIds != null && supplierIds.length > 0) {
			Supplier supplier = null;
			Log log = null;
			for (int i = 0; i < supplierIds.length; i++) {
				supplier = supplierService.get(supplierIds[i]);
				if (supplier != null) {
					log = new Log();
					log.setLogType(LogType.INFO);
					log.setLogContent("[" + supplier.getSupplierName() + "]" + "信息删除成功");
					super.saveLog(log);
				}
			}
		}
		supplierService.delete(supplierIds);
		return NONE;
	}

	public Pagination<Supplier> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Supplier> pagination) {
		this.pagination = pagination;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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

	public List<Supplier> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<Supplier> supplierList) {
		this.supplierList = supplierList;
	}

	public String[] getSupplierIds() {
		return supplierIds;
	}

	public void setSupplierIds(String[] supplierIds) {
		this.supplierIds = supplierIds;
	}

}
