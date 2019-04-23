/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.position;

import ers.students.factory.ResponseFactory;
import ers.students.portfolio.Position;
import ers.students.registry.ProviderRegistry;
import javax.ws.rs.core.Response;

/**
 *
 * @author martinstoynov
 */
public class PositionRestServiceImpl implements PositionRestService {
    
    private ProviderRegistry registry;
    
    public PositionRestServiceImpl(ProviderRegistry registry){
        if(ProviderRegistry.getInstance() != null)
            this.registry = registry;
    }
    
    @Override
    public Response create(Position position) {
        return ResponseFactory.make(registry.getPositionProvider().create(position), false);
    }

    @Override
    public Response update(Position position) {
        return ResponseFactory.make(registry.getPositionProvider().update(position), true);
    }

    @Override
    public Response loadById(String id) {
        return ResponseFactory.make(registry.getPositionProvider().loadById(id));
    }

    @Override
    public Response deleteById(String id) {
        return ResponseFactory.make(registry.getPositionProvider().delete(id),true);
    }

    @Override
    public Response loadAll() {
        return ResponseFactory.make(registry.getPositionProvider().loadAll());
    }

    @Override
    public Response searchByName(String name) {
        return ResponseFactory.make(registry.getPositionProvider().searchByName(name));
    }
    
}
