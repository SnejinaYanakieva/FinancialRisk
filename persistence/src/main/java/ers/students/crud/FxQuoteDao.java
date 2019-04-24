/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.market.FxQuote;
import ers.students.persistentStore.PersistentStore;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ayhan
 *
 * Stores data retrieved from CRUD operations
 */
public class FxQuoteDao extends AbstractCrudDao<FxQuote> {

    private final String INSERT = "INSERT INTO FxQuote VALUES(?,?,?,?,?)";
    private final String UPDATE = "UPDATE FxQuote SET 'from'=?, 'to'=?, date=?, value=? WHERE id=?";

    public FxQuoteDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "FxQuote";
    }

    @Override
    public void save(FxQuote fxQuote) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(INSERT)) {
            prepStatement.setString(1, fxQuote.getId());
            prepStatement.setString(2, fxQuote.getFrom().toString());
            prepStatement.setString(3, fxQuote.getTo().toString());
            prepStatement.setString(4, fxQuote.getDate().toString());
            prepStatement.setString(5, String.valueOf(fxQuote.getValue()));

            prepStatement.executeUpdate();
            prepStatement.close();
        }
    }

    @Override
    public void update(FxQuote fxQuote) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(UPDATE)) {
            prepStatement.setString(1, fxQuote.getFrom().toString());
            prepStatement.setString(2, fxQuote.getTo().toString());
            prepStatement.setString(3, fxQuote.getDate().toString());
            prepStatement.setString(4, String.valueOf(fxQuote.getValue()));
            prepStatement.setString(5, fxQuote.getId());

            prepStatement.executeUpdate();
            prepStatement.close();
        }
    }
}
