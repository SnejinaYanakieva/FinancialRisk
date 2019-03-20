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
 *
 * @author Irina 
 */
public class AbstactCrudProvider<E extends Validatable> {

    PersistentStore persistentStore;

    Map<ErrorCode, List<String>> create(E entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Map<ErrorCode, List<String>> update(E entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    LoadResults<E> loadById(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Map<ErrorCode, List<String>> delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    CrudDao<E> getDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
