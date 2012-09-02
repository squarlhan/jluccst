/**
 * 
 */
package com.boan.crm.customer.analysis.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.customer.analysis.dao.IFuzzyRuleInfoDAO;
import com.boan.crm.customer.analysis.model.RuleInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 *
 */
@Repository("fuzzyRuleInfoDao")
public class FuzzyRuleInfoDAOImpl extends BaseDao<RuleInfo, Integer> implements IFuzzyRuleInfoDAO{

}
