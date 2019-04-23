/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Portfolio;

/**
 *
 * @author Ayhan
 *
 * Stores data retrieved from CRUD operations
 */
public class PortfolioDao extends AbstractSearchingDao<Portfolio> {

    public PortfolioDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return this.getClass().getName();
    }

}
