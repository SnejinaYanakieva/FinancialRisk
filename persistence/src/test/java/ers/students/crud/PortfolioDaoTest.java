/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.JdbcPersistentStore;
import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Portfolio;
import ers.students.util.Currency;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Ayhan
 */
public class PortfolioDaoTest extends TestCase {

    private final PersistentStore jdbcPersistentStore = new JdbcPersistentStore("jdbc:hsqldb:mem:/DBTesting/dbtest", "SA", "");

    public PortfolioDaoTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.jdbcPersistentStore.startTransaction();
        jdbcPersistentStore.createDB();
        this.jdbcPersistentStore.commitTransaction();
        Thread.sleep(2000);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getTableName method, of class PortfolioDao.
     */
    public void testGetTableName() {
        System.out.println("getTableName");
        
        PortfolioDao instance = new PortfolioDao(jdbcPersistentStore);
        String expResult = "Portfolio";
        String result = instance.getTableName();
        assertEquals(expResult, result);
    }

    /**
     * Test of save method, of class PortfolioDao.
     *
     * @throws java.lang.Exception
     */
    public void testSave() throws Exception {
        System.out.println("save");
        
        Portfolio result = new Portfolio();
        Portfolio portfolio = new Portfolio("port1", "portname", Currency.BGN);
        PortfolioDao instance = new PortfolioDao(this.jdbcPersistentStore);
        
        this.jdbcPersistentStore.startTransaction();
        instance.save(portfolio);
        this.jdbcPersistentStore.commitTransaction();

        String select = "SELECT * FROM Portfolio WHERE id='port1'";
        Statement statement = this.jdbcPersistentStore.getConnection().createStatement();
        ResultSet res = statement.executeQuery(select);

        if (res.next()) {
            result.setId(res.getString(1));
            result.setName(res.getString(2));
            result.setCurrency(Currency.valueOf(res.getString(3)));
        }

        assertEquals(portfolio, result);
    }

    /**
     * Test of update method, of class PortfolioDao.
     *
     * @throws java.lang.Exception
     */
    public void testUpdate() throws Exception {
        System.out.println("update");
        
        Portfolio result = new Portfolio();
        Portfolio portfolioOld = new Portfolio("port", "name", Currency.AUD);
        Portfolio portfolioUpdate = new Portfolio("port", "name2", Currency.AUD);
        PortfolioDao instance = new PortfolioDao(jdbcPersistentStore);
        
        this.jdbcPersistentStore.startTransaction();
        instance.save(portfolioOld);
        instance.update(portfolioUpdate);
        this.jdbcPersistentStore.commitTransaction();

        String select = "SELECT * FROM Portfolio WHERE id='port'";
        Statement statement = this.jdbcPersistentStore.getConnection().createStatement();
        ResultSet res = statement.executeQuery(select);

        if (res.next()) {
            result.setId(res.getString(1));
            result.setName(res.getString(2));
            result.setCurrency(Currency.valueOf(res.getString(3)));
        }

        assertEquals(portfolioUpdate, result);
    }

    /**
     * Test of loadById method, of class PortfolioDao.
     *
     * @throws java.lang.Exception
     */
    public void testLoadById() throws Exception {
        System.out.println("loadById");
        
        Portfolio portfolio = new Portfolio("port3", "name3", Currency.AUD);
        Portfolio result;
        PortfolioDao instance = new PortfolioDao(this.jdbcPersistentStore);
        
        this.jdbcPersistentStore.startTransaction();
        instance.save(portfolio);
        result = instance.loadById("port3");
        this.jdbcPersistentStore.commitTransaction();

        assertEquals(portfolio, result);
    }

    /**
     * Test of loadAll method, of class PortfolioDao.
     *
     * @throws java.lang.Exception
     */
    public void testLoadAll() throws Exception {
        System.out.println("loadAll");

        Portfolio portfolio = new Portfolio("id5", "portfolio5", Currency.BGN);
        Portfolio portfolio2 = new Portfolio("id6", "portfolio5", Currency.GBP);

        PortfolioDao instance = new PortfolioDao(this.jdbcPersistentStore);
        List<Portfolio> expResult = new ArrayList<>();
        expResult.add(portfolio);
        expResult.add(portfolio2);

        this.jdbcPersistentStore.startTransaction();
        String delete = "DELETE FROM Portfolio";
        Statement statement = this.jdbcPersistentStore.getConnection().createStatement();
        statement.executeUpdate(delete);

        instance.save(portfolio);
        instance.save(portfolio2);
        List<Portfolio> result = instance.loadAll();
        this.jdbcPersistentStore.commitTransaction();

        assertEquals(expResult, result);
    }

    /**
     * Test of searchByName method, of class PortfolioDao.
     *
     * @throws java.lang.Exception
     */
    public void testSearchByName() throws Exception {
        System.out.println("searchByName");

        Portfolio portfolio = new Portfolio("port6", "portname3", Currency.AUD);
        Portfolio portfolio2 = new Portfolio("port4", "portname3", Currency.AUD);
        Portfolio portfolio3 = new Portfolio("port5", "portname3", Currency.AUD);

        String name = "portname3";
        PortfolioDao instance = new PortfolioDao(this.jdbcPersistentStore);
        List<Portfolio> expResult = new ArrayList<>();

        expResult.add(portfolio2);
        expResult.add(portfolio3);
        expResult.add(portfolio);

        this.jdbcPersistentStore.startTransaction();
        instance.save(portfolio);
        instance.save(portfolio2);
        instance.save(portfolio3);
        List<Portfolio> result = instance.searchByName(name);
        this.jdbcPersistentStore.commitTransaction();

        assertEquals(expResult, result);
    }
}
