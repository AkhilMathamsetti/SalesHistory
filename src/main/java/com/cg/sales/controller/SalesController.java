package com.cg.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sales.entity.Sales;
import com.cg.sales.service.SalesService;

@RestController
@RequestMapping(value="/api/v1/sales")
public class SalesController {

	private SalesService salesService;
	
	@Autowired
	public void setSalesService(SalesService salesService) {
		this.salesService = salesService;
	}
	
	@GetMapping(value="")
	public ResponseEntity<List<Sales>> getAllSaleRecords(){
		List<Sales> allSales = salesService.getAllSales();
		ResponseEntity<List<Sales>> re = new ResponseEntity<List<Sales>>(allSales, HttpStatus.OK);
		return re;
	}
}
