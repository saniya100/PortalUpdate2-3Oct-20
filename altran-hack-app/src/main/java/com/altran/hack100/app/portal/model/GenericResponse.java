package com.altran.hack100.app.portal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GenericResponse<T> {
	
	T data;
	Long totalRows;
	
	
	public GenericResponse(T t) {
		this.data = t;
	}
	
	public GenericResponse(T data, Long totalRows) {
		super();
		this.data = data;
		this.totalRows = totalRows;
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
	
	
	
	

}
