/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Transaction;
import java.sql.SQLException;

/**
 *
 * @author Ayhan
 *
 * Stores data retrieved from CRUD operations
 */
public class TransactionDao extends AbstractSearchingDao<Transaction> {

    public TransactionDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "Transaction";
    }

    @Override
    public void save(Transaction e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Transaction e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
