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

import com.imaginamos.example.domain.jpa.Product;
import com.imaginamos.example.service.ProductService;
import com.imaginamos.example.util.response.Response;

@RestController
@RequestMapping(value = "/private/product")
public class ProductController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.POST, path = "", 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> create(@RequestBody Product product) {
		LOGGER.info("Creating a new product");
		
		product = productService.addProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "", 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> update(@RequestBody Product product) {
		LOGGER.info("Updating a product");
		Response response;
		
		if (productService.findByIdProduct(product.getIdProduct()) == null) {
			response = new Response();
			response.setCode("EP001");
			response.setMessage("Product does not exist");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		product = productService.updateProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/idProduct/{idProduct}", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> delete(@PathVariable("idProduct") Long idProduct) {
		LOGGER.info("deleting a product");
		
		Response response = new Response();
		if (productService.findByIdProduct(idProduct) != null) {
			productService.deleteProduct(idProduct);
		} else {
			response.setCode("EP001");
			response.setMessage("Product does not exist");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		response.setCode(HttpStatus.OK.toString());
		response.setMessage("Successfully deleted product");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/idProduct/{idProduct}", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getProductById(@PathVariable("idProduct") Long idProduct) {
		LOGGER.info("Get product by idProduct");
		Response response;
		
		Product product = productService.findByIdProduct(idProduct);
		if (product == null){
			response = new Response();
			response.setCode("EP001");
			response.setMessage("Product does not exist");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
}
