package cn.edu.jlu.ccst.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
/**
 * 规则原因实体类
 * @author alapapang
 */
@Entity
@Component("backwardandreason")
public class BackwardandReason {
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne (cascade = { CascadeType.MERGE }) 
	@JoinColumn(name = "bid")
	/**
	 * 对应规则外键
	 */
	private Backward bid;
	/**
	 * 原因名词
	 */
	private String nouns;
	/**
	 * 优先级别
	 */
	private double  cf_reason;
	/**
	 * 原因动词
	 */
	private String verb;
	/**
	 * 相关建议
	 */
	private String sugg;
	
	
	
	

	/**
	 * 现象构造函数
	 */
	public BackwardandReason(Backward bid, String nouns, double cf_reason,
			String verb, String sugg) {
		super();
		this.bid = bid;
		this.nouns = nouns;
		this.cf_reason = cf_reason;
		this.verb = verb;
		this.sugg = sugg;
	}
	public BackwardandReason() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Backward getBid() {
		return bid;
	}
	public void setBid(Backward bid) {
		this.bid = bid;
	}
	

	public double getCf_reason() {
		return cf_reason;
	}
	public void setCf_reason(double cf_reason) {
		this.cf_reason = cf_reason;
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


	
	
}
