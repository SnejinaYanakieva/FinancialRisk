/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author martinstoynov
 */

public interface TransactionService {
    
    @POST
    @Path("transaction/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("transactionId") Long transactionId);
    
    @PUT
    @Path("transaction/{transactionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("transactionId") Long transactionId);
    
    @GET
    @Path("transaction/{transactionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadByID(@PathParam("transactionId") Long transactionId);
    
    @DELETE
    @Path("transaction/{transactionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("transactionId") Long transactionId);
    
    @GET
    @Path("transaction/{transactionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadAll(@PathParam("transactionId") Long transactionId);
    
    @GET
    @Path("transaction/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchByName(@PathParam("name") String name);
}
