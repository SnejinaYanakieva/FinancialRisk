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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides methods based on CRUD operations.
 *
 * @author Irina
 */
public abstract class AbstactCrudProvider<E extends Validatable> {

    protected PersistentStore persistentStore;

    /**
     * Creates an entity in DB.
     *
     * @param entity to create
     * @return corresponding error code and list of errors
     */
    protected Map<ErrorCode, List<String>> create(E entity) {
        Map<ErrorCode, List<String>> errors = getErrors(entity);
        if (errors.size() != 0) {
            return errors;
        }
        try {
            persistentStore.startTransaction();
            getDao().save(entity);
            persistentStore.commitTransaction();
        } catch (Exception e) {
            errors = getExceptionsAndRollbackTransaction(e);
        }
        return errors;
    }

    /**
     * Updates an entity in DB.
     *
     * @param entity to update
     * @return corresponding error code and list of errors
     */
    protected Map<ErrorCode, List<String>> update(E entity) {
        Map<ErrorCode, List<String>> errors = getErrors(entity);
        if (errors.size() != 0) {
            return errors;
        }
        try {
            persistentStore.startTransaction();
            getDao().update(entity);
            persistentStore.commitTransaction();
        } catch (Exception e) {
            errors = getExceptionsAndRollbackTransaction(e);
        }
        return errors;
    }

    /**
     * Loads an entity by given id.
     *
     * @param id on which we search for entity
     * @return loaded entities and map of errors
     */
    LoadResults<E> loadById(String id) {
        LoadResults<E> results = new LoadResults<>();
        Map<ErrorCode, List<String>> errors = new HashMap<>();
        try {
            persistentStore.startTransaction();
            E entity = getDao().loadById(id); 
            //////////////////////////
            errors = loadEntityAndCheckForNull(id);
            if (errors.size() != 0) {
                results.setErrors(errors);
                return results;
            }
            persistentStore.commitTransaction();
            results.setEntities(Arrays.asList(entity));
        } catch (Exception e) {
            results.setErrors(getExceptionsAndRollbackTransaction(e));
        }

        return results;
    }

    /**
     * Deletes an entity in DB.
     *
     * @param id on which we search for entity
     * @return corresponding error code and list of errors
     */
    protected Map<ErrorCode, List<String>> delete(String id) {
        Map<ErrorCode, List<String>> errors = new HashMap<>();
        try {
            persistentStore.startTransaction();
            errors = loadEntityAndCheckForNull(id);
            if (errors.size() != 0) {
                return errors;
            }
            getDao().delete(id);
            persistentStore.commitTransaction();
        } catch (Exception e) {
            errors = getExceptionsAndRollbackTransaction(e);
        }
        return errors;
    }

    /**
     * Provides DAO interface for entity.
     *
     * @return
     */
    protected abstract CrudDao<E> getDao();

    private Map<ErrorCode, List<String>> getErrors(E entity) {
        Map<ErrorCode, List<String>> errors = new HashMap<>();
        if (entity.validate().size() != 0) {
            errors.put(ErrorCode.VALIDATION, entity.validate());
        }
        return errors;
    }

    private Map<ErrorCode, List<String>> getExceptionsAndRollbackTransaction(Exception e) {
        Map<ErrorCode, List<String>> errors = new HashMap<>();
        errors.put(ErrorCode.INTERNAL_ERROR, Arrays.asList(e.getCause().getMessage()));
        persistentStore.rollbackTransaction();
        return errors;
    }

    private Map<ErrorCode, List<String>> loadEntityAndCheckForNull(String id) {
        Map<ErrorCode, List<String>> errors = new HashMap<>();
        E entity = getDao().loadById(id);
        if (entity.equals(null)) {
            errors.put(ErrorCode.NO_SUCH_ELEMENT, Arrays.asList("No such element"));
            persistentStore.rollbackTransaction();
        }
        return errors;
    }

}
