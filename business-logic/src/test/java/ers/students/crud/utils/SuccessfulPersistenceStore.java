/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.utils;

import ers.students.crud.CrudDao;
import ers.students.crud.FxQuoteDao;
import ers.students.crud.InstrumentDao;
import ers.students.crud.PositionDao;
import ers.students.crud.SearchingDao;
import ers.students.crud.TransactionDao;
import ers.students.crud.YieldCurveDao;
import ers.students.instruments.Instrument;
import ers.students.market.FxQuote;
import ers.students.market.YieldCurve;
import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Portfolio;
import ers.students.portfolio.Position;
import ers.students.portfolio.Transaction;
import java.sql.Connection;

/**
 *
 * @author Irina
 */
public class SuccessfulPersistenceStore implements PersistentStore {

    @Override
    public void createDB() {

    }

    @Override
    public void dropDB() {

    }

    @Override
    public void startTransaction() {

    }

    @Override
    public void rollbackTransaction() {

    }

    @Override
    public void commitTransaction() {

    }

    @Override
    public SearchingDao<Portfolio> getPortfolioDao() {
        return new SuccessfulPortfolioDao(this);
    }

    @Override
    public SearchingDao<Position> getPositionDao() {
        return new PositionDao(this);
    }

    @Override
    public SearchingDao<Transaction> getTransactionDao() {
        return new TransactionDao(this);
    }

    @Override
    public SearchingDao<Instrument> getInstrumentDao() {
        return new InstrumentDao(this);
    }

    @Override
    public CrudDao<YieldCurve> getYieldCurveDao() {
        return new YieldCurveDao(this);
    }

    @Override
    public CrudDao<FxQuote> getFxQuote() {
        return new FxQuoteDao(this);
    }

    @Override
    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
