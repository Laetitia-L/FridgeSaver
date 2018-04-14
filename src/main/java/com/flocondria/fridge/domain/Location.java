package com.flocondria.fridge.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 * JPA Entity for a Storage Location available in a Home.
 * <p>
 * Created by Lætitia.
 */
@Entity
@Table(name = "LOCATION")
public class Location {
	
@Id
@GeneratedValue
private Integer id;

@OneToOne
private Home home;	

@OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private List<Product> products = new ArrayList<>();

@OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private List<Fridge> frigdes = new ArrayList<>();

@OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private List<Freezer> freezers = new ArrayList<>();

@OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private List<Pantry> pantries = new ArrayList<>();



public Location() {
}

public Integer getId() {
	return id;
}

public Home getHome() {
	return home;
}

public void setHome(Home home) {
	this.home = home;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(Product product) {
	this.products.add(product);
}

public List<Fridge> getFrigdes() {
	return frigdes;
}

public void setFrigdes(Fridge frigde) {
	this.frigdes.add(frigde);
}

public List<Freezer> getFreezers() {
	return freezers;
}

public void setFreezers(Freezer freezer) {
	this.freezers.add(freezer);
}

public List<Pantry> getPantries() {
	return pantries;
}

public void setPantries(Pantry pantry) {
	this.pantries.add(pantry);
}

@Override
public String toString() {
	return "Location [id=" + id +  ", home=" + home + ", products=" + products + ", frigdes="
			+ frigdes + ", freezers=" + freezers + ", pantries=" + pantries + "]";
}



}
