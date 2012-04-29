/*
 * @(#)Department.java 1.1 2012-4-27
 */

package com.boan.rees.expertsystem.threshold.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 阈值项实体
 * @author ZhuYF
 * @version 1.0.0
 */
@Entity
@Table(name="THRESHOLD")
public class Threshold implements Serializable{
    
	private static final long serialVersionUID = 1L;

	/**
	 * 阈值Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Threshold_Id")
	private Integer id;
	
	/**
	 *  阈值名称（如 ：A类、B类、C类等）
	 */
	@Column(name = "Threshold_Name")
	private String thresholdName;

	/**
	 * 阈值单位(如 ：赫兹、摄氏度)
	 */
	@Column(name = "Threshold_Unit")
	private String unit;
	
	/**
	 * 阈值项所属类别 （震动类 或 声音类....）
	 */
	@ManyToOne( cascade=CascadeType.REFRESH,optional=false)
    @JoinColumn(name = "Threshold_Category_Id")
    private ThresholdCategory thresholdCategory;
	
	/**
	 * 阈值项
	 */
	@OneToMany(mappedBy="threshold",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ThresholdItem> thresholdItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getThresholdName() {
		return thresholdName;
	}

	public void setThresholdName(String thresholdName) {
		this.thresholdName = thresholdName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public ThresholdCategory getThresholdCategory() {
		return thresholdCategory;
	}

	public void setThresholdCategory(ThresholdCategory thresholdCategory) {
		this.thresholdCategory = thresholdCategory;
	}

	public List<ThresholdItem> getThresholdItems() {
		return thresholdItems;
	}

	public void setThresholdItems(List<ThresholdItem> thresholdItems) {
		this.thresholdItems = thresholdItems;
	}
}
