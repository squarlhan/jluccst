package com.boan.rees.forum.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.boan.rees.forum.model.ForumIssueInfo;
import com.boan.rees.forum.model.ForumMessageInfo;
import com.boan.rees.forum.service.IForumIssueInfoService;
import com.boan.rees.forum.service.IForumMessageInfoService;
import com.boan.rees.utils.calendar.CalendarUtils;
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
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("forumIssueInfoService")
	private IForumIssueInfoService forumIssueInfoService;
	/**
	 * 定义一个实体用于添加/修改页的数据绑定和显示
	 */
	private ForumMessageInfo forumMessageInfo;
	/**
	 * 用于列表显示数据的分页对象
	 */
	private Pagination<ForumMessageInfo> pagination = new Pagination<ForumMessageInfo>();
	/**
	 * 话题Id
	 */
	private String issueId = "";
	/**
	 * 查询开始时间
	 */
	private Calendar queryBeginTime = null;
	/**
	 * 查询结束时间
	 */
	private Calendar queryEndTime = null;
	

	/**
	 * 话题对象信息
	 */
	private ForumIssueInfo forumIssueInfo = null;
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
		
		forumIssueInfo = forumIssueInfoService.get( issueId );
		Map<String,String> values = new HashMap<String,String>();
		values.put( "issueId", issueId );
		if(queryBeginTime == null)
		{
			values.put("beginTime",CalendarUtils.toString( Calendar.getInstance() ) + " 00:00:00");
			values.put("endTime",CalendarUtils.toString( Calendar.getInstance() ) + " 23:59:59");
		}
		pagination = forumMessageInfoService.findForumMessageInfoForPage( values, pagination );
		
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
public String getIssueId()
{
	return issueId;
}

public void setIssueId( String issueId )
{
	this.issueId = issueId;
}
public Calendar getQueryBeginTime()
{
	return queryBeginTime;
}
public void setQueryBeginTime( Calendar queryBeginTime )
{
	this.queryBeginTime = queryBeginTime;
}
public Calendar getQueryEndTime()
{
	return queryEndTime;
}
public void setQueryEndTime( Calendar queryEndTime )
{
	this.queryEndTime = queryEndTime;
}
}


