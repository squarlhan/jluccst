package com.boan.crm.other.feedback.dao.impl;

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

}
