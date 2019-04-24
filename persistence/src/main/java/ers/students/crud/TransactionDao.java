/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Transaction;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ayhan
 *
 * Stores data retrieved from CRUD operations
 */
public class TransactionDao extends AbstractSearchingDao<Transaction> {

    private final String INSERT = "INSERT INTO Transaction VALUES (?,?,?,?,?)";
    private final String UPDATE = "UPDATE Transaction SET position_id=?, payer=?, receiver=? "
            + "date=? WHERE id=?";

    public TransactionDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "Transaction";
    }

    @Override
    public void save(Transaction transaction) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(INSERT)) {
            prepStatement.setString(1, transaction.getId());
            prepStatement.setString(2, transaction.getPositionId());
            prepStatement.setString(3, transaction.getPayer());
            prepStatement.setString(4, transaction.getReciver());
            prepStatement.setDate(5, (Date) transaction.getDate());

            prepStatement.executeUpdate();
            prepStatement.close();
        }
    }

    @Override
    public void update(Transaction transaction) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(INSERT)) {
            prepStatement.setString(1, transaction.getPositionId());
            prepStatement.setString(2, transaction.getPayer());
            prepStatement.setString(3, transaction.getReciver());
            prepStatement.setDate(4, (Date) transaction.getDate());
            prepStatement.setString(5, transaction.getId());

            prepStatement.executeUpdate();
            prepStatement.close();
        }
    }

}
