/*
 * @(#)Employee.java 1.1 2012-4-27
 */

package com.boan.rees.expertsystem.threshold.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 阈值项参数
 * @author ZhuYF
 * @version 1.0.0
 */
@Entity
@Table(name="THRESHOLD_ITEM")
public class ThresholdItem implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="Threshold_Item_Id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	/**
	 * 阈值项名称
	 */
	@Column(name = "Threshold_Item_Name")
	private String thresholdItemName;
	
	/**
	 * 阈值取值范围表达式（如 ： 20<v<30   其中v为阈值参数名称）
	 */
	@Column(name = "Threshold_Item_Expression")
	private String thresholdItemExpression;
	
	/**
	 * 故障Id
	 */
	@Column(name = "Trouble_Id")
	private String troubleId;
	
	/**
	 * 阈值标识（0：正常，1：报警）
	 */
	@Column(name = "Threshold_Sign")
	private int sign;
	
    @ManyToOne( cascade=CascadeType.REFRESH,optional=false)
    @JoinColumn(name = "Threshold_Id")
    private Threshold threshold;

    /**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar createTime;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getThresholdItemName() {
		return thresholdItemName;
	}

	public void setThresholdItemName(String thresholdItemName) {
		this.thresholdItemName = thresholdItemName;
	}

	public String getThresholdItemExpression() {
		return thresholdItemExpression;
	}

	public void setThresholdItemExpression(String thresholdItemExpression) {
		this.thresholdItemExpression = thresholdItemExpression;
	}

	public String getTroubleId() {
		return troubleId;
	}

	public void setTroubleId(String troubleId) {
		this.troubleId = troubleId;
	}
	
	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

	public Threshold getThreshold() {
		return threshold;
	}

	public void setThreshold(Threshold threshold) {
		this.threshold = threshold;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
}