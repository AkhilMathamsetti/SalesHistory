package com.cg.sales.exceptions;

public class CountryNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CountryNotFoundException() {
	}

	public CountryNotFoundException(String msg) {
		super(msg);
	}

}
