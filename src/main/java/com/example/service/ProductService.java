package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		// fill this portion in
		return productRepository.findAll();
	}

	public Product findById(long id) {
		// fill this portion in
		return productRepository.findById(id);
	}

	public List<String> findDistinctBrands() {
		// fill this portion in
		return productRepository.findDistinctBrands();
	}

	public List<String> findDistinctCategories() {
		// fill this portion in
		return productRepository.findDistinctCategories();
	}

	public void save(Product product) {
		// fill this portion in
		productRepository.save(product);
	}

	public void deleteById(long id) {
		// fill this portion in
		productRepository.deleteById(id);
	}

	public List<Product> findByBrandAndOrCategory(String brand, String category) {
		return productRepository.findByBrandAndCategory(brand, category);
	}
}
