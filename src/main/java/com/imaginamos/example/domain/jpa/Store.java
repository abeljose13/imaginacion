package com.imaginamos.example.domain.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author agavide
 *
 */
@Entity
@Table(name="STORE")
public class Store implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1775018550909237168L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_STORE")
	private Long idStore;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "HORARY")
	private String horary;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@ManyToMany
	private Collection<Product> products;
	
	public Store(){
		products = new ArrayList<Product>();
	}
	
	public void addProduct(Product product){
		if (!getProducts().contains(product)) {
			getProducts().add(product);
	    }
		if (!product.getStores().contains(this)) {
			product.getStores().add(this);
	    }
	}
	
	public Collection<Product> getProducts(){
		return products;
	}

	public String getHorary() {
		return horary;
	}

	public void setHorary(String horary) {
		this.horary = horary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public Long getIdStore() {
		return idStore;
	}

	public void setIdStore(Long idStore) {
		this.idStore = idStore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
