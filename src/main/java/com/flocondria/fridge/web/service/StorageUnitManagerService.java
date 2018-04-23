package com.flocondria.fridge.web.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flocondria.fridge.domain.StorageUnit;
import com.flocondria.fridge.repository.HomeRepository;
import com.flocondria.fridge.repository.StorageUnitRepository;
import com.flocondria.fridge.web.request.StorageUnitRequest;

@Service
public class StorageUnitManagerService {
	private HomeRepository homeRepository;
	private StorageUnitRepository storageUnitRepository;
	private StorageUnit storageUnit;
	
	@Autowired
	public StorageUnitManagerService(HomeRepository homeRepository, StorageUnitRepository storageUnitRepository,
			StorageUnit storageUnit) {
		this.homeRepository = homeRepository;
		this.storageUnitRepository = storageUnitRepository;
		this.storageUnit = storageUnit;
	}
	
	public void createStorageUnit(StorageUnitRequest request ){
		 if(request.getHome() != null){
			 this.storageUnit.setName(request.getName());
			 this.storageUnit.setType(request.getType());
			 this.storageUnit.setHome(request.getHome());
		 }else {
			 throw new EntityNotFoundException();
		 }
		
	}
	
}
