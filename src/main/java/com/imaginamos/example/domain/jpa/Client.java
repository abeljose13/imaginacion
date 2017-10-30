package com.imaginamos.example.domain.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author agavide
 *
 */
@Entity
@Table(name="CLIENT")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 874799040087440512L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENT")
	private Long idClient;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "AGE")
	private Integer age;
	
	@Column(name = "DOCUMENT")
	private String document;
	
	@Column(name = "MAIL")
	private String mail;
	
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "PASSWRD")
	private String password;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
