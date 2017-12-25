package com.sxt.bls.utils;

public class PageBean {
	private int currentPage;
	private int pageSize = 5;
	private int totalPage;
	private int totalCount;
	public PageBean() {}
	public PageBean(int currentPage, int pageSize, int totalPage, int totalCount) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
	}
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
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPage = (int)Math.ceil(totalCount*1.0/pageSize);
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageSize="
				+ pageSize + ", totalPage=" + totalPage + ", totalCount="
				+ totalCount + "]";
	}
	
	
}
