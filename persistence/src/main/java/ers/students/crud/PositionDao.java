/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.portfolio.Position;
import java.util.List;

/**
 *
 * @author Ayhan
 */
public class PositionDao extends AbstractSearchingDao {

    @Override
    public void save(Object e) {    // saves/inserts row in DB
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Object e) {  // updates row in DB
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(int id) {    // deletes row in DB
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Position loadById(int id) {    // returns the object with the given id 
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Position> loadAll() {     // returns a list of all the objects
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Position> searchByName(String name) { // returns a list of the objects with the given name
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
