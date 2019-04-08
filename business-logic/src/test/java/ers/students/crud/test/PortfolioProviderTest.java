/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.test;

import ers.students.crud.provider.searching.PortfolioCrudProvider;
import ers.students.crud.utils.SuccessfulPersistenceStore;
import ers.students.portfolio.Portfolio;
import ers.students.util.Currency;

/**
 * Uses a successful portfolio object to test CRUD methods.
 *
 * @author Irina
 */
public class PortfolioProviderTest extends AbstractProviderTest {

    private final Portfolio portfolio = new Portfolio("1l", "name1", Currency.CHF);

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
}
