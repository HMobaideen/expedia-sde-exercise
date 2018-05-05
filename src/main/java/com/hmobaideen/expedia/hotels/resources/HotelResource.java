package com.hmobaideen.expedia.hotels.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.hmobaideen.expedia.hotels.business.HotelBusiness;

/**
 * <h1>HotelResource</h1>
 * 
 * Class to handle hotels REST API(s)
 * 
 * @author Haneen Mobaideen
 *
 */

@Path("/hotelsFinder")
public class HotelResource {

	/**
	 * REST API as POST request to get Hotels based on filter parameters
	 * 
	 * @param filterParams
	 *            as map of Key and multiple values pairs <br/>
	 *            key: filter parameter <br/>
	 *            values: filter parameter value
	 * 
	 * @return Response, set response entity with: <br/>
	 *         Success: JSON text of filtered hotels <br/>
	 *         Failure: server error code with message.
	 * 
	 */

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchHotels(MultivaluedMap<String, String> filterParams) {
		try {

			return Response.status(Response.Status.OK).entity(new HotelBusiness().getHotels(filterParams)).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().entity("Error: " + e.getMessage()).build();
		}
	}

}
