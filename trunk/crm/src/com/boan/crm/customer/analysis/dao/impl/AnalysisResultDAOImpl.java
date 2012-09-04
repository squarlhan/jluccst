/**
 * 
 */
package com.boan.crm.customer.analysis.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.customer.analysis.dao.IAnalysisResultDAO;
import com.boan.crm.customer.analysis.model.AnalysisResult;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 *
 */
@Repository("analysisResultDao")
public class AnalysisResultDAOImpl extends BaseDao<AnalysisResult, Integer> implements IAnalysisResultDAO{

}
