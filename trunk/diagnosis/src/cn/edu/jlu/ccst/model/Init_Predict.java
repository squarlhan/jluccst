package cn.edu.jlu.ccst.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component("init_predict")
public class Init_Predict {
	@Id
	private String pid;
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Init_Predict(String pid, String name) {
		super();
		this.pid = pid;
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Init_Predict() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
