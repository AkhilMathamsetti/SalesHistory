package com.cg.sales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sales.dto.SalesQtysCategory;
import com.cg.sales.dto.SalesQtysCategoryYear;
import com.cg.sales.dto.SalesSoldCategory;
import com.cg.sales.dto.SalesSoldCategoryYear;
import com.cg.sales.entities.Sales;
import com.cg.sales.exceptions.SalesNotFoundException;
import com.cg.sales.repositories.SalesRepository;
import com.cg.sales.services.SalesService;

@RestController
@RequestMapping(value="/api/v1/sales")
public class SalesController {

	private SalesService salesService;
	private SalesRepository salesRepository;
	
	@Autowired
	public void setSalesService(SalesService salesService) {
		this.salesService = salesService;
	}
	
	@Autowired
	public void setSalesRepository(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}
	
	@GetMapping(value="")
	public ResponseEntity<List<Sales>> getAllSaleRecords(){
		List<Sales> allSales = salesService.getAllSales();
		return new ResponseEntity<List<Sales>>(allSales, HttpStatus.OK);
	}
	
	
	@GetMapping(value="/{quarter}")
	public ResponseEntity<List<Sales>> getSalesByQuarter(@RequestParam(value="quarter") int quarter){
		List<Sales> salesList = salesService.getSalesByQuater(quarter);
		if(salesList.isEmpty())
			throw new SalesNotFoundException("Sale with given quarter: "+quarter+",is not present");
		return ResponseEntity.ok(salesList);
	}
	
	@GetMapping(value="/{date}")
	public ResponseEntity<List<Sales>> getSalesByDate(@RequestParam(value="date") int date){
		List<Sales> salesList = salesService.getSalesByDate(date);
		if(salesList.isEmpty())
			throw new SalesNotFoundException("Sale with given date: "+date+",is unavailable");
		return ResponseEntity.ok(salesList);
	}
	
	@GetMapping(value="/qtys/categorywise")
	public List<SalesQtysCategory> getSalesQuantitesByCategory(){
		return salesRepository.getSalesQuantitesByCategory();
	}
	
	@GetMapping(value="/qtys/categorywise/{year}")
	public List<SalesQtysCategoryYear> getSalesQuantitesByCategoryYear(@PathVariable("year") int year){
		List<SalesQtysCategoryYear> salesList = salesRepository.getSalesQuantitiesByCategoryYear(year);
		if(salesList.isEmpty())
			throw new SalesNotFoundException("Sale with given quarter: "+year+",is not present");
		return salesRepository.getSalesQuantitiesByCategoryYear(year);
	}
	
	@GetMapping(value="/sold/categorywise")
	public List<SalesSoldCategory> getSalesSoldByCategory(){
		return salesRepository.getSalesSoldCategory();
	}
	
	@GetMapping(value="/sold/categorywise/{year}")
	public List<SalesSoldCategoryYear> getSalesSoldByCategoryYear(@PathVariable("year") int year){
		List<SalesSoldCategoryYear> salesList = salesRepository.getSalesSoldCategoryYear(year);
		if(salesList.isEmpty())
			throw new SalesNotFoundException("Sale with given quarter: "+year+",is not present");
		return salesRepository.getSalesSoldCategoryYear(year);
	}
	
}
