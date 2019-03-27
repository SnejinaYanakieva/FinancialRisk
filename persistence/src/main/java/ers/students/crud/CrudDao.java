/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import java.sql.SQLException;
import java.util.List;

/**
 * Provides methods to perform CRUD type operations in the database
 * 
 * @author Ayhan
 * @param <Entity> entity
 */
public interface CrudDao<Entity> {

    /**
     * Saves/inserts entity in DB
     * @param e - entity
     * @throws java.sql.SQLException
     */
    void save(Entity e) throws SQLException;

    /**
     * Updates entity in DB
     * @param e - entity
     * @throws java.sql.SQLException
     */
    void update(Entity e) throws SQLException;
    
    /**
     * Deletes entity in DB
     * @param id - ID of row to delete data from
     * @throws java.sql.SQLException
     */
    void delete(String id) throws SQLException;

    /**
     * Loads object with the given ID
     * @param id
     * @return entity
     * @throws java.sql.SQLException
     */
    Entity loadById(String id) throws SQLException;

    /**
     * Loads all data
     * @return list of entities
     * @throws java.sql.SQLException
     */
    List<Entity> loadAll() throws SQLException;
}
