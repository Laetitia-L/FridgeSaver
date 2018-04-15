package com.flocondria.fridge.domain;

import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;



/**
 * JPA Entity for a Home which has several Storage Locations.
 * <p>
 * Created by Lætitia.
 */
@Entity
@Table(name = "HOME")
public class Home {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@Column
	private String name;

	public Home( String name) {
		this.name = name;
	}

	public UUID getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Home [id=" + id +"name =" +name+  "]";
	}
	
	
}
