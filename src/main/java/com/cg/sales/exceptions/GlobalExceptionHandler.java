package com.cg.sales.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException cnfe){
		return new ResponseEntity<>(cnfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException pnfe){
		return new ResponseEntity<>(pnfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CountryNotFoundException.class)
	public ResponseEntity<String> handleCountryNotFoundException(CountryNotFoundException cnfe){
		return new ResponseEntity<>(cnfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SalesNotFoundException.class)
	public ResponseEntity<String> handleSalesNotFoundException(SalesNotFoundException snfe){
		return new ResponseEntity<>(snfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	
}
