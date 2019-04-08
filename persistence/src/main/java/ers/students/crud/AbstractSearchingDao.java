/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.PersistentStore;
import java.sql.SQLException;
import java.util.List;

/**
 * Provides a method for looking up entities by name
 *
 * @author Ayhan
 * @param <Entity> entity
 */
public abstract class AbstractSearchingDao<Entity> extends AbstractCrudDao<Entity>
        implements SearchingDao<Entity> {
    
    public AbstractSearchingDao(PersistentStore ps){
        super(ps);
        
    }

    private static final String SELECT = "SELECT * FROM ? WHERE name=?";

    /**
     * 
     * @param name - string to use for searching in DB
     * @return list of entities
     */
    @Override
    public List<Entity> searchByName(String name) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
