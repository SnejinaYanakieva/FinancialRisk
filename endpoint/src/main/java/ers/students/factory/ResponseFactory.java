/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.factory;

import javax.ws.rs.core.Response;
import ers.students.crud.results.LoadResult;
import ers.students.crud.results.ErrorCode;
import ers.students.crud.results.LoadResults;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * The class provides an instance that returns a HTTP response message.
 *
 * @author martinstoynov
 */
public class ResponseFactory {

    /**
     * Creates an object of type ResponseFactory.
     */
    private static final ResponseFactory instance = new ResponseFactory();

    /**
     * Returns the only object available.
     *
     * @return
     */
    public static ResponseFactory getInstance() {
        return instance;
    }

    /**
     * Returns a HTTP response based on the given result.
     *
     * @param result
     * @param statusOK
     * @return
     */
    public static Response make(LoadResult result, boolean statusOK) {

        ResponseBuilder builder = Response.status(Response.Status.OK).entity(result.getEntity());
        
        if(statusOK == false)
            builder = Response.status(Response.Status.CREATED).entity(result.getEntity());
        
        builder = checkForErrors(builder, result.getErrors());

        return builder.build();
    }

    /**
     * Returns a HTTP response based on the given results.
     *
     * @param results
     * @param statusOK
     * @return
     */
    public static Response make(LoadResults results, boolean statusOK) {

        ResponseBuilder builder = Response.status(Response.Status.OK).entity(results.getEntities());
        
        if(statusOK == false)
            builder = Response.status(Response.Status.CREATED).entity(results.getEntities());
        
        builder = checkForErrors(builder, results.getErrors());

        return builder.build();
    }

    /**
     * The method iterates through a map containing error codes and sets
     * an error status, if present in the map.
     * 
     * @param builder
     * @param errors
     * @return 
     */
    private static ResponseBuilder checkForErrors(ResponseBuilder builder, Map<ErrorCode, List<String>> errors) {

        errors.forEach((k, v) -> {

            switch ((ErrorCode) k) {
                case INTERNAL_ERROR:
                    builder.status(Response.Status.INTERNAL_SERVER_ERROR).entity(v);
                    break;

                case NO_SUCH_ELEMENT:
                    builder.status(Response.Status.NOT_FOUND).entity(v);
                    break;

                case VALIDATION:
                    builder.status(Response.Status.BAD_REQUEST).entity(v);
                    break;
            }
        });
        return builder;
    }

}
