package net.fajarachmad.security.service.impl;

import javax.validation.Valid;

import net.fajarachmad.security.dao.RegistrationDAO;
import net.fajarachmad.security.model.Registration;
import net.fajarachmad.security.model.Tenant;
import net.fajarachmad.security.model.User;
import net.fajarachmad.security.service.RegistrationService;
import net.fajarachmad.security.service.TenantService;
import net.fajarachmad.security.service.UserSevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	private RegistrationDAO registrationDAO;
	
	@Autowired
	private UserSevice userService;
	
	@Autowired
	private TenantService tenantService;
	
	@Transactional
	@Override
	public User registerTenant(Registration registration) {
		//Step 1 Insert to Registration
		save(registration);
		//Step 2 Create Database
		Tenant tenant = tenantService.createTenant(registration);
		//Step 3 Create User Login
		registration.setTenantGUID(tenant.getTenantGUID());
		User user = userService.createUserRegistration(registration);
		
		return user;
		
	}
	
	@Transactional
	@Override
	public String save(@Valid Registration registration) {
		return registrationDAO.insert(registration);
	}

}
