/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider;

import ers.students.crud.CrudDao;
import ers.students.market.YieldCurve;
import ers.students.persistentStore.PersistentStore;

/**
 *
 * @author Irina
 */
public class YieldCurveCrudProvider extends AbstractCrudProvider<YieldCurve> {

    public YieldCurveCrudProvider(PersistentStore persistentStore) {
        super(persistentStore);
    }

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
