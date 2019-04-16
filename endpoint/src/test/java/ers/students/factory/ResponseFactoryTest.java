
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.factory;

import ers.students.crud.results.ErrorCode;
import ers.students.crud.results.LoadResult;
import ers.students.crud.results.LoadResults;
import ers.students.portfolio.Portfolio;
import ers.students.util.Currency;
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
    private Portfolio portfolio;
    private LoadResult result;
    private List<Portfolio> entities;
    private LoadResults results;
    
    public ResponseFactoryTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        errors = new HashMap<>();
        list = new ArrayList<>();
        statusOk = true;
        
        portfolio = new Portfolio("001","Portfolio1",Currency.BGN);
        result = new LoadResult();
        result.addAllErrors(errors);
        result.setEntity(portfolio);
        
        entities = new ArrayList<>();
        entities.add(new Portfolio("001","Portfolio1",Currency.BGN));
        entities.add(new Portfolio("002","Portfolio2",Currency.AUD));
        entities.add(new Portfolio("003","Portfolio3",Currency.CHF));
        entities.add(new Portfolio("004","Portfolio4",Currency.GBP));
        entities.add(new Portfolio("005","Portfolio5",Currency.USD));
        results = new LoadResults();
        results.addAllErrors(errors);
        results.addAllEntities(entities);
    }
    
    @Override
    protected void tearDown() throws Exception {
        
        super.tearDown();
        
        errors.clear();
        list.clear();
    }

    public void testCreated() {
        
        errors.clear();
        statusOk = false;
        
        Response response = ResponseFactory.make(errors, statusOk);
        
        assertEquals(201, response.getStatus());
    }
    
    public void testOk() {
        
        errors.clear();
        
        Response response = ResponseFactory.make(errors, statusOk);
        
        assertEquals(200, response.getStatus());
    }
    
    public void testNotFound() {
        
        errors.clear();
        errors.put(ErrorCode.NO_SUCH_ELEMENT, Arrays.asList("No such element"));
        
        Response response = ResponseFactory.make(errors, statusOk);
        
        assertEquals(404, response.getStatus());
    }
    
    public void testInternalError() {
        
        errors.clear();
        errors.put(ErrorCode.INTERNAL_ERROR, Arrays.asList("Internal server error!"));
        
        Response response = ResponseFactory.make(errors, statusOk);
        
        assertEquals(500, response.getStatus());
    }
    
    public void testBadRequest() {
        
        errors.clear();
        errors.put(ErrorCode.VALIDATION, Arrays.asList("Bad request!"));
        
        Response response = ResponseFactory.make(errors, statusOk);
        
        assertEquals(400, response.getStatus());
    }

    public void testEntity() {
        list.clear();
        errors.clear();
        
        list.add("No such element");
        errors.put(ErrorCode.NO_SUCH_ELEMENT, Arrays.asList("No such element"));
        
        statusOk = false;
        
        Response expResponse = Response.status(Response.Status.NOT_FOUND).entity(list).build();
        
        Response response = ResponseFactory.make(errors, statusOk);
        
        assertEquals(expResponse.getEntity(),response.getEntity());
    }
    
    public void testLoadResult(){
        
        errors.clear();
        
        Response expResponse = Response.status(Response.Status.OK).entity(portfolio).build();
        Response response = ResponseFactory.make(result);
        
        assertEquals(expResponse.getEntity(),response.getEntity());

    }
    
    public void testLoadResults() {
        
        errors.clear();
        
        Response expResponse = Response.status(Response.Status.OK).entity(entities).build();
        Response response = ResponseFactory.make(results);
        
        assertEquals(expResponse.getEntity(),response.getEntity());

    }
}
