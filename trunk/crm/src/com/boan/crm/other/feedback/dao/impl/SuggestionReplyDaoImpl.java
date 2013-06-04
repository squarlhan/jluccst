package com.boan.crm.other.feedback.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.boan.crm.other.feedback.dao.ISuggestionReplyDao;
import com.boan.crm.other.feedback.model.SuggestionReply;
import com.boan.crm.utils.dao.impl.BaseDao;
/**
 * 意见回复
 * @author Administrator
 *
 */
@Repository("suggestionReplyDao")
public class SuggestionReplyDaoImpl extends BaseDao<SuggestionReply, String> implements ISuggestionReplyDao {

	@Override
	public void deleteBySuggestionId(String suggestionId) {
		String hql = " delete SuggestionReply where suggestionId = :suggestionId ";
		Map<String, Object> map = new HashMap<String, Object>();
		this.executeHql(hql, map);
	}

}
