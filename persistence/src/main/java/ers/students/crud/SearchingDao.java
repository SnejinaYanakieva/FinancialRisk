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
    void save(Entity e);

    @Override
    void update(Entity e);

    @Override
    void delete(int id);

    @Override
    Entity loadById(int id);

    @Override
    List<Entity> loadAll();

    List<Entity> searchByName(String name);
}
