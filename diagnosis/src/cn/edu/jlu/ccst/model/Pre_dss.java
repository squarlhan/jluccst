package cn.edu.jlu.ccst.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component("pre_dss")
public class Pre_dss implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6305660104857386885L;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String simu_time;
	private String seqno;
	private Double value;
	public Pre_dss() { 
		super();
		
	}
	public Pre_dss(int id,String name, String simu_time, String seqno, Double value) {
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
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
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
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}

	
	
	
}
