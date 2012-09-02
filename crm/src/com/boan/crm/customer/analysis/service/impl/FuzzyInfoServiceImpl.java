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
	public List<FuzzyInfo> findAllFuzzyInfoByCategory(String category)
	{
		Map<String,String> idMap = new HashMap<String,String>();
		idMap.put("fuzzyCategory", category);
		return fuzzyInfoDao.find("from FuzzyInfo where fuzzyCategory = :fuzzyCategory", idMap);
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
