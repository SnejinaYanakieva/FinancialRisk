/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ers.students.services;

import ers.students.portfolio.Transaction;
import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author martinstoynov
 */

// The Java class will be hosted at the URI path "/transaction"
@Path("/transaction")
//The @Consumes annotation is used to specify which MIME media types of
//representations a resource can accept, or consume, from the client.
@Consumes({"application/json"})
public interface TransactionRestService {
    // The Java methods will process HTTP POST/GET/PUT/DELETE requests
    
    @POST
    Response create(Transaction transaction);
    
    @PUT
    Response update(Transaction transaction);
    
    @GET
    Response loadById(String id);
    
    @DELETE
    Response deleteById(String id);
    
    @GET
    Response loadAll();
    
    @GET
    Response searchByPositionId(String positionId);
    
}
