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

import com.boan.crm.customer.analysis.dao.IFuzzyInfoDAO;
import com.boan.crm.customer.analysis.model.FuzzyInfo;
import com.boan.crm.customer.analysis.service.IFuzzyInfoService;

/**
 * @author luojx
 *
 */
@Service("fuzzyInfoService")
public class FuzzyInfoServiceImpl implements IFuzzyInfoService{
	@Autowired
	@Qualifier("fuzzyInfoDao")
	private IFuzzyInfoDAO fuzzyInfoDao;
	/**
	 * 根据分类获取模糊项
	 */
	public List<FuzzyInfo> findAllFuzzyInfoByCategory(String category,String companyId)
	{
		Map<String,String> idMap = new HashMap<String,String>();
		idMap.put("fuzzyCategory", category);
		idMap.put("companyId", companyId);
		return fuzzyInfoDao.find("from FuzzyInfo where fuzzyCategory = :fuzzyCategory and companyId = :companyId", idMap);
	}

	/**
	 * 从总记录中拷贝生成公司记录
	 * @param companyId
	 */
	public void saveMainFuzzyInfoToCompany(String companyId)
	{
		Map<String,String> idMap = new HashMap<String,String>();
		List<FuzzyInfo> listFuzzy = fuzzyInfoDao.find("from FuzzyInfo where companyId is null or companyId = '' ", idMap);
		if(listFuzzy != null && listFuzzy.size() > 0)
		{
			for(int i=0;i<listFuzzy.size();i++)
			{
				FuzzyInfo temp = listFuzzy.get(i);
				FuzzyInfo fuzzyInfo = new FuzzyInfo();
				fuzzyInfo.setFirstValue(temp.getFirstValue());
				fuzzyInfo.setFourthValue(temp.getFourthValue());
				fuzzyInfo.setFunctionCName(temp.getFunctionCName());
				fuzzyInfo.setFunctionName(temp.getFunctionName());
				fuzzyInfo.setFuzzyCategory(temp.getFuzzyCategory());
				fuzzyInfo.setFuzzyCategoryName(temp.getFuzzyCategoryName());
				fuzzyInfo.setFuzzyName(temp.getFuzzyName());
				fuzzyInfo.setSecondValue(temp.getSecondValue());
				fuzzyInfo.setSugeno(temp.getSugeno());
				fuzzyInfo.setThirdValue(temp.getThirdValue());
				fuzzyInfo.setCompanyId(companyId);
				save(fuzzyInfo);
			}
		}
	}
	/**
	 * 根据id获取模糊项
	 */
	public FuzzyInfo get(int id)
	{
		return fuzzyInfoDao.get(id);
	}

	/**
	 * 根据id删除模糊项
	 */
	public void deleteFuzzyInfo(Integer... ids)
	{
		fuzzyInfoDao.delete(ids);
	}

	/**
	 * 保存模糊项
	 */
	public void save(FuzzyInfo table1)
	{
		fuzzyInfoDao.save(table1);
	}
	

}
