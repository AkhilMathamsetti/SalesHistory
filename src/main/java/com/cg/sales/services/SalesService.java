package com.cg.sales.services;

import java.util.List;

import com.cg.sales.entities.Sales;

public interface SalesService {

	public List<Sales> getAllSales();
	public List<Integer> getById();
	public List<Sales> getSalesByQuater(int quarter);
	public List<Sales> getSalesByDate(int date);
}
