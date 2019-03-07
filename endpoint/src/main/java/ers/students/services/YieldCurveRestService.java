/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.services;

import ers.students.market.YieldCurve;

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

@Path("/yieldCurve")
public interface YieldCurveRestService {
    
    @POST
    Response create(YieldCurve yieldCurve);
    
    @PUT
    Response update(YieldCurve yieldCurve);
    
    @GET
    Response loadById(String id);
    
    @DELETE
    Response deleteById(String id);
    
    @GET
    Response loadAll();
    
    @GET
    Response searchByName(String name);

}
