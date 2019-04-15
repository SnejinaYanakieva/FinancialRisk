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
import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Portfolio;
import ers.students.validate.Validatable;
import java.util.List;
import java.util.Map;
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
        entityName = null;
    }

    protected abstract void save(Map<ErrorCode, List<String>> errors);

    protected abstract void update(Map<ErrorCode, List<String>> errors);

    protected abstract void update(LoadResult<Portfolio> result);

    protected abstract void delete(Map<ErrorCode, List<String>> errors);

    protected abstract void loadAll(LoadResults<E> results);

    protected abstract void searchByName(LoadResults<Portfolio> results);

    public void testSave() {
        save(crudProvider.create(entity));
    }

    public void testUpdate() {
        update(crudProvider.update(entity));
    }

    public void testLoadById() {
        update(crudProvider.loadById(entityID));
    }

    public void testDelete() {
        delete(crudProvider.delete(entityID));
    }

    public void testLoadAll() {
        loadAll(crudProvider.loadAll());
    }

    public void testSearchByName() {
        searchByName(crudProvider.searchByName(entityName));
    }
}
