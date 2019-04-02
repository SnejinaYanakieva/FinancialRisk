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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private YieldCurveDao yieldCurve;
    private FxQuoteDao FxQuote;

    /**
     * Creates the DB
     *
     */
    public JdbcPersistentStore() {
        try {
            connection = DriverManager.getConnection(dbURL, userName, password);
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @return Connection object
     */
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
        String dropDBQuery = "DROP DATABASE ?";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(dropDBQuery);
        } catch (SQLException ex) {
            Logger.getLogger(JdbcPersistentStore.class.getName()).log(Level.SEVERE, null, ex);
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
       if(positionDao==null){
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

}
