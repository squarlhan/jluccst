package com.boan.rees.forum.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.forum.model.ForumIssueInfo;
import com.boan.rees.forum.model.ForumMessageInfo;
import com.boan.rees.forum.model.ForumMessageInfo;
import com.boan.rees.forum.service.IForumMessageInfoService;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 论坛议题Action
 * @author YangYJ
 * @version 1.0.0
 */
@Controller("forumMessageInfoAction")
@Scope("prototype")
public class ForumMessageInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("forumMessageInfoService")
	private IForumMessageInfoService forumMessageInfoService;
	
	/**
	 * 定义一个实体用于添加/修改页的数据绑定和显示
	 */
	private ForumMessageInfo forumMessageInfo;
	
	/**
	 * 用于列表显示数据的分页对象
	 */
	private Pagination<ForumMessageInfo> pagination = new Pagination<ForumMessageInfo>();
	
	
	
	
	//********************************************************************************************
	
	
	

	public void setForumMessageInfo(ForumMessageInfo forumMessageInfo) {
		this.forumMessageInfo = forumMessageInfo;
	}

	/**
	 * 显示列表页
	 * @return
	 */
	public String openForumMessageInfo(){
		pagination = forumMessageInfoService.findForumMessageInfoForPage(null, pagination);
		return this.SUCCESS;
	}
	
	/**
	 * 打开添加页面
	 * @return success：跳转到添加页   input ： 跳转到添加页并带着错误信息
	 */
	public String openAddForumMessageInfo(){
		//System.out.println("如果添加页需要做一些初始化操作 ，在这写代码！");
		return this.SUCCESS;
	}

/**
 * 执行添加论坛信息业务操作
 * @return success：添加页（带成功提示）   input ： 跳转到添加页并带着错误信息
 */
public String toAddForumIssueInfo(){
	System.out.println(forumMessageInfo.getMessageContent());
	try{
		//调用service保存方法向数据库保存信息
		forumMessageInfoService.save(forumMessageInfo);
		message = "保存成功！";
	}catch(Exception e){
		e.printStackTrace();
		message = "保存失败！";
		return this.INPUT;
	}
	return this.SUCCESS;
}

private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public ForumMessageInfo getForumMessageInfo() {
	return forumMessageInfo;
}

public void setForumIssueInfo(ForumMessageInfo forumMessageInfo) {
	this.forumMessageInfo = forumMessageInfo;
}

public Pagination<ForumMessageInfo> getPagination() {
	return pagination;
}

public void setPagination(Pagination<ForumMessageInfo> pagination) {
	this.pagination = pagination;
}
}


