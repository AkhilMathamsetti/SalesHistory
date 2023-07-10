package com.cg.sales;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sales.repository.SalesRepository;
import com.cg.sales.service.SalesService;

@SpringBootTest
public class SalesTests {

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
	public void getSales() {
		assertNotNull(salesService.getAllSales());
	}
	
	@Test
	public void testGetSalesByDate() {
		assertNotNull(salesRepository.getSalesByDate(24));
	}
	
	@Test
	public void testGetSalesByYear() {
		assertNotNull(salesRepository.getSalesByDate(2020));
	}
	
}
