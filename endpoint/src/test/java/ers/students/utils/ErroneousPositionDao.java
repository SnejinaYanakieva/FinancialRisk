/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.utils;

import ers.students.crud.AbstractSearchingDao;
import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Position;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author martinstoynov
 */
public class ErroneousPositionDao extends AbstractSearchingDao<Position> {

    public ErroneousPositionDao(PersistentStore JDBCPersistentStore) {
        super(JDBCPersistentStore);
    }

    @Override
    public void delete(String e) throws SQLException {
        throw new SQLException("Test sql exception.");
    }

    @Override
    public Position loadById(String id) {
        return null;
    }

    @Override
    public void save(Position portfolio) throws SQLException {
        throw new SQLException("Cannot be saved.");
    }

    @Override
    public void update(Position e) throws SQLException {
        throw new SQLException("Cannot be updated.");
    }

    @Override
    public List<Position> loadAll() throws SQLException {
        throw new SQLException("Cannot load all.");
    }

    @Override
    public List<Position> searchByName(String name) throws SQLException {
        throw new SQLException("Cannot find entity.");
    }
}
