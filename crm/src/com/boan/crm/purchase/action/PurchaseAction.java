package com.boan.crm.purchase.action;

import java.util.ArrayList;
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
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.goods.model.GoodsInfoBase;
import com.boan.crm.goods.model.GoodsType;
import com.boan.crm.goods.service.IGoodsInfoBaseService;
import com.boan.crm.goods.service.IGoodsTypeService;
import com.boan.crm.purchase.model.PurchaseBatch;
import com.boan.crm.purchase.model.PurchaseRecord;
import com.boan.crm.purchase.service.IPurchaseBatchService;
import com.boan.crm.purchase.service.IPurchaseRecordService;
import com.boan.crm.sellrecord.model.GoodsInfo;
import com.boan.crm.sellrecord.service.IGoodsInfoService;
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
@Controller("purchaseAction")
@Scope("prototype")
public class PurchaseAction extends BaseActionSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2674338931674827758L;

	@Resource
	private IPurchaseBatchService purchaseBatchService = null;
	@Resource
	private IPurchaseRecordService purchaseRecordService = null;
	@Resource
	private ICompanyService companyService = null;
	@Resource
	private ISupplierService supplierService = null;
	@Resource
	private IGoodsTypeService goodsTypeService = null;
	@Resource
	private IGoodsInfoBaseService goodsInfoBaseService = null;

	private Pagination<PurchaseBatch> pagination = new Pagination<PurchaseBatch>();

	private Pagination<PurchaseRecord> paginationRecord = new Pagination<PurchaseRecord>();

	private PurchaseBatch purchaseBatch = null;

	private PurchaseRecord purchaseRecord = null;

	private Message message = new Message();

	private String companyId = null;

	private String[] purchaseBatchIds = null;

	private String[] purchaseRecordIds = null;

	private List<Supplier> supplierList = null;

	private String isArrive = null;

	private String isSettleAccount = null;

	private List<GoodsType> productTypeList = null;

	private List<GoodsInfoBase> productList = null;

	private String productId = null;

	private String productTypeId = null;
	
	private String changeFlag = null;

	/**
	 * 显示采购记录
	 * 
	 * @return
	 */
	public String showPurchaseRecordList() throws Exception {
		companyId = sessionCompanyId;
		if (StringUtils.isBlank(purchaseRecord.getBatchId())) {
			purchaseBatch = new PurchaseBatch();
			paginationRecord = new Pagination<PurchaseRecord>();
		} else {
			purchaseBatch = purchaseBatchService.get(purchaseRecord.getBatchId());
			// 提取采购记录
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("batchId", purchaseRecord.getBatchId());
			paginationRecord = purchaseRecordService.findForPage(map, paginationRecord);
		}
		// 供应商记录
		supplierList = supplierService.queryList(companyId);
		return SUCCESS;
	}

	/**
	 * 保存批次
	 * 
	 * @return
	 */
	public String savePurchaseBatch() throws Exception {
		Date date = new Date();
		if (StringUtils.isBlank(purchaseBatch.getId())) {
			purchaseBatch.setId(null);
		}
		purchaseBatch.setCompanyId(sessionCompanyId);
		purchaseBatch.setCompanyName(sessionCompanyName);
		purchaseBatch.setUserId(sessionUserId);
		purchaseBatch.setUserName(sessionUserCName);
		purchaseBatch.setCreateTime(date);
		// 保存状态
		if ("1".equals(isArrive)) {
			purchaseBatch.setIsArrive(1);
		} else {
			purchaseBatch.setIsArrive(0);
		}
		if ("1".equals(isSettleAccount)) {
			purchaseBatch.setIsSettleAccount(1);
		} else {
			purchaseBatch.setIsSettleAccount(0);
		}
		// 保存供应商信息
		Supplier su = supplierService.get(purchaseBatch.getSupplierId());
		if (su != null) {
			purchaseBatch.setSupplierName(su.getSupplierName());
			purchaseBatch.setSupplierNumber(su.getSupplierNumber());
		}
		try {
			purchaseBatchService.saveOrUpdate(purchaseBatch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		message.setContent("采购批次信息保存成功！");
		// 保存日志开始
		Log log = new Log();
		log.setLogType(LogType.INFO);
		log.setLogContent("[" + purchaseBatch.getBatchName() + "]" + "供应商采购批次信息保存成功");
		super.saveLog(log);
		// 保存日志结束
		purchaseRecord = new PurchaseRecord();
		purchaseRecord.setBatchId(purchaseBatch.getId());
		return this.showPurchaseRecordList();
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
		if (pagination != null && pagination.getData() != null && pagination.getData().size() > 0) {
			for (int i = 0; i < pagination.getData().size(); i++) {
				// 数组长度为四，0-3，分别表示：总运费，总应付款，总实付款，总欠款
				Object[] objects = purchaseRecordService.queryRecordSum(pagination.getData().get(i).getId());
				if (objects != null && objects.length > 0) {
					// 总运费暂时不用显示到页面上
					if (objects[1] != null) {
						pagination.getData().get(i).setTotalAccountPayable(Float.parseFloat(objects[1].toString()));
					}
					if (objects[2] != null) {
						pagination.getData().get(i).setTotalActualPayment(Float.parseFloat(objects[2].toString()));
					}
					if (objects[3] != null) {
						pagination.getData().get(i).setTotalAmountInArrear(Float.parseFloat(objects[3].toString()));
					}
				}
			}
		}
		return SUCCESS;
	}

	/**
	 * 删除批次
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
		purchaseRecordService.deleteByBatchIds(purchaseBatchIds);
		return NONE;
	}

	/**
	 * 删除记录
	 * 
	 * @return
	 */
	public String deletePurchaseRecord() throws Exception {
		if (purchaseRecordIds != null && purchaseRecordIds.length > 0) {
			PurchaseRecord purchaseRecord = null;
			Log log = null;
			for (int i = 0; i < purchaseRecordIds.length; i++) {
				purchaseRecord = purchaseRecordService.get(purchaseRecordIds[i]);
				if (purchaseRecord != null) {
					log = new Log();
					log.setLogType(LogType.INFO);
					log.setLogContent("[" + purchaseRecord.getProductName() + "]" + "采购记录删除成功");
					super.saveLog(log);
				}
			}
		}
		purchaseRecordService.delete(purchaseRecordIds);
		return NONE;
	}

	/**
	 * 显示采购记录
	 * 
	 * @return
	 */
	public String showPurchaseRecordInfo() {
		String batchId = purchaseRecord.getBatchId();
		productId = purchaseRecord.getProductId();
		productTypeId = purchaseRecord.getProductType();
		if (StringUtils.isBlank(purchaseRecord.getId())) {
		} else {
			purchaseRecord = purchaseRecordService.get(purchaseRecord.getId());
			purchaseRecord.setBatchId(batchId);
			if (StringUtils.isNotBlank(productId)) {
				purchaseRecord.setProductId(productId);
			}
			if (StringUtils.isNotBlank(productTypeId)) {
				purchaseRecord.setProductType(productTypeId);
			}
		}
		// 赋规格和单价
		if (StringUtils.isNotBlank(purchaseRecord.getProductId())) {
			if (StringUtils.isBlank(purchaseRecord.getId()) || StringUtils.isNotBlank(changeFlag) ) {
				GoodsInfoBase base = goodsInfoBaseService.get(purchaseRecord.getProductId());
				if (base != null) {
					purchaseRecord.setSpecification(base.getGoodsStandard());
					purchaseRecord.setUnitPrice(Float.parseFloat(base.getGoodsPrice()));
				}
			}
		}
		// 显示产品列表
		/*
		 * productList =
		 * dataDictionaryService.findDataDictionaryByType(sessionCompanyId, 8);
		 * if (productList == null) { productList = new
		 * ArrayList<DataDictionary>(); }
		 */
		productTypeList = goodsTypeService.findAllGoodsType(sessionCompanyId);
		if (productTypeList == null) {
			productTypeList = new ArrayList<GoodsType>();
		}
		if (StringUtils.isNotBlank(purchaseRecord.getProductType())) {
			productList = goodsInfoBaseService.findGoodsInfoBaseByGoodsTypeId(purchaseRecord.getProductType());
		}
		if (productList == null) {
			productList = new ArrayList<GoodsInfoBase>();
		}
		return SUCCESS;
	}

	/**
	 * 保存采购记录
	 * 
	 * @return
	 */
	public String savePurchaseRecord() {
		Date date = new Date();
		if (StringUtils.isBlank(purchaseRecord.getId())) {
			purchaseRecord.setId(null);
		}
		purchaseRecord.setCompanyId(sessionCompanyId);
		// 获取产品名称
		GoodsInfoBase product = goodsInfoBaseService.get(purchaseRecord.getProductId());
		if (product != null) {
			purchaseRecord.setProductName(product.getName());
		} else {
			purchaseRecord.setProductName("未知产品");
		}
		// 获取供应商信息
		PurchaseBatch batch = purchaseBatchService.get(purchaseRecord.getBatchId());
		if (batch != null) {

			purchaseRecord.setSupplierId(batch.getSupplierId());
			purchaseRecord.setSupplierName(batch.getSupplierName());
			purchaseRecord.setSupplierNumber(batch.getSupplierNumber());
		}

		purchaseRecord.setCreateTime(date);
		try {
			purchaseRecordService.saveOrUpdate(purchaseRecord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		message.setContent("采购记录保存成功！");
		// 保存日志开始
		Log log = new Log();
		log.setLogType(LogType.INFO);
		log.setLogContent("[" + purchaseRecord.getProductName() + "]" + "采购记录保存成功");
		super.saveLog(log);
		// 保存日志结束
		return SUCCESS;
	}

	/**
	 * 用于库存清单显示详细记录用
	 * 
	 * @return
	 */
	public String showPurchaseDetail() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productId", productId);
		map.put("companyId", sessionCompanyId);
		paginationRecord = purchaseRecordService.findPorductDetailListForPage(map, paginationRecord);
		return SUCCESS;
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

	public IPurchaseRecordService getPurchaseRecordService() {
		return purchaseRecordService;
	}

	public void setPurchaseRecordService(IPurchaseRecordService purchaseRecordService) {
		this.purchaseRecordService = purchaseRecordService;
	}

	public PurchaseRecord getPurchaseRecord() {
		return purchaseRecord;
	}

	public void setPurchaseRecord(PurchaseRecord purchaseRecord) {
		this.purchaseRecord = purchaseRecord;
	}

	public ISupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(ISupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public List<Supplier> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<Supplier> supplierList) {
		this.supplierList = supplierList;
	}

	public Pagination<PurchaseRecord> getPaginationRecord() {
		return paginationRecord;
	}

	public void setPaginationRecord(Pagination<PurchaseRecord> paginationRecord) {
		this.paginationRecord = paginationRecord;
	}

	public String[] getPurchaseRecordIds() {
		return purchaseRecordIds;
	}

	public void setPurchaseRecordIds(String[] purchaseRecordIds) {
		this.purchaseRecordIds = purchaseRecordIds;
	}

	public String getIsArrive() {
		return isArrive;
	}

	public void setIsArrive(String isArrive) {
		this.isArrive = isArrive;
	}

	public String getIsSettleAccount() {
		return isSettleAccount;
	}

	public void setIsSettleAccount(String isSettleAccount) {
		this.isSettleAccount = isSettleAccount;
	}

	public List<GoodsInfoBase> getProductList() {
		return productList;
	}

	public void setProductList(List<GoodsInfoBase> productList) {
		this.productList = productList;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public IGoodsTypeService getGoodsTypeService() {
		return goodsTypeService;
	}

	public void setGoodsTypeService(IGoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}

	public List<GoodsType> getProductTypeList() {
		return productTypeList;
	}

	public void setProductTypeList(List<GoodsType> productTypeList) {
		this.productTypeList = productTypeList;
	}

	public IGoodsInfoBaseService getGoodsInfoBaseService() {
		return goodsInfoBaseService;
	}

	public void setGoodsInfoBaseService(IGoodsInfoBaseService goodsInfoBaseService) {
		this.goodsInfoBaseService = goodsInfoBaseService;
	}

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getChangeFlag() {
		return changeFlag;
	}

	public void setChangeFlag(String changeFlag) {
		this.changeFlag = changeFlag;
	}

}
