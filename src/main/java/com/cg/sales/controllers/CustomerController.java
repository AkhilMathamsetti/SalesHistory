package com.cg.sales.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sales.entities.Customer;
import com.cg.sales.services.CustomerService;

@RestController
@RequestMapping(value="/api/v1")
public class CustomerController {

	private CustomerService customerService;
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	/*
	 * Post Mapping for Customer Entity
	 */
	@PostMapping(value="/customers")
	@ResponseStatus(value=HttpStatus.CREATED,reason="Customer Created")
	public Customer saveCustomer(@RequestBody Customer customer){
		return customerService.saveCustomer(customer);
	}
	
	
	/*
	 * Get Mapping for All Customers
	 */
	@GetMapping(value = "/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
	
	
	/*
	 * Put Mapping for Customer Entity Update
	 */
	@PutMapping(value = "/customers/{custId}")
	@ResponseStatus(value=HttpStatus.ACCEPTED, reason="Customer details Updated")
	public Customer updateCustomer(@Valid @PathVariable Integer custId,@RequestBody Customer customer){
		return customerService.updateCustomer(custId, customer);
	}
	
	
	/*
	 * Delete Mapping for Customer Entity
	 */
	@DeleteMapping(value = "/customers/{custId}")
	@ResponseStatus(value=HttpStatus.ACCEPTED,reason="Customer Deleted Successfully")
	public void deleteCustomer(@RequestParam(value="custId") Integer custId){
		customerService.deleteCustomer(custId);
	}
	
	
	/*
	 * Get Mapping for Customer by FirstName
	 */
	@GetMapping(value="/customers/{custFirstName}")
	public ResponseEntity<List<Customer>> searchCustomerByFirstName(@Valid @RequestParam(value="custFirstName") String custFirstName){
		List<Customer> customers = customerService.searchCustomerByFirstname(custFirstName);
		return ResponseEntity.ok(customers);
	}
	
	
	/*
	 * Get Mapping for Customer by City
	 */
	@GetMapping(value="/customers/{custCity}")
	public ResponseEntity<List<Customer>> searchCustomerByCity(@Valid @RequestParam(value="custCity") String custCity){
		return ResponseEntity.ok(customerService.searchCustomerByCity(custCity));
	}
	
	
	/*
	 * Get Mapping for Customer by income
	 */
	@GetMapping(value="/customers/{custIncomeLevel}")
	public ResponseEntity<List<Customer>> searchCustomerIncome(@RequestParam(value="custIncomeLevel") String custIncomeLevel){
		return ResponseEntity.ok(customerService.searchCustomerByIncome(custIncomeLevel));
	}
	
	@GetMapping(value="/customers/{custCreditLimit}")
	public ResponseEntity<List<Customer>> searchCustomerByCreditLimit(@RequestParam(value="custCreditLimit") Integer custCreditLimit){
		return ResponseEntity.ok(customerService.searchCustomerByCreditLimit(custCreditLimit));
	}
	
	/*
	 * Put Mapping for Customer Entity Credit Limit
	 */
	@PutMapping(value = "/customers/creditlimit/{custId}")
	@ResponseStatus(value=HttpStatus.OK,reason="Customer credit limit updated successfully")
	public Customer updateCustomerCreditLimit(@PathVariable Integer custId,@RequestBody Customer customer){
		return customerService.updateCustomerCreditLimit(custId, customer);
	}
	
}
