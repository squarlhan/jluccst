/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */
package com.boan.crm.servicemanage.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 服务日志实体类
 * 
 * @author leon
 * @version 1.0.0
 */
@Entity
@Table(name = "SERVICE_LOG")
public class ServiceLog implements Serializable {
	private static final long serialVersionUID = -5253216291180281080L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	/**
	 * 编号
	 */
	private String id;
	
	/**
	 * 数据对应的单位ID
	 */
	@Column(name = "MY_COMPANY_ID")
	private String myCompanyId;
	
	/**
	 * 客户编号
	 */
	@Column(name = "COMPANY_ID", length = 50)
	private String companyId;

	/**
	 * 客户名称
	 */
	@Column(name = "COMPANY_NAME", length = 200)
	private String companyName;
	
	/**
	 * 联系人
	 */
	@Column(name = "CONTACT", length = 50)
	private String contact;

	/**
	 * 联系人电话
	 */
	@Column(name = "MOBILE_PHONE", length = 100)
	private String mobilePhone;
	
	/**
	 * 服务时间
	 */
	@Column(name = "SERVICE_TIME")
	private Calendar serviceTime;
	
	/**
	 * 到达时间
	 */
	@Column(name = "ARRIVE_TIME")
	private Calendar arriveTime;
	
	/**
	 * 完成时间
	 */
	@Column(name = "FINISH_TIME")
	private Calendar finishTime;
	
	/**
	 * 品牌型号
	 */
	@Column(name = "BRAND_MODEL", length = 50)
	private String brandModel;
	
	/**
	 * 维修员
	 */
	@Column(name = "REPAIRMAIN", length = 50)
	private String repairman;
	
	/**
	 * 故障情况
	 */
	@Column(name = "MALFUNCTION", length = 1000)
	private String malfunction;
	
	/**
	 * 解决措施
	 */
	@Column(name = "SOLUTIONS", length = 1000)
	private String solutions;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the myCompanyId
	 */
	public String getMyCompanyId() {
		return myCompanyId;
	}

	/**
	 * @param myCompanyId the myCompanyId to set
	 */
	public void setMyCompanyId(String myCompanyId) {
		this.myCompanyId = myCompanyId;
	}

	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return the serviceTime
	 */
	public Calendar getServiceTime() {
		return serviceTime;
	}

	/**
	 * @param serviceTime the serviceTime to set
	 */
	public void setServiceTime(Calendar serviceTime) {
		this.serviceTime = serviceTime;
	}

	/**
	 * @return the arriveTime
	 */
	public Calendar getArriveTime() {
		return arriveTime;
	}

	/**
	 * @param arriveTime the arriveTime to set
	 */
	public void setArriveTime(Calendar arriveTime) {
		this.arriveTime = arriveTime;
	}

	/**
	 * @return the finishTime
	 */
	public Calendar getFinishTime() {
		return finishTime;
	}

	/**
	 * @param finishTime the finishTime to set
	 */
	public void setFinishTime(Calendar finishTime) {
		this.finishTime = finishTime;
	}

	/**
	 * @return the brandModel
	 */
	public String getBrandModel() {
		return brandModel;
	}

	/**
	 * @param brandModel the brandModel to set
	 */
	public void setBrandModel(String brandModel) {
		this.brandModel = brandModel;
	}

	/**
	 * @return the repairman
	 */
	public String getRepairman() {
		return repairman;
	}

	/**
	 * @param repairman the repairman to set
	 */
	public void setRepairman(String repairman) {
		this.repairman = repairman;
	}

	/**
	 * @return the malfunction
	 */
	public String getMalfunction() {
		return malfunction;
	}

	/**
	 * @param malfunction the malfunction to set
	 */
	public void setMalfunction(String malfunction) {
		this.malfunction = malfunction;
	}

	/**
	 * @return the solutions
	 */
	public String getSolutions() {
		return solutions;
	}

	/**
	 * @param solutions the solutions to set
	 */
	public void setSolutions(String solutions) {
		this.solutions = solutions;
	}
	
}
