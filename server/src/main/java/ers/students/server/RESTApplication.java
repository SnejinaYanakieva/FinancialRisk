/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.server;

import ers.students.persistentStore.PersistentStore;
import ers.students.registry.ProviderRegistry;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author martinstoynov
 */
@ApplicationPath("/network-management")
public class RESTApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();
    private ProviderRegistry registry;

    public RESTApplication(PersistentStore store) {
        ProviderRegistry.createInstance(store);
        registry = ProviderRegistry.getInstance();
        singletons.add(registry.getFxQuoteProvider());
        singletons.add(registry.getInstrumentProvider());
        singletons.add(registry.getPortfolioProvider());
        singletons.add(registry.getPositionProvider());
        singletons.add(registry.getTransactionProvider());
        singletons.add(registry.getYieldCurveProvider());        
    }

    @Override
    public Set<Class<?>> getClasses() {
        return empty;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
