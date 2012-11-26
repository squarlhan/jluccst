package com.boan.rees.forum.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.boan.rees.forum.model.ForumIssueInfo;
import com.boan.rees.forum.model.ForumMessageInfo;
import com.boan.rees.forum.model.NoticeReadInfo;
import com.boan.rees.forum.service.IForumIssueInfoService;
import com.boan.rees.forum.service.IForumMessageInfoService;
import com.boan.rees.forum.service.INoticeReadInfoService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;

/**
 * 论坛议题Action
 * @author YangYJ
 * @version 1.0.0
 */
@Controller("forumMessageInfoAction")
@Scope("prototype")
public class ForumMessageInfoAction extends BaseActionSupport {

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
	
	@Autowired
	@Qualifier("noticeReadInfoService")
	private INoticeReadInfoService noticeReadInfoService;
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
	 * 通知Id
	 */
	private String noticeId = "";
	
	public String getNoticeId()
	{
		return noticeId;
	}
	public void setNoticeId( String noticeId )
	{
		this.noticeId = noticeId;
	}

	/**
	 * 话题对象信息
	 */
	private ForumIssueInfo forumIssueInfo = new ForumIssueInfo();
	/**
	 * 参与人
	 */
	private List<Object[]> joinPersonList = null;
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
		
		if(noticeId != null && noticeId.length() > 0)
		{
			NoticeReadInfo noticeReadInfo = new NoticeReadInfo();
			noticeReadInfo.setNoticeId( noticeId );
			noticeReadInfo.setUserId( sessionUserId );
			
			noticeReadInfoService.save( noticeReadInfo );
		}
		
		
		forumIssueInfo = forumIssueInfoService.get( issueId );
		if(forumIssueInfo != null)
		{
			forumIssueInfo.setIssueContent( forumIssueInfo.getIssueContent().replaceAll( "\r\n", "<br/>" ) );
			Map<String,String> values = new HashMap<String,String>();
			values.put( "issueId", issueId );
			pagination.setCurrentPage( 1 );
			pagination.setPageSize( 100 );
			pagination = forumMessageInfoService.findForumMessageInfoForPage( values, pagination );
			
			joinPersonList = forumMessageInfoService.joinPerson(issueId);
		}else
		{
			message = "话题已经被删除，请查看其他话题！";
			return INPUT;
		}
		return this.SUCCESS;
	}

/**
 * 执行添加论坛信息业务操作
 * @return success：添加页（带成功提示）   input ： 跳转到添加页并带着错误信息
 */
public String toAddForumMessageInfo(){
	try{
		//调用service保存方法向数据库保存信息
		forumMessageInfo.setMessageTime( Calendar.getInstance() );
		
		forumMessageInfo.setPublisher( sessionUserCName );
		String dept = "";
		if(sessionCompanyName != null && sessionCompanyName.length() > 0)
		{
			dept = sessionCompanyName;
		}
		if(sessionFactoryName != null && sessionFactoryName.length() > 0)
		{
			dept = dept + " " +sessionFactoryName;
		}
		if(sessionWorkshopName != null && sessionWorkshopName.length() > 0)
		{
			dept = dept + " " +sessionWorkshopName;
		}
		forumMessageInfo.setPublisherDept( dept.trim() );
		
		forumMessageInfoService.save(forumMessageInfo);
		message = "保存成功！";
		
		forumMessageInfo = null;
		forumIssueInfo = forumIssueInfoService.get( issueId );
		
		Map<String,String> values = new HashMap<String,String>();
		values.put( "issueId", issueId );
		pagination.setCurrentPage( 1 );
		pagination.setPageSize( 100 );
		pagination = forumMessageInfoService.findForumMessageInfoForPage( values, pagination );
		
		joinPersonList = forumMessageInfoService.joinPerson(issueId);
		
		//return NONE;
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
public ForumIssueInfo getForumIssueInfo()
{
	return forumIssueInfo;
}
public void setForumIssueInfo( ForumIssueInfo forumIssueInfo )
{
	this.forumIssueInfo = forumIssueInfo;
}
public List<Object[]> getJoinPersonList()
{
	return joinPersonList;
}

public void setJoinPersonList( List<Object[]> joinPersonList )
{
	this.joinPersonList = joinPersonList;
}

//********************************************************************************************
public void setForumMessageInfo(ForumMessageInfo forumMessageInfo) {
	this.forumMessageInfo = forumMessageInfo;
}
}


