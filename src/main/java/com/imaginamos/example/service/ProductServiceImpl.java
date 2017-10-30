package com.imaginamos.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginamos.example.domain.jpa.Product;
import com.imaginamos.example.repository.jpa.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {
		product = productRepository.save(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		product = productRepository.save(product);
		return product;
	}

	@Override
	public void deleteProduct(Long idProduct) {
		productRepository.delete(idProduct);
	}

	@Override
	public Product findByIdProduct(Long idProduct) {
		return productRepository.findByIdProduct(idProduct);
	}

}
