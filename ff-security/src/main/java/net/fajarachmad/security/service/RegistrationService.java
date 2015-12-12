package net.fajarachmad.security.service;

import net.fajarachmad.security.model.Registration;
import net.fajarachmad.security.model.User;

public interface RegistrationService {
	
	public User registerTenant(Registration registration);
	
	public String save(Registration registration);
	
	
	
}
