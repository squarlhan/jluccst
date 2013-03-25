package com.boan.crm.purchase.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.common.Message;
import com.boan.crm.goods.model.GoodsInfoBase;
import com.boan.crm.goods.model.GoodsType;
import com.boan.crm.goods.service.IGoodsInfoBaseService;
import com.boan.crm.goods.service.IGoodsTypeService;
import com.boan.crm.purchase.model.InitRepertory;
import com.boan.crm.purchase.service.IInitRepertoryService;
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
	@Resource
	private IGoodsTypeService goodsTypeService = null;
	@Resource
	private IGoodsInfoBaseService goodsInfoBaseService = null;

	private Pagination<InitRepertory> pagination = new Pagination<InitRepertory>();

	private Message message = new Message();

	private InitRepertory initRepertory = null;

	private String[] ids = null;

	private String companyId = null;

	private List<GoodsType> productTypeList = null;

	private List<GoodsInfoBase> productList = null;

	private String productId = null;

	private String productTypeId = null;

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
		productId = initRepertory.getProductId();
		productTypeId = initRepertory.getProductType();

		if (StringUtils.isNotBlank(initRepertory.getId())) {
			initRepertory = initRepertoryService.get(initRepertory.getId());
		}
		if (initRepertory == null) {
			initRepertory = new InitRepertory();
		}

		if (StringUtils.isBlank(initRepertory.getId())) {
		} else {
			if (StringUtils.isNotBlank(productId)) {
				initRepertory.setProductId(productId);
			}
			if (StringUtils.isNotBlank(productTypeId)) {
				initRepertory.setProductType(productTypeId);
			}
		}

		productTypeList = goodsTypeService.findAllGoodsType(sessionCompanyId);
		if (productTypeList == null) {
			productTypeList = new ArrayList<GoodsType>();
		}
		if (StringUtils.isNotBlank(initRepertory.getProductType())) {
			productList = goodsInfoBaseService.findGoodsInfoBaseByGoodsTypeId(initRepertory.getProductType());
		}
		if (productList == null) {
			productList = new ArrayList<GoodsInfoBase>();
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
		// 获取产品名称
		GoodsInfoBase product = goodsInfoBaseService.get(initRepertory.getProductId());
		if (product != null) {
			initRepertory.setProductName(product.getName());
		} else {
			initRepertory.setProductName("未知产品");
		}
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

	public IGoodsTypeService getGoodsTypeService() {
		return goodsTypeService;
	}

	public void setGoodsTypeService(IGoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}

	public IGoodsInfoBaseService getGoodsInfoBaseService() {
		return goodsInfoBaseService;
	}

	public void setGoodsInfoBaseService(IGoodsInfoBaseService goodsInfoBaseService) {
		this.goodsInfoBaseService = goodsInfoBaseService;
	}

	public List<GoodsType> getProductTypeList() {
		return productTypeList;
	}

	public void setProductTypeList(List<GoodsType> productTypeList) {
		this.productTypeList = productTypeList;
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

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}
}
