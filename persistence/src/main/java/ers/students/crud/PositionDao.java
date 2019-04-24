/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Position;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public PositionDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "Position";
    }

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

    @Override
    public void update(Position position) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(INSERT)) {

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

}
