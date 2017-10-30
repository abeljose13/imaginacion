package com.imaginamos.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginamos.example.domain.jpa.Store;
import com.imaginamos.example.repository.jpa.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Override
	public Store addStore(Store store) {
		store = storeRepository.save(store);
		return store;
	}

	@Override
	public Store updateStore(Store store) {
		store = storeRepository.save(store);
		return store;
	}

	@Override
	public void deleteStore(Long idStore) {
		storeRepository.delete(idStore);
	}

	@Override
	public Store findByIdStore(Long idStore) {
		return storeRepository.findByIdStore(idStore);
	}

}
