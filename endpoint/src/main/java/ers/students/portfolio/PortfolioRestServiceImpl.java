/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;

import ers.students.factory.ResponseFactory;
import ers.students.registry.ProviderRegistry;
import javax.ws.rs.core.Response;

/**
 *
 * @author martinstoynov
 */
public class PortfolioRestServiceImpl implements PortfolioRestService {

    private ProviderRegistry registry;
    
    public PortfolioRestServiceImpl(ProviderRegistry registry){
        if(ProviderRegistry.getInstance() != null)
            this.registry = registry;
    }
    
    @Override
    public Response create(Portfolio portfolio) {
        return ResponseFactory.make(registry.getPortfolioProvider().create(portfolio),false);
    }

    @Override
    public Response update(Portfolio portfolio) {
        return ResponseFactory.make(registry.getPortfolioProvider().update(portfolio),true);
    }

    @Override
    public Response loadById(String id) {
        return ResponseFactory.make(registry.getPortfolioProvider().loadById(id));
    }

    @Override
    public Response deleteById(String id) {
        return ResponseFactory.make(registry.getPortfolioProvider().delete(id),true);
    }

    @Override
    public Response loadAll() {
        return ResponseFactory.make(registry.getPortfolioProvider().loadAll());
    }

    @Override
    public Response searchByName(String name) {
        return ResponseFactory.make(registry.getPortfolioProvider().searchByName(name));
    }
    
}
