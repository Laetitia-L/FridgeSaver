package com.flocondria.fridge.authentification.service;

import com.flocondria.fridge.authentification.domain.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);

}
