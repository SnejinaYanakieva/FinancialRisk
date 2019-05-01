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
public class TransactionDao extends AbstractSearchingDao<Transaction> {

    private final String INSERT = "INSERT INTO Transaction VALUES (?,?,?,?,?)";
    private final String UPDATE = "UPDATE Transaction SET position_id=?, payer=?, receiver=? "
            + "date=? WHERE id=?";
    private final String LOAD_BY_ID = "SELECT * FROM Instrument WHERE id=?";
    private final String LOAD_ALL = "SELECT * FROM ?";

    public TransactionDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "Transaction";
    }

    /**
     * Saves Transaction in DB
     * 
     * @param transaction
     * @throws SQLException 
     */
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

    /**
     * Updates Transaction in DB
     * 
     * @param transaction
     * @throws SQLException 
     */
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

    /**
     * Loads Transaction with the given ID
     * @param id
     * @return
     * @throws SQLException 
     */
    @Override
    public Transaction loadById(String id) throws SQLException {
        Transaction transaction = new Transaction();

        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(LOAD_BY_ID)) {
            prepStatement.setString(1, id);

            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                transaction.setId(resultSet.getString("id"));
                transaction.setPositionId(resultSet.getString("position_id"));
                transaction.setPayer(resultSet.getString("payer"));
                transaction.setReciver(resultSet.getString("receiver"));
                transaction.setDate(resultSet.getDate("date"));
            }

            resultSet.close();
            prepStatement.close();
        }

        return transaction;
    }

    /**
     * Loads all Transactions from DB
     * 
     * @return
     * @throws SQLException 
     */
    @Override
    public List<Transaction> loadAll() throws SQLException {
        List<Transaction> transactionList = new ArrayList<>();
        Transaction transaction;
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(LOAD_ALL)) {
            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                transaction = new Transaction();

                transaction.setId(resultSet.getString("id"));
                transaction.setPositionId(resultSet.getString("position_id"));
                transaction.setPayer(resultSet.getString("payer"));
                transaction.setReciver(resultSet.getString("receiver"));
                transaction.setDate(resultSet.getDate("date"));
            }

            resultSet.close();
            prepStatement.close();
        }

        return transactionList;
    }

    /**
     * Loads all Transactions from DB with the given name
     * 
     * @param name
     * @return
     * @throws SQLException 
     */
    @Override
    public List<Transaction> searchByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
