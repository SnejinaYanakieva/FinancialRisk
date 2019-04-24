/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.instruments.Instrument;
import ers.students.persistentStore.PersistentStore;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ayhan
 *
 * Stores data retrieved from CRUD operations
 */
public class InstrumentDao extends AbstractSearchingDao<Instrument> {

    private final String INSERT = "INSERT INTO Instrument VALUES (?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Instrument SET type=?, isin=?, currency=?, issue_date=?, maturity_date=?, "
            + "interest_rate=?, interest_frequency=?, amortization_frequency=? WHERE id=?";

    public InstrumentDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "Instrument";
    }

    @Override
    public void save(Instrument instrument) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(INSERT)) {
            prepStatement.setString(1, instrument.getId());
            prepStatement.setString(3, instrument.getIsin());
            prepStatement.setString(4, instrument.getCurrency().toString());
            prepStatement.setDate(5, (Date) instrument.getIssueDate());
            prepStatement.setDate(6, (Date) instrument.getMaturityDate());
        }
    }

    @Override
    public void update(Instrument instrument) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(INSERT)) {
            prepStatement.setString(2, instrument.getIsin());
            prepStatement.setString(3, instrument.getCurrency().toString());
            prepStatement.setDate(4, (Date) instrument.getIssueDate());
            prepStatement.setDate(5, (Date) instrument.getMaturityDate());
            prepStatement.setString(9, instrument.getId());
        }
    }

}
