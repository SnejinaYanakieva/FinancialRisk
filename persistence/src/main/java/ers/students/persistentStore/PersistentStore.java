/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.persistentStore;

import ers.students.crud.CrudDao;
import ers.students.crud.SearchingDao;
import ers.students.instruments.Instrument;
import ers.students.market.FxQuote;
import ers.students.market.YieldCurve;
import ers.students.portfolio.Portfolio;
import ers.students.portfolio.Position;
import ers.students.portfolio.Transaction;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Ayhan
 * This interface provides methods for working with database and transactions
 */

public interface PersistentStore {

    /**
     * Creates database
     */
    void createDB();

    /**
     * Deletes database
     */
    void dropDB(); 

    /**
     * Begins transaction
     */
    void startTransaction();

    /**
     * Reverts back to the previous state of the database
     * changes made in DB aren't saved
     */
    void rollbackTransaction();

    /**
     * Saves transaction
     * @throws java.sql.SQLException
     */
    void commitTransaction() throws SQLException;

    /**
     * Uses lazy initialization
     * @return 
     */
    SearchingDao<Portfolio> getPortfolioDao(); 

    /**
     * Uses lazy initialization
     * @return 
     */
    SearchingDao<Position> getPositionDao(); 
    
    /**
     * Uses lazy initialization
     * @return 
     */
    SearchingDao<Transaction> getTransactionDao();
    
    /**
     * Uses lazy initialization
     * @return 
     */
    SearchingDao<Instrument> getInstrumentDao();
    
    /**
     * Uses lazy initialization
     * @return 
     */
    CrudDao<YieldCurve> getYieldCurveDao();
    
    /**
     * Uses lazy initialization
     * @return 
     */
    CrudDao<FxQuote> getFxQuote();

    /**
     * 
     * @return 
     */
    Connection getConnection();
    
    /**
     * Closes connection with DB if it's open
     */
    void close();
    
}
