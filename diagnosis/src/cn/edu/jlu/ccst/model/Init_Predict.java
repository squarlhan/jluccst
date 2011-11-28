package cn.edu.jlu.ccst.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component("init_predict")
public class Init_Predict {
	@Id
	private String id;
	private String name;
	private String value;
	
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Init_Predict(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Init_Predict() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
