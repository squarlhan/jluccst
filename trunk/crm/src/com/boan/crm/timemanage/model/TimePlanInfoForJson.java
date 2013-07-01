package com.boan.crm.timemanage.model;


/**
 * 时间计划对象For Json
 * @author Luojx
 *
 */
public class TimePlanInfoForJson {
//	/**
//	 * 销售员id
//	 */
//	private String id="";
	/**
	 * 销售员名称
	 */
	private String name="";
	private String type = "";
	private String date = "";
	private String summary = "";
	private String plan = "";
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	/**
	 * @return the id
	 */
//	public String getId() {
//		return id;
//	}
//	/**
//	 * @param id the id to set
//	 */
//	public void setId(String id) {
//		this.id = id;
//	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
