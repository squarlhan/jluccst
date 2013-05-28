package com.boan.crm.other.feedback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 意见反馈
 * @author Administrator
 *
 */
@Entity
@Table(name = "OTHER_SUGGESTION_REPLY")
public class SuggestionReply implements java.io.Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3756919360106534955L;
	
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	/**
	 * 意见id
	 */
	@Column(name = "SUGGESTION_ID" , length = 50)
	private String suggestionId;
	
	/**
	 * 回复内容
	 */
	@Column(name = "CONTENT" , length = 50)
	private String content;
	
	/**
	 * 回复用户id
	 */
	@Column(name = "USER_ID" , length = 50)
	private String userId;
	
	/**
	 * 回复用户姓名
	 */
	@Column(name = "USER_NAME" , length = 50)
	private String userName;
	
	/**
	 * 回复时间
	 */
	@Column(name = "REPLY_TIME" )
	private String replyTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(String suggestionId) {
		this.suggestionId = suggestionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

}
