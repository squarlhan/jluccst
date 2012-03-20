package com.boan.rees.utils.mztreeview;

/**
 * 树节点属性
 * 
 * @author leon
 * 
 */
public class MzTreeNode {
	private String id = null;
	private String icon = null;
	private String text = null;
	private String url = null;
	private String data = null;
	private String target = null;
	private String XMLData = null;
	/**
	 * @return 节点id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param 节点id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return 图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param 图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * @return 节点内容
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param 节点内容
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return 节点链接
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param 节点链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return 节点链接参数
	 */
	public String getData() {
		return data;
	}
	/**
	 * @param 节点链接参数
	 */
	public void setData(String data) {
		this.data = data;
	}
	/**
	 * @return 跳转窗口名
	 */
	public String getTarget() {
		return target;
	}
	/**
	 * @param 跳转页窗口名
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	/**
	 * @return 获得XML字符串地址
	 */
	public String getXMLData() {
		return XMLData;
	}
	/**
	 * @param 获得XML字符串地址
	 */
	public void setXMLData(String data) {
		XMLData = data;
	}

}
