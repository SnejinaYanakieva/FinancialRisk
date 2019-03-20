/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import java.util.List;

/**
 *
 * @author Ayhan
 * Implements methods used for CRUD based operations on the DB.
 * 
 * @param <Entity> - entity
 */

public abstract class AbstractCrudDao<Entity> implements CrudDao<Entity> {

    /**
     * Saves/inserts entity in DB
     * @param e entity to save/insert
     */
    @Override
    public void save(Entity e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Updates entity in DB
     * @param e entity to update
     */
    @Override
    public void update(Entity e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Deletes entity in DB
     * @param id - id of row to delete data from
     */
    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Loads entity based on ID
     * @param id - id of entity
     * @return entity
     */
    @Override
    public Entity loadById(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Loads all entities in a List
     * @return List of entities
     */
    @Override
    public List<Entity> loadAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
