/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.services;

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

public interface InstrumentService {
    
    @POST
    @Path("instrument/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("instrumentId") Long instrumentId);
    
    @PUT
    @Path("instrument/{instrumentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("instrumentId") Long instrumentId);
    
    @GET
    @Path("instrument/{portfolioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadByID(@PathParam("instrumentId") Long instrumentId);
    
    @DELETE
    @Path("instrument/{instrumentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("instrumentId") Long instrumentId);
    
    @GET
    @Path("instrument/{instrumentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadAll(@PathParam("instrumentId") Long instrumentId);
    
    @GET
    @Path("instrument/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchByName(@PathParam("name") String name);
}
