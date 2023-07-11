package com.cg.sales.services;

import java.util.List;

import com.cg.sales.entities.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	public Product getProduct(Integer prodId);
	public List<Product> getAllProducts();
	public Product updateProduct(Integer prodId,Product product);
	public void deleteProduct(Integer prodId);
	public List<Product> searchAllProductsByCategory(String prodCategory);
	public List<Product> searchAllProductsByStatus(String prodStatus);
	public List<Product> searchAllProductsBySubcategory(String prodSubcategory);
	public List<Product> searchAllProductsBySupplierId(Integer supplierId);
	
	public List<Product> searchAllDuplicateProducts();
	
	public List<Product> getStatusOfSoldProducts(Integer prodId);
	
	public List<Object[]> getProductsByChannel();
}
