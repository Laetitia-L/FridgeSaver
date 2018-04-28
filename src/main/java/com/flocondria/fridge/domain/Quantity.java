package com.flocondria.fridge.domain;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

/**
 * JPA Entity for the Quantity of one Product .
 * <p>
 * Created by Lætitia.
 */
@Entity
@Table
@Component
public class Quantity {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@OneToOne
	private Serving serving;
	
	@OneToOne (cascade = CascadeType.ALL)
	private Product product;
	
	/**
	 * For example a box of neapolitan cake have a weight of 125 g which contain 5 cake
	 * the unity is gramme (g) and amount 125 we can add optional portion 5.
	 */
	@Column
	private float amount;
	
	@Column	
	private String unity;
	
	@Column
	private int portion;
	
	public Quantity() {
	}
	
	public Quantity setId(UUID id) {
		this.id = id;
		return this;
	}
	
	public UUID getId() {
		return id;
	}


	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}


	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}
	

	public Serving getServing() {
		return serving;
	}


	public void setServing(Serving serving) {
		this.serving = serving;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getPortion() {
		return portion;
	}
	
	public Quantity setPortion(int portion) {
		this.portion = portion;
		return this;
	}
	
	@Override
	public String toString() {
		return "Quantity [id=" + id + ", product=" + product + ", amount=" + amount + ", unity=" + unity + "]";
	}

	
	
}
