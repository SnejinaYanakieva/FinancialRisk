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
public interface PersistentStore{
    public void createDB();
    public void dropDB();
    public void startTransaction();
    public void rollbackTransaction();
    public void commitTransaction();
    public SearchingDao<Portfolio> getPortfolioDao();
    public SearchingDao<Position> getPositionDao();
}
