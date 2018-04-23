package com.flocondria.fridge.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.flocondria.fridge.domain.StorageUnitEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageUnitControllerTest {
	
	private MockMvc mockMvc;
	
	@Before
    public void setup() {
		mockMvc = standaloneSetup(new StorageUnitController()).build();
    }
	
	//Case 1 : EntityNotFoundException is thrown
	@Test(expected = EntityNotFoundException.class)
	public void CreateStorageWithHomeNotFound() throws Exception{
		/*StorageUnitController storageUnitController =new StorageUnitController();
		StorageUnitRequest request = new StorageUnitRequest();
		request.setName("Storage_name");
		request.setType(StorageUnitEnum.FRIDGE.toString());
		storageUnitController.createStorageUnit(request);*/
		
		 this.mockMvc.perform(post("/addStorageUnit").param("name", "Storage_name") 
	                .param("type",StorageUnitEnum.FRIDGE.toString()));
	}
	
	
	//Case 2 : The storage unit is succesfully created

}
