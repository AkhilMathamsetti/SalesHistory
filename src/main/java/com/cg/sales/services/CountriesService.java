package com.cg.sales.services;

import java.util.List;
import java.util.Map;

import com.cg.sales.entities.Countries;

public interface CountriesService {

	public Countries saveCountries(Countries country);
	public List<Countries> getAllCountries();
	public Countries updateCountry(Integer countryId,Countries country);
	public Countries getCountry(Integer countryId);
	public void deleteCountry(Integer countryId);
	
	public Map<String, Integer> getCustomerCountByCountry();
}
