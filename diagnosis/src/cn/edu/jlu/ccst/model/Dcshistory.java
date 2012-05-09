package cn.edu.jlu.ccst.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
/**
 * dcs历史数据实体类
 */
@Entity
@Component("dcshistory")
public class Dcshistory implements Serializable{

	
	/**
	 * 主键
	 */
	private static final long serialVersionUID = 499290511105257682L;
	@Id
	@GeneratedValue
	private int id;
	/**
	 * 设备名称
	 */
	private String equipment;
	/**
	 * 参数
	 */
	private String item;
	/**
	 * 参数值
	 */
	private Double value;
	/**
	 * 记录批次时间
	 */
	private String seqno;
	public Dcshistory() { 
		super();
		
	}
	/**
	 * 构造函数
	 */
	public Dcshistory(int id, String equipment, String item, Double value, String seqno) {
		super();
		this.id = id;
		this.equipment = equipment;
		this.item = item;
		this.value = value;
		this.seqno = seqno;
	}
	/**
	 * 
	 */
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
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	
	
	
}
