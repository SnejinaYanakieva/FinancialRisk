/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.PersistentStore;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ayhan Implements methods used for CRUD based operations on the DB.
 *
 * @param <Entity> - entity
 */
public abstract class AbstractCrudDao<Entity> implements CrudDao<Entity> {

    private final PersistentStore persistentStore;
    private static final String DELETE = "DELETE FROM ? WHERE id=?";

    public AbstractCrudDao(PersistentStore persistentStore) {

        this.persistentStore = persistentStore;
    }

    abstract String getTableName();

    public PersistentStore getPersistentStore() {
        return this.persistentStore;
    }

    /**
     * Deletes entity in DB
     *
     * @param id - id of row to delete data from
     */
    @Override
    public void delete(String id) throws SQLException {

        try (PreparedStatement preparedStatement = persistentStore.getConnection().prepareStatement(DELETE)) {
            preparedStatement.setString(1, this.getTableName());
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
    }

}
