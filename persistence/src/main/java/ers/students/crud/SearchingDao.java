/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import java.sql.SQLException;
import java.util.List;

/**
 * This interface provides methods for searching data in the DB
 * 
 * @author Ayhan
 * @param <Entity> entity
 */
public interface SearchingDao<Entity> extends CrudDao<Entity> {

    /**
     * For looking up data by name
     * @param name
     * @return List of entities
     * @throws java.sql.SQLException
     */
    List<Entity> searchByName(String name) throws SQLException;
}
