package com.boan.crm.other.feedback.service;

import java.util.Map;

import com.boan.crm.other.feedback.model.Suggestion;
import com.boan.crm.utils.page.Pagination;

/**
 * 意见Service类
 * 
 * @author Administrator
 * 
 */
public interface ISuggestionService {
	/**
	 * 获得对象实例
	 * 
	 * @return
	 */
	public Suggestion get(String id);

	/**
	 * 保存信息
	 * 
	 * @return
	 */
	public void save(Suggestion object);
	
	/**
	 * 删除信息
	 * @param ids
	 */
	public void delete( String[] ids );

	/**
	 * 更新信息
	 * 
	 * @return
	 */
	public void update(Suggestion object);

	/**
	 * 实现分页
	 * 
	 * @return
	 */
	public Pagination<Suggestion> findSuggestionForPage(Map<String, ?> values, Pagination<Suggestion> pagination);
}
