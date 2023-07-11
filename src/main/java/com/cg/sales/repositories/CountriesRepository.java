package com.cg.sales.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.sales.dto.CustomerCountRegion;
import com.cg.sales.entities.Countries;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Integer> {
	
	@Query("SELECT new com.cg.sales.dto.CustomerCountRegion(co.countryRegion, COUNT(c.custId) AS CustomerCount) From Customer c JOIN Countries co ON c.country.countryId = co.countryId WHERE co.countryRegion = :countryRegion")
	List<CustomerCountRegion> getCustomersCountByRegion(@Param("countryRegion") String countryRegion);
}


