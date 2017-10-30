package com.imaginamos.example.service;

import com.imaginamos.example.domain.jpa.Store;

public interface StoreService {
	
	public Store addStore(Store store);
	
	public Store updateStore(Store store);
	
	public void deleteStore(Long idStore);
	
	public Store findByIdStore(Long idStore);
}
