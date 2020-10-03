package com.altran.hack100.app.portal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GenericResponseMsg<T> {
	
	private T data;
	private Long totalRows;
	private String responseMessage;
	
	
	public GenericResponseMsg(T t) {
		this.data = t;
	}
	
	public GenericResponseMsg(T data, Long totalRows) {
		super();
		this.data = data;
		this.totalRows = totalRows;
	}
	
	public GenericResponseMsg(T data, Long totalRows, String responseMessage) {
		super();
		this.data = data;
		this.totalRows = totalRows;
		this.responseMessage = responseMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Long totalRows) {
		this.totalRows = totalRows;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	

}
