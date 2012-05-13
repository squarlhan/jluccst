/*
 * @(#)ErrorLogAction.java 1.1 2012-4-26
 */

package com.boan.rees.error.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.error.model.ErrorLog;
import com.boan.rees.error.service.IErrorLogService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;

/**
 * 故障action 类
 * @author zhaomengxue
 * @version 1.0.0
 */
@Controller("errorLogAction")
@Scope("prototype")
public class ErrorLogAction extends BaseActionSupport{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("errorLogService")
	private IErrorLogService errorLogService;
	
	/**
	 * 分页列表
	 */
	private Pagination<ErrorLog> pagination = new Pagination<ErrorLog>();
	
	/**
	 * 页面对象
	 */
	private ErrorLog errorLog;
	
	/**
	 * 页面所选行的id
	 */
	private String[] ids;
	
	/**
	 * 查询方式列表初始化数据
	 */
	private Map<String,String> selectWayList = new HashMap<String, String>();
	/**
	 * 类别：１为报警管理，２为故障日志
	 */
	private String category = "";
	

	/**
	 * 打开列表方法
	 * @return success
	 */
	public String openErrorLog(){
		//分页显示
		selectWayList.put("1", "全部");
		selectWayList.put("2", "已解除");
		selectWayList.put("3", "报警中");
		
		Map<String,String> values = new HashMap<String,String>();
		values.put( "category", category );
		
		pagination = errorLogService.findErrorLogForPage(values, pagination);
		if(category.equals( "1" ))
		{
			return "alarmsuccess";
		}else
		{
			return SUCCESS;         
		}
	}
	
	/**
	 * 打开添加页面方法
	 * @return success
	 */
	public String openAddErrorLog(){
		errorLog = errorLogService.get( errorLog.getId() );
		return SUCCESS;
	}
	
	/**
	 * 添加新对象方法
	 * @return success
	 */
	public String toAddErrorLog(){
		errorLogService.save(errorLog);
		return SUCCESS;
	}
	/**
	 * 添加新对象方法
	 * @return success
	 */
	public String toOpenErrorLog(){
		errorLogService.save(errorLog);
		return SUCCESS;
	}
	
	/**
	 * 置位，清除故障
	 * @return
	 */
	public String toSetIsRemove(){
		errorLogService.updateSetIsRemove(errorLog.getId());
		return NONE;
	}

	public IErrorLogService getErrorLogService() {
		return errorLogService;
	}

	public void setErrorLogService(IErrorLogService errorLogService) {
		this.errorLogService = errorLogService;
	}

	public Pagination<ErrorLog> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<ErrorLog> pagination) {
		this.pagination = pagination;
	}

	public ErrorLog getErrorLog() {
		return errorLog;
	}

	public void setErrorLog(ErrorLog errorLog) {
		this.errorLog = errorLog;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public Map<String, String> getSelectWayList() {
		return selectWayList;
	}

	public void setSelectWayList(Map<String, String> selectWayList) {
		this.selectWayList = selectWayList;
	}
	
	public String getCategory()
	{
		return category;
	}

	public void setCategory( String category )
	{
		this.category = category;
	}
	
}

