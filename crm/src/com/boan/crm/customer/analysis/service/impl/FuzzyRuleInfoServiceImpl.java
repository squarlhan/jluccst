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
import com.boan.crm.customer.analysis.dao.IFuzzyRuleInfoDAO;
import com.boan.crm.customer.analysis.model.AnalysisResult;
import com.boan.crm.customer.analysis.model.FuzzyCategory;
import com.boan.crm.customer.analysis.model.IdCaption;
import com.boan.crm.customer.analysis.model.RuleInfo;
import com.boan.crm.customer.analysis.service.IFuzzyRuleInfoService;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 *
 */
@Service("fuzzyRuleInfoService")
public class FuzzyRuleInfoServiceImpl implements IFuzzyRuleInfoService{
	@Autowired
	@Qualifier("fuzzyRuleInfoDao")
	private IFuzzyRuleInfoDAO fuzzyRuleInfoDao;
	@Autowired
	@Qualifier("fuzzyInfoDao")
	private IFuzzyInfoDAO fuzzyInfoDao;
	/**
	 * 根据分类获取模糊项
	 */
	public List<IdCaption> findAllFuzzyRuleInfo()
	{
		StringBuilder hql = new StringBuilder();
		hql.append( "select new com.boan.crm.customer.analysis.model.IdCaption(t.groupId,t.resultFuzzyName) from RuleInfo t group by t.groupId,t.resultFuzzyName ");
		hql.append(" order by groupId asc");
		List<IdCaption> data = fuzzyRuleInfoDao.find(hql.toString(),new Object[0]);
		if(data != null && data.size() > 0)
		{
			for(int i=0;i<data.size();i++)
			{
				List<RuleInfo> list = findAllFuzzyRuleInfoByGroupId(data.get(i).getIId());
				if(list != null && list.size() >0)
				{
					for(int j=0;j<list.size();j++)
					{
						list.get(j).setFuzzyCategoryName(FuzzyCategory.getCategoryNameById(list.get(j).getFuzzyCategory()));
					}
				}
				data.get(i).setAttachObject(list);
			}
		}
		return data;
	}
	/**
	 * 根据分类获取规则
	 */
	public Pagination<IdCaption> findAllFuzzyRuleResultInfo(Map<String, ?> values,Pagination<IdCaption> pagination)
	{
		StringBuilder hql = new StringBuilder();
		hql.append( "select new com.boan.crm.customer.analysis.model.IdCaption(t.groupId,t.resultFuzzyName) from RuleInfo t where t.companyId = :companyId group by t.groupId,t.resultFuzzyName");
		hql.append(" order by groupId asc");
		List<IdCaption> data = fuzzyRuleInfoDao.findForPage(hql.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		if(data != null && data.size() > 0)
		{
			for(int i=0;i<data.size();i++)
			{
				List<RuleInfo> list = findAllFuzzyRuleInfoByGroupId(data.get(i).getIId());
				if(list != null && list.size() >0)
				{
					for(int j=0;j<list.size();j++)
					{
						list.get(j).setFuzzyCategoryName(FuzzyCategory.getCategoryNameById(list.get(j).getFuzzyCategory()));
					}
				}
				data.get(i).setAttachObject(list);
			}
		}
		hql.delete(0, hql.length());
		hql.append(" select Count(t.groupId) from RuleInfo t where t.companyId = :companyId group by t.groupId" );
		List<Integer> list = fuzzyRuleInfoDao.find(hql.toString(), values);
		int totalRows = 0;
		if(list != null && list.size() > 0)
		{
			totalRows =list.size();
		}
		pagination.setTotalRows(totalRows);
		pagination.setData(data);

		return pagination;
	}
	/**
	 * 根据分类获取规则
	 */
	public List<RuleInfo> findAllFuzzyRuleInfoByResultId(int resultId)
	{
		Map<String ,Integer > values = new HashMap<String ,Integer>();
		values.put("resultFuzzyId", resultId);
		return fuzzyRuleInfoDao.find("from RuleInfo where resultFuzzyId = :resultFuzzyId", values);
	}
	
	/**
	 * 从总记录中拷贝生成公司记录
	 * @param companyId
	 */
	public void copyMainFuzzyRuleInfoToCompany(String companyId)
	{
		Map<String,String> idMap = new HashMap<String,String>();
		List<RuleInfo> listRuleInfo = fuzzyRuleInfoDao.find("from RuleInfo where companyId is null ", idMap);
		if(listRuleInfo != null && listRuleInfo.size() > 0)
		{
			for(int i=0;i<listRuleInfo.size();i++)
			{
				RuleInfo ruleInfo = listRuleInfo.get(i);
				ruleInfo.setCompanyId(companyId);
				save(ruleInfo);
			}
		}
	}
	
	/**
	 * 根据分类获取规则
	 */
	public List<RuleInfo> findAllFuzzyRuleInfoByGroupId(int groupId)
	{
		Map<String ,Integer > values = new HashMap<String ,Integer>();
		values.put("groupId", groupId);
		return fuzzyRuleInfoDao.find("from RuleInfo where groupId = :groupId", values);
	}
	/**
	 * 根据id获取模糊项
	 */
	public RuleInfo get(int id)
	{
		return fuzzyRuleInfoDao.get(id);
	}

	/**
	 * 根据id删除模糊项
	 */
	public void deleteFuzzyRuleInfo(String... ids)
	{
		for(int i=0;i< ids.length;i++)
		{
			deleteFuzzyRuleInfoByGroupId(Integer.parseInt(ids[i]));
		}
	}
	
	/**
	 * 根据resultId删除规则
	 */
	public void deleteFuzzyRuleInfoByResultId(int resultId)
	{
		Map<String ,Integer > values = new HashMap<String ,Integer>();
		values.put("resultFuzzyId", resultId);
		fuzzyRuleInfoDao.executeHql("delete from RuleInfo where resultFuzzyId = :resultFuzzyId", values);
	}
	/**
	 * 根据resultId删除规则
	 */
	public void deleteFuzzyRuleInfoByGroupId(int groupId)
	{
		Map<String ,Integer > values = new HashMap<String ,Integer>();
		values.put("groupId", groupId);
		fuzzyRuleInfoDao.executeHql("delete from RuleInfo where groupId = :groupId", values);
	}

	/**
	 * 保存模糊项
	 */
	public void save(RuleInfo table1)
	{
		fuzzyRuleInfoDao.save(table1);
	}
	/**
	 * 按分页查询信息
	 */
	public Pagination<RuleInfo> findFuzzyRuleInfoInfoForPage(
			Map<String, ?> values, Pagination<RuleInfo> pagination)
	{
		StringBuilder hql = new StringBuilder();
		hql.append( "from RuleInfo ");
		hql.append(" order by id asc");
		List<RuleInfo> data = fuzzyRuleInfoDao.findForPage(hql.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		hql.delete(0, hql.length());
		hql.append(" select count(*) from RuleInfo where 1=1 " );
		
		int totalRows = fuzzyRuleInfoDao.findCountForPage(hql.toString(), values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		
		List<RuleInfo> list = pagination.getData();
		if(list != null && list.size() > 0)
		{
//			for(int i=0;i< list.size();i++)
//			{
//				RuleInfo ruleInfo = list.get(i);
//			}
		}
		return pagination;
	}

}
