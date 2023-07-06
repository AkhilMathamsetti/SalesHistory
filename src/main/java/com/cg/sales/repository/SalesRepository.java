package com.cg.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.sales.DTO.SalesResponse;
import com.cg.sales.entity.Product;
import com.cg.sales.entity.Sales;
import java.math.BigDecimal;


@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {

	@Query("SELECT s.amountSold FROM Sales s")
	//@Query("SELECT s.salesId, p.prodId, c.channelId FROM Sales s JOIN Product p ON p.prodId = s.prodId JOIN Channel c ON c.channelId = s.channelId ORDER BY salesId")
	List<BigDecimal> findAllList();
}
