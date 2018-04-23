package com.flocondria.fridge.web.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flocondria.fridge.web.request.ProductManagerRequest;
import com.flocondria.fridge.web.request.StorageUnitRequest;
import com.flocondria.fridge.web.service.ProductManagerService;


@RestController
@RequestMapping(path="addStorageUnit")
public class StorageUnitController {
	
	
	 @Autowired
	private StorageUnitService StorageUnitManagerService;
	
	//Create a storage unit
	@RequestMapping(method= RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity createStorageUnit(@RequestBody StorageUnitRequest request){
		
		try{
			StorageUnitManagerService.createStorageUnit(request);
		}catch(EntityNotFoundException e){
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
}
