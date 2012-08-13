package com.boan.crm.marketinquiry.service;

import java.util.Map;

import com.boan.crm.marketinquiry.model.MarketInquiry;
import com.boan.crm.utils.page.Pagination;

public interface IMarketInquiryService {

	/**
	 * 保存或修改市场调查
	 * @param MarketInquiry
	 */
	public void saveOrUpdateMarketInquiry(MarketInquiry MarketInquiry);
	
	 /**
	  * 通过Id删除市场调查
	  * @param id
	  */
	public void deleteMarketInquiry(String... id);
	
	/**
	 * 通过id查询市场调查
	 * @param id
	 */
	public MarketInquiry getMarketInquiryById(String id);
	
	/**
	 * 按分页查询市场调查
	 */
	public Pagination<MarketInquiry> findMarketInquiryForPage( Map<String, ?> values, Pagination<MarketInquiry> pagination);
}
