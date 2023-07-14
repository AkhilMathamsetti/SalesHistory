package com.cg.sales.exceptions;

import java.util.Date;

public class ErrorResponse {

	private Date date;
	private String message;
	private String status;
	
	public ErrorResponse(Date date, String message, String status) {
		super();
		this.date = date;
		this.message = message;
		this.status = status;
	}
	
	public ErrorResponse() {
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
