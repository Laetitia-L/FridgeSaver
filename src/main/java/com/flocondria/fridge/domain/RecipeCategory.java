package com.flocondria.fridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class RecipeCategory {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@Column
	private String name;
	
	@OneToMany
	private List<Recipe> recipes = new ArrayList<Recipe>();
	
	public UUID getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Recipe> getRecipes() {
		return recipes;
	}
	
	public void setRecipes(Recipe recipe) {
		this.recipes.add(recipe);
	}
	
	@Override
	public String toString() {
		return "RecipeCategory [id=" + id + ", name=" + name + ", recipes=" + recipes + "]";
	}
	
}
