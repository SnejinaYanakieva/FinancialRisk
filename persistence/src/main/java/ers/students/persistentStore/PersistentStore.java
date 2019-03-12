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
 * begin, end and revert transactions and return PortfolioDao and PositionDao
 * in the form of SearchingDao interface with the respective template class.
 */
public interface PersistentStore {

    void createDB();

    void dropDB(); 

    void startTransaction();

    void rollbackTransaction();

    void commitTransaction();

    SearchingDao<Portfolio> getPortfolioDao(); 

    SearchingDao<Position> getPositionDao(); 
}
