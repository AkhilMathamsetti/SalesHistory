package com.cg.sales.exceptions;

public class DataTypeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataTypeNotFoundException() {
	}
	
	public DataTypeNotFoundException(String msg) {
		super(msg);
	}
}
