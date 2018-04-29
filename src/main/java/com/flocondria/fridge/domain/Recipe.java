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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * JPA Entity for the Quantity of one Product .
 * <p>
 * Created by Lætitia.
 */
@Entity
@Table
public class Recipe {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private int prepTime;
	
	@Column
	private int cookTime;
	
	@ManyToMany(mappedBy = "recipes", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();
	
	@ManyToMany
	private List<RecipeCategory> recipeCategory = new ArrayList<RecipeCategory>();
	
	public Recipe() {
	}
	
	public List<RecipeCategory> getRecipeCategories() {
		return recipeCategory;
	}
	
	public void setRecipeCategories(RecipeCategory recipe_cat) {
		this.recipeCategory.add(recipe_cat);
	}
	
	public UUID getId() {
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
		return prepTime;
	}
	
	public void setPrep_time(int prep_time) {
		this.prepTime = prep_time;
	}
	
	public int getCook_time() {
		return cookTime;
	}
	
	public void setCook_time(int cook_time) {
		this.cookTime = cook_time;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(Product product) {
		this.products.add(product);
	}
	
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", prep_time=" + prepTime
			+ ", cook_time=" + cookTime + ", products=" + products + ", recipe_cat=" + recipeCategory + "]";
	}
	
}
