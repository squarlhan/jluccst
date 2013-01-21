package com.boan.crm.backstagemanage.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import com.boan.crm.backstagemanage.common.ProductType;
import com.boan.crm.utils.calendar.CurrentDateTime;
import com.boan.crm.utils.calendar.MySimpleDateFormat;

/**
 * 公司实体类
 * 
 * @author XXX
 * @version 1.0.0
 */
@Entity
@Table(name = "GROUP_COMPANY")
public class Company {

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	/**
	 * 公司实体主键
	 */
	private String id;

	public Company() {
		this.id = "";
	}

	/**
	 * 公司电话
	 */
	@Column(name = "PHONE")
	private String phone;

	/**
	 * 公司地址
	 */
	@Column(name = "ADDRESS")
	private String address;

	/**
	 * 公司名称
	 */
	@Column(name = "COMPANY_NAME")
	private String companyName;

	/**
	 * 传真
	 */
	@Column(name = "FAX")
	private String fax;

	/**
	 * 法人
	 */
	@Column(name = "CORPORATION")
	private String corporation;

	/**
	 * 公司短信序号列
	 */
	@Column(name = "SMS_SN")
	private String smsSN;

	/**
	 * 公司短信密码
	 */
	@Column(name = "SMS_PASSWORD")
	private String smsPassword;

	/**
	 * 公司短信Key
	 */
	@Column(name = "SMS_KEY")
	private String smsKey;

	/**
	 * 短信服务是否已被激活的标识，1表示激活，0表示注销
	 */
	@Column(name = "SMS_ACTIVATION_STATUS")
	private int smsActivationStatus;

	/**
	 * 服务截至日期，如果没有，则表示无限期服务
	 */
	@Column(name = "SERVICE_TERM", length = 50)
	private String serviceTerm;

	/**
	 * 公司排序号
	 */
	@Column(name = "SORT_INDEX")
	private int sortIndex = 99;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar createTime = Calendar.getInstance();
	
	/**
	 * 试用标识，1表示试用，0表示正式版
	 */
	@Column(name = "TRIAL_FLAG", nullable=false)
	private int  trialFlag;

	/**
	 * 如果公司下有部门或有人，则不能删除
	 */
	@Transient
	private int deleteFlag = 0;
	/**
	 * 产品类型
	 */
	@Column(name = "PRODUCT_TYPE", nullable=false)
	private int productType = 0;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getSmsSN() {
		return smsSN;
	}

	public void setSmsSN(String smsSN) {
		this.smsSN = smsSN;
	}

	public String getSmsPassword() {
		return smsPassword;
	}

	public void setSmsPassword(String smsPassword) {
		this.smsPassword = smsPassword;
	}

	public String getSmsKey() {
		return smsKey;
	}

	public void setSmsKey(String smsKey) {
		this.smsKey = smsKey;
	}

	public int getSmsActivationStatus() {
		return smsActivationStatus;
	}

	public void setSmsActivationStatus(int smsActivationStatus) {
		this.smsActivationStatus = smsActivationStatus;
	}

	public String getServiceTerm() {
		return serviceTerm;
	}

	public String getServiceTermCn() {
		if (StringUtils.isNotBlank(serviceTerm)) {
			return serviceTerm;
		} else {
			return "无限期";
		}
	}

	public void setServiceTerm(String serviceTerm) {
		this.serviceTerm = serviceTerm;
	}
	/**
	 * 判断是否过服务期限，如果超了，则不能继续服务了
	 * @return
	 */
	public boolean checkServiceTerm(){
		if( StringUtils.isBlank(serviceTerm) ){
			//无限期
			return false;
		}
		Calendar endDate = MySimpleDateFormat.parse(serviceTerm +  " 00:00:00");
		Calendar cal = Calendar.getInstance();
		int c = CurrentDateTime.compareBothDate(cal, endDate);
		if( c > 0){
			//过期
			return true;
		}else{
			//没过期
			return false;
		}
	}

	public int getTrialFlag() {
		return trialFlag;
	}

	public void setTrialFlag(int trialFlag) {
		this.trialFlag = trialFlag;
	}
	
	public String getTrialFlagCn(){
		if( trialFlag == 1 ){
			return "<font color='red'>有限制</font>";
		}else{
			return "无限制";
		}
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}
	
	public String getProductTypeCn() {
		return ProductType.getMean(productType);
	}
}
