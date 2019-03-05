/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.portfolio.Portfolio;
import java.util.List;

/**
 *
 * @author Ayhan
 */
public class PortfolioDao extends AbstractSearchingDao{
    
    @Override
    public void save(Object e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public void delete (int id){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Portfolio loadById(int id){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<Portfolio> loadAll(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<Portfolio> seachByName(){
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
