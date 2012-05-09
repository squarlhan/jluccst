package cn.edu.jlu.ccst.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
/**
 * 位号对照表实体类
 */
@Entity
@Component("exceldata")
public class ExcelData {
	/**
	 * 主键，工艺位号
	 */
	@Id
	private String id;
	/**
	 * 对应名称
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
	public ExcelData(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public ExcelData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
