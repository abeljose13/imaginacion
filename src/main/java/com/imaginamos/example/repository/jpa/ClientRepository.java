package com.imaginamos.example.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginamos.example.domain.jpa.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	Client findByIdClient(Long idClient);
	
	Client findByMail(String mail);
	
	Client findByDocument(String document);
	
	Client findByLoginAndPassword(String login, String password);
}
