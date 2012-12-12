package com.boan.crm.sellreport.sellduty.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.sellreport.sellduty.model.SellDuty;
import com.boan.crm.utils.page.Pagination;

/**
 * @author YF
 *
 */
public interface ISellDutyService {

	/**
	 * 保存或修改销售职责
	 * @param SellDuty
	 */
	public void saveOrUpdateSellDuty(SellDuty SellDuty);
	
	 /**
	  * 通过Id删除销售职责
	  * @param id
	  */
	public void deleteSellDuty(String... id);
	
	/**
	 * 通过id查询销售职责
	 * @param id
	 */
	public SellDuty getSellDutyById(String id);
	
	/**
	 * 按分页查询销售职责
	 */
	public Pagination<SellDuty> findSellDutyForPage( Map<String, ?> values, Pagination<SellDuty> pagination);
	
	/**
	 * 查询本公司的所有销售职责
	 */
	public List<SellDuty> findAllSellDutyByCompanyId(String companyId);
}
