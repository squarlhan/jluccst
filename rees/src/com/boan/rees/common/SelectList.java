package com.boan.rees.common;

/**
 * 主要针对下拉列表
 * 
 * @author leon
 * 
 */
public class SelectList {
	// 内容
	private String text = "";
	// 对应的值
	private String value = "";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
