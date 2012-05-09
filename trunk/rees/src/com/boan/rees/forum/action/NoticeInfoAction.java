package com.boan.rees.forum.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.forum.model.ForumIssueInfo;
import com.boan.rees.forum.model.NoticeInfo;
import com.boan.rees.forum.model.NoticeReadInfo;
import com.boan.rees.forum.service.IForumIssueInfoService;
import com.boan.rees.forum.service.INoticeInfoService;
import com.boan.rees.forum.service.INoticeReadInfoService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;
/**
 * 通知Action
 * @author Luojx
 */
@Controller("noticeInfoAction")
@Scope("prototype")
public class NoticeInfoAction extends BaseActionSupport {
	
	private static final long serialVersionUID = -8890204064921452148L;
	private String issueId = "";
	private String userId = this.sessionUserId;
	private NoticeInfo noticeInfo = new NoticeInfo();
	private String message;
	private String noticeId;
	
	/**
	 * 用于列表显示数据的分页对象
	 */
	private Pagination<ForumIssueInfo> pagination = new Pagination<ForumIssueInfo>();
	/**
	 * 用于列表显示数据的分页对象
	 */
	private Pagination<NoticeInfo> paginationNotice = new Pagination<NoticeInfo>();
	

	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("forumIssueInfoService")
	private IForumIssueInfoService forumIssueInfoService;
	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("noticeInfoService")
	private INoticeInfoService noticeInfoService;
	
//	/**
//	 * 用于调用数据库相关操作
//	 */
//	@Autowired
//	@Qualifier("noticeReadInfoService")
//	private INoticeReadInfoService noticeReadInfoService;
	
	
	/**
	 * 判断是否有新通知
	 */
	public String getNewNoticeCountsByUserId()
	{
		int recordCount = noticeInfoService.getNewNoticeCountsByUserId( this.sessionUserId );
		message = String.valueOf( recordCount );
		return SUCCESS;
	}
	/**
	 * 论坛处发送通知
	 */
	public String sendNotice()
	{
		noticeInfo.setPublisher( sessionUserCName ); 
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
		noticeInfo.setPublisherDept( dept );
		
		ForumIssueInfo forumInfo = forumIssueInfoService.get( issueId );
		if(forumInfo != null)
		{
			noticeInfo.setNoticeTitle( "论坛中：["+forumInfo.getIssueName()+"]需要您参与！" );
			noticeInfo.setNoticeContent( "论坛中：["+forumInfo.getIssueName()+"]需要您参与！<br/>内容：" +forumInfo.getIssueContent() );
		}
		
		noticeInfo.setNoticePublishtime( Calendar.getInstance() );
		try{
			noticeInfoService.save( noticeInfo );
			
			pagination = forumIssueInfoService.findForumIssueInfoForPage(null, pagination);
		}catch(Exception e){
			e.printStackTrace();
			message = "保存失败！";
			return this.INPUT;
		}
		return SUCCESS;
	}
	/**
	 * 通知列表
	 */
	public String openNoticeList()
	{
		Map<String,String> values = new HashMap<String,String>();
		values.put( "userId", this.sessionUserId );
		paginationNotice = noticeInfoService.findNoticeInfoForPage( values, paginationNotice );
		
		return SUCCESS;
	}
	/**
	 * 查看通知
	 */
	public String openNoticeInfo()
	{
		//置通知状态已读
		NoticeReadInfo noticeReadInfo = new NoticeReadInfo();
		noticeReadInfo.setNoticeId( noticeId );
		noticeReadInfo.setUserId( this.sessionUserId );
		
		//noticeReadInfoService.save( noticeReadInfo );
		//显示通知内容
		noticeInfo = noticeInfoService.get( noticeId );
		return SUCCESS;
	}
	public Pagination<NoticeInfo> getPaginationNotice()
	{
		return paginationNotice;
	}
	public void setPaginationNotice( Pagination<NoticeInfo> paginationNotice )
	{
		this.paginationNotice = paginationNotice;
	}
	public String getIssueId()
	{
		return issueId;
	}

	public void setIssueId( String issueId )
	{
		this.issueId = issueId;
	}

	public NoticeInfo getNoticeInfo()
	{
		return noticeInfo;
	}

	public void setNoticeInfo( NoticeInfo noticeInfo )
	{
		this.noticeInfo = noticeInfo;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage( String message )
	{
		this.message = message;
	}
	public Pagination<ForumIssueInfo> getPagination()
	{
		return pagination;
	}

	public void setPagination( Pagination<ForumIssueInfo> pagination )
	{
		this.pagination = pagination;
	}
	
	public String getUserId()
	{
		return userId;
	}
	public void setUserId( String userId )
	{
		this.userId = userId;
	}
	public String getNoticeId()
	{
		return noticeId;
	}
	public void setNoticeId( String noticeId )
	{
		this.noticeId = noticeId;
	}
}
