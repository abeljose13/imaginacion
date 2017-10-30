package com.imaginamos.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginamos.example.domain.jpa.Client;
import com.imaginamos.example.repository.jpa.ClientRepository;

/**
 * 
 * @author agavide
 *
 */
@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	/*
	 * (non-Javadoc)
	 * @see com.imaginamos.example.service.ClientService#addClient(com.imaginamos.example.domain.jpa.Client)
	 */
	@Override
	public Client addClient(Client client) {
		client = clientRepository.save(client);
		return client;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.imaginamos.example.service.ClientService#updateClient(com.imaginamos.example.domain.jpa.Client)
	 */
	@Override
	public Client updateClient(Client client) {
		client = clientRepository.save(client);
		return client;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.imaginamos.example.service.ClientService#deleteClient(java.lang.Long)
	 */
	@Override
	public void deleteClient(Long idClient) {
		clientRepository.delete(idClient);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.imaginamos.example.service.ClientService#findAll()
	 */
	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.imaginamos.example.service.ClientService#findByIdClient(java.lang.Long)
	 */
	@Override
	public Client findByIdClient(Long idClient) {
		return clientRepository.findByIdClient(idClient);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.imaginamos.example.service.ClientService#findByMail(java.lang.String)
	 */
	@Override
	public Client findByMail(String mail) {
		return clientRepository.findByMail(mail);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.imaginamos.example.service.ClientService#findByDocument(java.lang.String)
	 */
	@Override
	public Client findByDocument(String document) {
		return clientRepository.findByDocument(document);
	}

	@Override
	public Client login(String login, String password) {
		return clientRepository.findByLoginAndPassword(login, password);
	}
	
}
