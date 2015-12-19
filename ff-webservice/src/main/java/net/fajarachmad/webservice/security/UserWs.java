package net.fajarachmad.webservice.security;

import javax.naming.AuthenticationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.fajarachmad.security.model.User;
import net.fajarachmad.security.service.UserSevice;
import net.fajarachmad.webservice.common.ResponseUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Path("/user")
public class UserWs {
	
	private static Logger logger = LoggerFactory.getLogger(UserWs.class);
	
	@Autowired
	private UserSevice userSevice;
	
	@GET
	@Path("/find")
	public Response getUserById() {

		//User result = userSeviceImpl.findById("re");

		return Response.status(200).entity("").build();

	}
	
	@GET
	@Path("/authenticate/{username}/{password}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authenticate(@PathParam("username")String username,
			@PathParam("password")String password) {
		User user;
		try {
			logger.debug("Authenticate for user {}", new Object[]{ username });
			user = userSevice.authenticate(username, password);
			return ResponseUtil.createResponseSuccess(user);
		} catch (AuthenticationException e) {
			logger.info(e.getExplanation());
			return ResponseUtil.createResponseError(215, username, e.getExplanation());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResponseUtil.createResponseError(500, username, e.getMessage());
		}
		
	}

}
