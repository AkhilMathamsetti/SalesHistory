package com.cg.sales;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sales.entities.Country;
import com.cg.sales.services.CountriesService;

@SpringBootTest
class CountriesTests {

	private CountriesService countriesService;
	
	@Autowired
	public void setCountriesService(CountriesService countriesService) {
		this.countriesService = countriesService;
	}
	
	@Test
	void testGetAllCountries() {
		assertNotNull(countriesService.getAllCountries());
	}
	
	@Test
	void testGetCountryById() {
		assertNotNull(countriesService.getCountry(52769));
	}
	
	@Test
	void testCountCountry() {
		assertNotNull(countriesService.getCustomerCountByCountry());
	}
	
}
