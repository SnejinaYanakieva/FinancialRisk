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
public interface CrudDao <Entity>{
    public void save(Entity e);
    public void update(Entity e);
    public void delete(int id);
    public Entity loadById(int id);
    public List<Entity> loadAll();
}
