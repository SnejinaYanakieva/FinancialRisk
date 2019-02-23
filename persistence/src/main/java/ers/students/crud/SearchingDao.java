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
 */
public class SearchingDao<Entity> implements CrudDao<Entity>{

    public void save(Entity e) {
    }

    public void update(Entity e) {
    }

    public void delete(int id) {
    }

    public Entity loadById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Entity> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*public List<Entity>searchByName(String name){
        
    }*/
}
