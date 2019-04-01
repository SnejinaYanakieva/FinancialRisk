/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.test;

import ers.students.crud.provider.searching.PortfolioCrudProvider;
import ers.students.crud.results.ErrorCode;
import ers.students.crud.results.LoadResult;
import ers.students.crud.results.LoadResults;
import ers.students.crud.utils.SuccessfulPersistenceStore;
import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Portfolio;
import ers.students.util.Currency;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;

/**
 *
 * @author Irina
 */
public class PortfolioProviderTest extends TestCase {

    private PortfolioCrudProvider crudProvider;
    private PersistentStore persistentStore;
    private Portfolio portfolio;

    public PortfolioProviderTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        persistentStore = new SuccessfulPersistenceStore();
        crudProvider = new PortfolioCrudProvider(persistentStore);
        portfolio = new Portfolio("1l", "name1", Currency.CHF);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        persistentStore = null;
        crudProvider = null;
        portfolio = null;
    }

    public void testSave() {
        Map<ErrorCode, List<String>> errors = crudProvider.create(portfolio);
        assertTrue("Cannot save.", errors.isEmpty());
    }

    public void testUpdate() {
        Map<ErrorCode, List<String>> errors = crudProvider.update(portfolio);
        assertTrue("Cannot update.", errors.isEmpty());
    }

    public void testLoadById() {
        LoadResult<Portfolio> result = crudProvider.loadById(portfolio.getId());
        assertTrue("Cannot load entity.", result.getErrors().isEmpty());
    }

    public void testDelete() {
        Map<ErrorCode, List<String>> errors = crudProvider.delete(portfolio.getId());
        assertTrue("Cannot delete.", errors.isEmpty());
    }

    public void testSearchByName() {
        LoadResults<Portfolio> results = crudProvider.searchByName(portfolio.getName());
        assertTrue("Cannot find entity.", results.getErrors().isEmpty());
    }
}
