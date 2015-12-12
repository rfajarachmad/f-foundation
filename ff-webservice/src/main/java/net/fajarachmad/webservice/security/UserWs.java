package net.fajarachmad.webservice.security;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import net.fajarachmad.security.model.User;
import net.fajarachmad.security.service.UserSevice;

import org.springframework.beans.factory.annotation.Autowired;


@Path("/user")
public class UserWs {
	
	@Autowired
	private UserSevice userSeviceImpl;
	
	@GET
	@Path("/find")
	public Response getUserById() {

		//User result = userSeviceImpl.findById("re");

		return Response.status(200).entity("").build();

	}

}
