/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.server;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import ers.students.factory.ResponseFactory;
import ers.students.fxquote.FxQuoteRestServiceImpl;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 *
 * @author Viktor
 */
//Bean ? info and why ,
public class JaxrsServerFactoryBean {

    public Server server;
    private final JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
    private BindingFactoryManager manager = sf.getBus().getExtension(BindingFactoryManager.class);
    private JAXRSBindingFactory factory = new JAXRSBindingFactory();
    
    public JaxrsServerFactoryBean() {
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

        factory.setBus(sf.getBus());
        manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, factory);
        server = sf.create();
        server.start();
        
    }

    public void serverStop() {
        if (server != null) {
            server.stop();
        }
    }
}
