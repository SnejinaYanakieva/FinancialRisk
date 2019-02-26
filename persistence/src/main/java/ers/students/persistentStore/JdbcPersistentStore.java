/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.persistentStore;

import ers.students.crud.SearchingDao;
import ers.students.portfolio.Portfolio;
import ers.students.portfolio.Position;

/**
 *
 * @author Ayhan
 */
public class JdbcPersistentStore implements PersistentStore{

    public void createDB() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void dropDB() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void startTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void rollbackTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void commitTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public SearchingDao<Position> getPositionDao() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public SearchingDao<Portfolio> getPortfolioDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
