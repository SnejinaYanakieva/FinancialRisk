/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.server;

import ers.students.persistentStore.JdbcPersistentStore;
import ers.students.persistentStore.PersistentStore;

import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author martinstoynov
 */
public class Connector {

    private PersistentStore persistentStore;
    private static final Connector instance = new Connector();

    private Connector() {
        loadFile();
    }

    public static Connector getInstance() {
        return instance;
    }

    private void loadFile() {
        try (InputStream input = new FileInputStream("./src/main/resources/config.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            persistentStore = new JdbcPersistentStore(
                    prop.getProperty("db.url"),
                    prop.getProperty("db.user"),
                    prop.getProperty("db.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public PersistentStore getPersistentStore(){
        return persistentStore;
    }
}
