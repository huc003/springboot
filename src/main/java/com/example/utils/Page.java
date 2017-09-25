package com.example.utils;


public class Page implements java.io.Serializable {

	private int page = 1;// 当前页

	private int rows = 15;// 每页显示记录数

	private String sort;// 排序字段

	private String order;// asc/desc
	
	private int offset;
	
	private int total;
	
	public int getTotal(int count,int rows) {
		double c = Double.valueOf(count);
		double r = Double.valueOf(rows);
		double total = c/r;
		return (int)Math.ceil(total);
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getOffset() {
		return (page - 1) * rows;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return
	 */
	public int offset() {
		return (page - 1) * rows;
	}
}
