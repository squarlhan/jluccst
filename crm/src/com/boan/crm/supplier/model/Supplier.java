package com.boan.crm.supplier.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 供货商
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "supplier")
public class Supplier implements java.io.Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4154306127227448676L;
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;

	/**
	 * 公司id
	 */
	@Column(name = "COMPANY_ID", length = 50)
	private String companyId;
	/**
	 * 公司名称
	 */
	@Column(name = "COMPANY_NAME", length = 50)
	private String companyName;
	/**
	 * 供货商名称
	 */
	@Column(name = "SUPPLIER_NAME", length = 100)
	private String supplierName;
	/**
	 * 供货商编号
	 */
	@Column(name = "SUPPLIER_NUMBER", length = 50)
	private String supplierNumber;

	/**
	 * 产品
	 */
	@Column(name = "PRODUCT", length = 100)
	private String product;

	/**
	 * 备注
	 */
	@Column(name = "MEMO", length = 1000)
	private String memo;

	/**
	 * 用户id
	 */
	@Column(name = "USER_ID", length = 50)
	private String userId;

	/**
	 * 用户姓名
	 */
	@Column(name = "USER_NAME", length = 50)
	private String userName;
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierNumber() {
		return supplierNumber;
	}

	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
