/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.utils;

import ers.students.crud.PortfolioDao;
import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Portfolio;
import ers.students.util.Currency;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author martinstoynov
 */
public class ErroneousPortfolioDao extends PortfolioDao {

    public static Portfolio portfolio = new Portfolio("", "", Currency.CHF);

    public ErroneousPortfolioDao(PersistentStore ps) {
        super(ps);
    }
    
    @Override
    public void delete(String e) throws SQLException {
        throw new SQLException("Test sql exception.");
    }

    @Override
    public Portfolio loadById(String id) {
        return null;
    }

    @Override
    public void save(Portfolio portfolio) throws SQLException {
        throw new SQLException("Cannot be saved.");
    }

    @Override
    public void update(Portfolio e) throws SQLException {
        throw new SQLException("Cannot be updated.");
    }

    @Override
    public List<Portfolio> loadAll() {
        return null;
    }

    @Override
    public List<Portfolio> searchByName(String name) {
        return null;
    }
}

