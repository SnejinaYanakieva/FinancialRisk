/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.JdbcPersistentStore;
import ers.students.persistentStore.PersistentStore;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ayhan Implements methods used for CRUD based operations on the DB.
 *
 * @param <Entity> - entity
 */
public abstract class AbstractCrudDao<Entity> implements CrudDao<Entity> {

    
    private final PersistentStore JDBCPersistentStore;
    private static final String INSERT = "INSERT INTO ? VALUES()";
    private static final String UPDATE = "";
    private static final String DELETE = "DELETE FROM ? WHERE id=?";
    private static final String LOADBYID = "SELECT * FROM ? WHERE id=?";
    private static final String LOADALL = "SELECT * FROM ?";

    public AbstractCrudDao() {
        this.JDBCPersistentStore = new JdbcPersistentStore();
    }

    /**
     * Saves/inserts entity in DB
     *
     * @param e entity to save/insert
     */
    @Override
    public void save(Entity e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Updates entity in DB
     *
     * @param e entity to update
     */
    @Override
    public void update(Entity e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Deletes entity in DB
     *
     * @param id - id of row to delete data from
     */
    @Override
    public void delete(String id) throws SQLException {
        /*PreparedStatement pStatement = JDBCPersistentStore.getConnection().prepareStatement(DELETE);
        pStatement.setString(2, id);
        pStatement.executeUpdate();
        pStatement.close();*/
    }

    /**
     * Loads entity based on ID
     *
     * @param id - id of entity
     * @return entity
     */
    @Override
    public Entity loadById(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Loads all entities in a List
     *
     * @return List of entities
     */
    @Override
    public List<Entity> loadAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
