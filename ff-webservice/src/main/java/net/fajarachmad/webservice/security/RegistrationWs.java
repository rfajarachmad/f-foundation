package net.fajarachmad.webservice.security;

import java.util.Date;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.fajarachmad.security.model.Registration;
import net.fajarachmad.security.model.User;
import net.fajarachmad.security.service.RegistrationService;
import net.fajarachmad.webservice.common.ResponseUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/registration")
public class RegistrationWs {
	
	Logger logger = LoggerFactory.getLogger(RegistrationWs.class);
	
	private static String USER_GUID = "d7a435ee954046238242abdc6b04861f";
	
	@Autowired
	private RegistrationService registrationService;
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerTenant(Registration model) {
		
		try {
			
			model.setCreatedBy(USER_GUID);
			model.setCreationDate(new Date());
			model.setLastUpdatedBy(USER_GUID);
			model.setLastUpdateDate(new Date());
			
			User user = registrationService.registerTenant(model);
			return ResponseUtil.createResponseSuccess(user);
		} catch (ConstraintViolationException e) {
			logger.info(e.getMessage());
			return ResponseUtil.createResponseError(400, model, e.getConstraintViolations());
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResponseUtil.createResponseError(500, model, e.getMessage());
		}
		
	}
	
}
