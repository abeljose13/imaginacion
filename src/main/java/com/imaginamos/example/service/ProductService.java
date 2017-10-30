package com.imaginamos.example.service;

import com.imaginamos.example.domain.jpa.Product;

public interface ProductService {
	
	public Product addProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public void deleteProduct(Long idProduct);
	
	public Product findByIdProduct(Long idProduct);
}
