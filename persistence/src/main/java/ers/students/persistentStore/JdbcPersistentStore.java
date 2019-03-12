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
 * This class implements the PersistentStore interface and overrides the methods for
 * creating and deleting a database, starting, ending reverting back a transaction
 * confirms/saves changes in DB
 */

public class JdbcPersistentStore implements PersistentStore {

    @Override
    public void createDB() {  
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void dropDB() { 
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void startTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void rollbackTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void commitTransaction() { 
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
