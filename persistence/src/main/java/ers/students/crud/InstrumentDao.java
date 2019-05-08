/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.instruments.Instrument;
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
public class InstrumentDao extends AbstractSearchingDao<Instrument> {

    private final String INSERT = "INSERT INTO Instrument VALUES (?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Instrument SET type=?, isin=?, currency=?, issue_date=?, maturity_date=?, "
            + "interest_rate=?, interest_frequency=?, amortization_frequency=? WHERE id=?";
    private final String LOAD_BY_ID = "SELECT * FROM Instrument WHERE id=?";
    private final String LOAD_ALL = "SELECT * FROM ?";
    private final String SEARCH_BY_NAME = "SELECT * FROM ? WHERE isin=?";

    public InstrumentDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "Instrument";
    }

    /**
     * Saves Instrument in DB
     * 
     * @param instrument
     * @throws SQLException 
     */
    @Override
    public void save(Instrument instrument) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(INSERT)) {
            // type, interest_rate, interest_frequency, amortization_frequency

            prepStatement.setString(1, instrument.getId());
            prepStatement.setString(3, instrument.getIsin());
            prepStatement.setString(4, instrument.getCurrency().toString());
            prepStatement.setDate(5, (Date) instrument.getIssueDate());
            prepStatement.setDate(6, (Date) instrument.getMaturityDate());
            
            //prepStatement.setDouble(7, (Date) instrument.)
        }
    }

    /**
     * Updates Instrument in DB
     * 
     * @param instrument
     * @throws SQLException 
     */
    @Override
    public void update(Instrument instrument) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(UPDATE)) {
            // type, interest_rate, interest_frequency, amortization_frequency

            prepStatement.setString(2, instrument.getIsin());
            prepStatement.setString(3, instrument.getCurrency().toString());
            prepStatement.setDate(4, (Date) instrument.getIssueDate());
            prepStatement.setDate(5, (Date) instrument.getMaturityDate());
            prepStatement.setString(9, instrument.getId());
        }
    }

    /**
     * Loads Instrument from DB with the given ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Instrument loadById(String id) throws SQLException {
        Instrument instrument = new Instrument();

        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(LOAD_BY_ID)) {
            prepStatement.setString(1, id);

            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                // type, interest_rate, interest_frequency, amortization_frequency

                instrument.setId(resultSet.getString("id"));
                instrument.setIsin(resultSet.getString("isin"));
                instrument.setCurrency(Currency.valueOf(resultSet.getString("currency")));
                instrument.setIssueDate(resultSet.getDate("issue_date"));
                instrument.setMaturityDate(resultSet.getDate("maturity_date"));
            }

            resultSet.close();
            prepStatement.close();
        }

        return instrument;
    }

    /**
     * Loads all Instruments from DB
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Instrument> loadAll() throws SQLException {
        List<Instrument> instrumentList = new ArrayList<>();
        Instrument instrument;

        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(LOAD_ALL)) {
            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                instrument = new Instrument();

                // type, interest_rate, interest_frequency, amortization_frequency
                instrument.setId(resultSet.getString("id"));
                instrument.setIsin(resultSet.getString("isin"));
                instrument.setCurrency(Currency.valueOf(resultSet.getString("currency")));
                instrument.setIssueDate(resultSet.getDate("issue_date"));
                instrument.setMaturityDate(resultSet.getDate("maturity_date"));

                instrumentList.add(instrument);
            }

            resultSet.close();
            prepStatement.close();
        }

        return instrumentList;
    }

    /**
     * Loads all Instruments from DB with the given name
     *
     * @param name
     * @return
     * @throws SQLException
     */
    @Override
    public List<Instrument> searchByName(String name) throws SQLException {
        List<Instrument> instrumentList = new ArrayList<>();
        Instrument instrument;

        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(SEARCH_BY_NAME)) {
            prepStatement.setString(1, name);
            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                instrument = new Instrument();

                // type, interest_rate, interest_frequency, amortization_frequency
                instrument.setId(resultSet.getString("id"));
                instrument.setIsin(resultSet.getString("isin"));
                instrument.setCurrency(Currency.valueOf(resultSet.getString("currency")));
                instrument.setIssueDate(resultSet.getDate("issue_date"));
                instrument.setMaturityDate(resultSet.getDate("maturity_date"));

                instrumentList.add(instrument);
            }
            resultSet.close();
            prepStatement.close();

        }

        return instrumentList;

    }

}
