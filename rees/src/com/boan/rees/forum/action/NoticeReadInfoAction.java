package com.boan.rees.forum.action;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.forum.model.NoticeInfo;
import com.boan.rees.forum.model.NoticeReadInfo;
import com.boan.rees.forum.service.INoticeReadInfoService;
import com.boan.rees.utils.action.BaseActionSupport;

/**
 * 通知读取Action
 * @author Luojx
 */
@Controller("noticeReadInfoAction")
@Scope("prototype")
public class NoticeReadInfoAction extends BaseActionSupport{
	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("noticeReadInfoService")
	private INoticeReadInfoService noticeReadInfoService;
	
	private String noticeId = null;
	private String userId = null;
	private String message = null;
	/**
	 * 执行添加论坛信息业务操作
	 * @return success：添加页（带成功提示）   input ： 跳转到添加页并带着错误信息
	 */
	public String readNoticeInfo(){
		try{
			//调用service保存方法向数据库保存信息
			NoticeReadInfo noticeReadInfo = new NoticeReadInfo();
			noticeReadInfo.setNoticeId( noticeId );
			noticeReadInfo.setUserId( userId );
			
			noticeReadInfoService.save( noticeReadInfo );
				
			message = "保存成功！";
		}catch(Exception e){
			e.printStackTrace();
			message = "保存失败！";
			return this.INPUT;
		}
		return NONE;
	}
	public String getNoticeId()
	{
		return noticeId;
	}
	public void setNoticeId( String noticeId )
	{
		this.noticeId = noticeId;
	}
	public String getUserId()
	{
		return userId;
	}
	public void setUserId( String userId )
	{
		this.userId = userId;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage( String message )
	{
		this.message = message;
	}
}
