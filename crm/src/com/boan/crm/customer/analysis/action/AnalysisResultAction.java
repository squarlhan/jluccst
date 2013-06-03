/**
 * 
 */
package com.boan.crm.customer.analysis.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.analysis.model.AnalysisResult;
import com.boan.crm.customer.analysis.service.IAnalysisResultService;
import com.boan.crm.utils.action.BaseActionSupport;

/**
 * @author luojx
 * 分析结论信息action
 */
@Controller("analysisResultAction")
@Scope("prototype")
public class AnalysisResultAction extends BaseActionSupport{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6971359095901250510L;

	@Autowired
	@Qualifier("analysisResultService")
	//分析结论状态接口类
	private IAnalysisResultService analysisResultService;
	
	//分析结论信息类
	private AnalysisResult analysisResult ;
	
	private int id = 0;
	private Integer[] ids = null;
	private List<AnalysisResult> analysisResultList = null;
	
	private String message = "";
	private String companyId = "";
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * 分析结论列表
	 * @return String
	 */
	public String analysisResultList()
	{
		//分析结论分类： 传0
		if(companyId != null && companyId.length() > 0)
		{
			analysisResultList = analysisResultService.findAllAnalysisResult(companyId);
		}else
		{
			analysisResultList = analysisResultService.findAllAnalysisResult(sessionCompanyId);
		}
		return SUCCESS;
	}
	
	/**
	 * 分析结论信息
	 * @return String
	 */
	public String analysisResult()
	{
		if(id != 0)
			analysisResult = analysisResultService.get(id);
		else
			analysisResult = new AnalysisResult();
		
		
		return SUCCESS;
	}
	/**
	 * 保存分析结论信息
	 * @return String
	 */
	public String saveAnalysisResult()
	{
		AnalysisResult obj = null;
		if( id != 0)
		{
			obj =  analysisResultService.get(id);
		}else
		{
			obj = new AnalysisResult();
		}
		
		obj.setBeginValue(analysisResult.getBeginValue());
		obj.setEndValue(analysisResult.getEndValue());
		obj.setResult(analysisResult.getResult());
		if(companyId != null && companyId.length() > 0)
		{
			obj.setCompanyId(companyId);
		}else
		{
			obj.setCompanyId(sessionCompanyId);
		}
		analysisResultService.save(obj);
		id = obj.getId();
		return SUCCESS;
	}
	/**
	 * 删除分析结论信息
	 * @return String
	 */
	public String deleteAnalysisResult()
	{
		analysisResultService.deleteAnalysisResult(ids);
		return SUCCESS;
	}
	public AnalysisResult getAnalysisResult() {
		return analysisResult;
	}
	public void setAnalysisResult(AnalysisResult analysisResult) {
		this.analysisResult = analysisResult;
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
	public List<AnalysisResult> getAnalysisResultList() {
		return analysisResultList;
	}
	public void setAnalysisResultList(List<AnalysisResult> analysisResultList) {
		this.analysisResultList = analysisResultList;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
