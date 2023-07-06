package com.cg.sales.service;

import java.math.BigDecimal;
import java.util.List;

import com.cg.sales.DTO.SalesResponse;
import com.cg.sales.entity.Product;
import com.cg.sales.entity.Sales;

public interface SalesService {

	public List<Sales> getAllSales();
	public List<BigDecimal> getProductsByAmountSold();
}
