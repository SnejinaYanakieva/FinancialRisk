/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Portfolio;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ayhan
 *
 * Stores data retrieved from CRUD operations
 */
public class PortfolioDao extends AbstractSearchingDao<Portfolio> {

    private final String INSERT = "INSERT INTO Portfolio VALUES (?, ?, ?)";
    private final String UPDATE = "UPDATE Portfolio SET name=?, currency=? WHERE id=?";

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
            prepStatement.setString(1, portfolio.getName());
            prepStatement.setString(1, portfolio.getCurrency().toString());
            
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
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(UPDATE)){
            prepStatement.setString(1, portfolio.getName());
            prepStatement.setString(2, portfolio.getCurrency().toString());
            prepStatement.setString(3, portfolio.getId());
            
            prepStatement.executeUpdate();
            prepStatement.close();
        }
    }

}
