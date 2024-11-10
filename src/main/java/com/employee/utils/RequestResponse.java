package com.employee.utils;

public class RequestResponse<T> {


	private T load;
	
	private int responseCode;
	
	private String message;
	
	private Integer page;
	
	private Integer pageSize;
	
	private Long totalRecords;
	
	private Integer totalPages;
	
	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public void setLoad(T load) {
		this.load = load;
	}

	public void setPageInfo (Integer page, Integer pageSize, Long totalRecords, Integer totalPages) {
		this.page = page;
		this.pageSize = pageSize;
		this.totalRecords = totalRecords;
		this.totalPages = totalPages;
	}
	
	public T getLoad() {
		return load;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	
}
