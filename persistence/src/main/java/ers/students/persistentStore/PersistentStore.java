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
     */
    void commitTransaction();

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
}
