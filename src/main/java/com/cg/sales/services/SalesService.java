package com.cg.sales.services;

import java.util.List;

import com.cg.sales.entities.Sale;

public interface SalesService {

	public List<Sale> getAllSales();
	public List<Integer> getById();
	public List<Sale> getSalesByQuater(int quarter);
	public List<Sale> getSalesByDate(int date);
}
