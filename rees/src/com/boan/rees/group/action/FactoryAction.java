package com.boan.rees.group.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.boan.rees.group.model.Factory;
import com.boan.rees.group.service.IFactoryService;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;

@Controller("factoryAction")
@Scope("prototype")
public class FactoryAction extends ActionSupport{
	@Autowired
	@Qualifier("factoryService")
	private IFactoryService service;
	
	/**
	 * 显示分页
	 */
	Pagination<Factory> pagination = new Pagination<Factory>();	
	
	/**
	 * 页面对象
	 */
	private Factory factory;
	//**************get and set method*********************************

	public Pagination<Factory> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Factory> pagination) {
		this.pagination = pagination;
	}

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	//*****************数据库操作****************************************
	/**
	 * 显示工厂列表
	 * @return
	 */	
	public String openFactory(){
		pagination = service.findFactoryForPage(null, pagination);
		return SUCCESS;
	}
	/**
	 * 打开添加工厂页面
	 * @return
	 */
	public String openAddFactory(){
		return SUCCESS;
	}
	/**
	 * 添加工厂信息
	 * @return
	 */
	public String toAddFactory(){
		service.save(factory);
		return SUCCESS;
	}
}
