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
 * saves/inserts row in DB updates row in DB deletes row in DB
 * returns the object with the given id returns a list of all the objects
 * returns a list of the objects with the given name
 */
public abstract class AbstractSearchingDao<Entity> extends AbstractCrudDao<Entity>
        implements SearchingDao<Entity> {

    @Override
    public void save(Entity e) {
        
    }

    @Override
    public void update(Entity e) {
        
    }

    @Override
    public void delete(int id){
        
    }

    @Override
    public Entity loadById(int id){
         throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Entity> loadAll(){
         throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Entity> searchByName(String name){
         throw new UnsupportedOperationException("Not supported yet.");
    }

}
