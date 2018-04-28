package com.flocondria.fridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * JPA Entity for Storage Unit containing Products.
 * <p>
 * Created by Lætitia.
 */

@Entity
@Component
@Table
@Scope(value = "prototype")
public class StorageUnit {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@Column
	private String name;
	
	@Column
	private String type;
	
	@ManyToMany(mappedBy = "storageUnits", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();
	
	@ManyToOne
	private Home home;
	
	public UUID getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(Product product) {
		this.products.add(product);
	}
	
	public Home getHome() {
		return home;
	}
	
	public void setHome(Home home) {
		this.home = home;
	}
	
	public StorageUnit() {
	}
	
	public StorageUnit(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "StorageUnit [id=" + id + ", name=" + name + ", type=" + type + ", products=" + products + ", home="
			+ home + "]";
	}
	
}
