/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider.searching;

import ers.students.crud.SearchingDao;
import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Portfolio;

/**
 *
 * @author Irina
 */
public class PortfolioCrudProvider extends SearchingCrudProvider<Portfolio> {

    public PortfolioCrudProvider(PersistentStore persistentStore) {
        super(persistentStore);
    }
    
    /**
     * Provides DAO interface for Portfolio.
     *
     * @return
     */
    @Override
    protected SearchingDao<Portfolio> getDao() {
        return persistentStore.getPortfolioDao();
    }
    
}
