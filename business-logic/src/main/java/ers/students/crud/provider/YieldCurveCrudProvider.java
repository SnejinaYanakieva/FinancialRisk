/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider;

import ers.students.crud.CrudDao;
import ers.students.market.YieldCurve;

/**
 *
 * @author Irina
 */
public class YieldCurveCrudProvider extends AbstactCrudProvider<YieldCurve> {

    /**
     * Provides DAO interface for YieldCurve.
     *
     * @return
     */
    @Override
    protected CrudDao<YieldCurve> getDao() {
        return persistentStore.getYieldCurveDao();
    }
}
