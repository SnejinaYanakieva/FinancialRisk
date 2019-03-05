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
public interface SearchingDao<Entity> extends CrudDao<Entity> {

    @Override
    void save(Entity e);        // saves/inserts row in DB

    @Override
    void update(Entity e);      // updates row in DB

    @Override
    void delete(int id);        // deletes row in DB

    @Override
    Entity loadById(int id);       // returns the object with the given id

    @Override
    List<Entity> loadAll();         // returns a list of all the objects

    List<Entity> searchByName(String name); // returns a list of the objects with the given name
}
