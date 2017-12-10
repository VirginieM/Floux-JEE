package fr.cpe;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.UserModel;
import dto.UserAuth;

@Path("/WatcherAuth")
public interface IWatcherAuth {
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	UserModel doPost(UserAuth user);
}
