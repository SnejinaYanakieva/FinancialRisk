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
public interface CrudDao<Entity> {

    void save(Entity e);    // saves/inserts row in DB

    void update(Entity e);  // updates row in DB

    void delete(int id);    // deletes row in DB

    Entity loadById(int id);    // returns the object with the given id 

    List<Entity> loadAll();     // returns a list of all the objects
}
