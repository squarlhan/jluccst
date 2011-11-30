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

@Entity
@Component("dss_advice")
public class Dss_advice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6305660104857386885L;
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	@JoinColumn(name="name")
	private Init_Predict name;

	private Double value;
	private String seqno;
	private String level;
	private String simu_time;
	private String error;
	private String sugg;
	public Dss_advice() { 
		super();
		
	}
	public Dss_advice(int id, Init_Predict name,  Double value, String seqno, String level,String simu_time,String error,String sugg) {
		super();
		this.id = id;
		this.name = name;
		
		this.value = value;
		this.seqno = seqno;
		this.level = level;
		this.simu_time = simu_time;
		this.error = error;
		this.sugg = sugg;
	}
	/**
	 * 
	 */
	public String getSugg() {
		return sugg;
	}
	public void setSugg(String sugg) {
		this.sugg = sugg;
	}
	public String getSeqno() {
		return seqno;
	}
	
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	
}
