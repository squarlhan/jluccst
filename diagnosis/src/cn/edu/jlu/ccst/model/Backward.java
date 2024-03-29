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

/**
 * 规则实体类
 *  @author alapapang
 */
@Entity
@Component("backward")
public class Backward implements Serializable{

	/**
	 * 主键
	 */
	private static final long serialVersionUID = -4761095751458248560L;
	@Id
	@GeneratedValue
	/**
	 * 
	 */
	private int bid;
	/**
	 * 规则简介
	 */
	private String memo = "";
	/**
	 * 规则名称
	 */
	private String name = "";
	/**
	 * 确定因子
	 */
	private int count;
	/**
	 * 优先级别
	 */
	private int priror;
	@OneToMany(mappedBy = "bid", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BackwardandReason.class) 
	private List<BackwardandReason> reasons= new ArrayList();
	@OneToMany(mappedBy = "bid", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BackwardandResult.class) 
	private List<BackwardandResult> results= new ArrayList();




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
