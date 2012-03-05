/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)Pages.java 1.1 2012-3-4
 */

package com.boan.rees.utils.page;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.components.Component;
import org.apache.struts2.dispatcher.StrutsRequestWrapper;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * 构建分页标签体的类
 * 
 * @author ZhuYF
 * @version 1.0.0
 */
public class Pages extends Component {
	private HttpServletRequest request;
	private String pageNo; // 当前页码
	private String total; // 总页数
	private String styleClass; // 分页的样式
	private String theme; // 分页的主题
	private String url; // action的路径
	private String urlType; // 路径的类型，主要用于URL重写的扩展

	public Pages(ValueStack arg0, HttpServletRequest request) {
		super(arg0);
		this.request = request;
	}

	@Override
	public boolean end(Writer writer, String body) {
		boolean result = super.start(writer);
		try {
			// 从ValueStack中取出数值
			Object obj = this.getStack().findValue(pageNo);
			pageNo = String.valueOf((Integer) obj);
			obj = this.getStack().findValue(total);
			total = String.valueOf((Integer) obj);

			StringBuilder str = new StringBuilder();
			Map cont = this.getStack().getContext();
			StrutsRequestWrapper req = (StrutsRequestWrapper) cont.get(StrutsStatics.HTTP_REQUEST);
			if (url == null || "".equals(url)) {
				url = (String) req.getAttribute("javax.servlet.forward.request_uri");
			}
			String pageNoStr = "?pageNo=";
			if ("dir".equals(urlType)) {
				pageNoStr = "";
				if ("1".equals(pageNo)) {// 第一页时
					if (url.lastIndexOf("/") != url.length() - 1) {
						if (url.lastIndexOf("1") == url.length() - 1) {// 如果有页码1，则去掉1
							url = url.substring(0, url.length() - 1);
						} else if (url.lastIndexOf("/") != url.length() - 1) {// 如果没有页码1，并且最后不是'/'时，加上'/'
							url = url + "/";
						}
					}
				} else {
					url = url.substring(0, url.lastIndexOf("/") + 1);
				}
			}

			// 下面这段处理主要是用来处理动态查询的参数，并拼接成url
			StringBuffer perUrl = new StringBuffer("");
			if (this.getParameters().size() != 0) {
				Iterator iter = this.getParameters().keySet().iterator();
				while (iter.hasNext()) {
					String key = (String) iter.next();
					Object o = this.getParameters().get(key);
					perUrl.append("&").append(key).append("=").append(o);
				}
			}
			Integer cpageInt = Integer.valueOf(pageNo);
			str.append("<span ");
			if (styleClass != null) {
				str.append(" class='" + styleClass + "'>");
			} else {
				str.append(">");
			}
			// 文本样式
			if (theme == null || "text".equals(theme)) {
				// 当前页与总页数相等
				str.append(" 共[ " + total + " ]条记录&nbsp;&nbsp;&nbsp;&nbsp;");
				if (pageNo.equals(total)) {
					str.append("<a href='" + url + pageNoStr + "1" + perUrl
							+ "'>首　页&nbsp;&nbsp;&nbsp;&nbsp;</a> ");
					str.append("<a href='" + url + pageNoStr
							+ (cpageInt - 1) + perUrl + "'>上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
					str.append("下一页&nbsp;&nbsp;&nbsp;&nbsp;");
					str.append("尾　页&nbsp;&nbsp;&nbsp;&nbsp;");
					str.append("当前["+ pageNo + "/" + total + "]页");
				} else {
					// 当前页与总页数不相同
					if ("1".equals(pageNo)) {
						str.append("首　页&nbsp;&nbsp;&nbsp;&nbsp;");
						str.append("上一页&nbsp;&nbsp;&nbsp;&nbsp;");
						str.append("<a href='" + url + pageNoStr
								+ (cpageInt + 1) + perUrl + "'>下一页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
						str.append("<a href='" + url + pageNoStr + total
								+ perUrl + "'>尾　页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
						str.append("当前["+ pageNo + "/" + total + "]页");
					} else {
						str.append("<a href='" + url + pageNoStr + "1" + perUrl
								+ "'>首　页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
						str.append("<a href='" + url + pageNoStr
								+ (cpageInt - 1) + perUrl + "'>上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
						str.append("<a href='" + url + pageNoStr
								+ (cpageInt + 1) + perUrl + "'>下一页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
						str.append("<a href='" + url + pageNoStr + total
								+ perUrl + "'>尾　页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
						str.append("当前["+ pageNo + "/" + total + "]页");
					}
				}
			} else if ("number".equals(theme)) { // 数字样式 [1 2 3 4 5 6 7 8 9 10 >
													// >>]
				Integer totalInt = Integer.valueOf(total);

				// 如果只有一页，则无需分页
				str.append("[ ");
				if (totalInt == 1) {
					str.append("<strong>1</strong> ");
				} else {
					if (cpageInt > 1) {
						// 当前不是第一组，要显示“<< <”
						// <<：返回前一组第一页
						// <：返回前一页
						str.append("<a href='" + url + pageNoStr + "1" + perUrl
								+ "'>?</a> ");
						str.append("<a href='" + url + pageNoStr
								+ (cpageInt - 1) + perUrl);
						str.append("'>‹</a> ");
					} else {
						str.append("? ‹ ");
					}

					int v = (cpageInt - 4) > 0 ? (cpageInt - 4) : 1;
					int v1 = (cpageInt + 4) < totalInt ? (cpageInt + 4)
							: totalInt;
					if (v1 == totalInt) {
						v = totalInt - 10;
						v = (v <= 0 ? 1 : v); // 如果为负数，则修改为1
					} else if (v == 1 && v1 < totalInt) {
						v1 = totalInt > 10 ? 10 : totalInt;
					}
					// 10个为一组显示
					for (int i = v; i <= v1; i++) {
						if (cpageInt == i) { // 当前页要加粗显示
							str.append("<strong>" + i + "</strong> ");
						} else {
							// str.append("<a href='"+url + i +perUrl+"'>" + i +
							// "</a> ");
							str.append("<a href='" + url + pageNoStr + i
									+ perUrl + "'>" + i + "</a> ");
						}
					}
					// 如果多于1组并且不是最后一组，显示“> >>”
					if (cpageInt < totalInt) {
						// >>：返回下一组最后一页
						// >：返回下一页
						str.append("<a href='" + url + pageNoStr
								+ (cpageInt + 1) + perUrl);
						str.append("'>›</a> ");
						str.append("<a href='" + url + pageNoStr + totalInt
								+ perUrl);
						str.append("'>?</a> ");
					} else {
						str.append("› ? ");
					}
				}
				str.append("]");
			}
			str.append("</span>");

			writer.write(str.toString());

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlType() {
		return urlType;
	}

	public void setUrlType(String urlType) {
		this.urlType = urlType;
	}
}
