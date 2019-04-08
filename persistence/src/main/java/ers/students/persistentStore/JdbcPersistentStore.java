/*
 * Interface that provides methods for creating a database and 
 */
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
 * @author Ayhan
 *
 * Implements methods for working with database and transactions
 */
public class JdbcPersistentStore implements PersistentStore {

    private Connection connection;
    private JDBCDataSource dataSource;
    private String dbURL;
    private String userName;
    private String password;
    private PortfolioDao portfolioDao;
    private PositionDao positionDao;
    private TransactionDao transactionDao;
    private InstrumentDao instrumentDao;
    private YieldCurveDao yieldCurveDao;
    private FxQuoteDao fxQuoteDao;
    
    private static final String DROPDB="DROP DATABASE ?";

    /**
     * Creates the DB
     *
     * @param dbURL - path of DB
     * @param userName - DB login information
     * @param password - DB login information
     */
    public JdbcPersistentStore(String dbURL, String userName, String password) {
        try {
            dataSource = new JDBCDataSource();
            dataSource.setURL(dbURL);
            dataSource.setUser(userName);
            dataSource.setPassword(password);
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
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
        try {
            PreparedStatement pStatement = connection.prepareStatement(DROPDB);
            pStatement.setString(1, connection.getCatalog());
            Statement statement = connection.createStatement();
            statement.executeUpdate(DROPDB);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Begin transaction
     */
    @Override
    public void startTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Reverts back to the previous state of the database.
     * Any changes made in DB aren't saved.
     */
    @Override
    public void rollbackTransaction() {
        try{
            connection.rollback();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Saves transaction
     */
    @Override
    public void commitTransaction() {
        try {
            connection.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Uses lazy initialization
     *
     * @return
     */
    @Override
    public SearchingDao<Position> getPositionDao() {
        if (positionDao == null) {
            positionDao = new PositionDao();
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
            portfolioDao = new PortfolioDao();
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
            transactionDao = new TransactionDao();
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
            instrumentDao = new InstrumentDao();
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
            yieldCurveDao = new YieldCurveDao();
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
            fxQuoteDao = new FxQuoteDao();
        }
        return fxQuoteDao;
    }

}
