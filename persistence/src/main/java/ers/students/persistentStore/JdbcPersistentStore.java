package ers.students.persistentStore;

import ers.students.crud.CrudDao;
import ers.students.crud.FxQuoteDao;
import ers.students.crud.InstrumentDao;
import ers.students.crud.PortfolioDao;
import ers.students.crud.PositionDao;
import ers.students.crud.SearchingDao;
import ers.students.crud.TransactionDao;
import ers.students.crud.YieldCurveDao;
import ers.students.instruments.Instrument;
import ers.students.market.FxQuote;
import ers.students.market.YieldCurve;
import ers.students.portfolio.Portfolio;
import ers.students.portfolio.Position;
import ers.students.portfolio.Transaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.hsqldb.jdbc.JDBCDataSource;

/**
 *
 * @author Ayhan Interface that provides methods for creating a database and
 * Implements methods for working with database and transactions
 */
public class JdbcPersistentStore implements PersistentStore {

    private Connection connection;
    private final JDBCDataSource dataSource;
    private String dbURL;
    private String userName;
    private String password;
    private PortfolioDao portfolioDao;
    private PositionDao positionDao;
    private TransactionDao transactionDao;
    private InstrumentDao instrumentDao;
    private YieldCurveDao yieldCurveDao;
    private FxQuoteDao fxQuoteDao;

    private static final String DROP_DB = "DROP DATABASE ?";

    /**
     * Creates the DB
     *
     * @param dbURL - path of DB
     * @param userName - DB login information
     * @param password - DB login information
     */
    public JdbcPersistentStore(String dbURL, String userName, String password) {

        dataSource = new JDBCDataSource();
        dataSource.setURL(dbURL);
        dataSource.setUser(userName);
        dataSource.setPassword(password);

    }

    /**
     *
     * @return Connection object
     */
    @Override
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public void createDB() {
        try {
            Statement statement = connection.createStatement();
            String tableCreateQuery = new String(Files.readAllBytes(Paths.get("CreateTableQueries.txt")));
            statement.executeUpdate(tableCreateQuery);
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Deletes the DB
     */
    @Override
    public void dropDB() {
        try (PreparedStatement pStatement = connection.prepareStatement(DROP_DB)) {
            pStatement.setString(1, connection.getCatalog());
            Statement statement = connection.createStatement();
            statement.executeUpdate(DROP_DB);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Begin transaction
     */
    @Override
    public void startTransaction() {
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     */
    @Override
    public void close() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Reverts back to the previous state of the database. Any changes made in
     * DB aren't saved.
     */
    @Override
    public void rollbackTransaction() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Saves transaction
     */
    @Override
    public void commitTransaction() throws SQLException {
        /*try {
            connection.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
        connection.commit();
    }

    /**
     * Uses lazy initialization
     *
     * @return
     */
    @Override
    public SearchingDao<Position> getPositionDao() {
        if (positionDao == null) {
            positionDao = new PositionDao(this);
        }
        return positionDao;
    }

    /**
     * Uses lazy initialization
     *
     * @return
     */
    @Override
    public SearchingDao<Portfolio> getPortfolioDao() {
        if (portfolioDao == null) {
            portfolioDao = new PortfolioDao(this);
        }
        return portfolioDao;
    }

    /**
     * Uses lazy initialization
     *
     * @return
     */
    @Override
    public SearchingDao<Transaction> getTransactionDao() {
        if (transactionDao == null) {
            transactionDao = new TransactionDao(this);
        }
        return transactionDao;
    }

    /**
     * Uses lazy initialization
     *
     * @return
     */
    @Override
    public SearchingDao<Instrument> getInstrumentDao() {
        if (instrumentDao == null) {
            instrumentDao = new InstrumentDao(this);
        }
        return instrumentDao;
    }

    /**
     * Uses lazy initialization
     *
     * @return
     */
    @Override
    public CrudDao<YieldCurve> getYieldCurveDao() {
        if (yieldCurveDao == null) {
            yieldCurveDao = new YieldCurveDao(this);
        }
        return yieldCurveDao;
    }

    /**
     * Uses lazy initialization
     *
     * @return
     */
    @Override
    public CrudDao<FxQuote> getFxQuote() {
        if (fxQuoteDao == null) {
            fxQuoteDao = new FxQuoteDao(this);
        }
        return fxQuoteDao;
    }

}
