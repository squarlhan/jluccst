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
	 * 
	 */
	private static final long serialVersionUID = -2343028207546084327L;

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
	
	private String message;
	/**
	 * 页面所选行的id
	 */
	private String[] ids;
	

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
	
	
	//*******************************************************************************************
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
		//System.out.println("如果添加页需要做一些初始化操作 ，在这写代码！");
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
	/**
	 * 删除数据
	 * @return
	 */
	public String deleteForumIssueInfo(){
		forumIssueInfoService.deleteForumIssueInfo(ids);
		return NONE;
	}
	/**
	 * 为修改页面做准备
	 * @return
	 */
	public String openModifyforumIssueInfo(){
		String id = forumIssueInfo.getId();
		forumIssueInfo = forumIssueInfoService.get(id);
		return SUCCESS;
	}
	
	/**
	 * 修改话题信息
	 * @return
	 */
	public String toModifyforumIssueInfo(){
		forumIssueInfo.update(forumIssueInfo);
		return SUCCESS;
	}
	
	/**
	 * 修改信息
	 * @return
	 */
	public String toModifyDemo(){
		return toAddForumIssueInfo();
	}
	
}


