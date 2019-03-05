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
    
    @Override
    public abstract void save(Entity e);
    
    @Override
    public abstract void update(Entity e);
    
    @Override
    public abstract void delete(int id);
    
    @Override
    public abstract Entity loadById(int id);
    
    @Override
    public abstract List<Entity> loadAll();
    
    @Override
    public abstract List<Entity> searchByName(String name);
    
}
