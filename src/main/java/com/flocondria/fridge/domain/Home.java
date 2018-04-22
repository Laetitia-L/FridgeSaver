package com.flocondria.fridge.domain;

import java.util.ArrayList;
import java.util.List;
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
	
	@OneToMany(mappedBy = "home", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<StorageUnit> storageUnits = new ArrayList<StorageUnit>();
	

	public Home( String name) {
		this.name = name;
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

	public List<StorageUnit> getStorageUnits() {
		return storageUnits;
	}

	public void setStorageUnits(StorageUnit storageUnit) {
		this.storageUnits.add(storageUnit);
	}

	@Override
	public String toString() {
		return "Home [id=" + id + ", name=" + name + ", storageUnits=" + storageUnits + "]";
	}
	
	
}
