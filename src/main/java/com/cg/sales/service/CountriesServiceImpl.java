package com.cg.sales.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sales.entity.Countries;
import com.cg.sales.entity.Customer;
import com.cg.sales.exception.CountryNotFoundException;
import com.cg.sales.repository.CountriesRepository;
import com.cg.sales.repository.CustomerRepository;

@Service
public class CountriesServiceImpl implements CountriesService {
	
	private CountriesRepository countriesRepository;
	private CustomerRepository customerRepository;
	
	@Autowired
	public void setCountriesRepository(CountriesRepository countriesRepository) {
		this.countriesRepository = countriesRepository;
	}
	
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Countries saveCountries(Countries country) {
		return countriesRepository.save(country);
	}

	@Override
	public List<Countries> getAllCountries() {
		return countriesRepository.findAll();
	}

	@Override
	public Countries updateCountry(Integer countryId,Countries country) {
		Countries existingCountry = getCountry(countryId);
		
		existingCountry.setCountryIsoCode(country.getCountryIsoCode());
		existingCountry.setCountryName(country.getCountryName());
		existingCountry.setCountryRegion(country.getCountryRegion());
		existingCountry.setCountryRegionId(country.getCountryRegionId());
		existingCountry.setCountrySubregion(country.getCountrySubregion());
		existingCountry.setCountrySubregionId(country.getCountrySubregionId());
		existingCountry.setCountryTotal(country.getCountryTotal());
		existingCountry.setCountryTotalId(country.getCountryTotalId());
		
		return countriesRepository.save(country);
	}

	@Override
	public Countries getCountry(Integer countryId) {
		return countriesRepository.findById(countryId).orElseThrow(()->new CountryNotFoundException("Country with ID: "+countryId+",not available"));
	}

	@Override
	public void deleteCountry(Integer countryId) {
		// TODO Auto-generated method stub
		Countries country=getCountry(countryId);
		countriesRepository.deleteById(country.getCountryId());
		
	}

	@Override
	public Map<String, Integer> getCustomerCountByCountry() {
		List<Object[]> result = customerRepository.getCustomerCountByCountry();
		Map<String, Integer> customerCountMap = new HashMap<>();
		for(Object[] row : result) {
			String countryName = (String) row[0];
			Long customerCount = (Long) row[1];
			customerCountMap.put(countryName,customerCount.intValue());
		}
		
		return customerCountMap;
	}
}
