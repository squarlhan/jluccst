
/*
 * @(#)DemoAction.java 1.1 2012-3-5
 */

package com.boan.rees.demo.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.demo.model.DemoModel;
import com.boan.rees.demo.service.IDemoService;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 例子Action
 * @author ZhuYF
 * @version 1.0.0
 */
@Controller("demoAction")
@Scope("prototype")
public class DemoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("demoService")
	private IDemoService demoService;
	
	/**
	 * 页面对象
	 */
	private DemoModel demoModel;
	
	/**
	 * 页面对象列表
	 */
	private List<DemoModel> demoModelList;
	
	/**
	 * 页面所选行的id
	 */
	private String[] ids;
	
	/**
	 * 页面需要初始化的数据
	 */
	private String initString;
	
	/**
	 * 分页列表
	 */
	Pagination<DemoModel> pagination = new Pagination<DemoModel>();
	
	public Pagination<DemoModel> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<DemoModel> pagination) {
		this.pagination = pagination;
	}

	public DemoModel getDemoModel() {
		return demoModel;
	}

	public void setDemoModel(DemoModel demoModel) {
		this.demoModel = demoModel;
	}
	
	public String getInitString() {
		return initString;
	}

	public void setInitString(String initString) {
		this.initString = initString;
	}

	public List<DemoModel> getDemoModelList() {
		return demoModelList;
	}

	public void setDemoModelList(List<DemoModel> demoModelList) {
		this.demoModelList = demoModelList;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
	 * 打开list表方法
	 * @return
	 */
	public String openDemo(){
		pagination = demoService.findDemoModelForPage(new HashMap(), pagination);
		return SUCCESS;          
	}

	/**
	 * 打开新增页面做准备
	 * @return
	 */
	public String openAddDemo(){
		initString = "是我一个在保存前要初始化的属性";
		return SUCCESS;
	}
	
	/**
	 * 添加新数据
	 * @return
	 */
	public String toAddDemo(){
		demoService.save(demoModel);
		return SUCCESS;
	}
	
	/**
	 * 为修改页面做准备
	 * @return
	 */
	public String openModifyDemo(){
		String id = demoModel.getId();
		demoModel = demoService.get(id);
		return SUCCESS;
	}
	
	/**
	 * 修改数据
	 * @return
	 */
	public String toModifyDemo(){
		return toAddDemo();
	}
	
	/**
	 * 删除数据
	 * @return
	 */
	public String deleteDemo(){
//		int d = ids.length;
//		String id = demoModel.getId();
		demoService.deleteDemoModel(ids);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	private String param="分页时要传递的参数";
//	
//	private Integer pageNo=1;   
//    private Integer total=100;
//
//	public Integer getPageNo() {
//		return pageNo;
//	}
//
//	public void setPageNo(Integer pageNo) {
//		this.pageNo = pageNo;
//	}
//
//	public Integer getTotal() {
//		return total;
//	}
//
//	public void setTotal(Integer total) {
//		this.total = total;
//	}
//
	public String getParam() {
		return param;
	}

	public void setParam(String param) throws UnsupportedEncodingException {
		param = new String( param.getBytes( "ISO8859-1" ), "GB2312" );
		this.param = param;
	}
}


