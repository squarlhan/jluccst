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
import com.boan.crm.customer.analysis.model.AnalysisResult;
import com.boan.crm.customer.analysis.service.IAnalysisResultService;

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
		String hql = "from AnalysisResult where companyId = :companyId order by id asc";
		Map<String ,String > values = new HashMap<String ,String>();
		values.put("companyId", companyId);
		return analysisResultDao.find(hql, values);
	}
	/**
	 * 从总记录中拷贝生成公司记录
	 * @param companyId
	 */
	public void saveMainFuzzyResultInfoToCompany(String companyId)
	{
		Map<String,String> idMap = new HashMap<String,String>();
		List<AnalysisResult> listFuzzyResult = analysisResultDao.find("from AnalysisResult where companyId is null or companyId = ''", idMap);
		if(listFuzzyResult != null && listFuzzyResult.size() > 0)
		{
			for(int i=0;i<listFuzzyResult.size();i++)
			{
				AnalysisResult temp = listFuzzyResult.get(i);
				AnalysisResult analysisResult = new AnalysisResult();
				analysisResult.setBeginValue(temp.getBeginValue());
				analysisResult.setEndValue(temp.getEndValue());
				analysisResult.setResult(temp.getResult());
				analysisResult.setCompanyId(companyId);
				save(analysisResult);
			}
		}
	}
	/**
	 * 根据值获取结论　
	 */
	public AnalysisResult findAnalysisResult(double result)
	{
		Map<String,Double> idMap = new HashMap<String,Double>();
		idMap.put("result", result);
		
		List<AnalysisResult> list= analysisResultDao.find("from AnalysisResult where :result >= beginValue and :result <= endValue", idMap);
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
