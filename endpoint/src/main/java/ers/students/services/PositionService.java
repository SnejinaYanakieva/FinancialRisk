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

public interface PositionService {
    
    @POST
    @Path("position/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("positionId") Long positionId);
    
    @PUT
    @Path("position/{positionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("positionId") Long positionId);
    
    @GET
    @Path("position/{positionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadByID(@PathParam("positionId") Long positionId);
    
    @DELETE
    @Path("position/{positionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("positionId") Long positionId);
    
    @GET
    @Path("position/{positionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadAll(@PathParam("positionId") Long positionId);
    
    @GET
    @Path("position/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchByName(@PathParam("name") String name);
}
