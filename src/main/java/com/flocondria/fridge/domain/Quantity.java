package com.flocondria.fridge.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * JPA Entity for the Quantity of one Product .
 * <p>
 * Created by Lætitia.
 */
@Entity
@Table
public class Quantity {
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne
	private Product product;
	
	@Column
	private float amount;
	
	@Column
	private float number;
	
	@Column	
	private String unity;

	
	
	public Quantity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getNumber() {
		return number;
	}

	public void setNumber(float number) {
		this.number = number;
	}

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}

	@Override
	public String toString() {
		return "Quantity [id=" + id + ", product=" + product + ", amount=" + amount + ", number=" + number + ", unity="
				+ unity + "]";
	}
	
	
}
