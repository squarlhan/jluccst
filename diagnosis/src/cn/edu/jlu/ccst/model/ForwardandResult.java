package cn.edu.jlu.ccst.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
@Entity
@Component("forwardandresult")
public class ForwardandResult {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne (cascade = { CascadeType.MERGE }) 
	@JoinColumn(name = "fid")
	private Forward fid;
	@ManyToOne (cascade = { CascadeType.MERGE }) 
	@JoinColumn(name = "nouns_id")
	private Nouns nouns_id;
	private float  cf_result;
	@ManyToOne (cascade = { CascadeType.MERGE }) 
	@JoinColumn(name = "verb_id")
	private Verb verb_id;
	
	
	
	

	public ForwardandResult(int id, Forward fid, Nouns nouns_id,
			float cf_result, Verb verb_id) {
		super();
		this.id = id;
		this.fid = fid;
		this.nouns_id = nouns_id;
		this.cf_result = cf_result;
		this.verb_id = verb_id;
	}
	public ForwardandResult() {
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
	public float getCf_result() {
		return cf_result;
	}
	public void setCf_result(float cf_result) {
		this.cf_result = cf_result;
	}
	public Verb getVerb_id() {
		return verb_id;
	}
	public void setVerb_id(Verb verb_id) {
		this.verb_id = verb_id;
	}

	
	
}
