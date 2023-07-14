package com.cg.sales;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sales.services.ProductService;

@SpringBootTest
class ProductTest {

	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@Test
	void testGetAllProducts() {
		assertNotNull(productService.getAllProducts());
	}
	
	@Test
	void testGetProductByStatus() {
		assertNotNull(productService.searchAllProductsByStatus("STATUS"));
	}
	
	
}
