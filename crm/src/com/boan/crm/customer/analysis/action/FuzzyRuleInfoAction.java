/**
 * 
 */
package com.boan.crm.customer.analysis.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.analysis.model.FuzzyCategory;
import com.boan.crm.customer.analysis.model.FuzzyInfo;
import com.boan.crm.customer.analysis.model.IdCaption;
import com.boan.crm.customer.analysis.model.RuleInfo;
import com.boan.crm.customer.analysis.service.IFuzzyInfoService;
import com.boan.crm.customer.analysis.service.IFuzzyRuleInfoService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 * 模糊规则信息action
 */
@Controller("fuzzyRuleInfoAction")
@Scope("prototype")
public class FuzzyRuleInfoAction extends BaseActionSupport{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6971359095901250510L;

	@Autowired
	@Qualifier("fuzzyRuleInfoService")
	//模糊规则状态接口类
	private IFuzzyRuleInfoService fuzzyRuleInfoService;
	@Autowired
	@Qualifier("fuzzyInfoService")
	//模糊规则状态接口类
	private IFuzzyInfoService fuzzyInfoService;
	
	//模糊规则信息类
	private RuleInfo ruleInfo ;
	
	private int id = 0;
	private String[] ids = null;
	
	private String ruleName = "";
	private List<IdCaption> categoryList = null;
	
	private List<IdCaption> resultList = null;
	private List<FuzzyInfo> listResultFuzzy = null;
	private String message = "";
	private List<RuleInfo> listRuleInfo = null;
	
	private String ifFuzzyCategory = "";
	private String ifFuzzyCategory1 = "";
	private String ifFuzzyCategory2 = "";
	private String ifFuzzyCategory3 = "";
	private String ifFuzzyCategory4 = "";
	private int ifFuzzyId = 0;
	private String companyId = "";
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getIfFuzzyCategory() {
		return ifFuzzyCategory;
	}

	public void setIfFuzzyCategory(String ifFuzzyCategory) {
		this.ifFuzzyCategory = ifFuzzyCategory;
	}

	public int getIfFuzzyId() {
		return ifFuzzyId;
	}

	public void setIfFuzzyId(int ifFuzzyId) {
		this.ifFuzzyId = ifFuzzyId;
	}

	private int ifFuzzyId1 = 0;
	private int ifFuzzyId2 = 0;
	private int ifFuzzyId3 = 0;
	private int ifFuzzyId4 = 0;
	
	
	private Pagination<IdCaption> pagination = new Pagination<IdCaption>();

	/**
	 * 模糊规则列表
	 * @return String
	 */
	public String fuzzyRuleList()
	{
		Map<String, String> values  = new HashMap<String ,String>();
		if(companyId != null && companyId.length() > 0)
		{
			values.put("companyId", companyId);
		}else
		{
			values.put("companyId", sessionCompanyId);
		}
		pagination = fuzzyRuleInfoService.findAllFuzzyRuleResultInfo(values,pagination);
		return SUCCESS;
	}
	
