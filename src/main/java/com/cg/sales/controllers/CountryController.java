package com.cg.sales.controllers;

import java.util.List;
import java.util.Map;

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

import com.cg.sales.dto.CustomerCountRegion;
import com.cg.sales.entities.Countries;
import com.cg.sales.exceptions.CountryNotFoundException;
import com.cg.sales.repositories.CountriesRepository;
import com.cg.sales.services.CountriesService;

@RestController
@RequestMapping(value="/api/v1")
public class CountryController {

	private CountriesService countryService;
	private CountriesRepository countriesRepository;
	
	@Autowired
	public void setCountryService(CountriesService countryService) {
		this.countryService = countryService;
	}

	@Autowired
	public void setCountriesRepository(CountriesRepository countriesRepository) {
		this.countriesRepository = countriesRepository;
	}
	
	/*
	 * Getting All Countries
	 */
	@GetMapping(value="/countries")
	public ResponseEntity<List<Countries>> getAllCountries(){
		return ResponseEntity.ok(countryService.getAllCountries());
	}
	
	/*
	 * Post Country
	 */
	@PostMapping(value="/countries")
	@ResponseStatus(value=HttpStatus.OK,reason="Country record created successfully")
	public Countries saveCountry(@RequestBody Countries countries){
		return countryService.saveCountries(countries);
	}
	
	/*
	 * Put Mapping using Country Id
	 */
	@PutMapping(value="/countries/{countryId}")
	@ResponseStatus(value=HttpStatus.ACCEPTED,reason="Country details updated successfuly")
	public Countries updateCounty( @PathVariable Integer countryId,@RequestBody Countries countries){
		if(countryId == null)
			throw new CountryNotFoundException("Please enter valid country ID");
		return countryService.updateCountry(countryId, countries);
	}
	
	/*
	 * Delete Country
	 */
	@DeleteMapping(value="/countries/{countryId}")
	@ResponseStatus(value=HttpStatus.ACCEPTED, reason="Record deleted successfully")
	public void deleteCustomer(@RequestParam(value="countryId") Integer countryId){
		countryService.deleteCountry(countryId);
	}
	
	@GetMapping(value="/countries/count")
	public ResponseEntity<Map<String,Integer>> getCustomerCountByCountry(){
		if(countriesRepository.findAll().isEmpty())
			throw new CountryNotFoundException("Countries count is not available");
		return ResponseEntity.ok(countryService.getCustomerCountByCountry());
	}
	
	
	@GetMapping(value="/countries/{region}/customers")
	public List<CustomerCountRegion> getCustomersCountByRegion(@PathVariable(value="region") String region){
		List<Countries> allCountries = countriesRepository.findAll();
		
		for (Countries countries : allCountries) {
			if(countries.getCountryRegion().contains(region)) {
				return countriesRepository.getCustomersCountByRegion(region);
			}else {
				 throw new CountryNotFoundException("Country count is Unavailable with :"+region);
			}
		}
		return countriesRepository.getCustomersCountByRegion(region);
	}
	
}
