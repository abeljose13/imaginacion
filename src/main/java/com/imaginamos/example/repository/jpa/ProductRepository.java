package com.imaginamos.example.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imaginamos.example.domain.jpa.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findByIdProduct(Long idProduct);
}
