/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.utils;

import ers.students.crud.CrudDao;
import ers.students.crud.SearchingDao;
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
 * @author martinstoynov
 */
public class ErroneousPersistenceStore implements PersistentStore {

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SearchingDao<Position> getPositionDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SearchingDao<Transaction> getTransactionDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SearchingDao<Instrument> getInstrumentDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CrudDao<YieldCurve> getYieldCurveDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CrudDao<FxQuote> getFxQuote() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
