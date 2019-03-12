/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import java.util.List;

/**
 * SearchingDao Interface provides method searchByName
 * which is for searching and returning a List of objects
 * based on their name
 * 
 * @author Ayhan
 * @param <Entity> template class
 */
public interface SearchingDao<Entity> extends CrudDao<Entity> {

    /**
     * For looking up data by name
     * @param name
     * @return List of objects of template class
     */
    List<Entity> searchByName(String name);
}
