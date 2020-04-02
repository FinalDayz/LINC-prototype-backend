package nl.lugus.development.backend.resources;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("profile")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed({"Admin"})
public class ProfileResource {

//    @GET
//    @Path("/user/{id}")
//    @RolesAllowed({"Admin", "Medewerker", "Gebruiker"})
//    public User getUserInfo(@PathParam("id") int id) {
//        return profileService.getUsersById(id);
//    }
}
