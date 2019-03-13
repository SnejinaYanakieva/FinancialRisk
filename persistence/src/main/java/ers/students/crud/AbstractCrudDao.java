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
 * AbstractCrudDao implements methods used for CRUD based operations on the DB.
 * 
 * @param <Entity> - entity
 */

public abstract class AbstractCrudDao<Entity> implements CrudDao<Entity> {

    /**
     * Saves/inserts row in DB
     * @param e entity to insert
     */
    @Override
    public void save(Entity e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Updates row in DB
     * @param e entity to update
     */
    @Override
    public void update(Entity e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Deletes row in DB
     * @param id - id of row to delete data from
     */
    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Loads entity based on ID
     * @param id - id of object to return
     * @return entity
     */
    @Override
    public Entity loadById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Loads all entities in a List
     * @return List of entities of template class
     */
    @Override
    public List<Entity> loadAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
