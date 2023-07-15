package com.cg.sales.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sales.entities.Product;
import com.cg.sales.exceptions.ProductNotFoundException;
import com.cg.sales.repositories.ProductRepository;
import com.cg.sales.services.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	private ProductService productService;
	private ProductRepository productRepository;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	/*
	 * POST Products
	 */
	@PostMapping(value="/products")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.saveProduct(product),HttpStatus.CREATED);
	}
	
	/*
	 * Get Products
	 */
	@GetMapping(value="/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> allProducts=productService.getAllProducts();
		return new ResponseEntity<List<Product>>(allProducts,HttpStatus.OK);
	}
	
	/*
	 * Get Mapping for getting Product by Id
	 */
	@GetMapping(value = "/products/{prodId}")
	public ResponseEntity<Product> getProduct(@RequestParam(value="prodId") Integer prodId) {
		if(productRepository.findById(prodId).isEmpty()) throw new ProductNotFoundException("Product Id: "+prodId+", is not available");
		else return ResponseEntity.ok(productService.getProduct(prodId));	
	}
	
	/*
	 * Delete Product By Id
	 */
	@DeleteMapping(value = "/products/{prodId}")
	public String deleteProduct(@RequestParam(value="prodId") Integer prodId){
		productService.deleteProduct(prodId);
		return "Product with Id:"+prodId+" Deleted Successfully!";		
	}
	
	/*
	 * Getting Products by Category
	 */
	@GetMapping(value="/products/{prodCategory}")
	public ResponseEntity<List<Product>> getProductByCategory(@RequestParam(value="prodCategory") String prodCategory){
		if(productService.searchAllProductsByCategory(prodCategory).isEmpty()) throw new ProductNotFoundException("Product Category is not present");
		else return ResponseEntity.ok(productService.searchAllProductsByCategory(prodCategory));
	}
	
	/*
	 * Getting Products by Status
	 */
	@GetMapping(value="/products/{prodStatus}")
	public ResponseEntity<List<Product>> getProductByStatus(@RequestParam(value="prodStatus") String prodStatus){
		if(productService.searchAllProductsByStatus(prodStatus).isEmpty()) throw new ProductNotFoundException("Poduct with Status:"+prodStatus+"is empty");
		else return ResponseEntity.ok(productService.searchAllProductsByStatus(prodStatus));
	}
	
	/*
	 * Getting Products by SubCategory
	 */
	@GetMapping(value="/products/{prodSubcategory}")
	public ResponseEntity<List<Product>> getProductBySubcategory(@RequestParam(value="prodSubcategory") String prodSubcategory){
		if(productService.searchAllProductsBySubcategory(prodSubcategory).isEmpty())throw new ProductNotFoundException("No data available");
		else return ResponseEntity.ok(productService.searchAllProductsBySubcategory(prodSubcategory));
	}
	
	/*
	 * Getting Products by SubCategory
	 */
	@GetMapping(value="/products/{supplierId}")
	public ResponseEntity<List<Product>> getProductBySupplierId(@RequestParam(value="supplierId") Integer supplierId){
		if(productService.searchAllProductsBySupplierId(supplierId).isEmpty()) throw new ProductNotFoundException("Please enter valid Supplier Id");
		else return ResponseEntity.ok(productService.searchAllProductsBySupplierId(supplierId));
	}
	
	/*
	 * Getting Duplicate Products
	 */
	@GetMapping(value="/products/duplicates")
	public List<Product> getDuplicateProducts(){
		return productService.searchAllDuplicateProducts();
	}
	
	/*
	 * Get List of Sold Products
	 */
	@GetMapping(value="/products/status/{prodId}")
	public ResponseEntity<List<Product>> getSoldProducts(@RequestParam(value="prodId") Integer prodId){
		if(productService.getStatusOfSoldProducts(prodId).isEmpty()) throw new ProductNotFoundException("Please Enter valid Product Id");
		else return ResponseEntity.ok(productService.getStatusOfSoldProducts(prodId));
	}
	
	
	/*
	 * Get List of Products Channel wise sold products
	 */
	@GetMapping(value="/products/channel")
	public ResponseEntity<List<Object[]>> getProductsByChannel(){
		return ResponseEntity.ok(productService.getProductsByChannel());
	}
	
	/*
	 * Get list of products order by query field
	 */
	@GetMapping(value="/products/sort/{field}")
	public ResponseEntity<List<Product>> getSortProductsByField(@PathVariable("field") String sortField){
		if(productRepository.findAll().isEmpty()) throw new ProductNotFoundException("Please enter valid Field String in the URL"); 
		Sort sort = Sort.by(sortField);
		return ResponseEntity.ok(productRepository.findAll(sort));
	}
	
}
