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
    }

    public void dropDB() {
    }

    public void startTransaction() {
    }

    public void rollbackTransaction() {
    }

    public void commitTransaction() {
    }

    public SearchingDao<Position> getPositionDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SearchingDao<Portfolio> getPortfolioDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
