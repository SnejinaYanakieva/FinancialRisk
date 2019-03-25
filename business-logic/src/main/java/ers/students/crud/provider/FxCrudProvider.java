/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider;

import ers.students.crud.CrudDao;
import ers.students.market.FxQuote;

/**
 *
 * @author Irina
 */
public class FxCrudProvider extends AbstactCrudProvider<FxQuote> {

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
