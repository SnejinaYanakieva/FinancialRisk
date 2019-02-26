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

public interface PortfolioService {
    
    @POST
    @Path("portfolio/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("portfolioId") Long portfolioId);
    
    @PUT
    @Path("portfolio/{portfolioId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("portfolioId") Long portfolioId);
    
    @GET
    @Path("portfolio/{portfolioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadByID(@PathParam("portfolioId") Long portfolioId);
    
    @DELETE
    @Path("portfolio/{portfolioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("portfolioId") Long portfolioId);
    
    @GET
    @Path("portfolio/{portfolioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadAll(@PathParam("portfolioId") Long portfolioId);
    
    @GET
    @Path("portfolio/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchByName(@PathParam("portfolioId") String name);
}
