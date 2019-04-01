/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider;

import ers.students.crud.CrudDao;
import ers.students.market.FxQuote;
import ers.students.persistentStore.PersistentStore;

/**
 *
 * @author Irina
 */
public class FxCrudProvider extends AbstractCrudProvider<FxQuote> {

    public FxCrudProvider(PersistentStore persistentStore) {
        super(persistentStore);
    }

    /**
     * Provides DAO interface for FxQuote.
     *
     * @return
     */
    @Override
    protected CrudDao<FxQuote> getDao() {
        return persistentStore.getFxQuote();
    }
}
