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
@Component("backward")
public class Backward implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4761095751458248560L;
	@Id
	@GeneratedValue
	private int bid;
	private String memo;
	private String name;
	private int count;
	private int priror;
	@OneToMany(mappedBy = "bid", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BackwardandReason.class) 
	private List<BackwardandReason> reasons= new ArrayList();
	@OneToMany(mappedBy = "bid", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BackwardandResult.class) 
	private List<BackwardandResult> results= new ArrayList();
	@OneToMany(mappedBy = "bid", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BackwardandUpper.class) 
	private List<BackwardandUpper> uppers= new ArrayList();
	@OneToMany(mappedBy = "bid", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BackwardandLower.class) 
	private List<BackwardandLower> lowers= new ArrayList();
	
	public List<BackwardandUpper> getUppers() {
		return uppers;
	}




	public void setUppers(List<BackwardandUpper> uppers) {
		this.uppers = uppers;
	}




	public List<BackwardandLower> getLowers() {
		return lowers;
	}




	public void setLowers(List<BackwardandLower> lowers) {
		this.lowers = lowers;
	}




	public int getBid() {
		return bid;
	}




	public void setBid(int bid) {
		this.bid = bid;
	}




	public int getCount() {
		return count;
	}




	public void setCount(int count) {
		this.count = count;
	}




	public int getPriror() {
		return priror;
	}




	public void setPriror(int priror) {
		this.priror = priror;
	}




	




	public Backward(String memo, String name, int count, int priror) {
		super();
		this.memo = memo;
		this.name = name;
		this.count = count;
		this.priror = priror;
	}







	public List<BackwardandReason> getReasons() {
		return reasons;
	}




	public void setReasons(List<BackwardandReason> reasons) {
		this.reasons = reasons;
	}




	public List<BackwardandResult> getResults() {
		return results;
	}




	public void setResults(List<BackwardandResult> results) {
		this.results = results;
	}




	public Backward(String memo, String name, int count, int priror,
			List<BackwardandReason> reasons, List<BackwardandResult> results) {
		super();
		this.memo = memo;
		this.name = name;
		this.count = count;
		this.priror = priror;
		this.reasons = reasons;
		this.results = results;
	}




	public Backward() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}


}
