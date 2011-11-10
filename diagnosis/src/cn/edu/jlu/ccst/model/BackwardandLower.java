package cn.edu.jlu.ccst.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
@Entity
@Component("backwardandlower")
public class BackwardandLower {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne (cascade = { CascadeType.MERGE }) 
	@JoinColumn(name = "bid")
	private Backward bid;
	@ManyToOne (cascade = { CascadeType.MERGE }) 
	@JoinColumn(name = "did")
	private DcsDscrib did;
	
	
	
	
	public BackwardandLower(Backward bid, DcsDscrib did) {
		super();
		this.bid = bid;
		this.did = did;
	}
	public BackwardandLower() {
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
	public DcsDscrib getDid() {
		return did;
	}
	public void setDid(DcsDscrib did) {
		this.did = did;
	}
	

	
	
}
