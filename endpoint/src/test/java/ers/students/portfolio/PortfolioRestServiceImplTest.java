/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;

import ers.students.persistentStore.PersistentStore;
import ers.students.registry.ProviderRegistry;
import ers.students.utils.ErroneousPortfolioDao;
import ers.students.utils.SuccessfulPersistenceStore;
import ers.students.utils.SuccessfulPortfolioDao;
import javax.ws.rs.core.Response;
import junit.framework.TestCase;

/**
 *
 * @author martinstoynov
 */
public class PortfolioRestServiceImplTest extends TestCase {

    private PortfolioRestServiceImpl service;
    private ProviderRegistry registry;
    private Response response;
    private PersistentStore persistentStore;
    
    private ErroneousPortfolioDao erroneousDao;
    private SuccessfulPortfolioDao successfulDao;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        persistentStore = new SuccessfulPersistenceStore();
        ProviderRegistry.createInstance(persistentStore);
        registry = ProviderRegistry.getInstance();
        service = new PortfolioRestServiceImpl(registry);
        
        successfulDao = new SuccessfulPortfolioDao(persistentStore);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreateSuccess() {
        response = service.create(SuccessfulPortfolioDao.portfolio);
        assertEquals(201,response.getStatus());
    }

    public void testUpdateSuccess() {
        response = service.update(SuccessfulPortfolioDao.portfolio);
        assertEquals(200,response.getStatus());
    }

    public void testLoadByIdSuccess() {
        response = service.loadById(SuccessfulPortfolioDao.portfolio.getId());
        assertEquals(200,response.getStatus());
    }

    public void testDeleteByIdSuccess() {
        response = service.deleteById(SuccessfulPortfolioDao.portfolio.getId());
        assertEquals(200,response.getStatus());
    }

    public void testLoadAllSuccess() {
        response = service.loadAll();
        assertEquals(200,response.getStatus());
    }

    public void testSearchByNameSuccess() {
        response = service.searchByName(SuccessfulPortfolioDao.portfolio.getName());
        assertEquals(200,response.getStatus());
    }
    
    public void testCreateError(){
        response = service.create(ErroneousPortfolioDao.portfolio);
        assertEquals(400,response.getStatus());
    }
    
    public void testUpdateError(){
        response = service.update(ErroneousPortfolioDao.portfolio);
        assertEquals(400,response.getStatus());
    }

    public void testLoadByIdError(){
        response = service.loadById(null);
        assertEquals(404,response.getStatus());
    }

    public void testDeleteByIdError(){
        response = service.deleteById(null);
        assertEquals(404,response.getStatus());
    }
}
