/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.test;

import ers.students.crud.provider.searching.PositionCrudProvider;
import ers.students.crud.utils.ErroneousPersistenceStore;
import ers.students.instruments.Instrument;
import ers.students.portfolio.Position;

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

}
