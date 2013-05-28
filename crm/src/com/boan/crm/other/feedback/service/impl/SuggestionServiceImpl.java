package com.boan.crm.other.feedback.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.other.feedback.dao.ISuggestionDao;
import com.boan.crm.other.feedback.model.Suggestion;
import com.boan.crm.other.feedback.service.ISuggestionService;
import com.boan.crm.utils.page.Pagination;

@Service("suggestionService")
public class SuggestionServiceImpl implements ISuggestionService{

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
		// TODO Auto-generated method stub
		return null;
	}

	public ISuggestionDao getDao() {
		return dao;
	}

	public void setDao(ISuggestionDao dao) {
		this.dao = dao;
	}

}
