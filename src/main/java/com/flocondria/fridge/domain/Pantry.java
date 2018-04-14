package com.flocondria.fridge.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JPA Entity for a Pantry in a Home.
 * <p>
 * Created by Lætitia.
 */
@Entity
@Table
public class Pantry {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Location location;
	
	@Column
	private String name;
	
	public Pantry(String name){
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pantry [id=" + id + ", location=" + location + ", name=" + name + "]";
	}

}
