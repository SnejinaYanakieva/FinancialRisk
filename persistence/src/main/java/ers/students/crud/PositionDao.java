/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Position;
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
public class PositionDao extends AbstractSearchingDao<Position> {

    private final String INSERT = "INSERT INTO Position VALUES (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Position SET name=?, short_side=?, long_side=?, "
            + "portfolio_id=?, instrument_id=? WHERE id=?";
    private final String LOAD_BY_ID = "SELECT * FROM Instrument WHERE id=?";
    private final String LOAD_ALL = "SELECT * FROM ?";
    private final String SEARCH_BY_NAME = "SELECT * FROM ? WHERE name=?";

    public PositionDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "Position";
    }

    /**
     * Saves Position in DB
     * 
     * @param position
     * @throws SQLException 
     */
    @Override
    public void save(Position position) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(INSERT)) {

            prepStatement.setString(1, position.getId());
            prepStatement.setString(2, position.getName());
            prepStatement.setString(3, position.getShortSide());
            prepStatement.setString(4, position.getLongSide());
            prepStatement.setString(5, position.getPortfolioId());
            prepStatement.setString(6, position.getInstrument().getId());

            prepStatement.executeUpdate();
            prepStatement.close();

        }
    }

    /**
     * Updates Position in DB
     * 
     * @param position
     * @throws SQLException 
     */
    @Override
    public void update(Position position) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(UPDATE)) {

            prepStatement.setString(1, position.getName());
            prepStatement.setString(2, position.getShortSide());
            prepStatement.setString(3, position.getLongSide());
            prepStatement.setString(4, position.getPortfolioId());
            prepStatement.setString(5, position.getInstrument().getId());
            prepStatement.setString(6, position.getId());

            prepStatement.executeUpdate();
            prepStatement.close();

        }
    }

    /**
     * Loads Position from DB with the given ID
     * 
     * @param id
     * @return
     * @throws SQLException 
     */
    @Override
    public Position loadById(String id) throws SQLException {
        Position position = new Position();

        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(LOAD_BY_ID)) {
            prepStatement.setString(1, id);

            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                position.setId(resultSet.getString("id"));
                position.setName(resultSet.getString("name"));
                position.setShortSide(resultSet.getString("short_side"));
                position.setLongSide(resultSet.getString("long_side"));
                position.setPortfolioId(resultSet.getString("position_id"));
                //position.setInstrument(resultSet.getString("instrument_id"));
            }

            resultSet.close();
            prepStatement.close();
        }

        return position;
    }

    /**
     * Loads all Positions from DB
     * 
     * @return
     * @throws SQLException 
     */
    @Override
    public List<Position> loadAll() throws SQLException {
        List<Position> positionList = new ArrayList<>();
        Position position;

        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(LOAD_ALL)) {
            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                position = new Position();

                position.setId(resultSet.getString("id"));
                position.setName(resultSet.getString("name"));
                position.setShortSide(resultSet.getString("short_side"));
                position.setLongSide(resultSet.getString("long_side"));
                position.setPortfolioId(resultSet.getString("position_id"));
                //position.setInstrument(resultSet.getString("instrument_id"));

                positionList.add(position);
            }

            resultSet.close();
            prepStatement.close();
        }

        return positionList;
    }

    /**
     * Loads all Positions from DB with the given name.
     * 
     * @param name
     * @return
     * @throws SQLException 
     */
    @Override
    public List<Position> searchByName(String name) throws SQLException {
        List<Position> positionList = new ArrayList<>();
        Position position;

        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(SEARCH_BY_NAME)) {
            prepStatement.setString(1, name);
            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                position = new Position();

                position.setId(resultSet.getString("id"));
                position.setName(resultSet.getString("name"));
                position.setShortSide(resultSet.getString("short_side"));
                position.setLongSide(resultSet.getString("long_side"));
                position.setPortfolioId(resultSet.getString("position_id"));
                //position.setInstrument(resultSet.getString("instrument_id"));

                positionList.add(position);
            }
            
            resultSet.close();
            prepStatement.close();

        }

        return positionList;

    }

}
