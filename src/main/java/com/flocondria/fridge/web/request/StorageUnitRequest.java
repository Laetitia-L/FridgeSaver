package com.flocondria.fridge.web.request;

import java.util.ArrayList;
import java.util.List;

import com.flocondria.fridge.domain.Home;
import com.flocondria.fridge.domain.Product;

public class StorageUnitRequest {
	private String name;
	private String type;
	private List<Product> products = new ArrayList<Product>();
	private String homeName;
	
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
	
	public String getHomeName() {
		return homeName;
	}
	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}
	
	

}
