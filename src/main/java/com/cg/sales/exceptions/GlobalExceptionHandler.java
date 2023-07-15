package com.cg.sales.exceptions;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException cnfe){
		ErrorResponse errorResponse = new ErrorResponse(new Date(),cnfe.getMessage(),HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CountryNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCountryNotFoundException(CountryNotFoundException cnfe){
		ErrorResponse errorResponse = new ErrorResponse(new Date(),cnfe.getMessage(),HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException pnfe){
		ErrorResponse errorResponse = new ErrorResponse(new Date(),pnfe.getMessage(),HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SalesNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleSalesNotFoundException(SalesNotFoundException snfe){
		ErrorResponse errorResponse = new ErrorResponse(new Date(),snfe.getMessage(),HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
}
