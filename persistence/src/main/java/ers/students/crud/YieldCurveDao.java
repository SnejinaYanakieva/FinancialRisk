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
            prepStatement.setString(3, String.valueOf(yieldCurve.getYield1month()));
            prepStatement.setString(4, String.valueOf(yieldCurve.getYield2month()));
            prepStatement.setString(5, String.valueOf(yieldCurve.getYield3month()));
            prepStatement.setString(6, String.valueOf(yieldCurve.getYield6month()));
            prepStatement.setString(7, String.valueOf(yieldCurve.getYield1year()));
            prepStatement.setString(8, String.valueOf(yieldCurve.getYield2year()));
            prepStatement.setString(9, String.valueOf(yieldCurve.getYield5year()));
            prepStatement.setString(10, String.valueOf(yieldCurve.getYield10year()));
            prepStatement.setString(11, String.valueOf(yieldCurve.getYield20year()));
            prepStatement.setString(12, String.valueOf(yieldCurve.getYield30year()));

            prepStatement.executeUpdate();
            prepStatement.close();
        }
    }

    @Override
    public void update(YieldCurve yieldCurve) throws SQLException {
        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(UPDATE)) {
            prepStatement.setString(1, yieldCurve.getName());
            prepStatement.setString(2, String.valueOf(yieldCurve.getYield1month()));
            prepStatement.setString(3, String.valueOf(yieldCurve.getYield2month()));
            prepStatement.setString(4, String.valueOf(yieldCurve.getYield3month()));
            prepStatement.setString(5, String.valueOf(yieldCurve.getYield6month()));
            prepStatement.setString(6, String.valueOf(yieldCurve.getYield1year()));
            prepStatement.setString(7, String.valueOf(yieldCurve.getYield2year()));
            prepStatement.setString(8, String.valueOf(yieldCurve.getYield5year()));
            prepStatement.setString(9, String.valueOf(yieldCurve.getYield10year()));
            prepStatement.setString(10, String.valueOf(yieldCurve.getYield20year()));
            prepStatement.setString(11, String.valueOf(yieldCurve.getYield30year()));
            prepStatement.setString(12, yieldCurve.getId());

            prepStatement.executeUpdate();
            prepStatement.close();
        }
    }
}
