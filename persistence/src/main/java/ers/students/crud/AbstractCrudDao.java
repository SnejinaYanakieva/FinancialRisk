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

public abstract class AbstractCrudDao <Entity> implements CrudDao<Entity>{
    
    public void save(Entity e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Entity e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public Entity loadById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public List<Entity> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
