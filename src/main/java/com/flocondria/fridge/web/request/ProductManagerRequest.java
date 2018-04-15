package com.flocondria.fridge.web.request;

public class ProductManagerRequest {
	private String name;
	private String brand;
	private String barcode;
	private float amount;
	private String unity;
	
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
	
}
