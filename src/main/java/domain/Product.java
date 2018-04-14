package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * JPA Entity for a Product possibly available in Storage Location.
 * <p>
 * Created by Lætitia.
 */
@Entity
@Table
public class Product {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Location location;
	
	@OneToOne
	private Quantity quantity;
	
	@ManyToMany
	private List<Recipe> recipes = new ArrayList<Recipe>();
		
	@Column
	private String name;
	
	@Column
	private String brand;
	
	@Column
	private String barcode;

	
	public Product() {
	}
	public Product(String barcode) {
		this.barcode = barcode;
	}

	public Product(String name, String brand) {
		this.name = name;
		this.brand = brand;
	}


	public Integer getId() {
		return id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", location=" + location + ", quantity=" + quantity + ", name=" + name + ", brand="
				+ brand + ", barcode=" + barcode + "]";
	}
	
	
}
