/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.test;

import ers.students.crud.provider.searching.PositionCrudProvider;
import ers.students.crud.results.LoadResult;
import ers.students.crud.results.LoadResults;
import ers.students.crud.utils.ErroneousPersistenceStore;
import ers.students.instruments.Instrument;
import ers.students.portfolio.Position;
import java.util.Map;

/**
 *
 * @author Irina
 */
public class PositionProviderTest extends AbstractProviderTest {

    private final Position position = new Position("2", "name2", "shortSide", "longSide", "1", new Instrument());

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        persistentStore = new ErroneousPersistenceStore();
        crudProvider = new PositionCrudProvider(persistentStore);
        entity = position;
        entityID = position.getId();
        entityName = position.getName();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Override
    protected void save(Map errors) {
        assertFalse("Entity saved.", errors.isEmpty());
    }

    @Override
    protected void update(Map errors) {
        assertFalse("Entity updated.", errors.isEmpty());
    }

    @Override
    protected void update(LoadResult result) {
        assertFalse("Entity loaded.", result.getErrors().isEmpty());
    }

    @Override
    protected void delete(Map errors) {
        assertFalse("Entity deleted.", errors.isEmpty());
    }

    @Override
    protected void loadAll(LoadResults results) {
        assertFalse("Entities found.", results.getErrors().isEmpty());
    }

    @Override
    protected void searchByName(LoadResults results) {
        assertFalse("Entities found.", results.getErrors().isEmpty());
    }

}
