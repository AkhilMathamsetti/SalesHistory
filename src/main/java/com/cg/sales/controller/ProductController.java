package com.cg.sales.controller;


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

import com.cg.sales.entity.Product;
import com.cg.sales.exception.ProductNotFoundException;
import com.cg.sales.repository.ProductRepository;
import com.cg.sales.service.ProductService;

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
		Product savedProduct = productService.saveProduct(product);
		ResponseEntity<Product> re = new ResponseEntity<Product>(savedProduct,HttpStatus.CREATED);
		return re;
	}
	
	/*
	 * Get Products
	 */
	@GetMapping(value="/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> allProducts=productService.getAllProducts();
		ResponseEntity<List<Product>> re=new ResponseEntity<List<Product>>(allProducts,HttpStatus.OK);
		return re;
	}
	
	/*
	 * Get Mapping for getting Product by Id
	 */
	@GetMapping(value = "/products/{prodId}")
	public ResponseEntity<Product> getProduct(@RequestParam(value="prodId") Integer prodId) {
		Product product = productService.getProduct(prodId);
		ResponseEntity<Product> re=new ResponseEntity<Product>(product,HttpStatus.OK);
		return re;	
	}
	
	/*
	 * Delete Product By Id
	 */
	@DeleteMapping(value = "/products/{prodId}")
	public ResponseEntity<String> deleteProduct(@RequestParam(value="prodId") Integer prodId){
		productService.deleteProduct(prodId);
		ResponseEntity<String> re=new ResponseEntity<String>("Product with Id:"+prodId+" Deleted Successfully!",HttpStatus.OK);
		return re;		
	}
	
	/*
	 * Getting Products by Category
	 */
	@GetMapping(value="/products/{prodCategory}")
	public ResponseEntity<List<Product>> getProductByCategory(@RequestParam(value="prodCategory") String prodCategory){
		
		List<Product> products = productService.searchAllProductsByCategory(prodCategory);
		return ResponseEntity.ok(products);
	}
	
	/*
	 * Getting Products by Status
	 */
	@GetMapping(value="/products/{prodStatus}")
	public ResponseEntity<List<Product>> getProductByStatus(@RequestParam(value="prodStatus") String prodStatus){
		if(prodStatus != "STATUS") {
			throw new ProductNotFoundException("No data available for "+prodStatus);
		}
		
		List<Product> products = productService.searchAllProductsByStatus(prodStatus);
		return ResponseEntity.ok(products);
	}
	
	/*
	 * Getting Products by SubCategory
	 */
	@GetMapping(value="/products/{prodSubcategory}")
	public ResponseEntity<List<Product>> getProductBySubcategory(@RequestParam(value="prodSubcategory") String prodSubcategory){
		if(prodSubcategory ==  null) {
			throw new ProductNotFoundException("No data available");
		}
		List<Product> products = productService.searchAllProductsBySubcategory(prodSubcategory);
		return ResponseEntity.ok(products);
	}
	
	/*
	 * Getting Products by SubCategory
	 */
	@GetMapping(value="/products/{supplierId}")
	public ResponseEntity<List<Product>> getProductBySupplierId(@RequestParam(value="supplierId") Integer supplierId){
		if(supplierId ==  null) {
			throw new ProductNotFoundException("Please enter valid Supplier Id");
		}
		
		List<Product> products = productService.searchAllProductsBySupplierId(supplierId);
		return ResponseEntity.ok(products);
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
		if(prodId == null) {
			throw new ProductNotFoundException("Please Enter valid Product Id");
		}
		List<Product> products = productService.getStatusOfSoldProducts(prodId);
		return ResponseEntity.ok(products);
	}
	
	
	/*
	 * Get List of Products Channel wise sold products
	 */
	@GetMapping(value="/products/channel")
	public ResponseEntity<List<Object[]>> getProductsByChannel(){
		List<Object[]> products = productService.getProductsByChannel();
		return ResponseEntity.ok(products);
	}
	
	/*
	 * Get list of products order by query field
	 */
	@GetMapping(value="/products/sort/{field}")
	public ResponseEntity<List<Product>> getSortProductsByField(@PathVariable("field") String sortField){
		if(sortField == null) {
			throw new ProductNotFoundException("Please enter valid Field String in the URL"); 
		}
		Sort sort = Sort.by(sortField);
		List<Product> productsList = productRepository.findAll(sort);
		return ResponseEntity.ok(productsList);
	}
	
}
