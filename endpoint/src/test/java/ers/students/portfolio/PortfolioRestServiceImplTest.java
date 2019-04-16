/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;

import ers.students.util.Currency;
import javax.ws.rs.core.Response;
import junit.framework.TestCase;

/**
 *
 * @author martinstoynov
 */
public class PortfolioRestServiceImplTest extends TestCase {

    private PortfolioRestService service;
    private Portfolio portfolio;
    
    public PortfolioRestServiceImplTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        service = new PortfolioRestServiceImpl(null);
        portfolio = new Portfolio("1", "Portfolio", Currency.BGN);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreate() {
        try {
            Response response = service.create(portfolio);
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    public void testUpdate() {
        try {
            Response response = service.update(portfolio);
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    public void testLoadById() {
        try {
            Response response = service.loadById("001");
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    public void testDeleteById() {
        try {
            Response response = service.deleteById("001");
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    public void testLoadAll() {
        try {
            Response response = service.loadAll();
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    public void testSearchByName() {
        try {
            Response response = service.searchByName("NAME");
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

}
