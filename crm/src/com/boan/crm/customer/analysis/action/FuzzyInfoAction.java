/**
 * 
 */
package com.boan.crm.customer.analysis.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.analysis.model.FuzzyCategory;
import com.boan.crm.customer.analysis.model.FuzzyInfo;
import com.boan.crm.customer.analysis.model.IdCaption;
import com.boan.crm.customer.analysis.service.IFuzzyInfoService;
import com.boan.crm.customer.analysis.utils.MathFunction;
import com.boan.crm.utils.action.BaseActionSupport;

/**
 * @author luojx
 * 模糊项信息action
 */
@Controller("fuzzyInfoAction")
@Scope("prototype")
public class FuzzyInfoAction extends BaseActionSupport{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6971359095901250510L;

	@Autowired
	@Qualifier("fuzzyInfoService")
	//模糊项状态接口类
	private IFuzzyInfoService fuzzyInfoService;
	
	//模糊项信息类
	private FuzzyInfo fuzzyInfo ;
	
	private int id = 0;
	private Integer[] ids = null;
	public FuzzyInfo getFuzzyInfo() {
		return fuzzyInfo;
	}
	public void setFuzzyInfo(FuzzyInfo fuzzyInfo) {
		this.fuzzyInfo = fuzzyInfo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public String getFuzzyName() {
		return fuzzyName;
	}
	public void setFuzzyName(String fuzzyName) {
		this.fuzzyName = fuzzyName;
	}
	public String getFuzzyCategory() {
		return fuzzyCategory;
	}
	public void setFuzzyCategory(String fuzzyCategory) {
		this.fuzzyCategory = fuzzyCategory;
	}
	public List<IdCaption> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<IdCaption> categoryList) {
		this.categoryList = categoryList;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<FuzzyInfo> getListFuzzyInfo() {
		return listFuzzyInfo;
	}
	public void setListFuzzyInfo(List<FuzzyInfo> listFuzzyInfo) {
		this.listFuzzyInfo = listFuzzyInfo;
	}
	private String fuzzyName = "";
	private String fuzzyCategory = "";
	private List<IdCaption> categoryList = null;
	private List<IdCaption> functionList = null;
	
	private String message = "";
	private List<FuzzyInfo> listFuzzyInfo = null;
	
	/**
	 * 模糊项列表
	 * @return String
	 */
	public String fuzzyCategoryList()
	{
		categoryList = FuzzyCategory.getFuzzyCatetory();
		return SUCCESS;
	}
	/**
	 * 模糊项列表
	 * @return String
	 */
	public String fuzzyList()
	{
		//模糊项分类： 传0
		listFuzzyInfo = fuzzyInfoService.findAllFuzzyInfoByCategory(fuzzyCategory);
		return SUCCESS;
	}
	
	/**
	 * 模糊项信息
	 * @return String
	 */
	public String fuzzyInfo()
	{
		if(id != 0)
			fuzzyInfo = fuzzyInfoService.get(id);
		else
			fuzzyInfo = new FuzzyInfo();
		
		if(fuzzyCategory != null && fuzzyCategory.length() > 0)
		{
			fuzzyInfo.setFuzzyCategoryName(FuzzyCategory.getCategoryNameById(fuzzyCategory));
		}
		
		functionList = MathFunction.getFuzzyFunction();
		
		return SUCCESS;
	}
	/**
	 * 保存模糊项信息
	 * @return String
	 */
	public String saveFuzzy()
	{
		FuzzyInfo obj = null;
		if( id != 0)
		{
			obj =  fuzzyInfoService.get(id);
		}else
		{
			obj = new FuzzyInfo();
		}
		
		obj.setFirstValue(fuzzyInfo.getFirstValue());
		obj.setFourthValue(fuzzyInfo.getFourthValue());
		obj.setFunctionName(fuzzyInfo.getFunctionName());
		obj.setFunctionCName(MathFunction.getFunctionNameById(obj.getFunctionName()));
		obj.setFuzzyCategory(fuzzyCategory);
		obj.setFuzzyCategoryName(FuzzyCategory.getCategoryNameById(fuzzyCategory));
		obj.setFuzzyName(fuzzyInfo.getFuzzyName());
		obj.setSecondValue(fuzzyInfo.getSecondValue());
		obj.setThirdValue(fuzzyInfo.getThirdValue());
		
		fuzzyInfoService.save(obj);
		id = obj.getId();
		return SUCCESS;
	}
	/**
	 * 删除模糊项信息
	 * @return String
	 */
	public String deleteFuzzy()
	{
		fuzzyInfoService.deleteFuzzyInfo(ids);
		return SUCCESS;
	}
	public List<IdCaption> getFunctionList() {
		return functionList;
	}
	public void setFunctionList(List<IdCaption> functionList) {
		this.functionList = functionList;
	}
	
}
