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
@Table(name="PRODUCT")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6388843687250201824L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUCT")
	private Long idProduct;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PRICE")
	private Double price;
	
	@Column(name = "BAR_CODE")
	private String barCode;
	
	@ManyToMany(mappedBy="products")
	private Collection<Store> stores;
	
	public Product(){
		stores = new ArrayList<Store>();
	}
	
	public Collection<Store> getStores(){
		return stores;
	}
	
	public void addStore(Store store){
		if (!getStores().contains(store)) {
			getStores().add(store);
        }
		if (!store.getProducts().contains(this)) {
			store.getProducts().add(this);
        }
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public void setStores(Collection<Store> stores) {
		this.stores = stores;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
