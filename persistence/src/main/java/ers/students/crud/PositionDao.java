/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Position;
import java.sql.SQLException;

/**
 *
 * @author Ayhan
 *
 * Stores data retrieved from CRUD operations
 */
public class PositionDao extends AbstractSearchingDao<Position> {

    public PositionDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "Position";
    }

    @Override
    public void save(Position e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Position e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
