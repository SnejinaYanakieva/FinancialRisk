/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.utils;

import ers.students.crud.PortfolioDao;
import ers.students.portfolio.Portfolio;
import ers.students.util.Currency;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Irina
 */
public class SuccessfulPortfolioDao extends PortfolioDao {

    @Override
    public Portfolio loadById(String id) {
        return new Portfolio("1l", "name1", Currency.CHF);
    }

    @Override
    public void save(Portfolio portfolio) throws SQLException {

    }

    @Override
    public List<Portfolio> loadAll() throws SQLException {
        List<Portfolio> portfolios = new ArrayList<>();
        portfolios.add(new Portfolio("1l", "name1", Currency.CHF));
        portfolios.add(new Portfolio("2l", "name2", Currency.BGN));
        return portfolios;
    }

    @Override
    public void delete(String id) throws SQLException {

    }

    @Override
    public void update(Portfolio e) throws SQLException {

    }
    
    @Override
    public List<Portfolio> searchByName(String name){
        return new ArrayList<>();
    }
}
