/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.market.YieldCurve;
import ers.students.persistentStore.PersistentStore;

/**
 *
 * @author Ayhan
 *
 * Stores data retrieved from CRUD operations
 */
public class YieldCurveDao extends AbstractCrudDao<YieldCurve> {

    public YieldCurveDao(PersistentStore ps) {
        super(ps);
    }

    @Override
    public String getTableName() {
        return this.getClass().getName();
    }
}
