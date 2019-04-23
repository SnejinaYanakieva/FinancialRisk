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
    private final boolean create = false;
    private final boolean ok = true;
    
    public PositionRestServiceImpl(ProviderRegistry registry){
        if(ProviderRegistry.getInstance() != null)
            this.registry = registry;
    }
    
    @Override
    public Response create(Position position) {
        return ResponseFactory.make(registry.getPositionProvider().create(position), create);
    }

    @Override
    public Response update(Position position) {
        return ResponseFactory.make(registry.getPositionProvider().update(position), ok);
    }

    @Override
    public Response loadById(String id) {
        return ResponseFactory.make(registry.getPositionProvider().loadById(id));
    }

    @Override
    public Response deleteById(String id) {
        return ResponseFactory.make(registry.getPositionProvider().delete(id),ok);
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
