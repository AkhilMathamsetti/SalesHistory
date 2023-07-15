package com.cg.sales;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sales.repositories.SalesRepository;
import com.cg.sales.services.SalesService;

@SpringBootTest
class SalesTests {

	@Autowired
	private SalesService salesService;
	private SalesRepository salesRepository;
	
	public void setSalesService(SalesService salesService) {
		this.salesService = salesService;
	}
	
	@Autowired
	public void setSalesRepository(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}
	
	@Test
	void getSales() {
		assertNotNull(salesService.getAllSales());
	}
	
	@Test
	void testGetSalesByDate() {
		assertNotNull(salesRepository.getSalesByDate(24));
	}
	
	@Test
	void testGetSalesByYear() {
		assertNotNull(salesRepository.getSalesByDate(2020));
	}
	
	@Test
	void testGetSalesByMonth() {
		assertNotNull(salesRepository.getSalesByQuater(2));
	}
	
}
