package com.imaginamos.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imaginamos.example.domain.jpa.Store;
import com.imaginamos.example.service.StoreService;
import com.imaginamos.example.util.response.Response;

@RestController
@RequestMapping(value = "/private/store")
public class StoreController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping(method = RequestMethod.POST, path = "", 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> create(@RequestBody Store store) {
		LOGGER.info("Creating a new store");
		
		store = storeService.addStore(store);
		return new ResponseEntity<Store>(store, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "", 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> update(@RequestBody Store store) {
		LOGGER.info("Updating a store");
		Response response;
		
		if (storeService.findByIdStore(store.getIdStore()) == null) {
			response = new Response();
			response.setCode("ES001");
			response.setMessage("Store does not exist");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		store = storeService.updateStore(store);
		return new ResponseEntity<Store>(store, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/idStore/{idStore}", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> delete(@PathVariable("idStore") Long idStore) {
		LOGGER.info("deleting a store");
		
		Response response = new Response();
		if (storeService.findByIdStore(idStore) != null) {
			storeService.deleteStore(idStore);
		} else {
			response.setCode("ES001");
			response.setMessage("Store does not exist");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		response.setCode(HttpStatus.OK.toString());
		response.setMessage("Successfully deleted store");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/idStore/{idStore}", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getStoreById(@PathVariable("idStore") Long idStore) {
		LOGGER.info("Get store by idStore");
		Response response;
		
		Store store = storeService.findByIdStore(idStore);
		if (store == null){
			response = new Response();
			response.setCode("EP001");
			response.setMessage("Store does not exist");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return new ResponseEntity<Store>(store, HttpStatus.OK);
	}
}
