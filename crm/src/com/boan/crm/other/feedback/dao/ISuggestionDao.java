package com.boan.crm.other.feedback.dao;

import com.boan.crm.other.feedback.model.Suggestion;
import com.boan.crm.utils.dao.IBaseDao;
/**
 * 意见Dao
 * @author Administrator
 *
 */
public interface ISuggestionDao  extends IBaseDao<Suggestion,String>{
	/**
	 * 更新意见表的回复状态
	 * @param suggestionId
	 * @param replyStatus
	 */
	public void updateReplyStatus( String  suggestionId , int replyStatus);
}
