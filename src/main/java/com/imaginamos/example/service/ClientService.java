package com.imaginamos.example.service;

import java.util.List;

import com.imaginamos.example.domain.jpa.Client;

/**
 * 
 * @author agavide
 *
 */
public interface ClientService {
	
	/**
	 * 
	 * @param client
	 * @return
	 */
	public Client addClient(Client client);
	
	/**
	 * 
	 * @param client
	 * @return
	 */
	public Client updateClient(Client client);
	
	/**
	 * 
	 * @param idClient
	 */
	public void deleteClient(Long idClient);
	
	/**
	 * 
	 * @return
	 */
	public List<Client> findAll();
	
	/**
	 * 
	 * @param idClient
	 * @return
	 */
	public Client findByIdClient(Long idClient);
	
	/**
	 * 
	 * @param mail
	 * @return
	 */
	public Client findByMail(String mail);
	
	/**
	 * 
	 * @param document
	 * @return
	 */
	public Client findByDocument(String document);
	
	/**
	 * 
	 * @param login
	 * @param password
	 * @return
	 */
	public Client login(String login, String password);
}
