/*
 * @(#)Employee.java 1.1 2012-4-27
 */

package com.boan.rees.expertsystem.threshold.model;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.boan.rees.expertsystem.model.RuleResultInfo;

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
	 * 阈值项数据类型 （S：速度  D:位移  A：加速度）
	 */
	@Column(name = "DATA_TYPE")
	private String dataType;
	
	
	/**
	 * 阈值取值范围表达式（如 ： 20<v<30   其中v为阈值参数名称）
	 */
	@Column(name = "Threshold_Item_Expression")
	private String thresholdItemExpression;
	
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
	@Column(name = "Create_Time")
	private Calendar createTime;
	
	/**
	 * 故障对象
	 */
	@OneToMany
//	@JoinTable(name="Threshold_Item_Trouble_Relation",joinColumns = { @JoinColumn( name="Threshold_Item_Id") },inverseJoinColumns = @JoinColumn( name="Rule_Result_Info_Id"))
	@JoinTable(name="rule_device_info",joinColumns = { @JoinColumn( name="DEVICE_VAR") },inverseJoinColumns = @JoinColumn( name="RESULT_ID"))
	private List<RuleResultInfo> troubles;
	
	/**
	 * 故障Id
	 */
	@Transient
	private List<String> troubleIds;
	
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
	
	public List<RuleResultInfo> getTroubles() {
		return troubles;
	}

	public void setTroubles(List<RuleResultInfo> troubles) {
		this.troubles = troubles;
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

	public List<String> getTroubleIds() {
		if(troubles!=null){
			troubleIds = new ArrayList<String>();
			for(RuleResultInfo trouble : troubles){
				troubleIds.add(""+trouble.getId());
			}
		}
		return troubleIds;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public void setTroubleIds(List<String> troubleIds) {
		this.troubleIds = troubleIds;
	}
}