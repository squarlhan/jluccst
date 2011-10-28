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
	@ManyToOne (cascade = { CascadeType.MERGE }) 
	@JoinColumn(name = "nouns_id")
	private Nouns nouns_id;
	private float  cf_reason;
	@ManyToOne (cascade = { CascadeType.MERGE }) 
	@JoinColumn(name = "verb_id")
	private Verb verb_id;
	@ManyToOne (cascade = { CascadeType.MERGE }) 
	@JoinColumn(name = "sid")
	private Suggestion sid;
	
	
	


	public ForwardandReason(int id, Forward fid, Nouns nouns_id,
			float cf_reason, Verb verb_id, Suggestion sid ) {
		super();
		this.id = id;
		this.fid = fid;
		this.nouns_id = nouns_id;
		this.cf_reason = cf_reason;
		this.verb_id = verb_id;
		this.sid = sid;
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
	public Nouns getNouns_id() {
		return nouns_id;
	}
	public void setNouns_id(Nouns nouns_id) {
		this.nouns_id = nouns_id;
	}
	public float getCf_reason() {
		return cf_reason;
	}
	public void setCf_reason(float cf_reason) {
		this.cf_reason = cf_reason;
	}
	public Verb getVerb_id() {
		return verb_id;
	}
	public void setVerb_id(Verb verb_id) {
		this.verb_id = verb_id;
	}

	
	
}
