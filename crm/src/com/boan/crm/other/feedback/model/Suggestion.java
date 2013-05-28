package com.boan.crm.other.feedback.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 意见
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "OTHER_SUGGESTION")
public class Suggestion implements java.io.Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4330231613101409127L;

	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;

	/**
	 * 功能菜单key
	 */
	@Column(name = "MENU_KEY" , length = 50)
	private String menuKey;

	/**
	 * 功能菜单名称
	 */
	@Column(name = "MENU_NAME" , length = 50)
	private String menuName;

	/**
	 * 意见内容
	 */
	@Column(name = "CONTENT" , length = 4000)
	private String content;

	/**
	 * 用户id
	 */
	@Column(name = "USER_ID" , length = 50)
	private String userId;

	/**
	 * 用户姓名
	 */
	@Column(name = "USER_NAME" , length = 50)
	private String userName;

	/**
	 * 所在机构id
	 */
	@Column(name = "ORGAN_ID" , length = 50)
	private String organId;

	/**
	 * 所在机构名称
	 */
	@Column(name = "ORGAN_NAME" , length = 50)
	private String organName;

	/**
	 * 单位id
	 */
	@Column(name = "UNIT_ID" , length = 50)
	private String unitId;

	/**
	 * 单位名称
	 */
	@Column(name = "UNIT_NAME" , length = 50)
	private String unitName;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME" )
	private Calendar createTime;

	/**
	 * 回复状态，0表示未回复，1表示已回复
	 */
	@Column(name = "REPLY_STATUS" )
	private int replyStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuKey() {
		return menuKey;
	}

	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
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

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public int getReplyStatus() {
		return replyStatus;
	}

	public void setReplyStatus(int replyStatus) {
		this.replyStatus = replyStatus;
	}

}
