package net.fajarachmad.security.service.impl;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.fajarachmad.security.dao.TenantDAO;
import net.fajarachmad.security.model.Registration;
import net.fajarachmad.security.model.Tenant;
import net.fajarachmad.security.service.TenantService;

@Service
public class TenantServiceImpl implements TenantService{
	
	private static Logger logger = LoggerFactory.getLogger(TenantServiceImpl.class);
	
	@Autowired
	private TenantDAO tenantDAO;
	
	@Value("${db.hostname}")
	private String dbHostname;
	
	@Value("${db.username}")
	private String dbUsername;
	
	@Value("${db.password}")
	private String dbPassword;
	
	@Override
	@Transactional
	public Tenant createTenant(@Valid Registration registration) {
		logger.debug("Creating new tenant, tenantName {}", new Object[]{ registration.getTenantName() });
		Tenant tenant = new Tenant();
		BeanUtils.copyProperties(registration, tenant);
		tenant.setCode(generateTenantCode());
		tenant.setName(registration.getTenantName());
		tenant.setDbHostname(dbHostname);
		tenant.setDbUsername(dbUsername);
		tenant.setDbPassword(dbPassword);
		tenantDAO.insert(tenant);
		
		buildTenantDatabase(tenant.getCode());
		
		return tenant;
	}
	
	private String generateTenantCode() {
		return "T000001";
	}
	
	private void buildTenantDatabase(String tenantCode){
		
		//Build Database
		
		//Populate data
		populateInitialData();
	}
	
	private void populateInitialData() {
		
	}

}
