package cn.edu.jlu.ccst.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
/**
 * 实时数据实体类
 */
@Entity
@Component("motodcsdata")
public class MotoDcsdata implements Serializable{

	/**
	 * 主键
	 */
	private static final long serialVersionUID = -6305660104857386885L;
	@Id
	@GeneratedValue
	private int id;
	/**
	 * 设备名称
	 */
	private String equipment;
	/**
	 * 对应参数
	 */
	private String item;
	/**
	 * 参数值
	 */
	private Double value;
	/**
	 * 优先级别
	 */
	private String isok;
	/**
	 * 构造函数
	 */
	public MotoDcsdata() { 
		super();
		
	}
	/**
	 * 构造函数
	 */
	public MotoDcsdata(int id, String equipment, String item, Double value) {
		super();
		this.id = id;
		this.equipment = equipment;
		this.item = item;
		this.value = value;
	}
	/**
	 * 
	 */
	
	public int getId() {
		return id;
	}
	public String getIsok() {
		return isok;
	}
	public void setIsok(String isok) {
		this.isok = isok;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
