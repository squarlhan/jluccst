package com.boan.crm.other.feedback.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.boan.crm.other.feedback.dao.ISuggestionDao;
import com.boan.crm.other.feedback.model.Suggestion;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * 意见DaoImpl类
 * @author Administrator
 *
 */
@Repository("suggestionDao")
public class SuggestionDaoImpl extends BaseDao<Suggestion,String> implements ISuggestionDao{

	@Override
	public void updateReplyStatus(String suggestionId, int replyStatus) {
		String hql = " update Suggestion set replyStatus = :replyStatus ";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("replyStatus", replyStatus);
		this.executeHql(hql, map);
	}

}
