package com.flocondria.fridge;

import com.flocondria.fridge.auth.model.Role;
import com.flocondria.fridge.auth.model.RoleName;
import com.flocondria.fridge.domain.Product;
import com.flocondria.fridge.repository.ProductRepository;
import com.flocondria.fridge.auth.repository.RoleRepository;
import com.flocondria.fridge.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FridgeSaverApplication implements CommandLineRunner {
	@Autowired
	ProductRepository productRepository;

	@Autowired
    UserRepository userRepository;

	@Autowired
    RoleRepository roleRepository;
	
	public static void main(String[] args){
		SpringApplication.run(FridgeSaverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		productRepository.save(new Product("Pain d'épices", "Bjorg", "3229820004341"));
		productRepository.save(new Product("Riz basmati", "Taureau ailé"));
		productRepository.save(new Product("Chocolat 85%", "Lindt"));

//		User userJohn = new User("john.doe", "jj@d.com","password", "password");
//		User userLele = new User("lele", "ll@d.com","password", "password");
//
		Role roleAdmin = new Role(RoleName.ROLE_ADMIN);
		Role roleUser  = new Role(RoleName.ROLE_USER);
//
//		roleAdmin.setUsers(userJohn);
//		roleUser.setUsers(userJohn);
//		roleUser.setUsers(userLele);
//
//		userJohn.setRoles(roleAdmin);
//		userJohn.setRoles(roleUser);
//		userLele.setRoles(roleUser);
//
//		userRepository.save(userJohn);
//		userRepository.save(userLele);
//
		roleRepository.save(roleAdmin);
		roleRepository.save(roleUser);
	}
}
