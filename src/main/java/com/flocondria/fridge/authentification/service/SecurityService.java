package com.flocondria.fridge.authentification.service;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);

}
