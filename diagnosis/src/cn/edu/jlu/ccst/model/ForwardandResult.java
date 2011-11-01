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
	private String nouns;
	private float  cf_result;
	private String verb;
	
	

	public ForwardandResult(Forward fid, String nouns, float cf_result,
			String verb) {
		super();
		this.fid = fid;
		this.nouns = nouns;
		this.cf_result = cf_result;
		this.verb = verb;
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
	public float getCf_result() {
		return cf_result;
	}
	public void setCf_result(float cf_result) {
		this.cf_result = cf_result;
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

	
	
}
