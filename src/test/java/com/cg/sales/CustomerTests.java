package com.cg.sales;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sales.service.CustomerService;


@SpringBootTest
public class CustomerTests {
	private CustomerService customerService;
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@Test
	public void getAllCustomers() {
		assertNotNull(customerService.getAllCustomers());
	}
	
	@Test
	public void getCustomerFirstName() {
		assertNotNull(customerService.searchCustomerByFirstname("Anne"));
	}
	
	@Test
	public void getCustomerCity() {
		assertNotNull(customerService.searchCustomerByCity("Diss"));
	}
	
	

}
