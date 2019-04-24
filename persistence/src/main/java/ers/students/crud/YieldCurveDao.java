/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.market.YieldCurve;
import ers.students.persistentStore.PersistentStore;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ayhan
 *
 * Stores data retrieved from CRUD operations
 */
public class YieldCurveDao extends AbstractCrudDao<YieldCurve> {

    private final String INSERT = "INSERT INTO Yield_Curve VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Yield_Curve SET name=?, yield1month=?, yield2month=?, yield3month=? "
            + "yield6month=?, yield1year=?, yield2year=?, yield5year=?, yield10year=?, yield20year=? "
            + "yield30year=? WHERE id=?";

    public YieldCurveDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "YieldCurve";
    }

    @Override
    public void save(YieldCurve yieldCurve) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(INSERT)) {
            prepStatement.setString(1, yieldCurve.getId());
            prepStatement.setString(2, yieldCurve.getName());
            prepStatement.setDouble(3, yieldCurve.getYield1month());
            prepStatement.setDouble(4, yieldCurve.getYield2month());
            prepStatement.setDouble(5, yieldCurve.getYield3month());
            prepStatement.setDouble(6, yieldCurve.getYield6month());
            prepStatement.setDouble(7, yieldCurve.getYield1year());
            prepStatement.setDouble(8, yieldCurve.getYield2year());
            prepStatement.setDouble(9, yieldCurve.getYield5year());
            prepStatement.setDouble(10, yieldCurve.getYield10year());
            prepStatement.setDouble(11, yieldCurve.getYield20year());
            prepStatement.setDouble(12, yieldCurve.getYield30year());

            prepStatement.executeUpdate();
            prepStatement.close();
        }
    }

    @Override
    public void update(YieldCurve yieldCurve) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(UPDATE)) {
            prepStatement.setString(1, yieldCurve.getName());
            prepStatement.setDouble(2, yieldCurve.getYield1month());
            prepStatement.setDouble(3, yieldCurve.getYield2month());
            prepStatement.setDouble(4, yieldCurve.getYield3month());
            prepStatement.setDouble(5, yieldCurve.getYield6month());
            prepStatement.setDouble(6, yieldCurve.getYield1year());
            prepStatement.setDouble(7, yieldCurve.getYield2year());
            prepStatement.setDouble(8, yieldCurve.getYield5year());
            prepStatement.setDouble(9, yieldCurve.getYield10year());
            prepStatement.setDouble(10, yieldCurve.getYield20year());
            prepStatement.setDouble(11, yieldCurve.getYield30year());
            prepStatement.setString(12, yieldCurve.getId());

            prepStatement.executeUpdate();
            prepStatement.close();
        }
    }
}
