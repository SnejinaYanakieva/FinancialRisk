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
 * This interface provides methods to create and delete a database,
 * begin, end and revert transactions
 */

public interface PersistentStore {

    /**
     * creates database
     */
    void createDB();

    /**
     * deletes database
     */
    void dropDB(); 

    /**
     * begins transaction
     */
    void startTransaction();

    /**
     * reverts back to the previous state of the database
     * changes made in DB aren't saved
     */
    void rollbackTransaction();

    /**
     * saves transaction
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
