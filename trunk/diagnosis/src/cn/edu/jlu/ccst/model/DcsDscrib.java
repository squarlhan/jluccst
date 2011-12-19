package cn.edu.jlu.ccst.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component("dcsdescrib")
public class DcsDscrib implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1318500835674165200L;
	/**
	 * 
	 */

	@Id
	@GeneratedValue
	private int did;
	private String item;
	private String eque;
	private String name;
	private double upper;
	private double lower;
	private double upper1;
	private double lower1;
	private double upper2;
	private double lower2;
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getEque() {
		return eque;
	}
	public void setEque(String eque) {
		this.eque = eque;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUpper() {
		return upper;
	}
	public void setUpper(double upper) {
		this.upper = upper;
	}
	public double getLower() {
		return lower;
	}
	public void setLower(double lower) {
		this.lower = lower;
	}

	public double getUpper1() {
		return upper1;
	}
	public void setUpper1(double upper1) {
		this.upper1 = upper1;
	}
	public double getLower1() {
		return lower1;
	}
	public void setLower1(double lower1) {
		this.lower1 = lower1;
	}
	public double getUpper2() {
		return upper2;
	}
	public void setUpper2(double upper2) {
		this.upper2 = upper2;
	}
	public double getLower2() {
		return lower2;
	}
	public void setLower2(double lower2) {
		this.lower2 = lower2;
	}
	
	public DcsDscrib(int did, String item, String eque, String name,
			double upper, double lower, double upper1, double lower1,
			double upper2, double lower2) {
		super();
		this.did = did;
		this.item = item;
		this.eque = eque;
		this.name = name;
		this.upper = upper;
		this.lower = lower;
		this.upper1 = upper1;
		this.lower1 = lower1;
		this.upper2 = upper2;
		this.lower2 = lower2;
	}
	public DcsDscrib() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
