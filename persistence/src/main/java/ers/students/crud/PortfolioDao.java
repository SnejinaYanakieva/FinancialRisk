/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Portfolio;
import ers.students.util.Currency;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ayhan
 *
 * Stores data retrieved from CRUD operations
 */
public class PortfolioDao extends AbstractSearchingDao<Portfolio> {

    private final String INSERT = "INSERT INTO Portfolio VALUES (?, ?, ?)";
    private final String UPDATE = "UPDATE Portfolio SET name=?, currency=? WHERE id=?";
    private final String LOAD_BY_ID = "SELECT * FROM Portfolio WHERE id=?";
    private final String LOAD_ALL = "SELECT * FROM Portfolio";
    private final String SEARCH_BY_NAME = "SELECT * FROM Portfolio WHERE name=?";

    public PortfolioDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "Portfolio";
    }

    /**
     * Saves object of Portfolio class to Portfolio table in DB
     *
     * @param portfolio
     * @throws SQLException
     */
    @Override
    public void save(Portfolio portfolio) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(INSERT)) {
            prepStatement.setString(1, portfolio.getId());
            prepStatement.setString(2, portfolio.getName());
            prepStatement.setString(3, portfolio.getCurrency().toString());

            prepStatement.executeUpdate();
            prepStatement.close();
        }
    }

    /**
     * Updates Portfolio table in DB
     *
     * @param portfolio
     * @throws SQLException
     */
    @Override
    public void update(Portfolio portfolio) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(UPDATE)) {
            prepStatement.setString(1, portfolio.getName());
            prepStatement.setString(2, portfolio.getCurrency().toString());
            prepStatement.setString(3, portfolio.getId());

            prepStatement.executeUpdate();
            prepStatement.close();
        }
    }

    /**
     * Loads Portfolio object with the given ID
     * 
     * @param id
     * @return
     * @throws SQLException 
     */
    @Override
    public Portfolio loadById(String id) throws SQLException {
        Portfolio portfolio = new Portfolio();

        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(LOAD_BY_ID)) {
            prepStatement.setString(1, id);

            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                portfolio.setId(resultSet.getString(1));
                portfolio.setName(resultSet.getString(2));
                portfolio.setCurrency(Currency.valueOf(resultSet.getString(3)));
            }

            resultSet.close();
            prepStatement.close();
        }

        return portfolio;
    }

    /**
     * Loads all Portfolios from DB
     * 
     * @return
     * @throws SQLException 
     */
    @Override
    public List<Portfolio> loadAll() throws SQLException {
        List<Portfolio> portfolioList = new ArrayList<>();
        Portfolio portfolio;
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(LOAD_ALL)) {
            ResultSet resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                portfolio = new Portfolio();

                portfolio.setId(resultSet.getString("id"));
                portfolio.setName(resultSet.getString("name"));
                portfolio.setCurrency(Currency.valueOf(resultSet.getString("currency")));

                portfolioList.add(portfolio);
            }

            resultSet.close();
            prepStatement.close();
        }

        return portfolioList;
    }

    /**
     * Loads all Portfolios with the given name
     * 
     * @param name
     * @return
     * @throws SQLException 
     */
    @Override
    public List<Portfolio> searchByName(String name) throws SQLException {
        List<Portfolio> portfolioList = new ArrayList<>();
        Portfolio portfolio;

        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(SEARCH_BY_NAME)) {
            prepStatement.setString(1, name);
            ResultSet resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                portfolio = new Portfolio();

                portfolio.setId(resultSet.getString(1));
                portfolio.setName(resultSet.getString(2));
                portfolio.setCurrency(Currency.valueOf(resultSet.getString(3)));

                portfolioList.add(portfolio);
            }

            resultSet.close();
            prepStatement.close();
        }

        return portfolioList;

    }

}
