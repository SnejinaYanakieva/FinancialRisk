/*
 * Interface that provides methods for creating a database and 
 */
package ers.students.persistentStore;

import ers.students.crud.SearchingDao;
import ers.students.portfolio.Portfolio;
import ers.students.portfolio.Position;

/**
 *
 * @author Ayhan
 * 
 * Implements methods for working with database and transactions
 */

public class JdbcPersistentStore implements PersistentStore {

    /**
     * creates the DB
     */
    @Override
    public void createDB() {  
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * deletes the DB
     */
    @Override
    public void dropDB() { 
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * begin transaction
     */
    @Override
    public void startTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * reverts back to the previous state of the database
     * changes made in DB aren't saved
     */
    @Override
    public void rollbackTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * saves transaction
     */
    @Override
    public void commitTransaction() { 
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * gets the position DAO
     * @return 
     */
    @Override
    public SearchingDao<Position> getPositionDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * gets the portfolio DAO
     * @return 
     */
    @Override
    public SearchingDao<Portfolio> getPortfolioDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
