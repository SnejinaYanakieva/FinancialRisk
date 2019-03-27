/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider.searching;

import ers.students.crud.CrudDao;
import ers.students.crud.SearchingDao;
import ers.students.instruments.Instrument;

/**
 *
 * @author Irina
 */
public class InstrumentCrudProvider extends SearchingCrudProvider<Instrument> {

    /**
     * Provides DAO interface for Instrument.
     *
     * @return
     */
    @Override
    public SearchingDao<Instrument> getDao() {
        return persistentStore.getInstrumentDao();
    }

}
