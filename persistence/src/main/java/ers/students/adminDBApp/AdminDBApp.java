/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.adminDBApp;

import ers.students.persistentStore.JdbcPersistentStore;
import ers.students.persistentStore.PersistentStore;
import java.sql.SQLException;

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
        String url = "jdbc:hsql:file:dbtest";
        String user = "SA";
        String pass = "admin";
        initJDBCPersistentStore(url, user, pass);
        try {
            persistentStore.startTransaction();
            persistentStore.createDB();
            persistentStore.commitTransaction();
        } catch (SQLException ex) {
            persistentStore.rollbackTransaction();
        } finally {
            if (persistentStore.getConnection() != null) {
                persistentStore.close();
            }
        }
    }
}
