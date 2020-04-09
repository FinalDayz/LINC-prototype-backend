package nl.lugus.development.backend.resources;

import nl.lugus.development.backend.model.User;
import nl.lugus.development.backend.services.ProfileService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("profile")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed({"Admin"})
public class ProfileResource {

    private ProfileService service;

    @Inject
    public ProfileResource(ProfileService service) {
        this.service = service;
    }

    @GET
    @Path("/user/{id}")
    public Response getUserInfo(@PathParam("id") int id) {
        return Response.ok(service.getUserById(id)).build();
    }

    @PUT
    @Path("/user/{id}")
    public Response updateUserInfo(User user, @PathParam("id") int id) {
        service.updateUserById(id, user);
        return Response.ok().build();
    }
}
