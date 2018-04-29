package com.flocondria.fridge.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * JPA Entity for a.
 * <p>
 * Created by Lætitia.
 */
@Entity
@Table
public class Serving {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@Column
	private int amount;
	
	@Column
	private String unity;
	
	@OneToOne
	private Quantity quantity;
	
	public UUID getId() {
		return id;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getUnity() {
		return unity;
	}
	
	public void setUnity(String unity) {
		this.unity = unity;
	}
	
	public Quantity getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}
	
	public Serving(int amount, String unity, Quantity quantity) {
		this.amount = amount;
		this.unity = unity;
		this.quantity = quantity;
	}
	
	public Serving(int amount, String unity) {
		super();
		this.amount = amount;
		this.unity = unity;
	}
	
	public Serving() {
	}
	
	@Override
	public String toString() {
		return "Serving [id=" + id + ", amount=" + amount + ", unity=" + unity + ", quantity=" + quantity + "]";
	}
	
}
