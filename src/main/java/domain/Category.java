package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * JPA Entity for the Category of Recipe (lunch, snack, dinner, etc.).
 * <p>
 * Created by Lætitia.
 */
@Entity
@Table
public class Category {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	
	@ManyToMany
	private List<Recipe> recipes = new ArrayList<Recipe>();
	
	public Category(String name){
		this.name = name;
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

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Recipe recipe) {
		this.recipes.add(recipe);
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", recipes=" + recipes + "]";
	}
	
	

}
