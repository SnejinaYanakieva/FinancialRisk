/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.factory;

import javax.ws.rs.core.Response;
import ers.students.crud.results.LoadResult;
import ers.students.crud.results.ErrorCode;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * The class provides an instance that returns a HTTP response.
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
     * @return
     */
    public static Response make(LoadResult result) {

        ResponseBuilder builder = Response.noContent();

        result.getErrors().forEach((k, v) -> {

            switch ((ErrorCode) k) {
                case INTERNAL_ERROR:

                    builder.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(result.getErrors().get(ErrorCode.INTERNAL_ERROR));
                    break;

                case NO_SUCH_ELEMENT:

                    builder.status(Response.Status.NOT_FOUND)
                            .entity(result.getErrors().get(ErrorCode.NO_SUCH_ELEMENT));
                    break;

                case VALIDATION:

                    builder.status(Response.Status.BAD_REQUEST)
                            .entity(result.getErrors().get(ErrorCode.VALIDATION));
                    break;

                default:

                    builder.status(Response.Status.OK)
                            .entity(result.getEntity());
                    break;
            }
        });

        return builder.build();
    }
}
