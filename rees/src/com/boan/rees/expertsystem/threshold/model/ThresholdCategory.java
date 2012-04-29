/*
 * @(#)Employee.java 1.1 2012-4-27
 */

package com.boan.rees.expertsystem.threshold.model;

import java.io.Serializable;
import java.util.Calendar;
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
 * 阈值项类别
 * @author ZhuYF
 * @version 1.0.0
 */
@Entity
@Table(name="THRESHOLD_CATEGORY")
public class ThresholdCategory implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="Category_Id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	/**
	 * 阈值参数名称
	 */
	@Column(name = "Category_Name")
	private String categoryName;
	
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar createTime;
	
    /**
	 * 阈值
	 */
	@OneToMany(mappedBy="thresholdCategory",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Threshold> thresholds;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Threshold> getThresholds() {
		return thresholds;
	}

	public void setThresholds(List<Threshold> thresholds) {
		this.thresholds = thresholds;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
}