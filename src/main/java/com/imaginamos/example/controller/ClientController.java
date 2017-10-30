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

import com.imaginamos.example.domain.jpa.Client;
import com.imaginamos.example.service.ClientService;
import com.imaginamos.example.util.response.Response;

/**
 * 
 * @author agavide
 *
 */
@RestController
@RequestMapping(value = "/private/client")
public class ClientController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private ClientService clientService;
	
	/**
	 * 
	 * @param client
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, path = "", 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> create(@RequestBody Client client) {
		LOGGER.info("Creating a new client");
		
		if (clientService.findByMail(client.getMail()) != null) {
			Response response = new Response();
			response.setCode("EC002");
			response.setMessage("The email already exists");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		if (clientService.findByDocument(client.getDocument()) != null) {
			Response response = new Response();
			response.setCode("EC003");
			response.setMessage("The document already exists");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		
		client = clientService.addClient(client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param client
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, path = "", 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> update(@RequestBody Client client) {
		LOGGER.info("Updating a client");
		Response response;
		
		if (clientService.findByIdClient(client.getIdClient()) == null){
			response = new Response();
			response.setCode("EC001");
			response.setMessage("Client does not exist");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		client = clientService.updateClient(client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param idClient
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, path = "/idClient/{idClient}", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> delete(@PathVariable("idClient") Long idClient) {
		LOGGER.info("Deleting a client");
		
		Response response = new Response();
		if (clientService.findByIdClient(idClient) != null){
			clientService.deleteClient(idClient);
		} else {
			response.setCode("EC001");
			response.setMessage("Client does not exist");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		response.setCode(HttpStatus.OK.toString());
		response.setMessage("Successfully deleted customer");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param idClient
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/idClient/{idClient}", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getClienteById(@PathVariable("idClient") Long idClient) {
		LOGGER.info("Get client by idClient");
		Response response;
		
		Client client = clientService.findByIdClient(idClient);
		if (client == null){
			response = new Response();
			response.setCode("EL001");
			response.setMessage("Client does not exist");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/login/{login}/password/{password}", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> login(@PathVariable("login") String login,
			@PathVariable("password") String password) {
		LOGGER.info("Get client by login and password");
		Response response;
		
		if (login.isEmpty() || password.isEmpty()) {
			response = new Response();
			response.setCode("EC001");
			response.setMessage("Login and/or password are empty");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		
		Client client = clientService.login(login, password);
		
		if (client == null) {
			response = new Response();
			response.setCode("EL002");
			response.setMessage("Login incorrect");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
}
