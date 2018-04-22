package com.flocondria.fridge.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flocondria.fridge.domain.Home;
import com.flocondria.fridge.domain.StorageUnit;
import com.flocondria.fridge.repository.HomeRepository;
import com.flocondria.fridge.repository.StorageUnitRepository;
import com.flocondria.fridge.web.request.HomeManagerRequest;

@Service
public class HomeManagerService {
	private HomeRepository homeRepository;
	private StorageUnitRepository storageUnitRepository;
	private Home home;
	private StorageUnit storageUnit;
	
	@Autowired
	public HomeManagerService(HomeRepository homeRepository, 
			StorageUnitRepository storageUnitRepository, 
			Home home,
			StorageUnit storageUnit) {
		this.homeRepository = homeRepository;
		this.storageUnitRepository = storageUnitRepository;
		this.home = home;
		this.storageUnit = storageUnit;
	}
	
	public void createHome(HomeManagerRequest request){
		this.home.setName(request.getName());
	}
	

	

}
