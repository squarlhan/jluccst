package com.boan.crm.other.feedback.service;

import java.util.Map;

import com.boan.crm.other.feedback.model.SuggestionReply;
import com.boan.crm.utils.page.Pagination;

/**
 * 意见回复Service
 * 
 * @author Administrator
 * 
 */
public interface ISuggestionReplyService {
	/**
	 * 获得对象实例
	 * 
	 * @return
	 */
	public SuggestionReply get(String id);

	/**
	 * 通过意见id获意见回复内容
	 * 
	 * @param suggestionId
	 * @return
	 */
	public SuggestionReply getReply(String suggestionId);

	/**
	 * 保存信息
	 * 
	 * @return
	 */
	public void save(SuggestionReply object);

	/**
	 * 删除信息
	 * 
	 * @param ids
	 */
	public void delete(String[] ids);

	/**
	 * 更新信息
	 * 
	 * @return
	 */
	public void update(SuggestionReply object);

	/**
	 * 实现分页
	 * 
	 * @return
	 */
	public Pagination<SuggestionReply> findSuggestionForPage(Map<String, ?> values, Pagination<SuggestionReply> pagination);

	/**
	 * 根据suggestionId删除回复意见
	 * 
	 * @param suggestionId
	 */
	public void deleteBySuggestionId(String suggestionId);
}
