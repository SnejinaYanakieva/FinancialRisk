/*
 * Interface that provides methods for creating a database and 
 */
package ers.students.persistentStore;

import ers.students.crud.CrudDao;
import ers.students.crud.PortfolioDao;
import ers.students.crud.PositionDao;
import ers.students.crud.SearchingDao;
import ers.students.instruments.Instrument;
import ers.students.market.FxQuote;
import ers.students.market.YieldCurve;
import ers.students.portfolio.Portfolio;
import ers.students.portfolio.Position;
import ers.students.portfolio.Transaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.hsqldb.jdbc.JDBCDataSource;

/**
 *
 * @author Ayhan
 *
 * Implements methods for working with database and transactions
 */
public class JdbcPersistentStore implements PersistentStore {

    private Connection connection;
    private JDBCDataSource dataSource;
    private String userName;
    private String password;
    private PortfolioDao portfolioDao;
    private PositionDao positionDao;
    private Transaction transactionDao;
    private Instrument instrumentDao;
    private YieldCurve yieldCurve;
    private FxQuote FxQuote;

    /**
     * Creates the DB
     */
    @Override
    public void createDB() {
        try {
            connect();

            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS FxQuote("
                    + "id TEXT(36) NOT NULL,"
                    + "from TEXT(3) NOT NULL,"
                    + "to TEXT(3) NOT NULL,"
                    + "date DATE NOT NULL,"
                    + "value DOUBLE NOT NULL,"
                    + "PRIMARY KEY(id))");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Yield_Curve("
                    + "id TEXT(36) NOT NULL,"
                    + "name TEXT(200) NOT NULL,"
                    + "yield1month DOUBLE,"
                    + "yield2month DOUBLE,"
                    + "yield3month DOUBLE,"
                    + "yield6month DOUBLE,"
                    + "yield1year DOUBLE,"
                    + "yield2year DOUBLE,"
                    + "yield5year DOUBLE,"
                    + "yield10year DOUBLE,"
                    + "yield20year DOUBLE,"
                    + "yield30year DOUBLE,"
                    + "PRIMARY KEY(id))");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Deletes the DB
     */
    @Override
    public void dropDB() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Begin transaction
     */
    @Override
    public void startTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Reverts back to the previous state of the database changes made in DB
     * aren't saved
     */
    @Override
    public void rollbackTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Saves transaction
     */
    @Override
    public void commitTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Uses lazy initialization
     *
     * @return
     */
    @Override
    public SearchingDao<Position> getPositionDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Uses lazy initialization
     *
     * @return
     */
    @Override
    public SearchingDao<Portfolio> getPortfolioDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Uses lazy initialization
     *
     * @return
     */
    @Override
    public SearchingDao<Transaction> getTransactionDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Uses lazy initialization
     *
     * @return
     */
    @Override
    public SearchingDao<Instrument> getInstrumentDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Uses lazy initialization
     *
     * @return
     */
    @Override
    public CrudDao<YieldCurve> getYieldCurveDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Uses lazy initialization
     *
     * @return
     */
    @Override
    public CrudDao<FxQuote> getFxQuote() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:hsql:file:", userName, password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
