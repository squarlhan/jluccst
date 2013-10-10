package com.boan.crm.actionplan.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 行动计划对象
 * @author YF
 *
 */
@Entity
@Table(name = "ACTION_PLAN")
public class ActionPlan implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	@Column(name = "PERSON_ID" , length = 50)
	private String personId;
	
	@Column(name = "ORGAN_ID" , length = 50)
	private String organId;
	
	@Column(name = "EMPLOYEE_ID" , length = 50)
	private String employeeId;
	
	@Column(name = "EMPLOYEE_NAME" , length = 50)
	private String employeeName;
	
	@Column(name = "DEPT_ID" , length = 50)
	private String deptId;
	
	@Column(name = "DEPT_NAME" , length = 50)
	private String deptName;
	
	@Column(name = "PLAN_TYPE" , length = 50)
	private String planType;
	
	@Column(name = "SUBMIT_TIME" , length = 50)
	private Calendar submitTime;
	
	@Column(name = "PLAN_CONTENT" , length = 4000)
	private String planContent;
	
	@Column(name = "MEMO" , length = 4000)
	private String memo;
	
	@Column(name = "CREATE_TIME")
	private Calendar createTime;
	
	@Column(name = "TRACK_OR_VISIT_ID" , length = 50)
	private String trackOrVisitId;
	
	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 员工Id
	 * @return
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * 员工Id
	 * @param employeeId
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * 员工姓名
	 * @return
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * 员工姓名
	 * @param employeeName
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * 员工部门Id
	 * @return
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 *  员工Id
	 * @param deptId
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 *  员工部门
	 * @return
	 */
	public String getDeptName() {
		return deptName;
	}

	/** 
	 *  员工部门
	 * @param deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * 计划类型
	 * @return
	 */
	public String getPlanType() {
		return planType;
	}

	/**
	 * 计划类型
	 * @param planType
	 */
	public void setPlanType(String planType) {
		this.planType = planType;
	}

	/**
	 * 提交时间
	 * @return
	 */
	public Calendar getSubmitTime() {
		return submitTime;
	}

	/**
	 * 提交时间
	 * @param submitTime
	 */
	public void setSubmitTime(Calendar submitTime) {
		this.submitTime = submitTime;
	}

	/**
	 * 计划内容
	 * @return
	 */
	public String getPlanContent() {
		return planContent;
	}

	/**
	 * 计划内容
	 * @param planContent
	 */
	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}

	/**
	 * 总结
	 * @return
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * 总结
	 * @param memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * 创建时间
	 * @return
	 */
	public Calendar getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 * @param createTime
	 */
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	/**
	 * 公司Id
	 * @param organId
	 */
	public String getOrganId() {
		return organId;
	}

	/**
	 * 公司Id
	 * @param organId
	 */
	public void setOrganId(String organId) {
		this.organId = organId;
	}

	/**
	 * @return the trackOrVisitId
	 */
	public String getTrackOrVisitId() {
		return trackOrVisitId;
	}

	/**
	 * @param trackOrVisitId the trackOrVisitId to set
	 */
	public void setTrackOrVisitId(String trackOrVisitId) {
		this.trackOrVisitId = trackOrVisitId;
	}
}
