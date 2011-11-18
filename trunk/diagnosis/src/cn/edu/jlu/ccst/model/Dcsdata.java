package cn.edu.jlu.ccst.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component("dcsdata")
public class Dcsdata implements Serializable{

	
	private static final long serialVersionUID = -4761095751458248560L;
	@Id
	@GeneratedValue
	private int id;
	private String equipment;
	private String item;
	private Double value;
	public Dcsdata() { 
		super();
		
	}
	public Dcsdata(int id, String equipment, String item, Double value) {
		super();
		this.id = id;
		this.equipment = equipment;
		this.item = item;
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
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
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
	
	
	
}
