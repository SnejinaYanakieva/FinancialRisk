/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.test;

import ers.students.crud.provider.searching.PositionCrudProvider;
import ers.students.crud.results.ErrorCode;
import ers.students.crud.results.LoadResult;
import ers.students.crud.results.LoadResults;
import ers.students.crud.utils.ErroneousPersistenceStore;
import ers.students.instruments.Instrument;
import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Position;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;

/**
 *
 * @author Irina
 */
public class PositionProviderTest extends TestCase {

    private PersistentStore persistentStore;
    private PositionCrudProvider crudProvider;
    private Position position;

    public PositionProviderTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        persistentStore = new ErroneousPersistenceStore();
        crudProvider = new PositionCrudProvider(persistentStore);
        position = new Position("2", "name2", "shortSide", "longSide", "1", new Instrument());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        persistentStore = null;
        crudProvider = null;
        position = null;
    }

    public void testSave() {
        Map<ErrorCode, List<String>> errors = crudProvider.create(position);
        assertFalse("Entity saved.", errors.isEmpty());
    }

    public void testUpdate() {
        Map<ErrorCode, List<String>> errors = crudProvider.update(position);
        assertFalse("Entity updated.", errors.isEmpty());
    }

    public void testLoadById() {
        LoadResult<Position> result = crudProvider.loadById(position.getId());
        assertFalse("Entity loaded.", result.getErrors().isEmpty());
    }

    public void testDelete() {
        Map<ErrorCode, List<String>> errors = crudProvider.delete(position.getId());
        assertFalse("Entity deleted.", errors.isEmpty());
    }

   /* public void testSearchByName() {
        LoadResults<Position> results = crudProvider.searchByName(position.getName());
        assertFalse("Entity found.", results.getErrors().isEmpty());
    }*/
}
