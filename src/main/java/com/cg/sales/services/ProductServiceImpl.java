package com.cg.sales.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sales.entities.Product;
import com.cg.sales.exceptions.ProductNotFoundException;
import com.cg.sales.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProduct(Integer prodId) {
		return productRepository.findById(prodId).orElseThrow(()->new ProductNotFoundException("Product with ID: "+prodId+",not available "));
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Integer prodId, Product product) {
		Product existingProduct=getProduct(prodId);
		existingProduct = product;
		return productRepository.save(existingProduct);
	}

	@Override
	public void deleteProduct(Integer prodId) {
		Product product=getProduct(prodId);
		productRepository.deleteById(product.getProdId());
	}

	@Override
	public List<Product> searchAllProductsByCategory(String prodCategory) {
		return productRepository.findByProdCategory(prodCategory);
	}

	@Override
	public List<Product> searchAllProductsByStatus(String prodStatus) {
		return productRepository.findByProdStatus(prodStatus);
	}

	@Override
	public List<Product> searchAllProductsBySubcategory(String prodSubcategory) {
		return productRepository.findByProdSubcategory(prodSubcategory);
	}

	@Override
	public List<Product> searchAllProductsBySupplierId(Integer supplierId) {
		return productRepository.findBySupplierId(supplierId);
	}

	@Override
    public List<Product> searchAllDuplicateProducts() {
         List<Product> allProducts = productRepository.findAll();
            Map<String, Integer> productCountMap = new HashMap<>();
            List<Product> duplicateProducts = new ArrayList<>();

            for (Product product : allProducts) {
                String productName = product.getProdName();
                productCountMap.put(productName, productCountMap.getOrDefault(productName, 0) + 1);
            }

            for (Product product : allProducts) {
                String productName = product.getProdName();
                if (productCountMap.get(productName) > 1 && !duplicateProducts.contains(product)) {
                    duplicateProducts.add(product);
                }
            }

            return duplicateProducts;
    }

	@Override
	public List<Product> getStatusOfSoldProducts(Integer prodId) {
		return productRepository.findByProdId(prodId);
	}

	@Override
	public List<Object[]> getProductsByChannel() {
		return productRepository.getProductsByChannel();
	}

}
