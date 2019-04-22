/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.PersistentStore;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ayhan Implements methods used for CRUD based operations on the DB.
 *
 * @param <Entity> - entity
 */
public abstract class AbstractCrudDao<Entity> implements CrudDao<Entity> {

    private final PersistentStore persistentStore;
    private static final String INSERT = "INSERT INTO ? VALUES()";
    private static final String UPDATE = "";
    private static final String DELETE = "DELETE FROM ? WHERE id=?";
    private static final String LOAD_BY_ID = "SELECT * FROM ? WHERE id=?";
    private static final String LOAD_ALL = "SELECT * FROM ?";

    public AbstractCrudDao(PersistentStore persistentStore) {

        this.persistentStore = persistentStore;
    }

    /**
     * Saves/inserts entity in DB
     *
     * @param e entity to save/insert
     */
    @Override
    public void save(Entity e) throws SQLException {

        try (PreparedStatement preparedStatement = persistentStore.getConnection().prepareStatement(INSERT)) {

        }

        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Updates entity in DB
     *
     * @param e entity to update
     */
    @Override
    public void update(Entity e) throws SQLException {

        try (PreparedStatement preparedStatement = persistentStore.getConnection().prepareStatement(UPDATE)) {
        }

        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Deletes entity in DB
     *
     * @param id - id of row to delete data from
     */
    @Override
    public void delete(String id) throws SQLException {

        try (PreparedStatement preparedStatement = persistentStore.getConnection().prepareStatement(DELETE)) {
            String tableName=this.getClass().getName();
            preparedStatement.setString(1, tableName.substring(0, tableName.length()-3));
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
    }

    /**
     * Loads entity based on ID
     *
     * @param id - id of entity
     * @return entity
     */
    @Override
    public Entity loadById(String id) throws SQLException {

        try (PreparedStatement preparedStatement = persistentStore.getConnection().prepareStatement(LOAD_BY_ID)) {
            //preparedStatement.setString(1, tableName);
            preparedStatement.setString(2, id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                
            }

        }

        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Loads all entities in a List
     *
     * @return List of entities
     */
    @Override
    public List<Entity> loadAll() throws SQLException {

        try (PreparedStatement preparedStatement = persistentStore.getConnection().prepareStatement(LOAD_ALL)) {
            //preparedStatement.setString(1, tableName);
        }
        
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
