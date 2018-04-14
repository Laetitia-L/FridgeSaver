package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * JPA Entity for a Frigde in a Home.
 * <p>
 * Created by Lætitia.
 */
@Entity
@Table
public class Fridge {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Location location;
	
	@Column
	private String name;
	
	public Fridge(String name){
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
		return "Fridge [id=" + id + ", location=" + location + ", name=" + name + "]";
	}
	
	
}
