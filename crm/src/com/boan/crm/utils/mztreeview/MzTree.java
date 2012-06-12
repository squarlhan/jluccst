package com.boan.crm.utils.mztreeview;

/**
 * 树节点属性
 * 
 * @author leon
 * 
 */
public class MzTree {
	private String id = null;
	private String parentId = null;
	private String icon = null;
	private String text = null;
	private String url = null;
	private String data = null;
	private String target = null;
	private String XMLData = null;
	private String JsData = null;

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
	 * 父节点ID
	 * 
	 * @return
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * 父节点ID
	 * 
	 * @param parentId
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
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

	/**
	 * JS字符串数据
	 * 
	 * @return
	 */
	public String getJsData() {
		return JsData;
	}

	/**
	 * JS字符串数据
	 * 
	 * @param jsData
	 */
	public void setJsData(String jsData) {
		JsData = jsData;
	}
}
