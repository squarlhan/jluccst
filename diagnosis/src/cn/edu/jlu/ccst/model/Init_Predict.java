package cn.edu.jlu.ccst.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
/**
 * 尾号对照表
 */
@Entity
@Component("init_predict")
public class Init_Predict {
	/**
	 * 主键，位号
	 */
	@Id
	private String id;
	/**
	 * 参数名称
	 */
	private String name;

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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 构造函数
	 */
	public Init_Predict() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
