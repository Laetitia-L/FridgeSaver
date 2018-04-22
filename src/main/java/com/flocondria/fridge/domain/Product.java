package com.flocondria.fridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * JPA Entity for a Product possibly available in Storage Location.
 * <p>
 * Created by Lætitia.
 */
@Entity
@Table
@Scope(value = "prototype")
@Component
public class Product {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@OneToOne (cascade = CascadeType.ALL)
	private Quantity quantity;
	
	@ManyToMany
	private List<Recipe> recipes = new ArrayList<Recipe>();
	
	@ManyToMany
	private List<StorageUnit> storageUnits = new ArrayList<StorageUnit>();
	
	@ManyToOne
	private ProductCategory productCategory;
		
	@Column
	private String name;
	
	@Column
	private String brand;
	
	@Column
	private String barcode;

	

	public UUID getId() {
		return id;
	}


	public Quantity getQuantity() {
		return quantity;
	}

	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Recipe recipe) {
		this.recipes.add(recipe);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public List<StorageUnit> getStorageUnit() {
		return storageUnits;
	}
	public void setStorageUnit(StorageUnit storageUnit) {
		this.storageUnits.add(storageUnit);
	}
	
	
	public ProductCategory getProductCategory() {
		return productCategory;
	}


	public void setProduct_cat(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}


	public Product() {
	}
	public Product(String barcode) {
		this.barcode = barcode;
	}

	public Product(String name, String brand) {
		this.name = name;
		this.brand = brand;
	}


	
	public Product(String name, String brand, String barcode) {
		this.name = name;
		this.brand = brand;
		this.barcode = barcode;
	}


	@Override
	public String toString() {
		return "Product [id=" + id +  ", quantity=" + quantity + ", name=" + name + ", brand="
				+ brand +  "Storage unit =" + storageUnits + ",category=" + productCategory +", barcode=" + barcode + "]";
	}
	
	
}
