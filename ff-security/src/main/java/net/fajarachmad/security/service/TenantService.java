package net.fajarachmad.security.service;

import net.fajarachmad.security.model.Registration;
import net.fajarachmad.security.model.Tenant;

public interface TenantService {
	
	public Tenant createTenant(Registration registration);
}
