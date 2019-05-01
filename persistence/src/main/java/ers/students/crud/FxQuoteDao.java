/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.market.FxQuote;
import ers.students.persistentStore.PersistentStore;
import ers.students.util.Currency;
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
public class FxQuoteDao extends AbstractCrudDao<FxQuote> {

    private final String INSERT = "INSERT INTO FxQuote VALUES(?,?,?,?,?)";
    private final String UPDATE = "UPDATE FxQuote SET 'from'=?, 'to'=?, date=?, value=? WHERE id=?";
    private final String LOAD_BY_ID = "SELECT * FROM Instrument WHERE id=?";
    private final String LOAD_ALL = "SELECT * FROM ?";

    public FxQuoteDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "FxQuote";
    }

    /**
     * Saves FxQuote object in DB
     *
     * @param fxQuote
     * @throws SQLException
     */
    @Override
    public void save(FxQuote fxQuote) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(INSERT)) {
            prepStatement.setString(1, fxQuote.getId());
            prepStatement.setString(2, fxQuote.getFrom().toString());
            prepStatement.setString(3, fxQuote.getTo().toString());
            prepStatement.setDate(4, (Date) fxQuote.getDate());
            prepStatement.setDouble(5, fxQuote.getValue());

            prepStatement.executeUpdate();
            prepStatement.close();
        }
    }

    /**
     * Updates FxQuote in DB
     *
     * @param fxQuote
     * @throws SQLException
     */
    @Override
    public void update(FxQuote fxQuote) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(UPDATE)) {
            prepStatement.setString(1, fxQuote.getId());
            prepStatement.setString(2, fxQuote.getFrom().toString());
            prepStatement.setString(3, fxQuote.getTo().toString());
            prepStatement.setDate(4, (Date) fxQuote.getDate());
            prepStatement.setDouble(5, fxQuote.getValue());

            prepStatement.executeUpdate();
            prepStatement.close();
        }
    }

    /**
     * Loads FxQuote object from DB with the given ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public FxQuote loadById(String id) throws SQLException {
        FxQuote fxQuote = new FxQuote();

        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(LOAD_BY_ID)) {
            prepStatement.setString(1, id);

            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                fxQuote.setId(resultSet.getString("id"));
                fxQuote.setFrom(Currency.valueOf(resultSet.getString("from")));
                fxQuote.setTo(Currency.valueOf(resultSet.getString("to")));
                fxQuote.setDate(resultSet.getDate("date"));
                fxQuote.setValue(resultSet.getDouble("value"));
            }

            resultSet.close();
            prepStatement.close();
        }

        return fxQuote;
    }

    /**
     * Loads all FxQuote from DB
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<FxQuote> loadAll() throws SQLException {
        List<FxQuote> fxQuoteList = new ArrayList<>();
        FxQuote fxQuote;

        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(LOAD_ALL)) {
            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                fxQuote = new FxQuote();

                fxQuote.setId(resultSet.getString("id"));
                fxQuote.setFrom(Currency.valueOf(resultSet.getString("from")));
                fxQuote.setTo(Currency.valueOf(resultSet.getString("to")));
                fxQuote.setDate(resultSet.getDate("date"));
                fxQuote.setValue(resultSet.getDouble("value"));

                fxQuoteList.add(fxQuote);
            }

            resultSet.close();
            prepStatement.close();
        }

        return fxQuoteList;
    }
}
