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
	 * 申请人
	 */
	@Column(name = "PETITIONER", length = 50)
	private String petitioner;
	
	/**
	 * 申请时间
	 */
	@Column(name = "PETITION_TIME")
	private Calendar petitionTime;

	/**
	 * 电话
	 */
	@Column(name = "TELEPHONE", length = 100)
	private String telephone;
	
	/**
	 * 服务事项
	 */
	@Column(name = "SERVICE_MATTER", length = 1000)
	private String serviceMatter;
	
	/**
	 * 服务人员
	 */
	@Column(name = "SERVICE_USER", length = 50)
	private String serviceUser;
	
	/**
	 * 客服人员
	 */
	@Column(name = "CUSTOMER_SERVICE", length = 50)
	private String customerService; 
	
	/**
	 * 预计收费
	 */
	@Column(name = "PLAN_CHARGES")
	private float planCharges = 0; 
	
	//------------------------------------------------------------------
	
	/**
	 * 到达时间
	 */
	@Column(name = "ARRIVE_TIME")
	private Calendar arriveTime;
	
	/**
	 * 离开时间
	 */
	@Column(name = "LEAVE_TIME")
	private Calendar leaveTime;
	
	/**
	 * 现场问题诊断
	 */
	@Column(name = "PROBLEM_DIAGNOSIS", length = 1000)
	private String problemDiagnosis;
	
	/**
	 * 问题解决方案
	 */
	@Column(name = "SOLUTION", length = 1000)
	private String solution;
	
	/**
	 * 实际现场服务人员
	 */
	@Column(name = "ACT_SERVICE_USER", length = 50)
	private String actServiceUser;
	
	/**
	 * 实际收费
	 */
	@Column(name = "ACT_CHARGES")
	private float actCharges = 0; 
	
	/**
	 * 是否收到回执
	 */
	@Column(name = "RECEIPT")
	private int receipt = 0; 
	
	//------------------------------------------------------------------
	
	/**
	 * 回访时间
	 */
	@Column(name = "RETURN_VISIT_TIME")
	private Calendar returnVisitTime;
	
	/**
	 * 回访方式
	 */
	@Column(name = "RETURN_VISIT_TYPE", length = 50)
	private String returnVisitType;
	
	/**
	 * 回访人员
	 */
	@Column(name = "RETURN_VISIT_USER", length = 50)
	private String returnVisitUser;
	
	/**
	 * 客户反馈
	 */
	@Column(name = "CUSTOMER_FEEDBACK", length = 1000)
	private String customerFeedback;
	
	/**
	 * 满意度
	 */
	@Column(name = "DEGREE_SATISFACTION")
	private int degreeSatisfaction = 0;

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
	 * @return the petitioner
	 */
	public String getPetitioner() {
		return petitioner;
	}

	/**
	 * @param petitioner the petitioner to set
	 */
	public void setPetitioner(String petitioner) {
		this.petitioner = petitioner;
	}

	/**
	 * @return the petitionTime
	 */
	public Calendar getPetitionTime() {
		return petitionTime;
	}

	/**
	 * @param petitionTime the petitionTime to set
	 */
	public void setPetitionTime(Calendar petitionTime) {
		this.petitionTime = petitionTime;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the serviceMatter
	 */
	public String getServiceMatter() {
		return serviceMatter;
	}

	/**
	 * @param serviceMatter the serviceMatter to set
	 */
	public void setServiceMatter(String serviceMatter) {
		this.serviceMatter = serviceMatter;
	}

	/**
	 * @return the serviceUser
	 */
	public String getServiceUser() {
		return serviceUser;
	}

	/**
	 * @param serviceUser the serviceUser to set
	 */
	public void setServiceUser(String serviceUser) {
		this.serviceUser = serviceUser;
	}

	/**
	 * @return the customerService
	 */
	public String getCustomerService() {
		return customerService;
	}

	/**
	 * @param customerService the customerService to set
	 */
	public void setCustomerService(String customerService) {
		this.customerService = customerService;
	}

	/**
	 * @return the planCharges
	 */
	public float getPlanCharges() {
		return planCharges;
	}

	/**
	 * @param planCharges the planCharges to set
	 */
	public void setPlanCharges(float planCharges) {
		this.planCharges = planCharges;
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
	 * @return the leaveTime
	 */
	public Calendar getLeaveTime() {
		return leaveTime;
	}

	/**
	 * @param leaveTime the leaveTime to set
	 */
	public void setLeaveTime(Calendar leaveTime) {
		this.leaveTime = leaveTime;
	}

	/**
	 * @return the problemDiagnosis
	 */
	public String getProblemDiagnosis() {
		return problemDiagnosis;
	}

	/**
	 * @param problemDiagnosis the problemDiagnosis to set
	 */
	public void setProblemDiagnosis(String problemDiagnosis) {
		this.problemDiagnosis = problemDiagnosis;
	}

	/**
	 * @return the solution
	 */
	public String getSolution() {
		return solution;
	}

	/**
	 * @param solution the solution to set
	 */
	public void setSolution(String solution) {
		this.solution = solution;
	}

	/**
	 * @return the actServiceUser
	 */
	public String getActServiceUser() {
		return actServiceUser;
	}

	/**
	 * @param actServiceUser the actServiceUser to set
	 */
	public void setActServiceUser(String actServiceUser) {
		this.actServiceUser = actServiceUser;
	}

	/**
	 * @return the actCharges
	 */
	public float getActCharges() {
		return actCharges;
	}

	/**
	 * @param actCharges the actCharges to set
	 */
	public void setActCharges(float actCharges) {
		this.actCharges = actCharges;
	}

	/**
	 * @return the receipt
	 */
	public int getReceipt() {
		return receipt;
	}

	/**
	 * @param receipt the receipt to set
	 */
	public void setReceipt(int receipt) {
		this.receipt = receipt;
	}

	/**
	 * @return the returnVisitTime
	 */
	public Calendar getReturnVisitTime() {
		return returnVisitTime;
	}

	/**
	 * @param returnVisitTime the returnVisitTime to set
	 */
	public void setReturnVisitTime(Calendar returnVisitTime) {
		this.returnVisitTime = returnVisitTime;
	}

	/**
	 * @return the returnVisitType
	 */
	public String getReturnVisitType() {
		return returnVisitType;
	}

	/**
	 * @param returnVisitType the returnVisitType to set
	 */
	public void setReturnVisitType(String returnVisitType) {
		this.returnVisitType = returnVisitType;
	}

	/**
	 * @return the returnVisitUser
	 */
	public String getReturnVisitUser() {
		return returnVisitUser;
	}

	/**
	 * @param returnVisitUser the returnVisitUser to set
	 */
	public void setReturnVisitUser(String returnVisitUser) {
		this.returnVisitUser = returnVisitUser;
	}

	/**
	 * @return the customerFeedback
	 */
	public String getCustomerFeedback() {
		return customerFeedback;
	}

	/**
	 * @param customerFeedback the customerFeedback to set
	 */
	public void setCustomerFeedback(String customerFeedback) {
		this.customerFeedback = customerFeedback;
	}

	/**
	 * @return the degreeSatisfaction
	 */
	public int getDegreeSatisfaction() {
		return degreeSatisfaction;
	}

	/**
	 * @param degreeSatisfaction the degreeSatisfaction to set
	 */
	public void setDegreeSatisfaction(int degreeSatisfaction) {
		this.degreeSatisfaction = degreeSatisfaction;
	}
}
