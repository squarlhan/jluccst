package com.boan.crm.sms.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.boan.crm.customer.model.CustomerInfo;

/***
 * 短信名片信息实体
 * @author Administrator
 *
 */
@Entity
@Table(name = "SMS_CUSTOMER_INFO")
public class SMSCustomerInfo {

	private static final long serialVersionUID = 7197292703142337721L;

	/**
	 * 编号
	 */
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(name = "ID", length=50)
	private String id;
	
	/**
	 * 客户联系人Id（用于将客户保存时保存为SMSCustomerInfo对象，在客户联系人删除时使用这个Id删除）
	 */
	@Column(name = "CUSTOMER_ID" , length = 50)
	private String customerId;

	/**
	 * 所属销售人员Id
	 */
	@Column(name = "SALESMAN_ID" , length = 50)
	private String salesmanId;
	
	/**
	 * 人员所属机构或公司Id
	 */
	@Column(name = "ORGAN_ID", length=50)
	private String organId;
	
	/**
	 * 人员所属机构或公司名称
	 */
	@Column(name = "ORGAN_NAME", length=200)
	private String organName;

	/**
	 * 電話號
	 */
	@Column(name = "PHONE" , length = 50)
	private String phone;
	
	/**
	 * 姓名
	 */
	@Column(name = "NAME" , length = 200)
	private String name;
	
	/**
	 * 姓名全拼
	 */
	@Column(name = "NAME_SPELL" , length = 500)
	private String nameSpell;
	
	/**
	 * 昵称
	 */
	@Column(name = "NICKNAME" , length = 250)
	private String nickname;
	
	/**
	 * 敬称（先生、小姐...）
	 */
	@Column(name = "APPELLATION" , length =250)
	private String appellation;
	
	/**
	 * 职务
	 */
	@Column(name = "POST" , length = 250)
	private String post;
	
	/**
	 * 性别（0：男   1：女）
	 */
	@Column(name = "SEX" , length = 1)
	private int sex;
	
	/**
	 * 生日
	 */
	@Column(name = "BIRTHDAY")
	private Calendar birthday;
	
	/**
	 * 是否是阴历（0：阴历  1：阳历）
	 */
	@Column(name = "IS_LUNAR_CALENDER" , length = 1)
	private int isLunarCalender;
	
	/**
	 * 传真
	 */
	@Column(name = "FAXES" , length = 100)
	private String faxes;
	
	/**
	 * Email
	 */
	@Column(name = "EMAIL" , length = 100)
	private String email;
	
	/**
	 * QQ号
	 */
	@Column(name = "QQ" , length = 20)
	private String qq;
	
	/**
	 * 单位
	 */
	@Column(name = "UNIT" , length = 100)
	private String unit; 
	
	/**
	 * 单位地址
	 */
	@Column(name = "UNIT_ADDRESS" , length = 100)
	private String unitAddress; 
	
	/**
	 * 邮政编码
	 */
	@Column(name = "POSTALCODE" , length = 20)
	private String postalcode; 
	
	/**
	 * 名片分类Id  客户:1  销售人员：2
	 */
	@Column(name = "CATEGORY_ID" , length = 50)
	private String categoryId;
	
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME" , length = 100)
	private Calendar createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public int getIsLunarCalender() {
		return isLunarCalender;
	}

	public void setIsLunarCalender(int isLunarCalender) {
		this.isLunarCalender = isLunarCalender;
	}

	public String getFaxes() {
		return faxes;
	}

	public void setFaxes(String faxes) {
		this.faxes = faxes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnitAddress() {
		return unitAddress;
	}

	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public String getNameSpell() {
		return nameSpell;
	}

	public void setNameSpell(String nameSpell) {
		this.nameSpell = nameSpell;
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

	public String getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(String salesmanId) {
		this.salesmanId = salesmanId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
