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
@Component("verb")
public class Verb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4761095751458248560L;
	@Id
	@GeneratedValue
	private int verb_id;
	private String memo;
	private String name;
	@OneToMany(mappedBy = "verb_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BackwardandResult.class) 
	private List<BackwardandResult> bresults = new ArrayList(0);
	@OneToMany(mappedBy = "verb_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BackwardandReason.class) 
	private List<BackwardandReason> breasons = new ArrayList(0);
	@OneToMany(mappedBy = "verb_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ForwardandResult.class) 
	private List<ForwardandResult> fresults = new ArrayList(0);
	@OneToMany(mappedBy = "verb_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ForwardandReason.class) 
	private List<ForwardandReason> freasons = new ArrayList(0);
	
	
	


	public List<BackwardandResult> getBresults() {
		return bresults;
	}

	public void setBresults(List<BackwardandResult> bresults) {
		this.bresults = bresults;
	}

	public List<BackwardandReason> getBreasons() {
		return breasons;
	}

	public void setBreasons(List<BackwardandReason> breasons) {
		this.breasons = breasons;
	}

	public List<ForwardandResult> getFresults() {
		return fresults;
	}

	public void setFresults(List<ForwardandResult> fresults) {
		this.fresults = fresults;
	}

	public List<ForwardandReason> getFreasons() {
		return freasons;
	}

	public void setFreasons(List<ForwardandReason> freasons) {
		this.freasons = freasons;
	}



	public Verb(int verb_id, String memo, String name,
			List<BackwardandResult> bresults, List<BackwardandReason> breasons,
			List<ForwardandResult> fresults, List<ForwardandReason> freasons) {
		super();
		this.verb_id = verb_id;
		this.memo = memo;
		this.name = name;
		this.bresults = bresults;
		this.breasons = breasons;
		this.fresults = fresults;
		this.freasons = freasons;
	}

	public Verb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Verb(int verb_id, String name, String memo) {
		super();
		this.verb_id = verb_id;
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

	public int getVerb_id() {
		return verb_id;
	}

	public void setVerb_id(int verb_id) {
		this.verb_id = verb_id;
	}
}
