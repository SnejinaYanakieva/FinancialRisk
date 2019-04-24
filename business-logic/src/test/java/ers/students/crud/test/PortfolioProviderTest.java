/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.test;

import ers.students.crud.provider.searching.PortfolioCrudProvider;
import ers.students.crud.results.LoadResult;
import ers.students.crud.results.LoadResults;
import ers.students.crud.utils.SuccessfulPersistenceStore;
import ers.students.crud.utils.SuccessfulPortfolioDao;
import ers.students.portfolio.Portfolio;
import ers.students.util.Currency;
import java.util.Map;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Uses a successful portfolio object to test CRUD methods.
 *
 * @author Irina
 */
public class PortfolioProviderTest extends AbstractProviderTest {

    private final Portfolio portfolio = SuccessfulPortfolioDao.portfolio;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        persistentStore = new SuccessfulPersistenceStore();
        crudProvider = new PortfolioCrudProvider(persistentStore);
        entity = portfolio;
        entityID = portfolio.getId();
        entityName = portfolio.getName();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Override
    protected void save(Map errors) {
        assertTrue("Cannot save.", errors.isEmpty());
    }

    @Override
    protected void update(Map errors) {
        assertEquals("Loaded erroneous portfolio. ", SuccessfulPortfolioDao.portfolio, entity);
        assertTrue("Cannot update.", errors.isEmpty());
    }

    @Override
    protected void update(LoadResult result) {
        assertEquals("Loaded erroneous portfolio. ", SuccessfulPortfolioDao.portfolio, entity);
        assertTrue("Cannot load entity.", result.getErrors().isEmpty());
    }

    @Override
    protected void delete(Map errors) {
        assertEquals("Loaded erroneous portfolio. ", SuccessfulPortfolioDao.portfolio, entity);
        assertTrue("Cannot delete.", errors.isEmpty());
    }

    @Override
    protected void loadAll(LoadResults results) {
        assertTrue("Cannot find entities.", results.getErrors().isEmpty());
    }

    @Override
    protected void searchByName(LoadResults results) {
        assertTrue("Cannot find entities.", results.getErrors().isEmpty());
    }
}
