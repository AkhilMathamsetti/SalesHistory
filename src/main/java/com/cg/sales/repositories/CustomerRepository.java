package com.cg.sales.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.sales.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByCustFirstName(String custFirstName);
	List<Customer> findByCustCity(String custCity);
	List<Customer> findByCustIncomeLevel(String custIncomeLevel);
	List<Customer> findByCustCreditLimit(Integer custCreditLimit);
	
	java.util.Optional<Customer> findByCustId(int custId);

	@Query("SELECT c.country.countryName, COUNT(c) FROM Customer c GROUP BY c.country.countryId")
	List<Object[]> getCustomerCountByCountry();
	
	
}
