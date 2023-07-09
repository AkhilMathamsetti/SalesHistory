package com.cg.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.sales.DTO.SalesQtysCategory;
import com.cg.sales.DTO.SalesQtysCategoryYear;
import com.cg.sales.DTO.SalesSoldCategory;
import com.cg.sales.DTO.SalesSoldCategoryYear;
import com.cg.sales.entity.Sales;


@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {

	@Query("SELECT s.salesId FROM Sales s")
	//@Query("SELECT s.salesId, p.prodId, c.channelId FROM Sales s JOIN Product p ON p.prodId = s.prodId JOIN Channel c ON c.channelId = s.channelId ORDER BY salesId")
	List<Integer> findAllList();
	
	@Query("SELECT s FROM Sales s JOIN Time t ON s.time.timeId = t.timeId WHERE t.calenderQuarterInt = :quarter")
	List<Sales> getSalesByQuater(@Param("quarter") int quarter);
	
	@Query("SELECT s FROM Sales s JOIN Time t ON s.time.timeId = t.timeId WHERE t.dayIntInMonth = :date")
	List<Sales> getSalesByDate(@Param("date") int date);
	
	@Query("SELECT new com.cg.sales.DTO.SalesQtysCategory(p.prodCategory, SUM(s.quantitySold) AS TotalQuantity) FROM Sales s JOIN Product p ON s.product.prodId = p.prodId WHERE p.prodId = s.product.prodId GROUP BY p.prodCategory")
	public List<SalesQtysCategory> getSalesQuantitesByCategory();
	
	@Query("SELECT new com.cg.sales.DTO.SalesQtysCategoryYear(p.prodCategory, SUM(s.quantitySold) AS TotalQuantity) FROM Sales s JOIN Product p ON s.product.prodId = p.prodId JOIN Time t ON s.time.timeId = t.timeId WHERE t.calendarYear = :year GROUP BY p.prodCategory")
	public List<SalesQtysCategoryYear> getSalesQuantitiesByCategoryYear(@Param("year") int year);
	
	@Query("SELECT new com.cg.sales.DTO.SalesSoldCategory(p.prodCategory, SUM(s.amountSold) AS TotalAmount) FROM Sales s JOIN Product p ON s.product.prodId = p.prodId GROUP BY p.prodCategory")
	public List<SalesSoldCategory> getSalesSoldCategory();
	
	@Query("SELECT new com.cg.sales.DTO.SalesSoldCategoryYear(p.prodCategory, SUM(s.amountSold) AS TotalAmount) FROM Sales s JOIN Product p ON s.product.prodId = p.prodId JOIN Time t ON s.time.timeId = t.timeId WHERE t.calendarYear = :year GROUP BY p.prodCategory")
	public List<SalesSoldCategoryYear> getSalesSoldCategoryYear(@Param("year") int year);
}
