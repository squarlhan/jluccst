package cn.edu.jlu.ccst.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
@Entity
@Component("forwardandreason")
public class ForwardandReason {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne (cascade = { CascadeType.MERGE }) 
	@JoinColumn(name = "fid")
	private Forward fid;
	private String nouns;
	private float  cf_reason;
	private String verb;
	private String sugg;
	
	

	public ForwardandReason(Forward fid, String nouns, float cf_reason,
			String verb, String sugg) {
		super();
		this.fid = fid;
		this.nouns = nouns;
		this.cf_reason = cf_reason;
		this.verb = verb;
		this.sugg = sugg;
	}
	public ForwardandReason() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public Forward getFid() {
		return fid;
	}
	public void setFid(Forward fid) {
		this.fid = fid;
	}
	public String getNouns() {
		return nouns;
	}
	public void setNouns(String nouns) {
		this.nouns = nouns;
	}
	public String getVerb() {
		return verb;
	}
	public void setVerb(String verb) {
		this.verb = verb;
	}
	public String getSugg() {
		return sugg;
	}
	public void setSugg(String sugg) {
		this.sugg = sugg;
	}
	public float getCf_reason() {
		return cf_reason;
	}
	public void setCf_reason(float cf_reason) {
		this.cf_reason = cf_reason;
	}

	
	
}
