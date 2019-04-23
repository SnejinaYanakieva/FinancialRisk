/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instrument;

import ers.students.factory.ResponseFactory;
import ers.students.instruments.Instrument;
import ers.students.registry.ProviderRegistry;
import javax.ws.rs.core.Response;

/**
 *
 * @author martinstoynov
 */
public class InstrumentRestServiceImpl implements InstrumentRestService {

    private ProviderRegistry registry;
    private final boolean create = false;
    private final boolean ok = true;
    
    public InstrumentRestServiceImpl(ProviderRegistry registry){
        if(ProviderRegistry.getInstance() != null)
            this.registry = registry;
    }
    
    @Override
    public Response create(Instrument instrument) {
        return ResponseFactory.make(registry.getInstrumentProvider().create(instrument),create);
    }

    @Override
    public Response update(Instrument instrument) {
        return ResponseFactory.make(registry.getInstrumentProvider().update(instrument),ok);
    }

    @Override
    public Response loadById(String id) {
        return ResponseFactory.make(registry.getInstrumentProvider().loadById(id));
    }

    @Override
    public Response deleteById(String id) {
        return ResponseFactory.make(registry.getInstrumentProvider().delete(id),ok);
    }

    @Override
    public Response loadAll() {
        return ResponseFactory.make(registry.getInstrumentProvider().loadAll());
    }

    @Override
    public Response searchByIsin(String isin) {
        return ResponseFactory.make(registry.getInstrumentProvider().searchByName(isin));
    }
    
}
