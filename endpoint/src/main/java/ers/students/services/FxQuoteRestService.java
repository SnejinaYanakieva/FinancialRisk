/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ers.students.services;

import ers.students.market.FxQuote;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author martinstoynov
 */

@Path("/fxQuote")
@Consumes("application/json")
@Produces("application/json")
public interface FxQuoteRestService {
    
    /**
    * Sends information to the server
    * about FX quote to create resource.
    */
    @POST
    @Path("/create")
    Response create(FxQuote fxQuote);

    /**
    * Replaces all current representations of the target
    * resource with the uploaded content.
    */
    @PUT
    @Path("/update")
    Response update(FxQuote fxQuote);
    
    /**
    * Retrieves information about resources,
    * specified by ID, from the server.
    */
    @GET
    @Path("/loadById")
    Response loadById(String id);
    
    /**
    * Removes all current representations of the target
    * resource, specified by ID.
    */
    @DELETE
    @Path("/deleteById")
    Response deleteById(String id);
    
    /**
    * Retrieves information about all
    * resources from the server using a given URI.
    */
    @GET
    @Path("/loadAll")
    Response loadAll();

}
