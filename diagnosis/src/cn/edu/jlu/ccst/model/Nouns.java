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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component("nouns")
public class Nouns implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4761095751458248560L;
	@Id
	@GeneratedValue
	private int nouns_id;
	private String memo;
	private String name;
	@OneToMany(mappedBy = "nouns_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BackwardandResult.class) 
	private List<BackwardandResult> bresults = new ArrayList(0);
	@OneToMany(mappedBy = "nouns_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BackwardandReason.class) 
	private List<BackwardandReason> breasons = new ArrayList(0);
	@OneToMany(mappedBy = "nouns_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ForwardandResult.class) 
	private List<ForwardandResult> fresults = new ArrayList(0);
	@OneToMany(mappedBy = "nouns_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ForwardandReason.class) 
	private List<ForwardandReason> freasons = new ArrayList(0);
	


	public Nouns(int nouns_id, String memo, String name,
			List<BackwardandResult> bresults, List<BackwardandReason> breasons,
			List<ForwardandResult> fresults, List<ForwardandReason> freasons) {
		super();
		this.nouns_id = nouns_id;
		this.memo = memo;
		this.name = name;
		this.bresults = bresults;
		this.breasons = breasons;
		this.fresults = fresults;
		this.freasons = freasons;
	}
	public List<BackwardandResult> getBresults() {
		return bresults;
	}
	public void setBresults(List<BackwardandResult> bresults) {
		this.bresults = bresults;
	}
	public List<ForwardandResult> getFresults() {
		return fresults;
	}
	public void setFresults(List<ForwardandResult> fresults) {
		this.fresults = fresults;
	}
	public Nouns() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nouns(int nouns_id, Suggestion sid, String name, String memo) {
		super();
		this.nouns_id = nouns_id;
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

	public List<BackwardandReason> getBreasons() {
		return breasons;
	}

	public void setBreasons(List<BackwardandReason> breasons) {
		this.breasons = breasons;
	}

	public List<ForwardandReason> getFreasons() {
		return freasons;
	}

	public void setFreasons(List<ForwardandReason> freasons) {
		this.freasons = freasons;
	}

	public int getNouns_id() {
		return nouns_id;
	}

	public void setNouns_id(int nouns_id) {
		this.nouns_id = nouns_id;
	}
	
	
}
