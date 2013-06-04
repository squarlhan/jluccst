package com.boan.crm.other.feedback.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.other.feedback.dao.ISuggestionDao;
import com.boan.crm.other.feedback.model.Suggestion;
import com.boan.crm.other.feedback.service.ISuggestionService;
import com.boan.crm.utils.page.Pagination;

@Service("suggestionService")
public class SuggestionServiceImpl implements ISuggestionService {

	@Autowired
	@Qualifier("suggestionDao")
	private ISuggestionDao dao = null;

	@Override
	public Suggestion get(String id) {
		return dao.get(id);
	}

	@Override
	public void save(Suggestion object) {
		dao.save(object);
	}

	@Override
	public void update(Suggestion object) {
		dao.update(object);
	}

	@Override
	public Pagination<Suggestion> findSuggestionForPage(Map<String, ?> values, Pagination<Suggestion> pagination) {
		String hql = " from Suggestion order by createTime desc ";
		List<Suggestion> data = dao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = " select count(id) from Suggestion ";
		int totalRows = dao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	public ISuggestionDao getDao() {
		return dao;
	}

	public void setDao(ISuggestionDao dao) {
		this.dao = dao;
	}

	@Override
	public void delete(String[] ids) {
		if( ids != null && ids.length  > 0 )
		{
			for( int i = 0; i < ids.length ; i ++ )
			{
				dao.delete(ids[i]);
			}
		}
		
	}

	@Override
	public Pagination<Suggestion> findMySuggestionForPage(Map<String, ?> values, Pagination<Suggestion> pagination) {
		String hql = " from Suggestion where userId = :userId  order by createTime desc ";
		List<Suggestion> data = dao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = " select count(id) from Suggestion where userId = :userId ";
		int totalRows = dao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	@Override
	public void updateReplyStatus(String suggestionId, int replyStatus) {
		dao.updateReplyStatus(suggestionId, replyStatus);
	}

}
