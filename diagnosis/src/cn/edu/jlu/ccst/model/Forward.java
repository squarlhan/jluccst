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
@Component("forward")
public class Forward implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4761095751458248560L;
	@Id
	@GeneratedValue
	private int fid;
	private String memo;
	private String name;
	private int count;
	private int priror;
	@OneToMany(mappedBy = "fid", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ForwardandReason.class) 
	private List<ForwardandReason> reasons= new ArrayList();
	@OneToMany(mappedBy = "fid", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ForwardandResult.class) 
	private List<ForwardandResult> results= new ArrayList();
	
	
	




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





	public Forward(int fid, String memo, String name, int count, int priror) {
		super();
		this.fid = fid;
		this.memo = memo;
		this.name = name;
		this.count = count;
		this.priror = priror;
	}




	public Forward(int fid, String memo, String name, int count, int priror,
			List<ForwardandReason> reasons, List<ForwardandResult> results) {
		super();
		this.fid = fid;
		this.memo = memo;
		this.name = name;
		this.count = count;
		this.priror = priror;
		this.reasons = reasons;
		this.results = results;
	}




	public int getFid() {
		return fid;
	}




	public void setFid(int fid) {
		this.fid = fid;
	}




	public List<ForwardandReason> getReasons() {
		return reasons;
	}




	public void setReasons(List<ForwardandReason> reasons) {
		this.reasons = reasons;
	}




	public List<ForwardandResult> getResults() {
		return results;
	}




	public void setResults(List<ForwardandResult> results) {
		this.results = results;
	}




	public Forward() {
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
