/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.adminDBApp;

import ers.students.persistentStore.JdbcPersistentStore;
import ers.students.persistentStore.PersistentStore;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class lets the administrator create a database by writing the URL of the
 * DB, username and password
 *
 * @author Ayhan
 */
public class AdminDBApp {

    static PersistentStore persistentStore;

    private static void initJDBCPersistentStore(String dbURL, String userName, String password) {
        persistentStore = new JdbcPersistentStore(dbURL, userName, password);
    }

    public static void main(String[] args) {
        String url = "jdbc:hsqldb:file:~/DBTest/dbtest";
        String user = "SA";
        String pass = "admin";
        initJDBCPersistentStore(url, user, pass);
        
        
        try {
            persistentStore.startTransaction();
            persistentStore.createDB();
            persistentStore.commitTransaction();
            Thread.sleep(2000);
        } catch (SQLException ex) {
            persistentStore.rollbackTransaction();
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminDBApp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           if (persistentStore.getConnection() != null) {
                persistentStore.close();
            }
        }
    }
}
