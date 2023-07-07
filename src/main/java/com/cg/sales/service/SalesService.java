package com.cg.sales.service;

import java.math.BigDecimal;
import java.util.List;

import com.cg.sales.DTO.SalesQtysCategory;
import com.cg.sales.DTO.SalesResponse;
import com.cg.sales.entity.Product;
import com.cg.sales.entity.Sales;

public interface SalesService {

	public List<Sales> getAllSales();
	public List<Integer> getById();
	
	public List<Sales> getSalesByQuater(int quarter);
	
	public List<Sales> getSalesByDate(int date);
	
	//public List<Object[]> getSalesQuantitiesByCategory();
}
