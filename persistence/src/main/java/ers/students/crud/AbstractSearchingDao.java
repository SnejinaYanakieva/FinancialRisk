/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import java.util.List;

/**
 *
 * @author Ayhan
 * @param <Entity>
 */
public abstract class AbstractSearchingDao <Entity> extends AbstractCrudDao <Entity> 
        implements SearchingDao <Entity> {
    
    public List<Entity> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
