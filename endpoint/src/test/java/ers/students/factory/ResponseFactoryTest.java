
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
    private boolean statusOk;
    private List<String> list;
    
    public ResponseFactoryTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        errors = new HashMap<>();
        list = new ArrayList<>();
        statusOk = true;
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        errors.clear();
        list.clear();
    }

    /**
     * Test for successful method create().
     */
    public void testCreated() {
        errors.clear();
        statusOk = false;
        Response result = ResponseFactory.make(errors, statusOk);
        assertEquals(201, result.getStatus());
    }
    
    /**
     * Test for successful methods update() and deleteById().
     */
    public void testOk() {
        errors.clear();
        Response result = ResponseFactory.make(errors, statusOk);
        assertEquals(200, result.getStatus());
    }
    
    /**
     * Test for status "404 Not found" 
     * on methods create(), update() and deleteById().
     */
    public void testNotFound() {
        errors.clear();
        errors.put(ErrorCode.NO_SUCH_ELEMENT, Arrays.asList("No such element"));
        Response result = ResponseFactory.make(errors, statusOk);
        
        assertEquals(404, result.getStatus());
    }
    
    /**
     * Test for status "500 Internal server error" 
     * on methods create(), update() and deleteById().
     */
    public void testInternalError() {
        errors.clear();
        errors.put(ErrorCode.INTERNAL_ERROR, Arrays.asList("Internal server error!"));
        Response result = ResponseFactory.make(errors, statusOk);
        
        assertEquals(500, result.getStatus());
    }
    
    /**
     * Test for status "400 Bad request" 
     * on methods create(), update() and deleteById().
     */
    public void testBadRequest() {
        errors.clear();
        errors.put(ErrorCode.VALIDATION, Arrays.asList("Bad request!"));
        Response result = ResponseFactory.make(errors, statusOk);
        
        assertEquals(400, result.getStatus());
    }

    /**
     * Test for entity of an error response
     * on methods create(), update() and deleteById().
     */
    public void testEntity() {
        list.clear();
        errors.clear();
        
        list.add("No such element");
        errors.put(ErrorCode.NO_SUCH_ELEMENT, Arrays.asList("No such element"));
        
        statusOk = false;
        
        Response expResult = Response.status(Response.Status.NOT_FOUND).entity(list).build();
        
        Response result = ResponseFactory.make(errors, statusOk);
        
        assertEquals(expResult.getEntity(),result.getEntity());
    }
        
    public void testLoadResult(){}
    
    public void testLoadResults(){}
    
}
