package cn.edu.jlu.ccst.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
/**
 *实时数据故障日志实体类
 */
@Entity
@Component("motoerrorlog")
public class MotoErrorlog implements Serializable{

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
	 * 设备参数
	 */
	private String item;
	/**
	 * 参数值
	 */
	private Double value;
	/**
	 * 故障时间
	 */
	private String time;
	/**
	 * 报警级别
	 */
	private String level;
	/**
	 * 相关故障
	 */
	private String error;
	/**
	 * 相关建议
	 */
	private String sugg;
	/**
	 * 故障动词
	 */
	private String wrong;
	
	
	/**
	 * 构造函数
	 */
	public MotoErrorlog() { 
		super();
		
	}
	/**
	 * 构造函数
	 */
	public MotoErrorlog(int id, String equipment, String item, Double value,
			String time, String level, String error, String sugg, String wrong) {
		super();
		this.id = id;
		this.equipment = equipment;
		this.item = item;
		this.value = value;
		this.time = time;
		this.level = level;
		this.error = error;
		this.sugg = sugg;
		this.wrong = wrong;
	}

	/**
	 * 
	 */
	

  
	public String getLevel() {
		return level;
	}
	public String getWrong() {
		return wrong;
	}
	public void setWrong(String wrong) {
		this.wrong = wrong;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getSugg() {
		return sugg;
	}
	public void setSugg(String sugg) {
		this.sugg = sugg;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getId() {
		return id;
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
