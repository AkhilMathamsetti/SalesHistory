package com.cg.sales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sales.entities.Sale;
import com.cg.sales.repositories.SalesRepository;

@Service
public class SalesServiceImpl implements SalesService {

	private SalesRepository salesRepository;
	
	@Autowired
	public void setSalesRepository(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}
	
	@Override
	public List<Sale> getAllSales() {
		return salesRepository.findAll();
	}
	
	@Override
	public List<Integer> getById() {
		return salesRepository.findAllList();
	}

	@Override
	public List<Sale> getSalesByQuater(int quarter) {
		return salesRepository.getSalesByQuater(quarter);
	}

	@Override
	public List<Sale> getSalesByDate(int date) {
		return salesRepository.getSalesByDate(date);
	}

}
