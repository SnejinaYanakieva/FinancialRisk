/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.test;

import ers.students.crud.provider.searching.SearchingCrudProvider;
import ers.students.crud.results.ErrorCode;
import ers.students.crud.results.LoadResult;
import ers.students.crud.results.LoadResults;
import ers.students.crud.utils.SuccessfulPortfolioDao;
import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Portfolio;
import ers.students.portfolio.Position;
import ers.students.validate.Validatable;
import java.util.List;
import java.util.Map;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

/**
 * Test the Abstract CRUD provider methods.
 *
 * @author Irina
 * @param <E>
 */
public abstract class AbstractProviderTest<E extends Validatable> extends TestCase {

    protected SearchingCrudProvider crudProvider;
    protected PersistentStore persistentStore;
    protected E entity;
    protected String entityID;
    protected String entityName;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        persistentStore = null;
        crudProvider = null;
        entity = null;
        entityID = null;
    }

    public void testSave() {
        Map<ErrorCode, List<String>> errors = crudProvider.create(entity);
        if (CheckIfEntityIsPortfolio()) {
            assertTrue("Cannot save.", errors.isEmpty());
        } else if (CheckIfEntityIsPosition()) {
            assertFalse("Entity saved.", errors.isEmpty());
        }
    }

    public void testUpdate() {
        Map<ErrorCode, List<String>> errors = crudProvider.update(entity);
        if (CheckIfEntityIsPortfolio()) {
            assertEquals("Loaded erroneous portfolio. ", SuccessfulPortfolioDao.portfolio, entity);
            assertTrue("Cannot update.", errors.isEmpty());
        } else if (CheckIfEntityIsPosition()) {
            assertFalse("Entity updated.", errors.isEmpty());
        }
    }

    public void testLoadById() {
        LoadResult<Portfolio> result = crudProvider.loadById(entityID);
        if (CheckIfEntityIsPortfolio()) {
            assertEquals("Loaded erroneous portfolio. ", SuccessfulPortfolioDao.portfolio, entity);
            assertTrue("Cannot load entity.", result.getErrors().isEmpty());
        } else if (CheckIfEntityIsPosition()) {
            assertFalse("Entity loaded.", result.getErrors().isEmpty());
        }
    }

    public void testDelete() {
        Map<ErrorCode, List<String>> errors = crudProvider.delete(entityID);
        if (CheckIfEntityIsPortfolio()) {
            assertEquals("Loaded erroneous portfolio. ", SuccessfulPortfolioDao.portfolio, entity);
            assertTrue("Cannot delete.", errors.isEmpty());
        } else if (CheckIfEntityIsPosition()) {
            assertFalse("Entity deleted.", errors.isEmpty());
        }
    }

    public void testLoadAll() {
        LoadResults<E> results = crudProvider.loadAll();
        if (CheckIfEntityIsPortfolio()) {
            assertTrue("Cannot find entities.", results.getErrors().isEmpty());
        } else if (CheckIfEntityIsPosition()) {
            assertFalse("Entities found.", results.getErrors().isEmpty());
        }
    }

    public void testSearchByName() {
        LoadResults<Portfolio> results = crudProvider.searchByName(entityName);
        if (CheckIfEntityIsPortfolio()) {
            assertTrue("Cannot find entities.", results.getErrors().isEmpty());
        } else if (CheckIfEntityIsPosition()) {
            assertFalse("Entities found.", results.getErrors().isEmpty());
        }
    }

    private boolean CheckIfEntityIsPortfolio() {
        return entity.getClass().equals(Portfolio.class);
    }

    private boolean CheckIfEntityIsPosition() {
        return entity.getClass().equals(Position.class);
    }    
}
