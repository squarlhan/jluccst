﻿/*
 * @(#)PersonReport.java 1.1 2012-3-8
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
 * 个人报表 类
 * @author zhaomengxue
 * @version 1.0.0
 */
@Entity
@Table(name = "report_person")
public class PersonReport implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	
	/**
	 * 主键
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
	 * 汇报人所在工厂Id
	 */
	@Column(name = "REPORT_FACTORY_ID")
	private String reportPersonFactoryId;
	
	/**
	 * 汇报人所在工厂名
	 */
	@Column(name = "REPORT_FACTORY_NAME")
	private String reportPersonFactoryName;
	
	/**
	 * 汇报人所在车间Id
	 */
	@Column(name = "REPORT_WORKSHOP_ID")
	private String reportPersonWorkshopId;
	
	/**
	 * 汇报人所在车间名
	 */
	@Column(name = "REPORT_WORKSHOP_NAME")
	private String reportPersonWorkshopName;
	
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
	 * 模板id.外键
	 */
	@Column(name = "TEMPLATE_ID")
	private String templateId;
	/**
	 * 报表状态0：保存；1：提交
	 */
	@Column(name = "REPORT_STATE")
	private Integer reportState;
	/**
	 * 删除标识0：正常；1：已删除
	 */
	@Column(name = "ISDELETE")
	private Integer isDelete;
	/**
	 * 所属部门id
	 */
	@Column(name = "DEPT_ID")
	private String deptId;
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar creatTime;
	
	/**
	 * 附件文件路径
	 */
	@Column(name = "FILE_PATH")
	private String filePath;
	
	/**
	 * 附件文件路径
	 */
	@Column(name = "FILE_NAME")
	private String fileName;
	
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
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public Integer getReportState() {
		return reportState;
	}
	public void setReportState(Integer reportState) {
		this.reportState = reportState;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public Calendar getCreatTime() {
		creatTime = Calendar.getInstance();
		return creatTime;
	}
	public void setCreatTime(Calendar creatTime) {
		this.creatTime = creatTime;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getReportPersonFactoryId() {
		return reportPersonFactoryId;
	}
	public void setReportPersonFactoryId(String reportPersonFactoryId) {
		this.reportPersonFactoryId = reportPersonFactoryId;
	}
	public String getReportPersonFactoryName() {
		return reportPersonFactoryName;
	}
	public void setReportPersonFactoryName(String reportPersonFactoryName) {
		this.reportPersonFactoryName = reportPersonFactoryName;
	}
	public String getReportPersonWorkshopId() {
		return reportPersonWorkshopId;
	}
	public void setReportPersonWorkshopId(String reportPersonWorkshopId) {
		this.reportPersonWorkshopId = reportPersonWorkshopId;
	}
	public String getReportPersonWorkshopName() {
		return reportPersonWorkshopName;
	}
	public void setReportPersonWorkshopName(String reportPersonWorkshopName) {
		this.reportPersonWorkshopName = reportPersonWorkshopName;
	}
}


