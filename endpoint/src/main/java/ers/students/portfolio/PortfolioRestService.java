/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;

import ers.students.portfolio.Portfolio;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author martinstoynov
 */

@Path("/portfolio")
@Consumes("application/json")
@Produces("application/json")
public interface PortfolioRestService {
    
    /**
    * Sends information to the server
    * about Portfolio to create a resource
    */
    @POST
    @Path("/create")
    Response create(Portfolio portfolio);
    
    /**
    * Replaces all current representations of the target
    * resource with the uploaded content.
    */
    @PUT
    @Path("/update")
    Response update(Portfolio portfolio);
    
    /**
    * Retrieves information about a resource,
    * specified by ID, from the server.
    */
    @GET
    @Path("/loadById/{id}")
    Response loadById(@PathParam("id") String id);
    
    /**
    * Removes all current representations of the target
    * resource, specified by ID.
    */
    @DELETE
    @Path("/deleteById/{id}")
    Response deleteById(@PathParam("id") String id);
    
    /**
    * Retrieves information about all
    * resources from the server using a given URI.
    */
    @GET
    @Path("/loadAll")
    Response loadAll();
    
    /**
    * Retrieves information about a resource,
    * specified by name, from the server.
    */
    @GET
    @Path("/searchByName/{name}")
    Response searchByName(@PathParam("name") String name);

}