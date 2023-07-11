package com.cg.sales.exceptions;

public class NoSuchCustomerExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public NoSuchCustomerExistsException(String message) {
		super(message);
	}

	public NoSuchCustomerExistsException() {
	
	}
	
	
	
}
