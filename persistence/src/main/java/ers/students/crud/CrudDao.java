/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import java.util.List;

/**
 * CrudDao interface provides methods to perform CRUD type operations in the database
 * 
 * @author Ayhan
 * @param <Entity> template class
 */
public interface CrudDao<Entity> {

    /**
     * saves/inserts row in DB
     * @param e - entity
     */
    void save(Entity e);

    /**
     * updates row in DB
     * @param e - entity
     */
    void update(Entity e);
    
    /**
     * deletes row in DB
     * @param id - id of row to delete data from
     */
    void delete(int id);

    /**
     * loads object with the given ID
     * @param id
     * @return entity
     */
    Entity loadById(int id);

    /**
     * loads all data
     * @return list of entities
     */
    List<Entity> loadAll();
}
