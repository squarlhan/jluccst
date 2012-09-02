/**
 * 
 */
package com.boan.crm.customer.analysis.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.customer.analysis.dao.IFuzzyInfoDAO;
import com.boan.crm.customer.analysis.model.FuzzyInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 *
 */
@Repository("fuzzyInfoDao")
public class FuzzyInfoDAOImpl extends BaseDao<FuzzyInfo, Integer> implements IFuzzyInfoDAO{

}
