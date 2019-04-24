/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Portfolio;
import java.sql.SQLException;

/**
 *
 * @author Ayhan
 *
 * Stores data retrieved from CRUD operations
 */
public class PortfolioDao extends AbstractSearchingDao<Portfolio> {
    
    private final String INSERT = "INSERT INTO Portfolio VALUES (?, ?, ?)";

    public PortfolioDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "Portfolio";
    }

    @Override
    public void save(Portfolio e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Portfolio e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
