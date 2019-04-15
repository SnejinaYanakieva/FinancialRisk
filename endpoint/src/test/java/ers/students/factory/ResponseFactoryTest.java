/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.factory;

import ers.students.crud.results.ErrorCode;
import ers.students.crud.results.LoadResult;
import ers.students.crud.results.LoadResults;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import junit.framework.TestCase;

/**
 *
 * @author martinstoynov
 */
public class ResponseFactoryTest extends TestCase {
    
    public ResponseFactoryTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getInstance method, of class ResponseFactory.
     */
    public void testGetInstance() {
        System.out.println("getInstance");
        ResponseFactory expResult = null;
        ResponseFactory result = ResponseFactory.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of make method, of class ResponseFactory.
     */
    public void testMake_Map_boolean() {
        System.out.println("make");
        Map<ErrorCode, List<String>> errors = null;
        boolean statusOk = false;
        Response expResult = null;
        Response result = ResponseFactory.make(errors, statusOk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of make method, of class ResponseFactory.
     */
    public void testMake_LoadResult() {
        System.out.println("make");
        LoadResult result_2 = null;
        Response expResult = null;
        Response result = ResponseFactory.make(result_2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of make method, of class ResponseFactory.
     */
    public void testMake_LoadResults() {
        System.out.println("make");
        LoadResults results = null;
        Response expResult = null;
        Response result = ResponseFactory.make(results);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
