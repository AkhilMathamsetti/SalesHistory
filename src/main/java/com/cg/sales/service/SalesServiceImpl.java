package com.cg.sales.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sales.DTO.SalesQtysCategory;
import com.cg.sales.DTO.SalesResponse;
import com.cg.sales.entity.Product;
import com.cg.sales.entity.Sales;
import com.cg.sales.repository.SalesRepository;

@Service
public class SalesServiceImpl implements SalesService {

	private SalesRepository salesRepository;
	
	@Autowired
	public void setSalesRepository(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}
	
	@Override
	public List<Sales> getAllSales() {
		return salesRepository.findAll();
	}
	
	@Override
	public List<Integer> getById() {
		return salesRepository.findAllList();
	}

	@Override
	public List<Sales> getSalesByQuater(int quarter) {
		return salesRepository.getSalesByQuater(quarter);
	}

	@Override
	public List<Sales> getSalesByDate(int date) {
		return salesRepository.getSalesByDate(date);
	}

//	@Override
//	public List<Object[]> getSalesQuantitiesByCategory() {
//		return salesRepository.getSalesQuantitesByCategory();
//	}

}
