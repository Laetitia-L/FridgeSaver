package com.flocondria.fridge.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



/**
 * JPA Entity for the Quantity of one Product .
 * <p>
 * Created by Lætitia.
 */
@Entity
@Table
public class Recipe {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private int prep_time;
	
	@Column
	private int cook_time;
	
	@ManyToMany
	private List<Product> products = new ArrayList<Product>();
	
	@ManyToMany
	private List<Category> categories = new ArrayList<Category>();
	
	public Recipe(){}
	
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(Category category) {
		this.categories.add(category);
	}
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrep_time() {
		return prep_time;
	}
	public void setPrep_time(int prep_time) {
		this.prep_time = prep_time;
	}
	public int getCook_time() {
		return cook_time;
	}
	public void setCook_time(int cook_time) {
		this.cook_time = cook_time;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(Product product) {
		this.products.add(product);
	}
	
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", prep_time=" + prep_time
				+ ", cook_time=" + cook_time + ", products=" + products + ", categories=" + categories + "]";
	}
	
	
}
