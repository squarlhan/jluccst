/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)PageTag.java 1.1 2012-3-4
 */

package com.boan.rees.utils.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * XXX 类
 * @author ZhuYF
 * @version 1.0.0
 */
public class PageTag extends ComponentTagSupport {   
    
    private String currentPage;   
    private String totalPages;
	private String totalRows;
    private String styleClass;   
    private String theme;
    private String url;
    private String urlType;
    private String validateFunction;
       
    public void setUrlType(String urlType) {
       this.urlType = urlType;
    }
    public void setUrl(String url) {
       this.url = url;
    }
    public void setTheme(String theme) {   
        this.theme = theme;   
    }       
    public void setStyleClass(String styleClass) {   
        this.styleClass = styleClass;   
    }   
    public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}
	public void setTotalRows(String totalRows) {
		this.totalRows = totalRows;
	}
	public void setValidateFunction(String validateFunction) {
		this.validateFunction = validateFunction;
	}
	@Override 
    public Component getBean(ValueStack arg0, HttpServletRequest arg1, HttpServletResponse arg2) {   
        return new Pages(arg0, arg1);   
    }   
 
    protected void populateParams() {   
        super.populateParams();   
           
        Pages pages = (Pages)component;
        pages.setCurrentPage(currentPage);
        pages.setTotalRows(totalRows);
        pages.setTotalPages(totalPages);
        pages.setStyleClass(styleClass);
        pages.setTheme(theme);
        pages.setUrl(url);
        pages.setUrlType(urlType);
        pages.setValidateFunction(validateFunction);
    }   
}   


