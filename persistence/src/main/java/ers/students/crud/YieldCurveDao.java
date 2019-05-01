/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.market.YieldCurve;
import ers.students.persistentStore.PersistentStore;
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
public class YieldCurveDao extends AbstractCrudDao<YieldCurve> {

    private final String INSERT = "INSERT INTO Yield_Curve VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Yield_Curve SET name=?, yield1month=?, yield2month=?, yield3month=? "
            + "yield6month=?, yield1year=?, yield2year=?, yield5year=?, yield10year=?, yield20year=? "
            + "yield30year=? WHERE id=?";
    private final String LOAD_BY_ID = "SELECT * FROM Instrument WHERE id=?";
    private final String LOAD_ALL = "SELECT * FROM ?";

    public YieldCurveDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return "YieldCurve";
    }

    /**
     * saves Yield Curve in DB
     * @param yieldCurve
     * @throws SQLException 
     */
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

    /**
     * Updates Yield Curve in DB
     * 
     * @param yieldCurve
     * @throws SQLException 
     */
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

    /**
     * Loads Yield Curve with the given ID
     * 
     * @param id
     * @return
     * @throws SQLException 
     */
    @Override
    public YieldCurve loadById(String id) throws SQLException {
        YieldCurve yieldCurve = new YieldCurve();

        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(LOAD_BY_ID)) {
            prepStatement.setString(1, id);

            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                yieldCurve.setId(resultSet.getString("id"));
                yieldCurve.setName(resultSet.getString("name"));
                yieldCurve.setYield1month(resultSet.getDouble("yield1month"));
                yieldCurve.setYield2month(resultSet.getDouble("yield2month"));
                yieldCurve.setYield3month(resultSet.getDouble("yield3month"));
                yieldCurve.setYield6month(resultSet.getDouble("yield6month"));
                yieldCurve.setYield1year(resultSet.getDouble("yield1year"));
                yieldCurve.setYield2year(resultSet.getDouble("yield2year"));
                yieldCurve.setYield5year(resultSet.getDouble("yield3year"));
                yieldCurve.setYield10year(resultSet.getDouble("yield10year"));
                yieldCurve.setYield20year(resultSet.getDouble("yield20year"));
                yieldCurve.setYield30year(resultSet.getDouble("yield30year"));
            }

            resultSet.close();
            prepStatement.close();
        }

        return yieldCurve;
    }

    /**
     * Loads all Yield Curves from DB
     * 
     * @return
     * @throws SQLException 
     */
    @Override
    public List<YieldCurve> loadAll() throws SQLException {
        List<YieldCurve> yieldCurveList = new ArrayList<>();
        YieldCurve yieldCurve;

        try (PreparedStatement prepStatement = super.getPersistentStore().getConnection().prepareStatement(LOAD_ALL)) {
            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                yieldCurve = new YieldCurve();
                
                yieldCurve.setId(resultSet.getString("id"));
                yieldCurve.setName(resultSet.getString("name"));
                yieldCurve.setYield1month(resultSet.getDouble("yield1month"));
                yieldCurve.setYield2month(resultSet.getDouble("yield2month"));
                yieldCurve.setYield3month(resultSet.getDouble("yield3month"));
                yieldCurve.setYield6month(resultSet.getDouble("yield6month"));
                yieldCurve.setYield1year(resultSet.getDouble("yield1year"));
                yieldCurve.setYield2year(resultSet.getDouble("yield2year"));
                yieldCurve.setYield5year(resultSet.getDouble("yield3year"));
                yieldCurve.setYield10year(resultSet.getDouble("yield10year"));
                yieldCurve.setYield20year(resultSet.getDouble("yield20year"));
                yieldCurve.setYield30year(resultSet.getDouble("yield30year"));
                
                yieldCurveList.add(yieldCurve);
            }
            
            resultSet.close();
            prepStatement.close();
        }

        return yieldCurveList;
    }
}
