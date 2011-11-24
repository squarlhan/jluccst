package cn.edu.jlu.ccst.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private String name;
	private String item;
	private Double value;
	private String seqno;
	private String level;
	private String simu_time;
	private String error;
	private String sugg;
	public Dss_advice() { 
		super();
		
	}
	public Dss_advice(int id, String name, String item, Double value, String seqno, String level,String simu_time,String error,String sugg) {
		super();
		this.id = id;
		this.name = name;
		this.item = item;
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
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
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
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	
}
