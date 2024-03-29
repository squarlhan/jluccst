package cn.edu.jlu.ccst.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
/**
 * 用户实体类
 */
@Entity
@Component("user")
public class User implements Serializable{

	/**
	 * 主键
	 */
	private static final long serialVersionUID = -4761095751458248560L;
	@Id
	@GeneratedValue
	private int id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 电话号码
	 */
	private String phone;
	/**
	 * 真实姓名
	 */
	private String name;
	/**
	 * 所属部门
	 */
	private String dept;
	/**
	 * 是否为用户
	 */
	private Boolean isuser;
	/**
	 * 是否为管理员
	 */
	private Boolean isadmin;
	/**
	 * 是否为专家
	 */
	private Boolean isprof;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 构造函数
	 */
	public User(String username, String password, String email,
			String phone, String name, String jid, String dept,Boolean isuser,Boolean isadmin,Boolean isprof) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.jid = jid;
		this.dept = dept;
		this.isuser = isuser;
		this.isadmin = isadmin;
		this.isprof = isprof;
	}
   
	
	

	public Boolean getIsuser() {
		return isuser;
	}

	public void setIsuser(Boolean isuser) {
		this.isuser = isuser;
	}

	public Boolean getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(Boolean isadmin) {
		this.isadmin = isadmin;
	}

	public Boolean getIsprof() {
		return isprof;
	}

	public void setIsprof(Boolean isprof) {
		this.isprof = isprof;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJid() {
		return jid;
	}

	public void setJid(String jid) {
		this.jid = jid;
	}

	private String jid;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
