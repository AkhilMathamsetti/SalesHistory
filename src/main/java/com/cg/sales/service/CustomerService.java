package com.cg.sales.service;

import java.util.List;

import com.cg.sales.entity.Customer;

public interface CustomerService {
	public Customer saveCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public Customer getCustomer(Integer cistId);
	public void deleteProduct(Integer custId);
	public Customer updateProduct(Integer custId,Customer customer);
}
