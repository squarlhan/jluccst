package com.boan.crm.other.feedback.dao;

import com.boan.crm.other.feedback.model.SuggestionReply;
import com.boan.crm.utils.dao.IBaseDao;

public interface ISuggestionReplyDao  extends IBaseDao<SuggestionReply,String>{
	/**
	 * 根据suggestionId删除回复意见
	 * 
	 * @param suggestionId
	 */
	public void deleteBySuggestionId(String suggestionId);
}