	/**
	 * 模糊规则信息
	 * @return String
	 */
	public String fuzzyRuleInfo()
	{
		List<RuleInfo> ruleList = fuzzyRuleInfoService.findAllFuzzyRuleInfoByGroupId(id);
		
		if(ruleList != null && ruleList.size() > 0)
		{
			ruleInfo = ruleList.get(0);
			ifFuzzyCategory = ruleInfo.getFuzzyCategory();
			ifFuzzyId = ruleInfo.getIfFuzzyId();
			
			if(ruleList.size() == 2)
			{
				ifFuzzyCategory1 = ruleList.get(1).getFuzzyCategory();
				ifFuzzyId1 = ruleList.get(1).getIfFuzzyId();
			}
			if(ruleList.size() == 3)
			{
				ifFuzzyCategory1 = ruleList.get(1).getFuzzyCategory();
				ifFuzzyId1 = ruleList.get(1).getIfFuzzyId();
				
				ifFuzzyCategory2 = ruleList.get(2).getFuzzyCategory();
				ifFuzzyId2 = ruleList.get(2).getIfFuzzyId();
			}
			if(ruleList.size() == 4)
			{
				ifFuzzyCategory1 = ruleList.get(1).getFuzzyCategory();
				ifFuzzyId1 = ruleList.get(1).getIfFuzzyId();
				
				ifFuzzyCategory2 = ruleList.get(2).getFuzzyCategory();
				ifFuzzyId2 = ruleList.get(2).getIfFuzzyId();
				
				ifFuzzyCategory3 = ruleList.get(3).getFuzzyCategory();
				ifFuzzyId3 = ruleList.get(3).getIfFuzzyId();
			}
			if(ruleList.size() == 5)
			{
				ifFuzzyCategory1 = ruleList.get(1).getFuzzyCategory();
				ifFuzzyId1 = ruleList.get(1).getIfFuzzyId();
				
				ifFuzzyCategory2 = ruleList.get(2).getFuzzyCategory();
				ifFuzzyId2 = ruleList.get(2).getIfFuzzyId();
				
				ifFuzzyCategory3 = ruleList.get(3).getFuzzyCategory();
				ifFuzzyId3 = ruleList.get(3).getIfFuzzyId();
				ifFuzzyCategory4 = ruleList.get(4).getFuzzyCategory();
				ifFuzzyId4 = ruleList.get(4).getIfFuzzyId();
			}
		}else
		{
			ruleInfo = new RuleInfo();
		}
		
		categoryList = FuzzyCategory.getFuzzyCatetoryNoResult();

		listResultFuzzy = fuzzyInfoService.findAllFuzzyInfoByCategory(FuzzyCategory.getResultFuzzyCatetory().get(0).getId(),sessionCompanyId);
		
		
		
		return SUCCESS;
	}
	/**
	 * 保存模糊规则信息
	 * @return String
	 */
	public String saveRule()
	{
		if(id != 0)
			fuzzyRuleInfoService.deleteFuzzyRuleInfoByGroupId(id);
		
		RuleInfo obj = new RuleInfo();
		String resultFuzzyName = fuzzyInfoService.get(ruleInfo.getResultFuzzyId()).getFuzzyName();
		obj.setFuzzyCategory(ruleInfo.getFuzzyCategory());
		obj.setIfFuzzyId(ruleInfo.getIfFuzzyId());
		obj.setIfFuzzyName(fuzzyInfoService.get(ruleInfo.getIfFuzzyId()).getFuzzyName());
		obj.setResultFuzzyId(ruleInfo.getResultFuzzyId());
		obj.setResultFuzzyName(resultFuzzyName);
		if(companyId != null && companyId.length() > 0)
		{
			obj.setCompanyId(companyId);
		}else
		{
			obj.setCompanyId(sessionCompanyId);
		}
		fuzzyRuleInfoService.save(obj);
		
		int groupId = obj.getId();
		obj.setGroupId(groupId);
		fuzzyRuleInfoService.save(obj);
		
		if(ifFuzzyCategory1 != null && ifFuzzyCategory1.length() > 0)
		{
			obj = new RuleInfo();
			
			obj.setFuzzyCategory(ifFuzzyCategory1);
			obj.setIfFuzzyId(ifFuzzyId1);
			obj.setIfFuzzyName(fuzzyInfoService.get(ifFuzzyId1).getFuzzyName());
			obj.setResultFuzzyId(ruleInfo.getResultFuzzyId());
			obj.setResultFuzzyName(resultFuzzyName);
			if(companyId != null && companyId.length() > 0)
			{
				obj.setCompanyId(companyId);
			}else
			{
				obj.setCompanyId(sessionCompanyId);
			}
			obj.setGroupId(groupId);
			fuzzyRuleInfoService.save(obj);
		}
		if(ifFuzzyCategory2 != null && ifFuzzyCategory2.length() > 0)
		{
			obj = new RuleInfo();
			
			obj.setFuzzyCategory(ifFuzzyCategory2);
			obj.setIfFuzzyId(ifFuzzyId2);
			obj.setIfFuzzyName(fuzzyInfoService.get(ifFuzzyId2).getFuzzyName());
			obj.setResultFuzzyId(ruleInfo.getResultFuzzyId());
			obj.setResultFuzzyName(resultFuzzyName);
			if(companyId != null && companyId.length() > 0)
			{
				obj.setCompanyId(companyId);
			}else
			{
				obj.setCompanyId(sessionCompanyId);
			}
			obj.setGroupId(groupId);
			fuzzyRuleInfoService.save(obj);
		}
		if(ifFuzzyCategory3 != null && ifFuzzyCategory3.length() > 0)
		{
			obj = new RuleInfo();
			
			obj.setFuzzyCategory(ifFuzzyCategory3);
			obj.setIfFuzzyId(ifFuzzyId3);
			obj.setIfFuzzyName(fuzzyInfoService.get(ifFuzzyId3).getFuzzyName());
			obj.setResultFuzzyId(ruleInfo.getResultFuzzyId());
			obj.setResultFuzzyName(resultFuzzyName);
			if(companyId != null && companyId.length() > 0)
			{
				obj.setCompanyId(companyId);
			}else
			{
				obj.setCompanyId(sessionCompanyId);
			}
			obj.setGroupId(groupId);
			fuzzyRuleInfoService.save(obj);
		}
		if(ifFuzzyCategory4 != null && ifFuzzyCategory4.length() > 0)
		{
			obj = new RuleInfo();
			
			obj.setFuzzyCategory(ifFuzzyCategory4);
			obj.setIfFuzzyId(ifFuzzyId4);
			obj.setIfFuzzyName(fuzzyInfoService.get(ifFuzzyId4).getFuzzyName());
			obj.setResultFuzzyId(ruleInfo.getResultFuzzyId());
			obj.setResultFuzzyName(resultFuzzyName);
			if(companyId != null && companyId.length() > 0)
			{
				obj.setCompanyId(companyId);
			}else
			{
				obj.setCompanyId(sessionCompanyId);
			}
			obj.setGroupId(groupId);
			fuzzyRuleInfoService.save(obj);
		}
		
		message = "保存成功！";
		return SUCCESS;
	}
	/**
	 * 删除模糊规则信息
	 * @return String
	 */
	public String deleteFuzzyRule()
	{
		fuzzyRuleInfoService.deleteFuzzyRuleInfo(ids);
		return SUCCESS;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public RuleInfo getRuleInfo() {
		return ruleInfo;
	}
	public void setRuleInfo(RuleInfo ruleInfo) {
		this.ruleInfo = ruleInfo;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public List<IdCaption> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<IdCaption> categoryList) {
		this.categoryList = categoryList;
	}
	public List<IdCaption> getResultList() {
		return resultList;
	}
	public void setResultList(List<IdCaption> resultList) {
		this.resultList = resultList;
	}
	public List<RuleInfo> getListRuleInfo() {
		return listRuleInfo;
	}
	public void setListRuleInfo(List<RuleInfo> listRuleInfo) {
		this.listRuleInfo = listRuleInfo;
	}
	public List<FuzzyInfo> getListResultFuzzy() {
		return listResultFuzzy;
	}
	public void setListResultFuzzy(List<FuzzyInfo> listResultFuzzy) {
		this.listResultFuzzy = listResultFuzzy;
	}
	public String getIfFuzzyCategory1() {
		return ifFuzzyCategory1;
	}

	public void setIfFuzzyCategory1(String ifFuzzyCategory1) {
		this.ifFuzzyCategory1 = ifFuzzyCategory1;
	}

	public String getIfFuzzyCategory2() {
		return ifFuzzyCategory2;
	}

	public void setIfFuzzyCategory2(String ifFuzzyCategory2) {
		this.ifFuzzyCategory2 = ifFuzzyCategory2;
	}

	public String getIfFuzzyCategory3() {
		return ifFuzzyCategory3;
	}

	public void setIfFuzzyCategory3(String ifFuzzyCategory3) {
		this.ifFuzzyCategory3 = ifFuzzyCategory3;
	}

	public String getIfFuzzyCategory4() {
		return ifFuzzyCategory4;
	}

	public void setIfFuzzyCategory4(String ifFuzzyCategory4) {
		this.ifFuzzyCategory4 = ifFuzzyCategory4;
	}

	public int getIfFuzzyId1() {
		return ifFuzzyId1;
	}

	public void setIfFuzzyId1(int ifFuzzyId1) {
		this.ifFuzzyId1 = ifFuzzyId1;
	}

	public int getIfFuzzyId2() {
		return ifFuzzyId2;
	}

	public void setIfFuzzyId2(int ifFuzzyId2) {
		this.ifFuzzyId2 = ifFuzzyId2;
	}

	public int getIfFuzzyId3() {
		return ifFuzzyId3;
	}

	public void setIfFuzzyId3(int ifFuzzyId3) {
		this.ifFuzzyId3 = ifFuzzyId3;
	}

	public int getIfFuzzyId4() {
		return ifFuzzyId4;
	}

	public void setIfFuzzyId4(int ifFuzzyId4) {
		this.ifFuzzyId4 = ifFuzzyId4;
	}
	public Pagination<IdCaption> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<IdCaption> pagination) {
		this.pagination = pagination;
	}

}
