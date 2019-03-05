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
public interface PersistentStore {

    void createDB();    // creates the database

    void dropDB();      // deletes the database

    void startTransaction();    // opens DB to begin

    void rollbackTransaction(); // reverts back to a previous state of the DB

    void commitTransaction();   // confirms/saves changes in DB

    SearchingDao<Portfolio> getPortfolioDao();  // 

    SearchingDao<Position> getPositionDao();    // 
}
