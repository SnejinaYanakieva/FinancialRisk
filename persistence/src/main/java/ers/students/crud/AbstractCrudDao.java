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
 * AbstractCrudDao implements the CrudDao interface, implementing its methods
 * used for CRUD based operations on the DB.
 * 
 * @param <Entity> - template class
 */

public abstract class AbstractCrudDao<Entity> implements CrudDao<Entity> {

    /**
     * Saves/inserts row in DB
     * @param e object of template class to insert
     */
    @Override
    public void save(Entity e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Updates row in DB
     * @param e object of template class to update
     */
    @Override
    public void update(Entity e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Deletes row in DB
     * @param id - id of row to delete
     */
    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the objects with the given ID
     * @param id - id of object to return
     * @return object of template class
     */
    @Override
    public Entity loadById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a list of all the objects
     * @return List of objects of template class
     */
    @Override
    public List<Entity> loadAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
