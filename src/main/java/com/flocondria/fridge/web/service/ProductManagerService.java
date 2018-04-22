package com.flocondria.fridge.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flocondria.fridge.domain.Product;
import com.flocondria.fridge.domain.Quantity;
import com.flocondria.fridge.repository.ProductRepository;
import com.flocondria.fridge.repository.QuantityRepository;
import com.flocondria.fridge.repository.StorageUnitRepository;
import com.flocondria.fridge.web.request.ProductManagerRequest;

@Service
public class ProductManagerService {

	private ProductRepository productRepository;
	private StorageUnitRepository storageUnitRepository;
	private QuantityRepository quantityRepository;
	private Product product;
	private Quantity quantity;

	@Autowired
	public ProductManagerService( 
			ProductRepository productRepository,
			StorageUnitRepository storageUnitRepository,
			QuantityRepository quantityRepository,
			Product product, 
			Quantity quantity
	) {
		this.productRepository = productRepository;
		this.storageUnitRepository = storageUnitRepository;
		this.quantityRepository = quantityRepository;
		this.product = product;
		this.quantity = quantity;
	}

	public void updateProductQuantity(ProductManagerRequest request) {
		createProduct(request);
		this.quantity.setAmount(request.getAmount());
		product.setQuantity(this.quantity);
		this.quantityRepository.save(quantity);
	}
	
	public void createProduct(ProductManagerRequest request){
		this.product.setBrand(request.getBrand());
		this.product.setName(request.getName());
		this.product.setBarcode(request.getBarcode());
		
		this.quantity.setAmount(request.getAmount());
		this.quantity.setUnity(request.getUnity());
		this.product.setQuantity(quantity);
		this.quantity.setProduct(this.product);
		
		this.quantityRepository.save(quantity);
		this.productRepository.save(product);
	
	}

	public void addProductToStorage(ProductManagerRequest request){
		//adding a product to a specified storage unit ?
		if(request.getStorageUnit() !=  null && request.getProduct() != null){
			request.getStorageUnit().setProducts(request.getProduct());;
		}
	}
}
