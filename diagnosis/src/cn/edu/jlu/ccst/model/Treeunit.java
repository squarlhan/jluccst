package cn.edu.jlu.ccst.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.stereotype.Component;
/**
 * 树形菜单节点实体类
 */
@Entity
@Component("treeunit")
public class Treeunit implements Serializable{

	/**
	 * 主键
	 */
	private static final long serialVersionUID = -6305660104857386885L;
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * 父亲节点
	 */
	private String father;
	/**
	 * 子节点
	 */
	private String child;
	/**
	 * 构造函数
	 */
	public Treeunit() { 
		super();
		
	}
	/**
	 * 构造函数
	 */
	public Treeunit(int id,String child, String father) {
		super();
		this.id = id;
		this.child = child;
		this.father = father;
		
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
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getChild() {
		return child;
	}
	public void setChild(String child) {
		this.child = child;
	}

	
	
	
}
