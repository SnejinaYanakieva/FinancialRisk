
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.factory;

import ers.students.crud.results.ErrorCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import junit.framework.TestCase;

/**
 *
 * @author martinstoynov
 */
public class ResponseFactoryTest extends TestCase {
    
    private Map<ErrorCode, List<String>> errors;
    private boolean statusOk = true;
    
    public ResponseFactoryTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        errors = new HashMap<>();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        errors.clear();
    }

    public void testCreated() {
        errors.clear();
        statusOk = false;
        Response result = ResponseFactory.make(errors, statusOk);
        assertEquals(201, result.getStatus());
    }
    
    public void testUpdatedOrDeleted() {
        errors.clear();
        Response result = ResponseFactory.make(errors, statusOk);
        assertEquals(200, result.getStatus());
    }
    
    public void testNotFound() {
        errors.clear();
        errors.put(ErrorCode.NO_SUCH_ELEMENT, Arrays.asList("No such element"));
        Response result = ResponseFactory.make(errors, statusOk);
        
        assertEquals(404, result.getStatus());
    }

    public void testInternalError() {
        errors.clear();
        errors.put(ErrorCode.INTERNAL_ERROR, Arrays.asList("Internal server error!"));
        Response result = ResponseFactory.make(errors, statusOk);
        
        assertEquals(500, result.getStatus());
    }
    
    public void testBadRequest() {
        errors.clear();
        errors.put(ErrorCode.VALIDATION, Arrays.asList("Bad request!"));
        Response result = ResponseFactory.make(errors, statusOk);
        
        assertEquals(400, result.getStatus());
    }
/*
    public void testEntity() {
        List<String> list = new ArrayList<>();
        errors.clear();
        
        list.add("No such element");
        errors.put(ErrorCode.NO_SUCH_ELEMENT, Arrays.asList("No such element"));
        
        statusOk = false;
        
        Response expResult = Response.status(Response.Status.NOT_FOUND).entity(list).build();
        
        Response result = ResponseFactory.make(errors, statusOk);
        
        assertEquals(expResult.readEntity(String.class),result.readEntity(String.class));
    }
*/
}
