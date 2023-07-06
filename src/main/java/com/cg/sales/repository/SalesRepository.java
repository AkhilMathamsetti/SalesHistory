package com.cg.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sales.entity.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {

}
