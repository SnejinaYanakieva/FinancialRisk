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

public interface SearchingDao <Entity> extends CrudDao<Entity> {
    void save(Entity e);
    void update(Entity e);
    void delete(int id);
    Entity loadById(int id);
    List<Entity> searchByName(String name);
}

