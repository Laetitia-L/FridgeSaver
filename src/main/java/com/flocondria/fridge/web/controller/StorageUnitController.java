package com.flocondria.fridge.web.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flocondria.fridge.web.request.StorageUnitRequest;
import com.flocondria.fridge.web.service.StorageUnitManagerService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.*;

@RestController
@RequestMapping(path="addStorageUnit")
public class StorageUnitController {
	
	
	@Autowired
	private StorageUnitManagerService StorageUnitManagerService;
	static Log log = LogFactory.getLog(StorageUnitController.class.getName());
	
	//Create a storage unit
	@RequestMapping(method= RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpStatus> createStorageUnit(@RequestBody StorageUnitRequest request) throws Exception{
		
		try{
			StorageUnitManagerService.createStorageUnit(request);
		}catch(EntityNotFoundException e){
			log.error("Entity not found when trying to create a storage unit");
			Logger logger = LoggerFactory.getLogger("storage_error");
			logger.info("OOps I could not create a storage unit");
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	
}
