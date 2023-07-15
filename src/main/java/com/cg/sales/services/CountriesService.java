package com.cg.sales.services;

import java.util.List;
import java.util.Map;

import com.cg.sales.entities.Country;

public interface CountriesService {

	public Country saveCountries(Country country);
	public List<Country> getAllCountries();
	public Country updateCountry(Integer countryId,Country country);
	public Country getCountry(Integer countryId);
	public void deleteCountry(Integer countryId);
	public Map<String, Integer> getCustomerCountByCountry();
}
