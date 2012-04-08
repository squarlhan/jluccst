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
	 * 模板报表主键
	 */
	private String id;
	
	/**
	 * 模板汇报类型
	 */
	@Column(name = "REPORT_TYPE")
	private String reportType;
	/**
	 * 模板汇报题目
	 */
	@Column(name = "REPORT_SUBJECT")
	private String reportSubject;
	
	/**
	 * 模板汇报人
	 */
	@Column(name = "REPORT_PERSON")
	private String reportPerson;
	
	/**
	 * 模板汇报时间
	 */
	@Column(name = "REPORT_DATE")
	private Calendar reportDate;
	/**
	 * 模板汇报内容
	 */
	@Column(name = "REPORT_CONTENT")
	private String reportContent;
	
	/**
	 * 模板保存的相对路径
	 */
	@Column(name = "TEMPLATE_NAME")
	private String templateName;
	
	/**
	 * 模板保存的相对路径
	 */
	@Column(name = "TEMPLATE_PATH")
	private String templatePath;
	
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar createTime;

	public Calendar getCreateTime() {
		createTime= Calendar.getInstance();
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
}


