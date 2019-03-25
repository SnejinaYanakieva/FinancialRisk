/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider.searching;

import ers.students.crud.CrudDao;
import ers.students.crud.results.LoadResults;
import ers.students.portfolio.Portfolio;

/**
 *
 * @author Irina
 */
public class PortfolioCrudProvider extends SearchingCrudProvider<Portfolio> {

    /**
     * Provides DAO interface for Portfolio.
     *
     * @return
     */
    public CrudDao<Portfolio> getDao() {
        return persistentStore.getPortfolioDao();
    }

    /**
     *
     * @param name
     * @return
     */
    public LoadResults<Portfolio> searchByName(String name) {
        LoadResults<Portfolio> portfolioResults = new LoadResults<>();
        portfolioResults.setEntities(persistentStore.getPortfolioDao().searchByName(name));
        return portfolioResults;
    }
}
