/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.transaction;

import ers.students.factory.ResponseFactory;
import ers.students.portfolio.Transaction;
import ers.students.registry.ProviderRegistry;
import javax.ws.rs.core.Response;

/**
 *
 * @author martinstoynov
 */
public class TransactionRestServiceImpl implements TransactionRestService {

    private ProviderRegistry registry;
    private final boolean create = false;
    private final boolean ok = true;
    
    public TransactionRestServiceImpl(ProviderRegistry registry){
        if(ProviderRegistry.getInstance() != null)
            this.registry = registry;
    }
    
    @Override
    public Response create(Transaction transaction) {
        return ResponseFactory.make(registry.getTransactionProvider().create(transaction),create);
    }

    @Override
    public Response update(Transaction transaction) {
        return ResponseFactory.make(registry.getTransactionProvider().update(transaction),ok);
    }

    @Override
    public Response loadById(String id) {
        return ResponseFactory.make(registry.getTransactionProvider().loadById(id));
    }

    @Override
    public Response deleteById(String id) {
        return ResponseFactory.make(registry.getTransactionProvider().delete(id),ok);
    }

    @Override
    public Response loadAll() {
        return ResponseFactory.make(registry.getTransactionProvider().loadAll());
    }

    @Override
    public Response searchByPositionId(String positionId) {
        return ResponseFactory.make(registry.getTransactionProvider().searchByName(positionId));
    }
    
}
