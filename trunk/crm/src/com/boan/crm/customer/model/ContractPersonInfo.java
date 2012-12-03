package com.boan.crm.customer.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 客户联系人信息实体类
 * 
 * @author luojx
 * @version 1.0.0
 */
@Entity
@Table(name = "CONTRACT_PERSON_INFO")
public class ContractPersonInfo implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9165746092571541443L;
	public ContractPersonInfo(){ this.id = ""; }
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	@Column(name = "CUSTOMER_ID" , length = 50)
	private String customerId = "";
	@Column(name = "PERSON_NAME" , length = 50)
	private String personName = "";
	@Column(name = "DEPTORDUTY" , length = 200)
	private String deptOrDuty = "";
	@Column(name = "PHONE" , length = 50)
	private String phone = "";
	@Column(name = "TEL" , length = 50)
	private String tel = "";
	@Column(name = "NICK_NAME" , length = 50)
	private String nickName = "";
	@Column(name = "BIRTHDAY")
	private Calendar birthday = null;
	@Column(name = "ISLUNAR")
	private int lunar = 0;
	@Column(name = "QQ" , length = 50)
	private String qq = "";
	@Column(name = "EMAIL" , length = 100)
	private String email = "";
	@Column(name = "CREATE_TIME")
	private Calendar createTime = null;
	@Column(name = "SORT_INDEX")
	private int sort_index = 0;
	/**
	 * 编号
	 * @return　String
	 */
	public String getId() {
		return id;
	}
	/**
	 * 编号
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 客户编号
	 * @return　String
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * 客户编号
	 * @param customerId
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * 姓名
	 * @return　String
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * 姓名
	 * @param personName
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	/**
	 * 部门/职务
	 * @return String
	 */
	public String getDeptOrDuty() {
		return deptOrDuty;
	}
	/**
	 * 部门/职务
	 * @param deptOrDuty
	 */
	public void setDeptOrDuty(String deptOrDuty) {
		this.deptOrDuty = deptOrDuty;
	}
	/**
	 * 手机
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 手机
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 电话
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 昵称
	 * @return　String
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 昵称
	 * @param nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 生日
	 * @return　Calendar
	 */
	public Calendar getBirthday() {
		return birthday;
	}
	/**
	 * 生日
	 * @param birthday
	 */
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}
	/**
	 * qq
	 * @return String
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * qq
	 * @param qq
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * email
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 创建时间
	 * @return　Calendar
	 */
	public Calendar getCreateTime() {
		return createTime;
	}
	/**
	 *  创建时间
	 * @param createTime
	 */
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	/**
	 * 排序号
	 * @return int
	 */
	public int getSort_index() {
		return sort_index;
	}
	/**
	 * 排序号
	 * @param sort_index
	 */
	public void setSort_index(int sort_index) {
		this.sort_index = sort_index;
	}
	/**
	 * 农历
	 * @return
	 */
	public int getLunar() {
		return lunar;
	}
	/**
	 * 农历
	 * @param lunar
	 */
	public void setLunar(int lunar) {
		this.lunar = lunar;
	}
}
