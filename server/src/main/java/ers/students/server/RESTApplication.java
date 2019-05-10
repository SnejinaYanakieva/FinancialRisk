/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.server;

import ers.students.fxquote.FxQuoteRestServiceImpl;
import ers.students.instrument.InstrumentRestServiceImpl;
import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.PortfolioRestServiceImpl;
import ers.students.position.PositionRestServiceImpl;
import ers.students.registry.ProviderRegistry;
import ers.students.transaction.TransactionRestServiceImpl;
import ers.students.yieldcurve.YieldCurveRestServiceImpl;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author martinstoynov
 */

public class RESTApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();
    private ProviderRegistry registry;

    public RESTApplication(PersistentStore store) {
        
        ProviderRegistry.createInstance(store);
        
        registry = ProviderRegistry.getInstance();
        
        singletons.add(new FxQuoteRestServiceImpl(registry));
        singletons.add(new InstrumentRestServiceImpl(registry));
        singletons.add(new PortfolioRestServiceImpl(registry));
        singletons.add(new PositionRestServiceImpl(registry));
        singletons.add(new TransactionRestServiceImpl(registry));
        singletons.add(new YieldCurveRestServiceImpl(registry));        
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
