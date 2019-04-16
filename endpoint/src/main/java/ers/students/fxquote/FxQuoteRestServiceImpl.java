/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.fxquote;

import ers.students.factory.ResponseFactory;
import ers.students.market.FxQuote;
import ers.students.registry.ProviderRegistry;
import javax.ws.rs.core.Response;

/**
 *
 * @author martinstoynov
 */
public class FxQuoteRestServiceImpl implements FxQuoteRestService {

    private ProviderRegistry registry = ProviderRegistry.getInstance();
       

    @Override
    public Response create(FxQuote fxQuote) {
        return ResponseFactory.make(registry.getFxQuoteProvider().create(fxQuote),false);
    }

    @Override
    public Response update(FxQuote fxQuote) {
        return ResponseFactory.make(registry.getFxQuoteProvider().update(fxQuote),true);
    }

    @Override
    public Response loadById(String id) {
        return ResponseFactory.make(registry.getFxQuoteProvider().loadById(id));
    }

    @Override
    public Response deleteById(String id) {
        return ResponseFactory.make(registry.getFxQuoteProvider().delete(id),true);
    }

    @Override
    public Response loadAll() {
        return ResponseFactory.make(registry.getFxQuoteProvider().loadAll());
    }
    
}
