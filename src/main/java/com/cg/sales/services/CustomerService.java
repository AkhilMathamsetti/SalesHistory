package com.cg.sales.services;

import java.util.List;

import com.cg.sales.entities.Customer;

public interface CustomerService {
	public Customer saveCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public Customer getCustomer(Integer custId);
	public List<Customer> searchCustomerByFirstname(String custFirstName);
	public List<Customer> searchCustomerByCity(String custCity);
	public void deleteCustomer(Integer custId);
	public Customer updateCustomer(Integer custId,Customer customer);
	public List<Customer> searchCustomerByIncome(String custIncomeLevel);
	public Customer updateCustomerCreditLimit(Integer custId,Customer customer);
	public List<Customer> searchCustomerByCreditLimit(Integer custCreditLimit);
}
