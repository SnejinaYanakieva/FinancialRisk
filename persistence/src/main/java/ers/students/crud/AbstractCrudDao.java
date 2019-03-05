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
 * @param <Entity>
 */
public abstract class AbstractCrudDao<Entity> implements CrudDao<Entity> {

    /**
     *
     * @param e
     */
    @Override
    public abstract void save(Entity e);    // saves/inserts row in DB

    @Override
    public abstract void update(Entity e);  // updates row in DB

    @Override
    public abstract void delete(int id);    // deletes row in DB

    @Override
    public abstract Entity loadById(int id);    // returns the object with the given id 

    @Override
    public abstract List<Entity> loadAll();     // returns a list of all the objects

}
