package com.cg.sales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sales.entities.Customer;
import com.cg.sales.exceptions.CustomerNotFoundException;
import com.cg.sales.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomer(Integer custId) {
		return customerRepository.findById(custId).orElseThrow(()->new CustomerNotFoundException("Customer with ID: "+custId+",not available "));
	}
	
	@Override
	public List<Customer> searchCustomerByFirstname(String custFirstName) {
		if(customerRepository.findByCustFirstName(custFirstName).isEmpty()) {
			throw new CustomerNotFoundException("Customer with Firstname: "+custFirstName+" not available ");
		}
		return customerRepository.findByCustFirstName(custFirstName);
	}

	
	
	@Override
	public List<Customer> searchCustomerByCity(String custCity) {
		if(customerRepository.findByCustCity(custCity).isEmpty()) {
			throw new CustomerNotFoundException("Customer with City: "+custCity+" not available ");
		}
		
		return customerRepository.findByCustCity(custCity);
	}
	
	@Override
	public void deleteCustomer(Integer custId) {
		Customer customer = getCustomer(custId);
		customerRepository.deleteById(customer.getCustId());
	}

	@Override
	public Customer updateCustomer(Integer custId, Customer customer) {
		Customer existingCustomer = getCustomer(custId);
		existingCustomer = customer;
		return customerRepository.save(existingCustomer);
	}

	@Override
	public List<Customer> searchCustomerByIncome(String custIncomeLevel) {
		if(customerRepository.findByCustIncomeLevel(custIncomeLevel).isEmpty()) {
			throw new CustomerNotFoundException("CUstomer with income level: "+custIncomeLevel+",is not avialable");
		}
		return customerRepository.findByCustIncomeLevel(custIncomeLevel);
	}

	@Override
	public Customer updateCustomerCreditLimit(Integer custId,Customer customer) {
		Customer existingCustomer = getCustomer(custId);
		existingCustomer.setCustCreditLimit(customer.getCustCreditLimit());
		return customerRepository.save(existingCustomer);
	}

	@Override
	public List<Customer> searchCustomerByCreditLimit(Integer custCreditLimit) {
		if(customerRepository.findByCustCreditLimit(custCreditLimit).isEmpty()) {
			throw new CustomerNotFoundException("Customer with Credit limit: "+custCreditLimit+",is not avialable");
		}
		return customerRepository.findByCustCreditLimit(custCreditLimit);
	}

}
