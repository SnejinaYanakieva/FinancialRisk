
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
    private List<String> list;
    
    public ResponseFactoryTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        errors = new HashMap<>();
        list = new ArrayList<>();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of make method, of class ResponseFactory.
     */
    public void testMakeMapBoolean() {
        
        list.clear();
        errors.clear();
        
        list.add("No such element");
        errors.put(ErrorCode.NO_SUCH_ELEMENT, Arrays.asList("No such element"));
        
        boolean statusOk = false;

        Response expResult = Response.status(Response.Status.NOT_FOUND).entity(list).build();

        Response result = ResponseFactory.make(errors, statusOk);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), result.getStatus());
    }

}
