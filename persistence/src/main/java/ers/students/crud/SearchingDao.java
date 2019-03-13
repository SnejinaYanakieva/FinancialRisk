/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import java.util.List;

/**
 * This interface provides methods for searching data in the DB
 * 
 * @author Ayhan
 * @param <Entity> entity
 */
public interface SearchingDao<Entity> extends CrudDao<Entity> {

    /**
     * For looking up data by a string
     * @param name
     * @return List of entities
     */
    List<Entity> searchByName(String name);
}
