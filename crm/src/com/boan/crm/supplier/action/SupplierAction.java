package com.boan.crm.supplier.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.backstagemanage.service.ICompanyService;
import com.boan.crm.common.Message;
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

	private String supplierId = null;

	private String[] supplierIds = null;

	/**
	 * 显示供应商
	 * 
	 * @return
	 */
	public String showSupplierInfo() {
		supplier = supplierService.get(supplierId);
		return SUCCESS;
	}

	/**
	 * 保存供应商
	 * 
	 * @return
	 */
	public String saveSupplier() {
		Date date = new Date();
		supplier.setUserId(sessionUserId);
		supplier.setUserName(sessionUserCName);
		supplier.setCreateTime(date);
		supplierService.save(supplier);
		return SUCCESS;
	}

	/**
	 * 显示供应商列表
	 * 
	 * @return
	 */
	public String showSupplierList() throws Exception {
		supplierList = supplierService.queryList(companyId);
		return SUCCESS;
	}

	/**
	 * 删除供应商
	 * 
	 * @return
	 */
	public String deleteSupplier() {
		supplierService.delete(supplierIds);
		return SUCCESS;
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

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
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
