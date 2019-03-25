/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider;

import ers.students.crud.CrudDao;
import ers.students.crud.results.ErrorCode;
import ers.students.crud.results.LoadResults;
import ers.students.persistentStore.PersistentStore;
import ers.students.validate.Validatable;
import java.util.List;
import java.util.Map;

/**
 * Provides methods based on CRUD operations.
 *
 * @author Irina
 */
public class AbstactCrudProvider<E extends Validatable> {

    PersistentStore persistentStore;

    /**
     * Creates an entity in DB.
     *
     * @param entity to create
     * @return corresponding error code and list of errors
     */
    Map<ErrorCode, List<String>> create(E entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Updates an entity in DB.
     *
     * @param entity to update
     * @return corresponding error code and list of errors
     */
    Map<ErrorCode, List<String>> update(E entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Loads an entity by given id.
     *
     * @param id on which we search for entity
     * @return loaded entities and map of errors
     */
    LoadResults<E> loadById(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Deletes an entity in DB.
     *
     * @param id on which we search for entity
     * @return corresponding error code and list of errors
     */
    Map<ErrorCode, List<String>> delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Provides DAO interface for entity.
     *
     * @return
     */
    CrudDao<E> getDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
