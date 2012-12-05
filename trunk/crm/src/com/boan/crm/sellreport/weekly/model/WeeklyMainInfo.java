package com.boan.crm.sellreport.weekly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "WEEKLY_MAIN_INFO")
public class WeeklyMainInfo implements Serializable {

	private static final long serialVersionUID = -5495429232674841691L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	/**
	 * 所属单位(公司)ID
	 */
	@Column(name = "COMPANY_ID" , length = 50)
	private String companyId;
	
	/**
	 * 所属单位公司名称
	 */
	@Column(name = "COMPANY_NAME" , length = 50)
	private String companyName;
	
	/**
	 * 计划填写人Id
	 */
	@Column(name = "PERSON_ID", length = 50)
	private String personId;
	
	/**
	 * 计划填写人名称
	 */
	@Column(name = "PERSON_NAME", length = 50)
	private String personName;
	
	/**
	 * 所在部门Id
	 */
	@Column(name = "DEPT_ID", length = 50)
	private String deptId;
	
	/**
	 * 所在部门Id
	 */
	@Column(name = "DEPT_NAME", length = 50)
	private String deptName;
	
	/**
	 * 职务
	 */
	@Column(name = "POSITION", length = 50)
	private String position;
	
	/**
	 * 直接上级
	 */
	@Column(name = "SUPERIOR", length = 50)
	private String superior;
	
	/**
	 * 检查人
	 */
	@Column(name = "CHECKER", length = 50)
	private String checker;
	
	/**
	 * 计划区间段 如 ：（2011年9月1日—9月30日）
	 */
	@Column(name = "PLAN_INTERZONE", length =100)
	private String planInterzone;

	/**
	 * 公司战略重点
	 */
	@Column(name = "COMPANY_KEYSTONE", length =100)
	private String companyKeystone;
	
	/**
	 * 下周部门战略重点（部门负责人提出）
	 */
	@Column(name = "NEXT_WEEK_KEYSTONE", length =100)
	private String nextWeekKeystone;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSuperior() {
		return superior;
	}

	public void setSuperior(String superior) {
		this.superior = superior;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getPlanInterzone() {
		return planInterzone;
	}

	public void setPlanInterzone(String planInterzone) {
		this.planInterzone = planInterzone;
	}
}
