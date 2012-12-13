package com.boan.crm.sellreport.monthly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MONTHLY_ITEM_INFO")
public class MonthlyItemInfo implements Serializable {
	private static final long serialVersionUID = -5495429232674841691L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	/**
	 * 主记录Id
	 */
	@Column(name = "MAIN_INFO_ID" , length = 50)
	private String mainInfoId;
	
	/**
	 * 销售职责Id
	 */
	@Column(name = "SELL_DUTY_ID" , length = 50)
	private String sellDutyId;
	
	/**
	 * 销售职责名称
	 */
	@Column(name = "SELL_DUTY_NAME" , length = 50)
	private String sellDutyName;
	
	/**
	 * 销售额
	 */
	@Column(name = "SELL_TARGET" , length = 50)
	private String sellTarget;
	
	/**
	 * KPI
	 */
	@Column(name = "KPI" , length = 50)
	private String kpi;
	
	/**
	 * KPI公式
	 */
	@Column(name = "KPI_FORMULA" , length = 250)
	private String kpiFormula;
	
	/**
	 * 标准绩效
	 */
	@Column(name = "STANDARD_PERFORMANCE" , length =250)
	private String standardPerformance;
	
	/**
	 * 实际绩效
	 */
	@Column(name = "FACT_PERFORMANCE" , length = 250)
	private String factPerformance;
	
	/**
	 *权重
	 */
	@Column(name = "WEIGHT" , length = 250)
	private String weight;
	
	/**
	 * 序号
	 */
	@Column(name = "SEQUENCE" , length = 50)
	private String sequence="0";
	
	/**
	 * 月结果定义
	 */
	@Column(name = "MONTH_RESULT" , length = 1000)
	private String monthResult;
	
	/**
	 * 第一周结果定义
	 */
	@Column(name = "FIRST_WEEK" , length = 1000)
	private String firstWeek;
	/**
	 * 第二周结果定义
	 */
	@Column(name = "SECOND_WEEK" , length = 1000)
	private String secondWeek;
	/**
	 * 第三周结果定义
	 */
	@Column(name = "THIRD_WEEK" , length = 1000)
	private String thirdWeek;
	/**
	 * 第四周结果定义
	 */
	@Column(name = "FOURTH_WEEK" , length = 1000)
	private String fourthWeek;
	
	/**
	 * 执行基金
	 */
	@Column(name = "EXECUTE_MONEY")
	private String executeMoney ;
	
	/**
	 * 直接上级结果
	 */
	@Column(name = "SUPERIOR_RESULT", length = 1000)
	private String superiorResult;
	
	/**
	 * 直接上级实际得分
	 */
	@Column(name = "FACT_SCORE")
	private String factScore;
	
	/**
	 * 直接上级原因
	 */
	@Column(name = "SUPERIOR_REASON", length = 1000)
	private String superiorReason;
	/**
	 * 直接上级改进的措施
	 */
	@Column(name = "SUPERIOR_METHOD", length = 1000)
	private String superiorMethod;
	
	/**
	 * 总经理 新结果定义（承诺）
	 */
	@Column(name = "NEXT_MONTHLY_RESULT", length = 1000)
	private String nextMonthlyResult;

	/**
	 * 备注
	 */
	@Column(name = "MEMO", length = 1000)
	private String memo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMainInfoId() {
		return mainInfoId;
	}

	public void setMainInfoId(String mainInfoId) {
		this.mainInfoId = mainInfoId;
	}

	public String getSellDutyId() {
		return sellDutyId;
	}

	public void setSellDutyId(String sellDutyId) {
		this.sellDutyId = sellDutyId;
	}

	public String getSellDutyName() {
		return sellDutyName;
	}

	public void setSellDutyName(String sellDutyName) {
		this.sellDutyName = sellDutyName;
	}

	public String getKpi() {
		return kpi;
	}

	public void setKpi(String kpi) {
		this.kpi = kpi;
	}

	public String getKpiFormula() {
		return kpiFormula;
	}

	public void setKpiFormula(String kpiFormula) {
		this.kpiFormula = kpiFormula;
	}

	public String getStandardPerformance() {
		return standardPerformance;
	}

	public void setStandardPerformance(String standardPerformance) {
		this.standardPerformance = standardPerformance;
	}

	public String getFactPerformance() {
		return factPerformance;
	}

	public void setFactPerformance(String factPerformance) {
		this.factPerformance = factPerformance;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getMonthResult() {
		return monthResult;
	}

	public void setMonthResult(String monthResult) {
		this.monthResult = monthResult;
	}

	public String getFirstWeek() {
		return firstWeek;
	}

	public void setFirstWeek(String firstWeek) {
		this.firstWeek = firstWeek;
	}

	public String getSecondWeek() {
		return secondWeek;
	}

	public void setSecondWeek(String secondWeek) {
		this.secondWeek = secondWeek;
	}

	public String getThirdWeek() {
		return thirdWeek;
	}

	public void setThirdWeek(String thirdWeek) {
		this.thirdWeek = thirdWeek;
	}

	public String getFourthWeek() {
		return fourthWeek;
	}

	public void setFourthWeek(String fourthWeek) {
		this.fourthWeek = fourthWeek;
	}

	public String getExecuteMoney() {
		return executeMoney;
	}

	public void setExecuteMoney(String executeMoney) {
		this.executeMoney = executeMoney;
	}

	public String getSuperiorResult() {
		return superiorResult;
	}

	public void setSuperiorResult(String superiorResult) {
		this.superiorResult = superiorResult;
	}

	public String getFactScore() {
		return factScore;
	}

	public void setFactScore(String factScore) {
		this.factScore = factScore;
	}

	public String getSuperiorReason() {
		return superiorReason;
	}

	public void setSuperiorReason(String superiorReason) {
		this.superiorReason = superiorReason;
	}

	public String getSuperiorMethod() {
		return superiorMethod;
	}

	public void setSuperiorMethod(String superiorMethod) {
		this.superiorMethod = superiorMethod;
	}

	public String getNextMonthlyResult() {
		return nextMonthlyResult;
	}

	public void setNextMonthlyResult(String nextMonthlyResult) {
		this.nextMonthlyResult = nextMonthlyResult;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getSellTarget() {
		return sellTarget;
	}

	public void setSellTarget(String sellTarget) {
		this.sellTarget = sellTarget;
	}
}
