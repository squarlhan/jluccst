package com.boan.crm.sellrecord.service;

import java.math.BigDecimal;
import java.util.Map;

import com.boan.crm.sellrecord.model.SellRecord;
import com.boan.crm.utils.page.Pagination;

public interface ISellRecordService {

	/**
	 * 保存或就改销售记录相关信息
	 * @param record
	 */
	public void saveOrUpdate(SellRecord record);
	
	/**
	 * 根据销售记录Id查询销售记录信息
	 * @param id
	 * @return
	 */
	public SellRecord getSellRecordById(String id);
	
	/**
     * 分页查询销售记录
     * @return 记录数组
     */
	public Pagination<SellRecord> findSellRecordForPage(Map<String, ?> values, Pagination<SellRecord> pagination);
	
	/**
	 * 根据销售记录Id删除销售记录
	 * @param ids
	 */
	public void deleteSellRecordByIds(String... ids);
	
	/**
	 * 根据客户Id获取消费次数
	 * @param customerId
	 * @return
	 */
	public  int getConsumptionCount(String customerId);
	
	/**
	 * 根据客户Id获取消费金额
	 * @param customerId
	 * @return
	 */
	public  BigDecimal getConsumptionMoney(String customerId);
}