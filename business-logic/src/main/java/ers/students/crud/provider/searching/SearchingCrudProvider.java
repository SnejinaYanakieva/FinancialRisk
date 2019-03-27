/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider.searching;

import ers.students.crud.AbstractSearchingDao;
import ers.students.crud.CrudDao;
import ers.students.crud.SearchingDao;
import ers.students.crud.provider.AbstactCrudProvider;
import ers.students.crud.results.LoadResults;
import ers.students.validate.Validatable;

/**
 * Provides method for searching entities in DB.
 *
 * @author Irina
 * @param <E>
 */
public abstract class SearchingCrudProvider<E extends Validatable> extends AbstactCrudProvider<E> {

    /**
     * Provides DAO interface for searching entity by name.
     *
     * @return
     */
    @Override
    protected SearchingDao<E> getDao() {
        return getDao();
    }

    /**
     * Searches an entity by given name.
     *
     * @param name on which we search for entities
     * @return loaded entities and map of errors
     */
    protected LoadResults<E> searchByName(String name) {
        LoadResults<E> results = new LoadResults<>();
        results.setEntities(getDao().searchByName(name));
        return results;
    }
}
