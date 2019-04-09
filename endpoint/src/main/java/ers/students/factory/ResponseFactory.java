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
     * Private constructor to prevent others from instantiating this class.
     */
    private ResponseFactory(){}

    /**
     * Provide a global point of access to the instance.
     * 
     * @return returns the only object available
     */
    public static ResponseFactory getInstance() {
        return instance;
    }

    
    /**
     * Returns a HTTP response based on the given results.
     *
     * @param errors contains an ErrorCode constant and a phrase mapped into it 
     * @param statusOk indicates whether a the status returns OK or not
     * @return a response containing HTTP status code and phrase
     */
    public static Response make(Map<ErrorCode,List<String>> errors, boolean statusOk) {
        
        ResponseBuilder builder = Response.status(Response.Status.CREATED);
        
        if(statusOk == true)
            builder = Response.status(Response.Status.OK);
        
        builder = buildResponse(builder, errors);
        
        return builder.build();
    }
    
    /**
     * Returns a HTTP response based on the given result.
     *
     * @param result contains a map of error codes and an entity
     * @return a response containing HTTP status code and an entity
     */
    public static Response make(LoadResult result) {

        ResponseBuilder builder = Response.status(Response.Status.OK).entity(result.getEntity());
        
        builder = buildResponse(builder, result.getErrors());

        return builder.build();
    }

    /**
     * Returns a HTTP response based on the given results.
     *
     * @param results contains a map of error codes and a list of entities
     * @return a response containing HTTP status code and a list of entities
     */
    public static Response make(LoadResults results) {

        ResponseBuilder builder = Response.status(Response.Status.OK).entity(results.getEntities());
        
        builder = buildResponse(builder, results.getErrors());

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
    private static ResponseBuilder buildResponse(ResponseBuilder builder, Map<ErrorCode, List<String>> errors) {
        
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
