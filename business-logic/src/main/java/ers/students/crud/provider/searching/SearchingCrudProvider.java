/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider.searching;

import ers.students.crud.SearchingDao;
import ers.students.crud.provider.AbstractCrudProvider;
import ers.students.crud.results.ErrorCode;
import ers.students.crud.results.LoadResults;
import ers.students.persistentStore.PersistentStore;
import ers.students.validate.Validatable;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Provides method for searching entities in DB.
 *
 * @author Irina
 * @param <E>
 */
public abstract class SearchingCrudProvider<E extends Validatable> extends AbstractCrudProvider<E> {

    public SearchingCrudProvider(PersistentStore persistentStore) {
        super(persistentStore);
    }

    /**
     * Provides DAO interface for searching entity by name.
     *
     * @return
     */
    @Override
    protected abstract SearchingDao<E> getDao();

    /**
     * Searches an entity by given name.
     *
     * @param name on which we search for entities
     * @return loaded entities and map of errors
     */
    public LoadResults<E> searchByName(String name) {
        LoadResults<E> results = new LoadResults<>();

        try {
            results.addAllEntities(getDao().searchByName(name));
        } catch (SQLException e) {
            results.getErrors().put(ErrorCode.INTERNAL_ERROR, Arrays.asList(e.getMessage()));
        }

        return results;
    }
}
