package com.cg.sales.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.sales.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByProdCategory(String prodCategory);
	List<Product> findByProdStatus(String prodStatus);
	List<Product> findByProdSubcategory(String prodSubcategory);
	List<Product> findBySupplierId(int supplierId);
	List<Product> findByProdId(int prodId);

	@Query("select ch.channelId, p.prodName,c.custFirstName AS CustomerName FROM Sales s JOIN Channel ch ON s.channel.channelId = ch.channelId JOIN Product p ON s.product.prodId = p.prodId JOIN Customer c ON s.customer.custId = c.custId ORDER BY ch.channelId")
	List<Object[]> getProductsByChannel();
	
	@Query("SELECT p FROM Product p ORDER BY :sortField DESC")
	public List<Product> getSortProductsByField(@Param("sortField") String field);
}
