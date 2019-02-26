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
//@Path("/fxquote")
public interface FxQuoteService {
    @POST
    @Path("fxquote/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("fxQuoteId") Long fxQuoteId);
    
    @PUT
    @Path("fxquote/{fxQuoteId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("fxQuoteId") Long fxQuoteId);
    
    @GET
    @Path("fxquote/{fxQuoteId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadByID(@PathParam("fxQuoteId") Long fxQuoteId);
    
    @DELETE
    @Path("fxquote/{fxQuoteId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("fxQuoteId") Long fxQuoteId);
    
    @GET
    @Path("fxquote/{fxQuoteId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadAll(@PathParam("fxQuoteId") Long fxQuoteId);
    
}
