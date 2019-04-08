/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.results;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The LoadResults class provides by given ErrorCode corresponding list of
 * errors. It also contains information about loaded entities.
 *
 * @author Irina
 */
public class LoadResults<E> {

    private List<E> entities = new ArrayList<>();
    private Map<ErrorCode, List<String>> errors = new HashMap<>();

    public List<E> getEntities() {
        return entities;
    }
    
    public void addAllEntities(List<E> entities){
        this.entities.addAll(entities);
    }

    public Map<ErrorCode, List<String>> getErrors() {
        return errors;
    }

    public void addAllErrors(Map<ErrorCode, List<String>> errors) {
        this.errors.putAll(errors);
    }

}
