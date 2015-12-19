package net.fajarachmad.security.service;

import javax.naming.AuthenticationException;

import net.fajarachmad.security.model.Registration;
import net.fajarachmad.security.model.User;

public interface UserSevice {
	
	public User createUserRegistration(Registration registration);
	
	public User authenticate(String username, String password) throws AuthenticationException;
	
}
