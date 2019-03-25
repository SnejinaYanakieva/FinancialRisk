/*
 * Interface that provides methods for creating a database and 
 */
package ers.students.persistentStore;

import ers.students.crud.PortfolioDao;
import ers.students.crud.PositionDao;
import ers.students.crud.SearchingDao;
import ers.students.instruments.Instrument;
import ers.students.market.FxQuote;
import ers.students.market.YieldCurve;
import ers.students.portfolio.Portfolio;
import ers.students.portfolio.Position;
import ers.students.portfolio.Transaction;
import java.sql.Connection;

/**
 *
 * @author Ayhan
 * 
 * Implements methods for working with database and transactions
 */

public class JdbcPersistentStore implements PersistentStore {
    
    Connection connection;
    String userName;
    String password;
    PortfolioDao portfolioDao;
    PositionDao positionDao;
    Transaction transactionDao;
    Instrument instrumentDao;
    YieldCurve yieldCurve;
    FxQuote FxQuote;

    /**
     * Creates the DB
     */
    @Override
    public void createDB() {  
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Deletes the DB
     */
    @Override
    public void dropDB() { 
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Begin transaction
     */
    @Override
    public void startTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Reverts back to the previous state of the database
     * changes made in DB aren't saved
     */
    @Override
    public void rollbackTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Saves transaction
     */
    @Override
    public void commitTransaction() { 
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Uses lazy initialization
     * @return 
     */
    @Override
    public SearchingDao<Position> getPositionDao() {
        if(this.positionDao==null){
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Uses lazy initialization
     * @return 
     */
    @Override
    public SearchingDao<Portfolio> getPortfolioDao() {
        if(this.portfolioDao==null){
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Uses lazy initialization
     * @return 
     */
    @Override
    public SearchingDao<Transaction> getTransactionDao() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     * Uses lazy initialization
     * @return 
     */
    @Override
    public SearchingDao<Instrument> getInstrumentDao() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     * Uses lazy initialization
     * @return 
     */
    @Override
    public SearchingDao<YieldCurve> getYieldCurveDao() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     * Uses lazy initialization
     * @return 
     */
    @Override
    public SearchingDao<FxQuote> getFxQuote() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}
