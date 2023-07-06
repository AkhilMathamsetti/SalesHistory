package com.cg.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
