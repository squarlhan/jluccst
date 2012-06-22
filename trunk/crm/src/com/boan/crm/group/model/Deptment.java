package com.boan.crm.group.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "GROUP_DEPTMENT")
public class Deptment implements java.io.Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5843795944044845008L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	/**
	 * 部门实体主键
	 */
	private String id;

	/**
	 * 部门名称
	 */
	@Column(name = "DEPT_NAME")
	private String deptName;

	/**
	 * 部门负责人
	 */
	@Column(name = "PRINCIPAL")
	private String principal;

	/**
	 * 部门电话
	 */
	@Column(name = "PHONE")
	private String phone;

	/**
	 * 根节点标示
	 */
	@Column(name = "ROOT_ID")
	private String rootId;

	/**
	 * 排序号
	 */
	@Column(name = "SORT_INDEX")
	private int sortIndex = 0;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar createTime = Calendar.getInstance();

	/**
	 * 构造器
	 */
	public Deptment() {
		this.id = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRootId() {
		return rootId;
	}

	public void setRootId(String rootId) {
		this.rootId = rootId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
