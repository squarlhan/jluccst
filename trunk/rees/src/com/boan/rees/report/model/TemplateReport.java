/*
 * @(#)TemplateReport.java 1.1 2012-3-8
 */

package com.boan.rees.report.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 报表模板表  类
 * @author zhaomengxue
 * @version 1.0.0
 */
@Entity
@Table(name = "report_template")
public class TemplateReport implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	
	/**
	 * 设备实体主键
	 */
	private String id;
	
	/**
	 * 汇报类型
	 */
	@Column(name = "REPORT_TYPE")

	private String reportType;
	/**
	 * 汇报题目
	 */
	@Column(name = "REPORT_SUBJECT")
	private String reportSubject;
	
	/**
	 * 汇报人
	 */
	@Column(name = "REPORT_PERSON")
	private String reportPerson;
	
	/**
	 * 汇报时间
	 */
	@Column(name = "REPORT_DATE")
	private Calendar reportDate;
	/**
	 * 汇报内容
	 */
	@Column(name = "REPORT_CONTENT")
	private String reportContent;
	
	/**
	 * 模板名称
	 */
	@Column(name = "TEMPLATE_NAME")
	private String templateName;
	/**
	 * 模板保存的相对路径
	 */
	@Column(name = "TEMPLATE_PATH")
	private String templatePath;
	/**
	 * 所属部门id
	 */
	@Column(name = "DEPT_ID")
	private String deptId;
	/**
	 * 删除标识0:正常；1：已删除
	 */
	@Column(name = "ISDELETE")
	private Integer isDelete;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getTemplatePath() {
		return templatePath;
	}
	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getReportSubject() {
		return reportSubject;
	}
	public void setReportSubject(String reportSubject) {
		this.reportSubject = reportSubject;
	}
	public String getReportPerson() {
		return reportPerson;
	}
	public void setReportPerson(String reportPerson) {
		this.reportPerson = reportPerson;
	}
	public Calendar getReportDate() {
		return reportDate;
	}
	public void setReportDate(Calendar reportDate) {
		this.reportDate = reportDate;
	}
	public String getReportContent() {
		return reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
}


