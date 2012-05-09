package cn.edu.jlu.ccst.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
/**
 * 位号对照表
 */
@Entity
@Component("initdata")
public class InitData {
	/**
	 * 主键，位号
	 */
	@Id
	private String id;
	/**
	 * 参数名称
	 */
	private String name;
	/**
	 * 参数值
	 */
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
	public InitData(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public InitData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
