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
//@Path("/yieldcurve")
public interface YieldCurveService {
    @POST
    @Path("portfolio/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(@PathParam("portfolioId") Long yieldCurveId);
    
    @PUT
    @Path("yieldcurve/{yieldCurveId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("yieldCurveId") Long yieldCurveId);
    
    @GET
    @Path("yieldcurve/{yieldCurveId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadByID(@PathParam("yieldCurveId") Long yieldCurveId);
    
    @DELETE
    @Path("yieldcurve/{yieldCurveId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("yieldCurveId") Long yieldCurveId);
    
    @GET
    @Path("yieldcurve/{yieldCurveId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadAll(@PathParam("yieldCurveId") Long yieldCurveId);
    
    @GET
    @Path("yieldcurve/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchByName(@PathParam("name") String name);
}
