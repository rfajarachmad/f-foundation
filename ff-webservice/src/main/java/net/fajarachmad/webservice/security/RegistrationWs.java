package net.fajarachmad.webservice.security;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import net.fajarachmad.security.model.Registration;
import net.fajarachmad.security.service.RegistrationService;

@Path("/registration")
public class RegistrationWs {
	
	@Autowired
	private RegistrationService registrationService;
	
	@POST
	@Path("/register")
	public Response registerTenant(Registration model) {
		
		try {
			registrationService.save(model);
			return Response.status(200).entity("").build();
		} catch (Exception e) {
			return Response.status(500).entity("").build();
		}
		
	}
	
}
