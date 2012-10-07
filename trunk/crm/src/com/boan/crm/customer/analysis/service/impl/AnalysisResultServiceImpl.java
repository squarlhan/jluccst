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
	public List<AnalysisResult> findAllAnalysisResult(String companyId)
	{
		return analysisResultDao.find("from AnalysisResult where companyId = ? order by id asc", companyId);
	}
	/**
	 * 根据值获取结论　
	 */
	public AnalysisResult findAnalysisResult(double result)
	{
		Map<String,Double> idMap = new HashMap<String,Double>();
		idMap.put("result", result);
		
		List<AnalysisResult> list= analysisResultDao.find("from AnalysisResult where :result >= beginValue and :result < endValue", idMap);
		if(list != null && list.size() > 0)
		{
			return list.get(0);
		}
		return null;
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
