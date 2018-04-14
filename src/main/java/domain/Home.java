package domain;

import javax.persistence.*;



/**
 * JPA Entity for a Home which has several Storage Locations.
 * <p>
 * Created by Lætitia.
 */
@Entity
@Table(name = "HOME")
public class Home {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne
	private Location location;
	
	@Column
	private String name;

	public Home( String name) {
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
	
	@Override
	public String toString() {
		return "Home [id=" + id +"name =" +name+ ", location=" + location + "]";
	}
	
	
}
