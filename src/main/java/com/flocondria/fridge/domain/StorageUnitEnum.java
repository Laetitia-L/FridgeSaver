package com.flocondria.fridge.domain;

/**
 * Enumeration for the type of unit storage in a home.
 * <p>
 * Created by Lætitia.
 */
public enum StorageUnitEnum {
	FRIDGE("Fridge"),
	FREEZER("Freezer"),
	PANTRY("Pantry");
	
	private String StorageUnitType;
	
	StorageUnitEnum(String StorageUnitType) {
		this.StorageUnitType = StorageUnitType;
	}
	
	public String getStorageUnitType() {
		return this.StorageUnitType;
	}
}
