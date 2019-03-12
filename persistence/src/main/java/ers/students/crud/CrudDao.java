/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import java.util.List;

/**
 * CrudDao interface provides methods to perform CRUD type operations
 * on rows of the database.
 * 
 * @author Ayhan
 * @param <Entity> template class
 */
public interface CrudDao<Entity> {

    /**
     * saves/inserts row in DB
     * @param e - object of template class to save
     */
    void save(Entity e);

    /**
     * updates row in DB
     * @param e - object of template class to update
     */
    void update(Entity e);
    
    /**
     * deletes row in DB
     * @param id - id of row to delete
     */
    void delete(int id);

    /**
     * loads object with the given ID
     * @param id
     * @return object of template class
     */
    Entity loadById(int id);

    /**
     * loads all data
     * @return list of objects of template class
     */
    List<Entity> loadAll();
}
