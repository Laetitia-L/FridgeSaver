package com.flocondria.fridge.web.request;

import java.util.ArrayList;
import java.util.List;

import com.flocondria.fridge.domain.Product;
import com.flocondria.fridge.domain.ProductCategory;
import com.flocondria.fridge.domain.Recipe;
import com.flocondria.fridge.domain.StorageUnit;

public class ProductManagerRequest {
	private String            name;
	private String            brand;
	private String            barcode;
	private float             amount;
	private String            unity;
	private ProductCategory   productCategory;
	private List<Recipe>      recipes      = new ArrayList<Recipe>();
	private List<StorageUnit> storageUnits = new ArrayList<StorageUnit>();
	private StorageUnit       storageUnit;
	private Product           product;
	
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
	
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	
	public List<Recipe> getRecipes() {
		return recipes;
	}
	
	public void setRecipes(Recipe recipe) {
		this.recipes.add(recipe);
	}
	
	public List<StorageUnit> getStorageUnits() {
		return storageUnits;
	}
	
	public void setStorageUnits(StorageUnit storageUnit) {
		this.storageUnits.add(storageUnit);
	}
	
	public StorageUnit getStorageUnit() {
		return storageUnit;
	}
	
	public void setStorageUnit(StorageUnit storageUnit) {
		this.storageUnit = storageUnit;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
