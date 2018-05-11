package com.flocondria.fridge.web.controller;

import com.flocondria.fridge.web.request.ProductManagerRequest;
import com.flocondria.fridge.web.service.ProductManagerService;
import com.owlike.genson.Genson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/addProduct")
public class ProductController {
	
	
	@Autowired
	private ProductManagerService productManagerService;
	
	//Create product
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductManagerRequest request) {
		productManagerService.createProduct(request);
	}

	@RequestMapping(value = {"/data"}, method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_USER')")
	public @ResponseBody String welcome() {

		return new Genson().serialize(
				new String[]{"Course", "horse", "win"}
		);
	}
	
/*	//Update Product quantity when user 
	@RequestMapping(method = RequestMethod.PATCH)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateProduct(@RequestBody ProductManagerRequest request) {
		productManagerService.updateProductQuantity(request);
	}
	
	//Delete Product
	@RequestMapping(method= RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void removeProduct(@RequestBody Product product){
		
		System.out.println(product);
	}
	
	//Find Product by id
	@RequestMapping(method= RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void findProductbyId(@RequestBody Product product){
		
		System.out.println(product);
	}
	*/
	
}
