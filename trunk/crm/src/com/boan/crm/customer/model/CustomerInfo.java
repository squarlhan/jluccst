package com.boan.crm.customer.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 客户信息实体类
 * 
 * @author luojx
 * @version 1.0.0
 */
@Entity
@Table(name = "CUSTOMER_INFO")
public class CustomerInfo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6407278513107210750L;

	public CustomerInfo(){ this.id = ""; }
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	@Column(name = "CUSTOMER_NAME" , length = 255)
	private String customerName = "";
	@Column(name = "COMPANY_FULL_NAME" , length = 255)
	private String companyFullName = "";
	@Column(name = "FAX" , length = 50)
	private String fax = "";
	@Transient
	private String source = "";
	@Column(name = "SOURCEID" , length = 50)
	private String sourceId = "";
	@Column(name = "CATEGORYID" , length = 50)
	private String categoryId = "";
	@Transient
	private String category = "";
	@Column(name = "PROGRESSID" , length = 50)
	private String progressId = "";
	@Transient
	private String progress = "";
	@Transient
	private String maturity = "";
	@Column(name = "MATURITYID" , length = 50)
	private String maturityId = "";
	@Transient
	private String level = "";
	@Column(name = "LEVELID" , length = 50)
	private String levelId = "";
	@Transient
	private String salesman = "";
	@Column(name = "SALESMANID" , length = 50)
	private String salesmanId = "";
	@Transient
	private String otherSalesman = "";
	@Column(name = "OTHER_SALESMANID" , length = 50)
	private String otherSalesmanId = "";
	@Column(name = "REGISTER_TIME")
	private Calendar registerTime = Calendar.getInstance();
	@Column(name = "PROVINCE" , length = 50)
	private String province = "";
	@Column(name = "CITY" , length = 50)
	private String city = "";
	@Column(name = "DISTRICT" , length = 50)
	private String district = "";
	@Column(name = "ADDRESS" , length = 255)
	private String address = "";
	@Column(name = "CREATE_TIME")
	private Calendar createTime;
	@Column(name = "CREATORID")
	private String creatorId;
	@Column(name = "COMPANYID")
	private String companyId;
	@Transient
	private List<ContractPersonInfo> contractPersonList = null;
	@Column(name = "MAININDUSTRY")
	private String mainIndustry = null;
	@Column(name = "POSTCODE")
	private String postCode = null;
	@Column(name = "INTRODUCE_TIMES")
	private int introduceTimes = 0;
	@Transient
	private BigDecimal totalConsumption;
	@Transient
	private BigDecimal totalDebt;
	@Transient
	private int consumptionTimes = 0;
	@Transient
	private int paymentsTimes = 0;
	@Transient
	private BigDecimal payments;
	@Transient
	private double developDegree = 0;
	@Column(name = "DELETE_FLAG")
	private int deleteFlag = 0;
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public BigDecimal getTotalConsumption() {
		return totalConsumption;
	}
	public void setTotalConsumption(BigDecimal totalConsumption) {
		this.totalConsumption = totalConsumption;
	}
	public int getConsumptionTimes() {
		return consumptionTimes;
	}
	public void setConsumptionTimes(int consumptionTimes) {
		this.consumptionTimes = consumptionTimes;
	}
	public int getPaymentsTimes() {
		return paymentsTimes;
	}
	public void setPaymentsTimes(int paymentsTimes) {
		this.paymentsTimes = paymentsTimes;
	}
	public BigDecimal getPayments() {
		return payments;
	}
	public void setPayments(BigDecimal payments) {
		this.payments = payments;
	}
	public double getDevelopDegree() {
		return developDegree;
	}
	public void setDevelopDegree(double developDegree) {
		this.developDegree = developDegree;
	}
	public int getIntroduceTimes() {
		return introduceTimes;
	}
	public void setIntroduceTimes(int introduceTimes) {
		this.introduceTimes = introduceTimes;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getMainIndustry() {
		return mainIndustry;
	}
	public void setMainIndustry(String mainIndustry) {
		this.mainIndustry = mainIndustry;
	}
	/**
	 * 编号
	 * @return String
	 */
	public String getId()
	{
		return id;
	}
	/**
	 * 联系人
	 * @return　List<ContractPersonInfo>
	 */
	public List<ContractPersonInfo> getContractPersonList()
	{
		return contractPersonList;
	}
	/**
	 * 联系人
	 * @param contractPersonList
	 */
	public void setContractPersonList( List<ContractPersonInfo> contractPersonList )
	{
		this.contractPersonList = contractPersonList;
	}
	/**
	 * 编号
	 * @param id
	 */
	public void setId( String id )
	{
		this.id = id;
	}
	/**
	 * 客户名称
	 * @return　String
	 */
	public String getCustomerName()
	{
		return customerName;
	}
	/**
	 * 客户名称
	 * @param customerName
	 */
	public void setCustomerName( String customerName )
	{
		this.customerName = customerName;
	}
	/**
	 * 公司全称
	 * @return　String
	 */
	public String getCompanyFullName()
	{
		return companyFullName;
	}
	/**
	 * 公司全称
	 * @param companyFullName
	 */
	public void setCompanyFullName( String companyFullName )
	{
		this.companyFullName = companyFullName;
	}
	/**
	 * 传真
	 * @return　String
	 */
	public String getFax()
	{
		return fax;
	}
	/**
	 * 传真
	 * @param fax
	 */
	public void setFax( String fax )
	{
		this.fax = fax;
	}
	/**
	 * 客户来源
	 * @return String
	 */
	public String getSource()
	{
		return source;
	}
	/**
	 * 客户来源
	 * @param source
	 */
	public void setSource( String source )
	{
		this.source = source;
	}
	/**
	 * 客户来源Id
	 * @return String
	 */
	public String getSourceId()
	{
		return sourceId;
	}
	/**
	 * 客户来源Id
	 * @param sourceId
	 */
	public void setSourceId( String sourceId )
	{
		this.sourceId = sourceId;
	}
	/**
	 * 客户分类Id
	 * @return String
	 */
	public String getCategoryId()
	{
		return categoryId;
	}
	/**
	 * 客户分类Id
	 * @param categoryId
	 */
	public void setCategoryId( String categoryId )
	{
		this.categoryId = categoryId;
	}
	/**
	 * 客户分类
	 * @return　String
	 */
	public String getCategory()
	{
		return category;
	}
	/**
	 * 客户分类
	 * @param category
	 */
	public void setCategory( String category )
	{
		this.category = category;
	}
	/**
	 * 业务进展Id
	 * @return String
	 */
	public String getProgressId()
	{
		return progressId;
	}
	/**
	 * 业务进展Id
	 * @param progressId
	 */
	public void setProgressId( String progressId )
	{
		this.progressId = progressId;
	}
	/**
	 * 业务进展
	 * @return　String
	 */
	public String getProgress()
	{
		return progress;
	}
	/**
	 * 业务进展
	 * @param progress
	 */
	public void setProgress( String progress )
	{
		this.progress = progress;
	}
	/**
	 * 成熟度
	 * @return　String
	 */
	public String getMaturity()
	{
		return maturity;
	}
	/**
	 * 成熟度
	 * @param maturity
	 */
	public void setMaturity( String maturity )
	{
		this.maturity = maturity;
	}
	/**
	 * 成熟度Id
	 * @return String
	 */
	public String getMaturityId()
	{
		return maturityId;
	}
	/**
	 * 成熟度Id
	 * @param maturityId
	 */
	public void setMaturityId( String maturityId )
	{
		this.maturityId = maturityId;
	}
	/**
	 * 开发程度
	 * @return String
	 */
	public String getLevel()
	{
		return level;
	}
	/**
	 * 开发程度
	 * @param level
	 */
	public void setLevel( String level )
	{
		this.level = level;
	}
	/**
	 * 开发程度Id
	 * @return String
	 */
	public String getLevelId()
	{
		return levelId;
	}
	/**
	 * 开发程度Id
	 * @param levelId
	 */
	public void setLevelId( String levelId )
	{
		this.levelId = levelId;
	}
	/**
	 * 业务员
	 * @return String
	 */
	public String getSalesman()
	{
		return salesman;
	}
	/**
	 * 业务员
	 * @param salesman
	 */
	public void setSalesman( String salesman )
	{
		this.salesman = salesman;
	}
	/**
	 * 业务员Id
	 * @return String
	 */
	public String getSalesmanId()
	{
		return salesmanId;
	}
	/**
	 * 业务员Id
	 * @param salesmanId
	 */
	public void setSalesmanId( String salesmanId )
	{
		this.salesmanId = salesmanId;
	}
	/**
	 * 其他业务员
	 * @return　String
	 */
	public String getOtherSalesman()
	{
		return otherSalesman;
	}
	/**
	 * 其他业务员
	 * @param otherSalesman
	 */
	public void setOtherSalesman( String otherSalesman )
	{
		this.otherSalesman = otherSalesman;
	}
	/**
	 * 其他业务员Id
	 * @return
	 */
	public String getOtherSalesmanId()
	{
		return otherSalesmanId;
	}
	/**
	 * 其他业务员Id
	 * @param otherSalesmanId
	 */
	public void setOtherSalesmanId( String otherSalesmanId )
	{
		this.otherSalesmanId = otherSalesmanId;
	}
	/**
	 * 建档时间
	 * @return Calendar
	 */
	public Calendar getRegisterTime()
	{
		return registerTime;
	}
	/**
	 * 建档时间
	 * @param registerTime
	 */
	public void setRegisterTime( Calendar registerTime )
	{
		this.registerTime = registerTime;
	}
	/**
	 * 省份
	 * @return　String
	 */
	public String getProvince()
	{
		return province;
	}
	/**
	 * 省份
	 * @param province
	 */
	public void setProvince( String province )
	{
		this.province = province;
	}
	/**
	 * 城市
	 * @return　String
	 */
	public String getCity()
	{
		return city;
	}
	/**
	 * 城市
	 * @param city
	 */
	public void setCity( String city )
	{
		this.city = city;
	}
	/**
	 * 地区
	 * @return　String
	 */
	public String getDistrict()
	{
		return district;
	}
	/**
	 * 地区
	 * @param district
	 */
	public void setDistrict( String district )
	{
		this.district = district;
	}
	
	/**
	 * 地址
	 * @return　String
	 */
	public String getAddress()
	{
		return address;
	}
	/**
	 * 地址
	 * @param address
	 */
	public void setAddress( String address )
	{
		this.address = address;
	}
	/**
	 * 客户创建时间
	 * @return　Calendar
	 */
	public Calendar getCreateTime()
	{
		return createTime;
	}
	/**
	 * 客户创建时间
	 * @param createTime
	 */
	public void setCreateTime( Calendar createTime )
	{
		this.createTime = createTime;
	}
	/**
	 * 创建人Id
	 * @return String
	 */
	public String getCreatorId() {
		return creatorId;
	}
	/**
	 * 创建人Id
	 * @param creatorId
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	/**
	 * 单位Id
	 * @return String
	 */
	public String getCompanyId() {
		return companyId;
	}
	/**
	 * 单位Id
	 * @param companyId
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	/**
	 * 总欠款数
	 * @return
	 */
	public BigDecimal getTotalDebt() {
		return totalDebt;
	}
	/**
	 * 设置总欠款数
	 * @return
	 */
	public void setTotalDebt(BigDecimal totalDebt) {
		this.totalDebt = totalDebt;
	}
}
