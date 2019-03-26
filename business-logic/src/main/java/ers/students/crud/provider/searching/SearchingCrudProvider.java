/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider.searching;

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
     * Searches an entity by given name.
     *
     * @param name on which we search for entities
     * @return loaded entities and map of errors
     */
    protected abstract LoadResults<E> searchByName(String name);
}
