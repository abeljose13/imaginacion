package com.imaginamos.example.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imaginamos.example.domain.jpa.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
	
	Store findByIdStore(Long idStore);
}
