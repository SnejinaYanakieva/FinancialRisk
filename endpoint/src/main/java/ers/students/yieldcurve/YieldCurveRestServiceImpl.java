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

    private ProviderRegistry registry = ProviderRegistry.getInstance();
       
    @Override
    public Response create(YieldCurve yieldCurve) {
        return ResponseFactory.make(registry.getYieldCurveProvider().create(yieldCurve),false);
    }

    @Override
    public Response update(YieldCurve yieldCurve) {
        return ResponseFactory.make(registry.getYieldCurveProvider().update(yieldCurve),true);
    }

    @Override
    public Response loadById(String id) {
        return ResponseFactory.make(registry.getYieldCurveProvider().loadById(id));
    }

    @Override
    public Response deleteById(String id) {
        return ResponseFactory.make(registry.getYieldCurveProvider().delete(id),true);
    }

    @Override
    public Response loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
