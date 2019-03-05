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
public class JdbcPersistentStore implements PersistentStore {

    @Override
    public void createDB() {    // creates the database
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void dropDB() {      // deletes the database
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void startTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void rollbackTransaction() {     // reverts back to a previous state of the DB
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void commitTransaction() {       // confirms/saves changes in DB
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SearchingDao<Position> getPositionDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SearchingDao<Portfolio> getPortfolioDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
