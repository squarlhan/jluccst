package cn.edu.jlu.ccst.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
/**
 * 规则现象实体类
 * @author alapapang
 */
@Entity
@Component("backwardandresult")
public class BackwardandResult {
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue
	private int id;
	/**
	 * 对应规则外键
	 */
	@ManyToOne (cascade = { CascadeType.MERGE }) 
	@JoinColumn(name = "bid")
	private Backward bid;
	/**
	 * 现象名词
	 */
	private String nouns;
	/**
	 * 优先级别
	 */
	private float  cf_result;
	/**
	 * 现象动词
	 */
	private String verb;
	/**
	 * 现象简介
	 */
	private String memo;
	
	
	
	
	
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 现象构造函数
	 */
	public BackwardandResult(Backward bid, String nouns, float cf_result,
			String verb) {
		super();
		this.bid = bid;
		this.nouns = nouns;
		this.cf_result = cf_result;
		this.verb = verb;
	}
	public BackwardandResult() {
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
