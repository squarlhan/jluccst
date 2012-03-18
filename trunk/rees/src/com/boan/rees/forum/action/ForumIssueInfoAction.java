package com.boan.rees.forum.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.forum.model.ForumIssueInfo;
import com.boan.rees.forum.service.IForumIssueInfoService;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 论坛议题Action
 * @author YangYJ
 * @version 1.0.0
 */
@Controller("forumIssueInfoAction")
@Scope("prototype")
public class ForumIssueInfoAction extends ActionSupport {

	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("forumIssueInfoService")
	private IForumIssueInfoService forumIssueInfoService;
	
	/**
	 * 定义一个实体用于添加/修改页的数据绑定和显示
	 */
	private ForumIssueInfo forumIssueInfo;
	
	/**
	 * 用于列表显示数据的分页对象
	 */
	private Pagination<ForumIssueInfo> pagination = new Pagination<ForumIssueInfo>();
	
	/**
	 * 显示列表页
	 * @return
	 */
	public String openForumIssueInfo(){
		pagination = forumIssueInfoService.findForumIssueInfoForPage(null, pagination);
		return this.SUCCESS;
	}
	
	/**
	 * 打开添加页面
	 * @return success：跳转到添加页   input ： 跳转到添加页并带着错误信息
	 */
	public String openAddForumIssueInfo(){
		System.out.println("如果添加页需要做一些初始化操作 ，在这写代码！");
		return this.SUCCESS;
	}

	/**
	 * 执行添加论坛信息业务操作
	 * @return success：添加页（带成功提示）   input ： 跳转到添加页并带着错误信息
	 */
	public String toAddForumIssueInfo(){
		System.out.println(forumIssueInfo.getIssueConteit());
		try{
			//调用service保存方法向数据库保存信息
			forumIssueInfoService.save(forumIssueInfo);
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

	public ForumIssueInfo getForumIssueInfo() {
		return forumIssueInfo;
	}

	public void setForumIssueInfo(ForumIssueInfo forumIssueInfo) {
		this.forumIssueInfo = forumIssueInfo;
	}

	public Pagination<ForumIssueInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<ForumIssueInfo> pagination) {
		this.pagination = pagination;
	}
}


