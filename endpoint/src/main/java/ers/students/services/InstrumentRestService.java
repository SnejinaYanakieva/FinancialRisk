/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.services;

import ers.students.instruments.Instrument;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author martinstoynov
 */

// The Java class will be hosted at the URI path "/instruments"
@Path("/instruments")

//The @Consumes annotation is used to specify which MIME media types of
//representations a resource can accept, or consume, from the client.
@Consumes({"application/json"})

public interface InstrumentRestService {
    // The Java methods will process HTTP POST/GET/PUT/DELETE requests

    @POST
    @Path("/create")
    Response create(Instrument instrument);
    
    @PUT
    @Path("/update")
    Response update(Instrument instrument);
    
    @GET
    @Path("/load/{id}")
    Response loadById(@PathParam("id") String id);
    
    @DELETE
    @Path("/delete/{id}")
    Response deleteById(@PathParam("id") String id);
    
    @GET
    @Path("/load")
    Response loadAll();
    
    @GET
    @Path("/search/{isin}")
    Response searchByIsin(@PathParam("isin") String isin);
    
}
