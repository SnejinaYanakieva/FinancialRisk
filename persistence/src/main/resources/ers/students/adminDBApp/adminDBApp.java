package ers.students.adminDBApp;


import ers.students.persistentStore.JdbcPersistentStore;
import ers.students.persistentStore.PersistentStore;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ayhan
 */
public class adminDBApp {

    static PersistentStore JDBCPersistentStore;

    public static void initJDBCPersistentStore(String dbURL, String userName, String password) {
        JDBCPersistentStore = new JdbcPersistentStore(dbURL, userName, password);
    }

    public static void main(String[] args) {
        String url = "jdbc:hsql:file:testdb";
        String user = "SA";
        String pass = "admin";
        initJDBCPersistentStore(url, user, pass);
        try {
            //JDBCPersistentStore.startTransaction();
            JDBCPersistentStore.createDB();
            JDBCPersistentStore.commitTransaction();
        } catch (SQLException ex) {
            JDBCPersistentStore.rollbackTransaction();
            System.out.println(ex.getMessage());
        }
    }
}
