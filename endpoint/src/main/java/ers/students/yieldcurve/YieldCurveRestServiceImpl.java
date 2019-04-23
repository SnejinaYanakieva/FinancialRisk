/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.yieldcurve;

import ers.students.factory.ResponseFactory;
import ers.students.market.YieldCurve;
import ers.students.registry.ProviderRegistry;
import javax.ws.rs.core.Response;

/**
 *
 * @author martinstoynov
 */
public class YieldCurveRestServiceImpl implements YieldCurveRestService {

    private ProviderRegistry registry;
    private final boolean create = false;
    private final boolean ok = true;
    
    public YieldCurveRestServiceImpl(ProviderRegistry registry){
        if(ProviderRegistry.getInstance() != null)
            this.registry = registry;
    }
       
    @Override
    public Response create(YieldCurve yieldCurve) {
        return ResponseFactory.make(registry.getYieldCurveProvider().create(yieldCurve),create);
    }

    @Override
    public Response update(YieldCurve yieldCurve) {
        return ResponseFactory.make(registry.getYieldCurveProvider().update(yieldCurve),ok);
    }

    @Override
    public Response loadById(String id) {
        return ResponseFactory.make(registry.getYieldCurveProvider().loadById(id));
    }

    @Override
    public Response deleteById(String id) {
        return ResponseFactory.make(registry.getYieldCurveProvider().delete(id),ok);
    }

    @Override
    public Response loadAll() {
        return ResponseFactory.make(registry.getYieldCurveProvider().loadAll());
    }
}
