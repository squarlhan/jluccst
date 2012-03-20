package com.boan.rees.utils.mztreeview;

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * MzTreeView树处理函数
 * 
 * @author leon
 * @version 1.0.0
 */
public class MzTreeUtil {
	/**
	 * 将TreeNode对象值拼成XML字符串
	 * 
	 * @param treeNodes
	 * @return
	 */
	public static String toTreeXmlString(List<MzTreeNode> treeNodes) {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sb.append("<nodes>");
		for (MzTreeNode node : treeNodes) {
			sb.append("<node ");
			if (StringUtils.trimToNull(node.getId()) != null) {
				sb.append("id='" + node.getId() + "' ");
			}
			if (StringUtils.trimToNull(node.getId()) != null) {
				sb.append("icon='" + node.getIcon() + "' ");
			}
			if (StringUtils.trimToNull(node.getText()) != null) {
				sb.append("text='" + node.getText() + "' ");
			}
			if (StringUtils.trimToNull(node.getUrl()) != null) {
				sb.append("url='" + node.getUrl() + "' ");
			}
			if (StringUtils.trimToNull(node.getData()) != null) {
				sb.append("data='" + node.getData() + "' ");
			}
			if (StringUtils.trimToNull(node.getTarget()) != null) {
				sb.append("target='" + node.getTarget() + "' ");
			}
			if (StringUtils.trimToNull(node.getXMLData()) != null) {
				sb.append("XMLData='" + node.getXMLData() + "' ");
			}
			sb.append(" />");
		}
		sb.append("</nodes>");
		return sb.toString();
	}
}