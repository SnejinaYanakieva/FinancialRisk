/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.server;

import ers.students.persistentStore.PersistentStore;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.utils.ResourceUtils;

/**
 *
 * @author Viktor
 */
//Bean ? info and why ,
public class JaxrsServerFactoryBean {

    //private Connector connector = Connector.getInstance();
    private Connector connector = Connector.getInstance();
    
    private RESTApplication application;
    public Server server;
    private final JAXRSServerFactoryBean sf;
    private final JAXRSBindingFactory factory = new JAXRSBindingFactory();
    
    
    public JaxrsServerFactoryBean() {
        PersistentStore store = connector.getPersistentStore();
        application = new RESTApplication(store);
        sf = ResourceUtils.createApplication(application, false);
    }

    public void setResourceClass(Class Resourse) {

        sf.setResourceClasses(Resourse);

    }

    public void resourceProvider(Class Resourse) {
        
        sf.setResourceProvider(Resourse, new SingletonResourceProvider(Resourse));
        
    }

    public void setAddress(int num) {

        sf.setAddress("http://localhost:" + num + "/");
        
    }

    public void setAddressDef() {

        sf.setAddress("http://localhost:9000/");
        
    }

    public void Build() {

        setAddressDef();
        server = sf.create();
        server.start();
        
    }

    public void serverStop() {
        if (server != null) {
            server.stop();
        }
    }
}
