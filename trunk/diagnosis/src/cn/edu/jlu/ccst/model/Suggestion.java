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
@Component("suggestion")
public class Suggestion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4761095751458248560L;
	@Id
	@GeneratedValue
	private int sid;
	private String memo;
	private String name;
	@OneToMany(mappedBy = "sid", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BackwardandReason.class) 
	private List<BackwardandReason> bsugg = new ArrayList(0);
	@OneToMany(mappedBy = "sid", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ForwardandReason.class) 
	private List<ForwardandReason> fsugg = new ArrayList(0);
	
	
	
	
	public Suggestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Suggestion(int sid, String name, String memo) {
		super();
		this.sid = sid;
		this.name = name;
		this.memo = memo;
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
	
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public List<BackwardandReason> getBsugg() {
		return bsugg;
	}

	public void setBsugg(List<BackwardandReason> bsugg) {
		this.bsugg = bsugg;
	}

	public List<ForwardandReason> getFsugg() {
		return fsugg;
	}

	public void setFsugg(List<ForwardandReason> fsugg) {
		this.fsugg = fsugg;
	}

	public Suggestion(int sid, String memo, String name,
			List<BackwardandReason> bsugg, List<ForwardandReason> fsugg) {
		super();
		this.sid = sid;
		this.memo = memo;
		this.name = name;
		this.bsugg = bsugg;
		this.fsugg = fsugg;
	}

	

	

	
}
