/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.yieldcurve;

import ers.students.market.YieldCurve;
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

@Path("/yieldCurve")
@Consumes("application/json")
@Produces("application/json")
public interface YieldCurveRestService {
 
    /**
    * Sends information to the server
    * about Yield curve to create a resource
    *
    * @param yieldCurve
    * @return 
    */    
    @PUT
    @Path("/create")
    Response create(YieldCurve yieldCurve);
    
    /**
    * Replaces all current representations of the target
    * resource with the uploaded content.
    *
    * @param yieldCurve
    * @return 
    */    
    @POST
    @Path("/update")
    Response update(YieldCurve yieldCurve);
    
    /**
    * Retrieves information about a resource,
    * specified by ID, from the server.
    * 
    * @param id
    * @return 
    */    
    @GET
    @Path("/loadById/{id}")
    Response loadById(@PathParam("id") String id);
    
    /**
    * Removes all current representations of the target
    * resource, specified by ID.
    *
    * @param id
    * @return 
    */    
    @DELETE
    @Path("/deleteById/{id}")
    Response deleteById(@PathParam("id") String id);
    
    /**
    * Retrieves information about all
    * resources from the server using a given URI.
    *
    * @return 
    */    
    @GET
    @Path("/loadAll")
    Response loadAll();
}
