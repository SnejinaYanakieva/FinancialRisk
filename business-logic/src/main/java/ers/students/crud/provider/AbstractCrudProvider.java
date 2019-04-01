/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider;

import ers.students.crud.CrudDao;
import ers.students.crud.results.ErrorCode;
import ers.students.crud.results.LoadResult;
import ers.students.persistentStore.PersistentStore;
import ers.students.validate.Validatable;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides methods based on CRUD operations.
 *
 * @author Irina
 * @param <E>
 */
public abstract class AbstractCrudProvider<E extends Validatable> {

    protected final PersistentStore persistentStore;

    public AbstractCrudProvider(PersistentStore persistentStore) {
        this.persistentStore = persistentStore;
    }

    /**
     * Creates an entity in DB.
     *
     * @param entity to create
     * @return corresponding error code and list of errors
     */
    public Map<ErrorCode, List<String>> create(E entity) {
        Map<ErrorCode, List<String>> errors = getErrors(entity);
        if (!errors.isEmpty()) {
            return errors;
        }
        try {
            persistentStore.startTransaction();
            getDao().save(entity);
            persistentStore.commitTransaction();
        } catch (SQLException e) {
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
    public Map<ErrorCode, List<String>> update(E entity) {
        Map<ErrorCode, List<String>> errors = getErrors(entity);
        if (!errors.isEmpty()) {
            return errors;
        }
        try {
            persistentStore.startTransaction();
            getDao().update(entity);
            persistentStore.commitTransaction();
        } catch (SQLException e) {
            errors = getExceptionsAndRollbackTransaction(e);
        }
        return errors;
    }

    /**
     * Loads an entity by given id.
     *
     * @param id to search entity
     * @return loaded entities and map of errors
     */
    public LoadResult<E> loadById(String id) {
        LoadResult<E> result = new LoadResult<>();
        Map<ErrorCode, List<String>> errors = new HashMap<>();
        try {
            persistentStore.startTransaction();
            E entity = loadEntityAndCheckForNull(id, errors);
            if (!errors.isEmpty()) {
                result.setErrors(errors);
                return result;
            }
            persistentStore.commitTransaction();
            result.setEntity(entity);
        } catch (Exception e) {
            result.setErrors(getExceptionsAndRollbackTransaction(e));
        }

        return result;
    }

    /**
     * Deletes an entity in DB.
     *
     * @param id to search entity
     * @return corresponding error code and list of errors
     */
    public Map<ErrorCode, List<String>> delete(String id) {
        Map<ErrorCode, List<String>> errors = new HashMap<>();
        try {
            persistentStore.startTransaction();
            E entity = loadEntityAndCheckForNull(id, errors);
            if (!errors.isEmpty()) {
                return errors;
            }
            getDao().delete(id);
            persistentStore.commitTransaction();
        } catch (SQLException e) {
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

    /**
     * Checks if an entity is valid.
     *
     * @param entity to check for validation
     * @return pairs of error code and errors
     */
    private Map<ErrorCode, List<String>> getErrors(E entity) {
        Map<ErrorCode, List<String>> errors = new HashMap<>();
        if (!entity.validate().isEmpty()) {
            errors.put(ErrorCode.VALIDATION, entity.validate());
        }
        return errors;
    }

    /**
     * If an exception occurred, this method is called.
     *
     * @param e needed to retrieve the cause of the error
     * @return pairs of error code and errors
     */
    private Map<ErrorCode, List<String>> getExceptionsAndRollbackTransaction(Exception e) {
        Map<ErrorCode, List<String>> errors = new HashMap<>();
        errors.put(ErrorCode.INTERNAL_ERROR, Arrays.asList(e.getCause().getMessage()));
        persistentStore.rollbackTransaction();
        return errors;
    }

    /**
     * Loads and checks if entity is null.
     *
     * @param id to search entity
     * @return pairs of error code and errors
     */
    private E loadEntityAndCheckForNull(String id, Map<ErrorCode, List<String>> errors) {
        E entity = null;
        try {
            entity = getDao().loadById(id);
            if (entity == null) {
                errors.put(ErrorCode.NO_SUCH_ELEMENT, Arrays.asList("No such element"));
                persistentStore.rollbackTransaction();
            }
        } catch (SQLException e) {
            errors.put(ErrorCode.INTERNAL_ERROR, Arrays.asList("Cannot load entity."));
        }
        return entity;
    }

}
