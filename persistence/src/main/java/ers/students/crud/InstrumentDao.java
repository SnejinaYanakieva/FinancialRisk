/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.instruments.Instrument;
import ers.students.persistentStore.PersistentStore;
import java.sql.SQLException;

/**
 *
 * @author Ayhan
 *
 * Stores data retrieved from CRUD operations
 */
public class InstrumentDao extends AbstractSearchingDao<Instrument> {

    public InstrumentDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "Instrument";
    }

    @Override
    public void save(Instrument e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Instrument e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
