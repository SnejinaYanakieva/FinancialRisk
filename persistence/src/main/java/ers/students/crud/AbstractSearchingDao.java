/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import java.util.List;

/**
 * Provides a method for looking up objects by name
 *
 * @author Ayhan
 * @param <Entity> template class
 */
public abstract class AbstractSearchingDao<Entity> extends AbstractCrudDao<Entity>
        implements SearchingDao<Entity> {

    /**
     * 
     * @param name - name to use for searching in DB
     * @return list of objects of template class
     */
    @Override
    public List<Entity> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
