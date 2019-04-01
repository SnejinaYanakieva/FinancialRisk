/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.factory;

import javax.ws.rs.core.Response;
import ers.students.crud.results.LoadResult;
import ers.students.crud.results.ErrorCode;

/**
 * The class provides an instance that returns a HTTP response.
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
     * @param result
     * @return 
     */
    public static Response make(LoadResult result) {

        if (result.getErrors().keySet().contains(ErrorCode.INTERNAL_ERROR)) {

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(result.getErrors().get(ErrorCode.INTERNAL_ERROR))
                    .build();

        } else if (result.getErrors().keySet().contains(ErrorCode.NO_SUCH_ELEMENT)) {
            
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(result.getErrors().get(ErrorCode.NO_SUCH_ELEMENT))
                    .build();

        } else if (result.getErrors().keySet().contains(ErrorCode.VALIDATION)) {
            
            String message = "The request is not valid.";
            
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(result.getErrors().get(ErrorCode.VALIDATION))
                    .build();

        } else {
            return Response
                    .status(Response.Status.OK)
                    .entity(result.getEntity())
                    .build();
        }

    }

}
