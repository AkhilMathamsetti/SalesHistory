package com.cg.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.sales.DTO.SalesQtysCategory;
import com.cg.sales.entity.Sales;


@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {

	@Query("SELECT s.salesId FROM Sales s")
	//@Query("SELECT s.salesId, p.prodId, c.channelId FROM Sales s JOIN Product p ON p.prodId = s.prodId JOIN Channel c ON c.channelId = s.channelId ORDER BY salesId")
	List<Integer> findAllList();
	
	@Query("SELECT s FROM Sales s JOIN Time t ON s.time.timeId = t.timeId WHERE t.calendarMonthInt = :quarter")
	List<Sales> getSalesByQuater(@Param("quarter") int quarter);
	
	@Query("SELECT s FROM Sales s JOIN Time t ON s.time.timeId = t.timeId WHERE t.dayIntInMonth = :date")
	List<Sales> getSalesByDate(@Param("date") int date);
	
	@Query("SELECT new com.cg.sales.DTO.SalesQtysCategory(p.prodCategory, SUM(s.quantitySold) AS TotalQuantity) FROM Sales s JOIN Product p ON s.product.prodId = p.prodId WHERE p.prodId = s.product.prodId GROUP BY p.prodCategory")
	public List<SalesQtysCategory> getSalesQuantitesByCategory();
}
