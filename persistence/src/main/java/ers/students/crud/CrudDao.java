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
 * returns the object with the given ID
 * returns a list of all the objects
 */
public interface CrudDao<Entity> {

    void save(Entity e);

    void update(Entity e);

    void delete(int id);

    Entity loadById(int id);

    List<Entity> loadAll();
}
