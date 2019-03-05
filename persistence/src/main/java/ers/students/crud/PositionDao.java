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
    public void save(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void update(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public void delete(int id){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public Position loadById(int id){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public List<Position> loadAll(){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public List<Position> searchByName(String name){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
