/**
 * 
 */
package com.boan.crm.customer.analysis.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customer.analysis.dao.IAnalysisResultDAO;
import com.boan.crm.customer.analysis.dao.IFuzzyInfoDAO;
import com.boan.crm.customer.analysis.model.AnalysisResult;
import com.boan.crm.customer.analysis.model.FuzzyInfo;
import com.boan.crm.customer.analysis.service.IAnalysisResultService;
import com.boan.crm.customer.analysis.service.IFuzzyInfoService;

/**
 * @author luojx
 *
 */
@Service("analysisResultService")
public class AnalysisResultServiceImpl implements IAnalysisResultService{
	@Autowired
	@Qualifier("analysisResultDao")
	private IAnalysisResultDAO analysisResultDao;
	/**
	 * 根据分类获取模糊项
	 */
	public List<AnalysisResult> findAllAnalysisResult()
	{
		return analysisResultDao.find("from AnalysisResult order by id asc", new Object[0]);
	}

	/**
	 * 根据id获取模糊项
	 */
	public AnalysisResult get(int id)
	{
		return analysisResultDao.get(id);
	}

	/**
	 * 根据id删除模糊项
	 */
	public void deleteAnalysisResult(Integer... ids)
	{
		analysisResultDao.delete(ids);
	}

	/**
	 * 保存模糊项
	 */
	public void save(AnalysisResult table1)
	{
		analysisResultDao.save(table1);
	}
	

}
