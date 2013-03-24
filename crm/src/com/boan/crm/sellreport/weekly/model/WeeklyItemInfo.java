package com.boan.crm.sellreport.weekly.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "WEEKLY_ITEM_INFO")
public class WeeklyItemInfo implements Serializable {
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
	 * 序号
	 */
	@Column(name = "SEQUENCE" , length = 50)
	private String sequence;
	
	/**
	 * 周结果定义
	 */
	@Column(name = "WEEK_RESULT" , length = 1000)
	private String weekResult;
	
	/**
	 * 星期一结果定义
	 */
	@Column(name = "MONDAY" , length = 1000)
	private String monday;
	
	/**
	 * 星期二结果定义
	 */
	@Column(name = "TUESDAY" , length = 1000)
	private String tuesday;
	/**
	 * 星期三结果定义
	 */
	@Column(name = "WEDNESDAY" , length = 1000)
	private String wednesday;
	/**
	 * 星期四结果定义
	 */
	@Column(name = "THURSDAY" , length = 1000)
	private String thursday;
	/**
	 * 星期五结果定义
	 */
	@Column(name = "FRIDAY" , length = 1000)
	private String friday;
	/**
	 * 星期六结果定义
	 */
	@Column(name = "SATURDAY" , length = 1000)
	private String saturday;
	/**
	 * 星期日结果定义
	 */
	@Column(name = "SUNDAY" , length = 1000)
	private String sunday ;
	
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
	 * 检查人结果
	 */
	@Column(name = "CHECKER_RESULT", length = 1000)
	private String checkerResult;
	/**
	 * 备注
	 */
	@Column(name = "MEMO", length = 1000)
	private String memo;
	
	@Column(name = "CREATE_TIME")
	private Calendar createTime;
	
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
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getWeekResult() {
		return weekResult;
	}
	public void setWeekResult(String weekResult) {
		this.weekResult = weekResult;
	}
	public String getMonday() {
		return monday;
	}
	public void setMonday(String monday) {
		this.monday = monday;
	}
	public String getTuesday() {
		return tuesday;
	}
	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}
	public String getWednesday() {
		return wednesday;
	}
	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}
	public String getThursday() {
		return thursday;
	}
	public void setThursday(String thursday) {
		this.thursday = thursday;
	}
	public String getFriday() {
		return friday;
	}
	public void setFriday(String friday) {
		this.friday = friday;
	}
	public String getSaturday() {
		return saturday;
	}
	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}
	public String getSunday() {
		return sunday;
	}
	public void setSunday(String sunday) {
		this.sunday = sunday;
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
	public String getCheckerResult() {
		return checkerResult;
	}
	public void setCheckerResult(String checkerResult) {
		this.checkerResult = checkerResult;
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
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
}
