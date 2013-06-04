package com.boan.crm.other.feedback.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.other.feedback.dao.ISuggestionReplyDao;
import com.boan.crm.other.feedback.model.SuggestionReply;
import com.boan.crm.other.feedback.service.ISuggestionReplyService;
import com.boan.crm.utils.page.Pagination;

@Service("suggestionReplyService")
public class SuggestionReplyServiceImpl implements ISuggestionReplyService {

	@Autowired
	@Qualifier("suggestionReplyDao")
	private ISuggestionReplyDao dao = null;

	@Override
	public SuggestionReply get(String id) {
		return dao.get(id);
	}

	@Override
	public void save(SuggestionReply object) {
		dao.save(object);
	}

	@Override
	public void delete(String[] ids) {
		if (ids != null && ids.length > 0) {
			for (String s : ids) {
				dao.delete(s);
			}
		}
	}

	@Override
	public void update(SuggestionReply object) {
		dao.update(object);
	}

	@Override
	public Pagination<SuggestionReply> findSuggestionForPage(Map<String, ?> values, Pagination<SuggestionReply> pagination) {
		String hql = " from SuggestionReply order by replyTime desc ";
		List<SuggestionReply> data = dao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = " select count(id) from SuggestionReply ";
		int totalRows = dao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	public ISuggestionReplyDao getDao() {
		return dao;
	}

	public void setDao(ISuggestionReplyDao dao) {
		this.dao = dao;
	}

	@Override
	public SuggestionReply getReply(String suggestionId) {
		String hql = " from SuggestionReply where  suggestionId = :suggestionId order by replyTime desc ";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("suggestionId", suggestionId);
		List<SuggestionReply> list = dao.find(hql, map);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void deleteBySuggestionId(String suggestionId) {
		dao.deleteBySuggestionId(suggestionId);
	}

}
