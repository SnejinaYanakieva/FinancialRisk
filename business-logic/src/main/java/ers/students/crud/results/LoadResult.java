/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.results;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The LoadResult class provides by given ErrorCode corresponding list of
 * errors. It also contains information about loaded entity.
 *
 * @author Irina
 */
public class LoadResult<E> {

    private E entity;
    private Map<ErrorCode, List<String>> errors = new HashMap<>();

    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }

    public Map<ErrorCode, List<String>> getErrors() {
        return errors;
    }

    public void setErrors(Map<ErrorCode, List<String>> errors) {
        this.errors = errors;
    }
}
