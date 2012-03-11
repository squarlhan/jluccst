/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)Pagination.java 1.1 2012-3-11
 */

package com.boan.rees.utils.page;

import java.util.List;

/**
 * 分页实体
 * 
 * @author ZhuYF
 * @version 1.0.0
 */
public class Pagination<T> {

	/**
	 * 当前页号
	 */
	private int currentPage = 1;

	/**
	 * 每页要显示的记录数
	 */
	private int pageSize = 2;

	/**
	 * 总记录数
	 */
	private int totalRows = 0;
	
	/**
	 * 总页数
	 */
	private int totalPages = 1;

	/**
	 * 符合分页条件的数据列表
	 */
	private List<T> data;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	/**
	 * 计算出总页数
	 * @return 总页数
	 */
	public int getTotalPages() {
		if (totalRows <= 0) {
			return 1;
		} else {
			return (this.totalRows + this.pageSize - 1) / this.pageSize;
		}
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	/**
	 * 计算分页记录起始下标
	 * @return
	 */
	public int getStartIndex()
	{
		return ( this.getCurrentPage() - 1 ) * ( this.getPageSize() );
	}
}
