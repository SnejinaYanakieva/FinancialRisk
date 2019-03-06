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
 * saves/inserts row in DB
 * updates row in DB
 * deletes row in DB
 * returns the objects with the given ID
 * returns a list of all the objects
 */
public abstract class AbstractCrudDao<Entity> implements CrudDao<Entity> {

    /**
     *
     * @param e
     * 
     */
    public abstract void save(Entity e);

    public abstract void update(Entity e);

    public abstract void delete(int id); 

    public abstract Entity loadById(int id);  

    public abstract List<Entity> loadAll();

}
