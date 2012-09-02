/**
 * 
 */
package com.boan.crm.customer.analysis.model;

import java.util.List;

/**
 * @author luojx
 *
 */
public class IdCaption {
	private String id = "";
	private int iId = 0;
	private String caption = "";
	private List<?> attachObject = null;
	public IdCaption(){}
	public IdCaption(int id,String caption)
	{
		this.iId = id;
		this.caption = caption;
	}
	public IdCaption(String id,String caption)
	{
		this.id = id;
		this.caption = caption;
	}
	public int getIId() {
		return iId;
	}
	public void setIId(int iId) {
		this.iId = iId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public List<?> getAttachObject() {
		return attachObject;
	}
	public void setAttachObject(List<?> attachObject) {
		this.attachObject = attachObject;
	}
}
