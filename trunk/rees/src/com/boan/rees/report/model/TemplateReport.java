/*
 * @(#)TemplateReport.java 1.1 2012-3-8
 */

package com.boan.rees.report.model;

import java.io.Serializable;

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
@Table(name = "template_report")
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
	
	

}


