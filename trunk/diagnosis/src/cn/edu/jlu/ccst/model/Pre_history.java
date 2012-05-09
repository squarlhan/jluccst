package cn.edu.jlu.ccst.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.stereotype.Component;
/**
 * 工艺实时数据历史表
 */
@Entity
@Component("pre_history")
public class Pre_history implements Serializable{

	/**
	 * 主键
	 */
	private static final long serialVersionUID = -6305660104857386885L;
	@Id
	@GeneratedValue
	private int id;
	/**
	 * 工艺位号名称
	 */
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="name")
	private Init_Predict name;
	/**
	 * 批次号
	 */
	private String simu_time;
	/**
	 * 批次时间
	 */
	private String seqno;
	/**
	 * 参数值
	 */
	private String value;
	/**
	 * 构造函数
	 */
	public Pre_history() { 
		super();
		
	}
	/**
	 * 构造函数
	 */
	public Pre_history(int id,Init_Predict name, String simu_time, String seqno, String value) {
		super();
		this.id = id;
		this.name = name;
		this.simu_time = simu_time;
		this.seqno = seqno;
		this.value = value;
	}
	/**
	 * 
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Init_Predict getName() {
		return name;
	}
	
	public void setName(Init_Predict name) {
		this.name = name;
	}
	public String getSimu_time() {
		return simu_time;
	}
	public void setSimu_time(String simu_time) {
		this.simu_time = simu_time;
	}
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	
	
	
}
