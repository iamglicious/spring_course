package eu.fearierose.lessons.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import eu.fearierose.lessons.domain.Vereniging;
import eu.fearierose.lessons.persistence.VerenigingService;

/**
 * 
 * @author FaerieRose
 */
@Path("verenigingen")
@Component
public class VerenigingEndpoint {

	@Autowired
	private VerenigingService verenigingService;

	/**
	 * Creates a new vereniging
	 * @param vereniging the new Vereniging to be created
	 * @return Code 202 (accepted) with the new vereniging id
	 */	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postVereniging(Vereniging vereniging)  {
		Vereniging result = this.verenigingService.save(vereniging);
		return Response.accepted(result.getId()).build();
	}
	
	/**
	 * Gets an existing vereniging
	 * @param id the id of the Vereniging to be fetched
	 * @return Code 200 (ok) with the Vereniging or 204 (no content) if the vereniging does not exist
	 */	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getVerenigingById(@PathParam("id") Long id ) {
		Vereniging result = this.verenigingService.findById(id);
		if (result == null) {
			return Response.noContent().build();
		} else {
			return Response.ok(result).build();
		}
	}

	/**
	 * Gets all verenigingen in DB
	 * @return Code 200 (ok) with the Vereniging or 204 (no content) if there are no verenigingen in DB
	 */	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVerenigings() {
		Iterable<Vereniging> result = this.verenigingService.findAll();
		if (result == null) {
			return Response.noContent().build();
		} else {
			return Response.ok(result).build();
		}
	}
	
}
