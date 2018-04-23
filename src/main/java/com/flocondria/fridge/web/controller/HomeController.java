package com.flocondria.fridge.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flocondria.fridge.web.request.HomeManagerRequest;
import com.flocondria.fridge.web.service.HomeManagerService;

@RestController
@RequestMapping(path="addHome")
public class HomeController {
	

	@Autowired
	private HomeManagerService homeManagerService;
	
	//Create a Home
	@RequestMapping(method= RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createHome(@RequestBody HomeManagerRequest request){
		
		homeManagerService.createHome(request);
	}

}
