/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ers.students.transaction;

import ers.students.portfolio.Transaction;
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

@Path("/transaction")
@Consumes("application/json")
@Produces("application/json")
public interface TransactionRestService {
    
    /**
    * Sends information to the server
    * about Transaction to create a resource
    *
    * @param transaction
    * @return 
    */    
    @PUT
    @Path("/create")
    Response create(Transaction transaction);
    
    /**
    * Replaces all current representations of the target
    * resource with the uploaded content.
    *
    * @param transaction
    * @return 
    */    
    @POST
    @Path("/update")
    Response update(Transaction transaction);
    
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
    
    /**
    * Retrieves information about a resource,
    * specified by position ID, from the server.
    *
    * @param positionId
    * @return 
    */    
    @GET
    @Path("/searchByPositionId/{positionId}")
    Response searchByPositionId(@PathParam("positionId") String positionId);
    
}
